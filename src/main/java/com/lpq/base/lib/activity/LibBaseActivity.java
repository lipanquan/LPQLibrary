package com.lpq.base.lib.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lpq.base.lib.LibApplication;
import com.lpq.base.lib.R;
import com.lpq.base.lib.inf.ICurrencyInf;
import com.lpq.base.lib.inf.ILibBaseView;
import com.lpq.base.lib.utils.IsNull;
import com.lpq.base.lib.utils.Logger;
import com.lpq.base.lib.utils.SharedPreferencesUtils;
import com.lpq.base.lib.utils.SystemOut;
import com.lpq.base.lib.utils.ToastUtils;

/**
 * 功能：通用标题基类Activity <br />
 * 作者：lipanquan on 2018/1/9 <br />
 * 邮箱：862321807@qq.cn <br />
 */
public abstract class LibBaseActivity extends AppCompatActivity
        implements ILibBaseView, OnClickListener, ICurrencyInf {

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
     * 软键盘管理对象
     */
    private InputMethodManager inputMethodManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (isFullScreen()) {
            //取消标题栏
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            //取消状态栏
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        super.onCreate(savedInstanceState);
        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        ((LibApplication) getApplication()).addActivity(this);
    }

    /**
     * 是否全屏
     *
     * @return true为全屏
     */
    protected boolean isFullScreen() {
        return false;
    }

    @Override
    public void closeKeyboard() {
        try {
            IBinder windowToken = getCurrentFocus().getWindowToken();
            if (!isNull(windowToken)) {
                getWindow().setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void openKeyboard() {
        inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    @Override
    public boolean getInputMethodState() {
        return getWindow().getAttributes().softInputMode == WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((LibApplication) getApplication()).removeActivity(this);
    }

    /**
     * 初始化标题布局控件
     *
     * @param activity LibBaseActivity
     */
    protected void initTitle(LibBaseActivity activity) {
        if (isNotNull(activity)) {
            rl_title = activity.findViewById(R.id.rl_title);
            tv_title_left = activity.findViewById(R.id.tv_title_left);
            tv_title_title = activity.findViewById(R.id.tv_title_title);
            iv_title_loading = activity.findViewById(R.id.iv_title_loading);
            tv_title_right = activity.findViewById(R.id.tv_title_right);
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
    public void onClick(View v) {
        if (v == tv_title_left) { // 返回上一页
            startExitActivity();
        }
    }

    /**
     * 启动activity，伴随动画是进入动画（当前activity从右向左移出，要启动的activity从右向左进入）
     *
     * @param intent      Intent
     * @param requestCode 请求码
     */
    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        // overridePendingTransition(R.anim.tran_next_enter,
        // R.anim.tran_next_exit);
    }

    public void startActivityForResult(Class cls, int requestCode) {
        this.startActivityForResult(new Intent(this, cls), requestCode);
    }

    @Override
    public void startEnterActivity(Intent intent, boolean isFinish) {
        startEnterActivity(intent);
        if (isFinish)
            finish();
    }

    @Override
    public void startEnterActivity(Intent intent) {
        startActivity(intent);
        // overridePendingTransition(R.anim.tran_next_enter,
        // R.anim.tran_next_exit);
    }

    @Override
    public void startEnterActivity(Class cls, boolean isFinish) {
        startEnterActivity(cls);
        if (isFinish)
            finish();
    }

    @Override
    public void startEnterActivity(Class cls) {
        startActivity(new Intent(this, cls));
        // overridePendingTransition(R.anim.tran_next_enter,
        // R.anim.tran_next_exit);
    }

    @Override
    public void startExitActivity(Intent intent, boolean isFinish) {
        startExitActivity(intent);
        if (isFinish)
            finish();
    }

    @Override
    public void startExitActivity(Intent intent) {
        startActivity(intent);
        // overridePendingTransition(R.anim.tran_last_enter,
        // R.anim.tran_last_exit);
    }

    @Override
    public void startExitActivity(Class cls, boolean isFinish) {
        startExitActivity(cls);
        if (isFinish)
            finish();
    }

    @Override
    public void startExitActivity(Class cls) {
        startActivity(new Intent(this, cls));
        // overridePendingTransition(R.anim.tran_last_enter,
        // R.anim.tran_last_exit);
    }

    @Override
    public void startExitActivity() {
        finish();
        // overridePendingTransition(R.anim.tran_last_enter,
        // R.anim.tran_last_exit);
    }

    @Override
    public int getResColor(@ColorRes int colorRseId) {
        return getResources().getColor(colorRseId);
    }

    @Override
    public String getResString(@StringRes int stringRseId) {
        return getResources().getString(stringRseId);
    }

    @Override
    public void setViewVisible(@NonNull View view) {
        view.setVisibility(View.VISIBLE);
    }

    @Override
    public void setViewGone(@NonNull View view) {
        view.setVisibility(View.GONE);
    }

    @Override
    public void showToastShort(String msg) {
        ToastUtils.showToastShort(this, msg);
    }

    @Override
    public void showToastShort(@StringRes int msgId) {
        ToastUtils.showToastShort(this, msgId);
    }

    @Override
    public void showToastShort(@StringRes int msgId, String str) {
        showToastShort(getResString(msgId) + str);
    }

    @Override
    public void showToastShort(@StringRes int msgId, @StringRes int str) {
        showToastShort(getResString(msgId) + getResString(str));
    }

    @Override
    public void showToastLong(String msg) {
        ToastUtils.showToastLong(this, msg);
    }

    @Override
    public void showToastLong(@StringRes int msgId, String str) {
        showToastLong(getResString(msgId) + str);
    }

    @Override
    public void showToastLong(@StringRes int msgId, @StringRes int str) {
        showToastLong(getResString(msgId) + getResString(str));
    }

    @Override
    public void showToastLong(int msgId) {
        ToastUtils.showToastLong(this, msgId);
    }

    @Override
    public boolean isNull(Object obj) {
        return IsNull.isNull(obj);
    }

    @Override
    public boolean isNotNull(Object obj) {
        return !IsNull.isNull(obj);
    }

    @Override
    public String getString(String key) {
        return SharedPreferencesUtils.getInstance(this).getString(key);
    }

    @Override
    public void putString(String key, String value) {
        SharedPreferencesUtils.getInstance(this).putString(key, value);
    }

    @Override
    public Boolean getBoolean(String key) {
        return SharedPreferencesUtils.getInstance(this).getBoolean(key, false);
    }

    @Override
    public Boolean getBoolean(String key, boolean defValue) {
        return SharedPreferencesUtils.getInstance(this).getBoolean(key, defValue);
    }

    @Override
    public void putBoolean(String key, Boolean value) {
        SharedPreferencesUtils.getInstance(this).putBoolean(key, value);
    }

    @Override
    public Integer getInt(String key) {
        return SharedPreferencesUtils.getInstance(this).getInt(key);
    }

    @Override
    public void putInt(String key, Integer value) {
        SharedPreferencesUtils.getInstance(this).putInt(key, value);
    }

    @Override
    public Float getFloat(String key) {
        return SharedPreferencesUtils.getInstance(this).getFloat(key);
    }

    @Override
    public void putFloat(String key, Float value) {
        SharedPreferencesUtils.getInstance(this).putFloat(key, value);
    }

    @Override
    public Long getLong(String key) {
        return SharedPreferencesUtils.getInstance(this).getLong(key);
    }

    @Override
    public void putLong(String key, Long value) {
        SharedPreferencesUtils.getInstance(this).putLong(key, value);
    }

    @Override
    public void v(String tag, String msg) {
        Logger.v(tag, msg);
    }

    @Override
    public void d(String tag, String msg) {
        Logger.d(tag, msg);
    }

    @Override
    public void i(String tag, String msg) {
        Logger.i(tag, msg);
    }

    @Override
    public void w(String tag, String msg) {
        Logger.w(tag, msg);
    }

    @Override
    public void e(String tag, String msg) {
        Logger.e(tag, msg);
    }

    @Override
    public void syso(String msg) {
        SystemOut.sysoString(msg);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            startExitActivity();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
}