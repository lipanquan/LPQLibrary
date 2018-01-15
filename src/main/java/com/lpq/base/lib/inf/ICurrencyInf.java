package com.lpq.base.lib.inf;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

/**
 * 功能：activity和fragment的通用接口 <br/>
 * 作者：lipanquan on 2018/1/9 <br />
 * 邮箱：862321807@qq.cn <br />
 */
public interface ICurrencyInf extends IPublicInf {

    /**
     * 设置标题栏的高度
     *
     * @param titleHeight 标题栏的高度
     */
    void setTitleHeight(int titleHeight);

    /**
     * 设置左边按钮的属性
     *
     * @param isVisibility 设置左边按钮是否显示
     * @param drawableLeft 设置左边按钮显示的图片
     * @param text         设置左边按钮显示的文字
     */
    void setTitleLeft(boolean isVisibility, @DrawableRes int drawableLeft, @NonNull String text);

    /**
     * 设置左边按钮的属性
     *
     * @param isVisibility 设置左边按钮是否显示
     * @param drawableLeft 设置左边按钮显示的图片
     * @param text         设置左边按钮显示的文字
     */
    void setTitleLeft(boolean isVisibility, @DrawableRes int drawableLeft, @StringRes int text);

    /**
     * 设置左边按钮是否显示
     *
     * @param isVisibility 是否显示
     */
    void setTitleLeftVisibility(boolean isVisibility);

    /**
     * 设置左边按钮显示的图片
     *
     * @param drawableLeft 图片资源
     */
    void setTitleLeftDrawableLeft(@DrawableRes int drawableLeft);

    /**
     * 设置左边按钮显示的文字
     *
     * @param text String类型的文字
     */
    void setTitleLeftText(@NonNull String text);

    /**
     * 设置左边按钮显示的文字
     *
     * @param text int类型的引用
     */
    void setTitleLeftText(@StringRes int text);

    /**
     * 设置左边按钮透明度
     *
     * @param alpha float类型的透明度
     */
    void setTitleLeftAlpha(float alpha);

    /**
     * 开始加载数据
     */
    void startTitleLoading();

    /**
     * 加载数据完成
     */
    void stopTitleLoading();

    /**
     * 设置标题显示或隐藏<br/>
     * 并自动将RadioGroup标题自动设置为相反的显示或隐藏状态
     *
     * @param isVisibility true显示或false隐藏
     */
    void setTitleVisibility(boolean isVisibility);

    /**
     * 设置标题文字（无图标）
     *
     * @param title 标题文字显示
     */
    void setTitleText(@StringRes int title);

    /**
     * 设置标题文字（无图标）
     *
     * @param title 标题文字显示
     */
    void setTitleText(@NonNull String title);

    /**
     * 设置标题图标
     *
     * @param titleDrawable 标题图标
     */
    void setTitleDrawable(@DrawableRes int titleDrawable);

    /**
     * 设置标题图标及文字
     *
     * @param titleDrawable 标题图标
     * @param title         标题文字显示
     */
    void setTitleDrawable(@DrawableRes int titleDrawable, String title);

    /**
     * 设置标题图标及文字
     *
     * @param titleDrawable 标题图标
     * @param title         标题文字显示
     */
    void setTitleDrawable(@DrawableRes int titleDrawable, @StringRes int title);

    /**
     * 设置标题的字体大小
     *
     * @param size 字体大小
     */
    void setTitleTextSize(float size);

    /**
     * 设置标题栏右边按钮是否显示
     *
     * @param isVisibility true为显示，false不显示
     */
    void setTitleRightVisibility(boolean isVisibility);

    /**
     * 设置右边按钮的属性
     *
     * @param isVisibility 设置右边按钮是否显示
     * @param text         设置右边按钮显示的文字
     */
    void setTitleRight(boolean isVisibility, String text);

    /**
     * 设置右边按钮的属性
     *
     * @param isVisibility 设置右边按钮是否显示
     * @param text         设置右边按钮显示的文字
     */
    void setTitleRight(boolean isVisibility, @StringRes int text);

    /**
     * 设置右边按钮显示的文字
     *
     * @param text 显示的文字
     */
    void setTitleRightText(@NonNull String text);

    /**
     * 设置右边按钮显示的文字
     *
     * @param text 显示的文字
     */
    void setTitleRightText(@StringRes int text);

    /**
     * 设置右边按钮显示的图片
     *
     * @param drawableRight 显示的图片
     */
    void setTitleRightDrawable(@DrawableRes int drawableRight);

    /**
     * 设置右边按钮是否可用
     *
     * @param isEnabled true为可用，false为不可用
     */
    void setTitleRightEnabled(boolean isEnabled);
}