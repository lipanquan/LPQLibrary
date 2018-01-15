package com.lpq.base.lib.activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lpq.base.lib.R;
import com.lpq.base.lib.inf.ICurrencyInf;

/**
 * 功能：通用基类Fragment <br />
 * 作者：lipanquan on 2018/1/9 <br />
 * 邮箱：862321807@qq.cn <br />
 */
public class LibBaseFragment extends Fragment implements ICurrencyInf, View.OnClickListener {

    /**
     * 打印log的标志（类名）
     */
    protected final String TAG = this.getClass().getSimpleName();

    /**
     * 标题栏布局
     */
    private RelativeLayout rl_title;

    /**
     * 标题左边的按钮
     */
    private TextView tv_title_left;

    /**
     * 标题中的标题
     */
    private TextView tv_title_title;

    /**
     * 正在加载中的进度
     */
    private ImageView iv_title_loading;

    /**
     * 正在加载中的进度动画
     */
    private AnimationDrawable animationLoading;

    /**
     * 标题右边的按钮
     */
    private TextView tv_title_right;

    /**
     * 初始化标题布局控件
     *
     * @param fragment LibBaseFragment
     */
    protected void initTitle(LibBaseFragment fragment) {
        if (isNotNull(fragment)) {
            rl_title = getView().findViewById(R.id.rl_title);
            tv_title_left = getView().findViewById(R.id.tv_title_left);
            tv_title_title = getView().findViewById(R.id.tv_title_title);
            iv_title_loading = getView().findViewById(R.id.iv_title_loading);
            tv_title_right = getView().findViewById(R.id.tv_title_right);
            tv_title_left.setOnClickListener(this);
            tv_title_right.setOnClickListener(this);
            iv_title_loading.setVisibility(View.GONE);
            animationLoading = (AnimationDrawable) iv_title_loading.getBackground();
            setTitle();
        }
    }


    /**
     * 初始化标题栏显示
     */
    protected void setTitle() {

    }

