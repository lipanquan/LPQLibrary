package com.lpq.base.lib;

import android.app.Application;
import android.widget.Toast;

import com.github.pwittchen.reactivenetwork.library.ConnectivityStatus;
import com.github.pwittchen.reactivenetwork.library.ReactiveNetwork;

import java.util.ArrayList;

import com.lpq.base.lib.activity.LibBaseActivity;
import com.lpq.base.lib.config.LibAppConfig;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 功能：LibApplication
 * 作者：lipanquan on 2018/1/9 <br />
 * 邮箱：862321807@qq.cn <br />
 */
public abstract class LibApplication extends Application {

    /**
     * 栈中的activity
     */
    protected ArrayList<LibBaseActivity> activities = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        LibAppConfig.IS_DEBUG = getIsDebug();
        initNetworkStatusDetector();
    }

    /**
     * 是否与运行debug模式
     *
     * @return 是否是debug模式
     */
    protected abstract boolean getIsDebug();

    /**
     * 判断是否有网络
     */
    public static boolean networkAvailable = true;

    /**
     * 判断是否是wifi还是移动网络
     */
    public static NetStatus isWifi = NetStatus.WIFI;

    /**
     * 网络状态 分别代表wifi、wifi无网络、运营商网络
     */
    public enum NetStatus {
        WIFI,
        WIFI_NO_INTERNET,
        MOBILE_INTERNET
    }

    /**
     * 初始化网络监听
     */
    public void initNetworkStatusDetector() {
        ReactiveNetwork reactiveNetwork = new ReactiveNetwork();
        reactiveNetwork.observeConnectivity(this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(connectivityStatus -> {
                    //判断当前网络状态是否有效
                    if (connectivityStatus.toString().equals(ConnectivityStatus.OFFLINE.toString()) || connectivityStatus.toString().equals(ConnectivityStatus.WIFI_CONNECTED_HAS_NO_INTERNET.toString())) {
                        Toast.makeText(getApplicationContext(), "没有网络", Toast.LENGTH_SHORT).show();
                        networkAvailable = false;
                    } else {
                        networkAvailable = true;
                    }
                    //判断当前网络状态
                    if ((connectivityStatus.toString().equals(ConnectivityStatus.WIFI_CONNECTED.toString()) && connectivityStatus.toString().equals(ConnectivityStatus.WIFI_CONNECTED_HAS_NO_INTERNET.toString()))
                            || connectivityStatus.toString().equals(ConnectivityStatus.OFFLINE.toString())) {
                        isWifi = NetStatus.WIFI_NO_INTERNET; //连接了wifi,且无线不能用 || 网络不可用
                    } else if (connectivityStatus.toString().equals(ConnectivityStatus.MOBILE_CONNECTED.toString())) {
                        isWifi = NetStatus.MOBILE_INTERNET; //连接了移动网络
                    } else {
                        isWifi = NetStatus.WIFI;//wifi网络
                    }
                });
    }

    public void addActivity(LibBaseActivity activity) {
        this.activities.add(activity);
    }

    public void removeActivity(LibBaseActivity activity) {
        this.activities.remove(activity);
    }

    /**
     * 退出应用
     */
    public void exit() {
        for (int i = this.activities.size() - 1; i >= 0; i--) {
            try {
                this.activities.get(i).finish();
            } catch (Exception e) {
                continue;
            }
        }
    }
}