package com.lpq.base.lib.presenter;

import android.view.KeyEvent;
import android.view.View;

import java.lang.ref.WeakReference;

import com.lpq.base.lib.inf.ILibBaseView;
import com.lpq.base.lib.utils.IsNull;

/**
 * 功能：业务逻辑处理基类  <br/>
 * 作者：lipanquan on 2018/1/9 <br />
 * 邮箱：862321807@qq.cn <br />
 */
public abstract class LibBasePresenter<V extends ILibBaseView> implements View.OnClickListener {

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

    /**
     * 判断对象是否为空
     *
     * @param obj 要判断的对象
     * @return 空就返回true
     */
    public boolean isNull(Object obj) {
        return IsNull.isNull(obj);
    }

    /**
     * 判断对象不为空
     *
     * @param obj 要判断的对象
     * @return 非空就返回true
     */
    public boolean isNotNull(Object obj) {
        return !IsNull.isNull(obj);
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