    @Override
    public void setTitleHeight(int titleHeight) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) rl_title.getLayoutParams();
        params.height = titleHeight;
        rl_title.setLayoutParams(params);
    }

    @Override
    public void setTitleLeft(boolean isVisibility, int drawableLeft, String text) {
        setTitleLeftVisibility(isVisibility);
        setTitleLeftDrawableLeft(drawableLeft);
        setTitleLeftText(text);
    }

    @Override
    public void setTitleLeft(boolean isVisibility, int drawableLeft, int text) {
        setTitleLeftVisibility(isVisibility);
        setTitleLeftDrawableLeft(drawableLeft);
        setTitleLeftText(text);
    }

    @Override
    public void setTitleLeftVisibility(boolean isVisibility) {
        tv_title_left.setVisibility(isVisibility ? View.VISIBLE : View.GONE);
    }

    @Override
    public void setTitleLeftDrawableLeft(int drawableLeft) {
        tv_title_left.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, 0, 0, 0);
    }

    @Override
    public void setTitleLeftText(String text) {
        tv_title_left.setText(text);
    }

    @Override
    public void setTitleLeftText(int text) {
        tv_title_left.setText(text);
    }

    @Override
    public void setTitleLeftAlpha(float alpha) {
        tv_title_left.setAlpha(alpha);
    }

    @Override
    public void startTitleLoading() {
        if (!isNull(iv_title_loading)) {
            iv_title_loading.setVisibility(View.VISIBLE);
            animationLoading.start();
        }
    }

    @Override
    public void stopTitleLoading() {
        if (!isNull(iv_title_loading)) {
            iv_title_loading.setVisibility(View.GONE);
            animationLoading.stop();
        }
    }

    @Override
    public void setTitleVisibility(boolean isVisibility) {
        tv_title_title.setVisibility(isVisibility ? View.VISIBLE : View.GONE);
    }

    @Override
    public void setTitleText(@StringRes int title) {
        tv_title_title.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        tv_title_title.setText(title);
    }

    @Override
    public void setTitleText(String title) {
        tv_title_title.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        tv_title_title.setText(title);
    }

    @Override
    public void setTitleDrawable(@DrawableRes int titleDrawable) {
        tv_title_title.setText("");
        tv_title_title.setCompoundDrawablesWithIntrinsicBounds(titleDrawable, 0, 0, 0);
    }

    @Override
    public void setTitleDrawable(@DrawableRes int titleDrawable, String title) {
        tv_title_title.setText(title);
        tv_title_title.setCompoundDrawablesWithIntrinsicBounds(titleDrawable, 0, 0, 0);
    }

    @Override
    public void setTitleDrawable(@DrawableRes int titleDrawable, @StringRes int title) {
        tv_title_title.setText(title);
        tv_title_title.setCompoundDrawablesWithIntrinsicBounds(titleDrawable, 0, 0, 0);
    }

    @Override
    public void setTitleTextSize(float size) {
        if (size > 8)
            tv_title_title.setTextSize(size);
    }

    @Override
    public void setTitleRightVisibility(boolean isVisibility) {
        tv_title_right.setVisibility(isVisibility ? View.VISIBLE : View.GONE);
    }

    @Override
    public void setTitleRight(boolean isVisibility, String text) {
        setTitleRightVisibility(isVisibility);
        setTitleRightText(text);
    }

    @Override
    public void setTitleRight(boolean isVisibility, int text) {
        setTitleRightVisibility(isVisibility);
        setTitleRightText(text);
    }

    @Override
    public void setTitleRightText(String text) {
        tv_title_right.setText(text);
    }

    @Override
    public void setTitleRightText(int text) {
        tv_title_right.setText(text);
    }

    @Override
    public void setTitleRightDrawable(int drawableRight) {
        setTitleRightVisibility(true);
        tv_title_right.setText("");
        tv_title_right.setCompoundDrawablesWithIntrinsicBounds(drawableRight, 0, 0, 0);
    }

    @Override
    public void setTitleRightEnabled(boolean isEnabled) {
        tv_title_right.setEnabled(isEnabled);
        tv_title_right.setTextColor(getResources().getColor(
                isEnabled ? android.R.color.white : android.R.color.darker_gray));
    }

    @Override
    public void setViewVisible(View view) {
        view.setVisibility(View.VISIBLE);
    }

    @Override
    public void setViewGone(View view) {
        view.setVisibility(View.GONE);
    }

    protected LibBaseActivity getBaseActivity() {
        return (LibBaseActivity) getActivity();
    }

    @Override
    public void closeKeyboard() {
        getBaseActivity().closeKeyboard();
    }

    @Override
    public void openKeyboard() {
        getBaseActivity().openKeyboard();
    }

    @Override
    public boolean getInputMethodState() {
        return getBaseActivity().getInputMethodState();
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        getBaseActivity().startActivityForResult(intent, requestCode);
    }

    @Override
    public void startEnterActivity(Intent intent, boolean isFinish) {
        getBaseActivity().startEnterActivity(intent, isFinish);
    }

    @Override
    public void startEnterActivity(Intent intent) {
        getBaseActivity().startEnterActivity(intent);
    }

    @Override
    public void startEnterActivity(Class cls, boolean isFinish) {
        getBaseActivity().startEnterActivity(cls, isFinish);
    }

    @Override
    public void startEnterActivity(Class cls) {
        getBaseActivity().startEnterActivity(cls);
    }

    @Override
    public void startExitActivity(Intent intent, boolean isFinish) {
        getBaseActivity().startExitActivity(intent, isFinish);
    }

    @Override
    public void startExitActivity(Intent intent) {
        getBaseActivity().startExitActivity(intent);
    }

    @Override
    public void startExitActivity(Class cls, boolean isFinish) {
        getBaseActivity().startEnterActivity(cls, isFinish);
    }

    @Override
    public void startExitActivity(Class cls) {
        getBaseActivity().startExitActivity(cls);
    }

    @Override
    public void startExitActivity() {
        getBaseActivity().startExitActivity();
    }

    @Override
    public void showToastShort(String msg) {
        getBaseActivity().showToastShort(msg);
    }

    @Override
    public void showToastShort(@StringRes int msgId) {
        getBaseActivity().showToastShort(msgId);
    }

    @Override
    public void showToastShort(@StringRes int msgId, String str) {
        getBaseActivity().showToastShort(msgId, str);
    }

    @Override
    public void showToastShort(@StringRes int msgId, @StringRes int str) {
        getBaseActivity().showToastShort(msgId, str);
    }

    @Override
    public void showToastLong(String msg) {
        getBaseActivity().showToastLong(msg);
    }

    @Override
    public void showToastLong(@StringRes int msgId) {
        getBaseActivity().showToastLong(msgId);
    }

    @Override
    public void showToastLong(@StringRes int msgId, String str) {
        getBaseActivity().showToastLong(msgId, str);
    }

    @Override
    public void showToastLong(@StringRes int msgId, @StringRes int str) {
        getBaseActivity().showToastLong(msgId, str);
    }

    @Override
    public boolean isNull(Object obj) {
        return getBaseActivity().isNull(obj);
    }

    @Override
    public boolean isNotNull(Object obj) {
        return getBaseActivity().isNotNull(obj);
    }

    @Override
    public String getResString(@StringRes int id) {
        return getResources().getString(id);
    }

    @Override
    public String getResString(@StringRes int stringRseId, Object... formatArgs) {
        return getResources().getString(stringRseId, formatArgs);
    }

    @Override
    public int getResColor(@ColorRes int id) {
        return getResources().getColor(id);
    }

    @Override
    public String getString(String key) {
        return getBaseActivity().getString(key);
    }

    @Override
    public void putString(String key, String value) {
        getBaseActivity().putString(key, value);
    }

    @Override
    public boolean getBoolean(String key) {
        return getBaseActivity().getBoolean(key);
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        return getBaseActivity().getBoolean(key, defValue);
    }

    @Override
    public void putBoolean(String key, Boolean value) {
        getBaseActivity().putBoolean(key, value);
    }

    @Override
    public int getInt(String key) {
        return getBaseActivity().getInt(key);
    }

    @Override
    public void putInt(String key, Integer value) {
        getBaseActivity().putInt(key, value);
    }

    @Override
    public float getFloat(String key) {
        return getBaseActivity().getFloat(key);
    }

    @Override
    public void putFloat(String key, Float value) {
        getBaseActivity().putFloat(key, value);
    }

    @Override
    public long getLong(String key) {
        return getBaseActivity().getLong(key);
    }

    @Override
    public void putLong(String key, Long value) {
        getBaseActivity().putLong(key, value);
    }

    @Override
    public void v(String tag, String msg) {
        getBaseActivity().v(tag, msg);
    }

    @Override
    public void d(String tag, String msg) {
        getBaseActivity().d(tag, msg);
    }

    @Override
    public void i(String tag, String msg) {
        getBaseActivity().i(tag, msg);
    }

    @Override
    public void w(String tag, String msg) {
        getBaseActivity().w(tag, msg);
    }

    @Override
    public void e(String tag, String msg) {
        getBaseActivity().e(tag, msg);
    }

    @Override
    public void syso(String msg) {
        getBaseActivity().syso(msg);
    }

    @Override
    public void onClick(View v) {
        if (v == tv_title_left) { // 返回上一页
            startExitActivity();
        }
    }
}
