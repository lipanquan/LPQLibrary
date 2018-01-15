package com.lpq.base.lib.presenter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;

import com.lpq.base.lib.inf.ILibBaseView;
import com.lpq.base.lib.inf.IPublicInf;

import java.lang.ref.WeakReference;

/**
 * 功能：业务逻辑处理基类  <br/>
 * 作者：lipanquan on 2018/1/9 <br />
 * 邮箱：862321807@qq.cn <br />
 */
public abstract class LibBasePresenter<V extends ILibBaseView> implements View.OnClickListener, IPublicInf {

    /**
     * 防止内存泄漏
     */
    protected WeakReference<V> baseView;

    /**
     * 获取view的方法
     *
     * @return 当前关联的view
     */
    public V getView() {
        return baseView.get();
    }

    /**
     * 构造方法
     *
     * @param iBaseView 业务处理接口
     */
    public LibBasePresenter(V iBaseView) {
        this.baseView = new WeakReference<>(iBaseView);
    }

    @Override
    public boolean getInputMethodState() {
        return getView().getInputMethodState();
    }

    @Override
    public void closeKeyboard() {
        getView().closeKeyboard();
    }

    @Override
    public void openKeyboard() {
        getView().openKeyboard();
    }

    @Override
    public void setViewVisible(@NonNull View view) {
        getView().setViewVisible(view);
    }

    @Override
    public void setViewGone(@NonNull View view) {
        getView().setViewGone(view);
    }

    @Override
    public void startEnterActivity(Intent intent, boolean isFinish) {
        getView().startEnterActivity(intent, isFinish);
    }

    @Override
    public void startEnterActivity(Intent intent) {
        getView().startEnterActivity(intent);
    }

    @Override
    public void startEnterActivity(Class cls, boolean isFinish) {
        getView().startEnterActivity(cls, isFinish);
    }

    @Override
    public void startEnterActivity(Class cls) {
        getView().startEnterActivity(cls);
    }

    @Override
    public void startExitActivity(Intent intent, boolean isFinish) {
        getView().startExitActivity(intent, isFinish);
    }

    @Override
    public void startExitActivity(Intent intent) {
        getView().startExitActivity(intent);
    }

    @Override
    public void startExitActivity(Class cls, boolean isFinish) {
        getView().startExitActivity(cls, isFinish);
    }

    @Override
    public void startExitActivity(Class cls) {
        getView().startExitActivity(cls);
    }

    @Override
    public void startExitActivity() {
        getView().startExitActivity();
    }

    @Override
    public void showToastShort(String msg) {
        getView().showToastShort(msg);
    }

    @Override
    public void showToastShort(int msgId) {
        getView().showToastShort(msgId);
    }

    @Override
    public void showToastShort(int msgId, String str) {
        getView().showToastShort(msgId, str);
    }

    @Override
    public void showToastShort(int msgId, int str) {
        getView().showToastShort(msgId, str);
    }

    @Override
    public void showToastLong(String msg) {
        getView().showToastLong(msg);
    }

    @Override
    public void showToastLong(int msgId) {
        getView().showToastLong(msgId);
    }

    @Override
    public void showToastLong(int msgId, String str) {
        getView().showToastLong(msgId, str);
    }

    @Override
    public void showToastLong(int msgId, int str) {
        getView().showToastLong(msgId, str);
    }

    @Override
    public boolean isNull(Object obj) {
        return getView().isNull(obj);
    }

    @Override
    public boolean isNotNull(Object obj) {
        return !getView().isNull(obj);
    }

    @Override
    public String getResString(int id) {
        return getView().getResString(id);
    }

    @Override
    public String getResString(int id, Object... formatArgs) {
        return getView().getResString(id, formatArgs);
    }

    @Override
    public int getResColor(int id) {
        return getView().getResColor(id);
    }

    @Override
    public String getString(String key) {
        return getView().getString(key);
    }

    @Override
    public void putString(String key, String value) {
        getView().putString(key, value);
    }

    @Override
    public boolean getBoolean(String key) {
        return getView().getBoolean(key);
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        return getView().getBoolean(key, defValue);
    }

    @Override
    public void putBoolean(String key, Boolean value) {
        getView().putBoolean(key, value);
    }

    @Override
    public int getInt(String key) {
        return getView().getInt(key);
    }

    @Override
    public void putInt(String key, Integer value) {
        getView().putInt(key, value);
    }

    @Override
    public float getFloat(String key) {
        return getView().getFloat(key);
    }

    @Override
    public void putFloat(String key, Float value) {
        getView().putFloat(key, value);
    }

    @Override
    public long getLong(String key) {
        return getView().getLong(key);
    }

    @Override
    public void putLong(String key, Long value) {
        getView().putLong(key, value);
    }

    @Override
    public void v(String tag, String msg) {
        getView().v(tag, msg);
    }

    @Override
    public void d(String tag, String msg) {
        getView().d(tag, msg);
    }

    @Override
    public void i(String tag, String msg) {
        getView().i(tag, msg);
    }

    @Override
    public void w(String tag, String msg) {
        getView().w(tag, msg);
    }

    @Override
    public void e(String tag, String msg) {
        getView().e(tag, msg);
    }

    @Override
    public void syso(String msg) {
        getView().syso(msg);
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 处理按钮抬起事件
     *
     * @param keyCode 按键标示
     * @param event   事件
     * @return 是否拦截，默认不拦截
     */
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return false;
    }
}