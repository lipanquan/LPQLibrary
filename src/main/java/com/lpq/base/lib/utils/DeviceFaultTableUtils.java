package com.lpq.base.lib.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 设备故障表工具类
 /**
 * 功能：格式化日期时间工具类 <br/>
 * 作者：lipanquan on 2018/1/9 <br />
 * 邮箱：862321807@qq.cn <br />
 */
public final class DeviceFaultTableUtils {
    private DeviceFaultTableUtils() {
    }

    private static DeviceFaultTableUtils instance = new DeviceFaultTableUtils();

    /**
     * 获取故障表工具类对象
     *
     * @return 故障表工具类对象
     */
    public static DeviceFaultTableUtils getInstance() {
        return instance;
    }

    /**
     * 添加设备故障
     *
     * @param deviceFaultType 设备故障类型（类型如下：）
     *                        1	无法读身份证  DeviceFaultTableUtils.DEVICE_FAULT_TYPE__UNABLE_TO_READ_ID_CARD
     *                        2	无法读社保卡  DeviceFaultTableUtils.DEVICE_FAULT_TYPE__UNABLE_TO_READ_SOCIAL_SECURITY_CARD
     *                        3	指静脉故障   DeviceFaultTableUtils.DEVICE_FAULT_TYPE__FINGER_VEIN_MALFUNCTION
     *                        4	指纹仪故障   DeviceFaultTableUtils.DEVICE_FAULT_TYPE__FINGERPRINT_INSTRUMENT_FAULT
     *                        5	网络故障    DeviceFaultTableUtils.DEVICE_FAULT_TYPE__NETWORK_FAULT
     *                        6	触摸屏故障   DeviceFaultTableUtils.DEVICE_FAULT_TYPE__TOUCH_SCREEN_FAULT
     *                        7	摄像头故障   DeviceFaultTableUtils.DEVICE_FAULT_TYPE__CAMERA_FAULT
     *                        8	电话无法使用  DeviceFaultTableUtils.DEVICE_FAULT_TYPE__THE_PHONE_IS_UNAVAILABLE
     *                        9	无法进行认证  DeviceFaultTableUtils.DEVICE_FAULT_TYPE__UNABLE_TO_AUTHENTICATE
     *                        10 程序无响应   DeviceFaultTableUtils.DEVICE_FAULT_TYPE__PROGRAM_UNRESPONSIVE
     *                        11 社保无法查询  DeviceFaultTableUtils.DEVICE_FAULT_TYPE__SOCIAL_SECURITY_CAN_NOT_QUERY
     *                        12 其他故障    DeviceFaultTableUtils.DEVICE_FAULT_TYPE__OTHER_FAULT
     */
    public void addDeviceFault(String deviceFaultType) {
        DeviceFaultTableUtils.deviceFaultTables.add(deviceFaultType);
    }

    /**
     * 获取故障表
     *
     * @return 故障表
     */
    public List<String> getDeviceFaultTables() {
        return new ArrayList<>(DeviceFaultTableUtils.deviceFaultTables);
    }

    /**
     * 清楚故障表
     */
    public void clearDeviceFaultTables() {
        DeviceFaultTableUtils.deviceFaultTables.clear();
    }

    /**
     * 1	无法读身份证  DeviceFaultTableUtils.DEVICE_FAULT_TYPE__UNABLE_TO_READ_ID_CARD
     * 2	无法读社保卡  DeviceFaultTableUtils.DEVICE_FAULT_TYPE__UNABLE_TO_READ_SOCIAL_SECURITY_CARD
     * 3	指静脉故障   DeviceFaultTableUtils.DEVICE_FAULT_TYPE__FINGER_VEIN_MALFUNCTION
     * 4	指纹仪故障   DeviceFaultTableUtils.DEVICE_FAULT_TYPE__FINGERPRINT_INSTRUMENT_FAULT
     * 5	网络故障    DeviceFaultTableUtils.DEVICE_FAULT_TYPE__NETWORK_FAULT
     * 6	触摸屏故障   DeviceFaultTableUtils.DEVICE_FAULT_TYPE__TOUCH_SCREEN_FAULT
     * 7	摄像头故障   DeviceFaultTableUtils.DEVICE_FAULT_TYPE__CAMERA_FAULT
     * 8	电话无法使用  DeviceFaultTableUtils.DEVICE_FAULT_TYPE__THE_PHONE_IS_UNAVAILABLE
     * 9	无法进行认证  DeviceFaultTableUtils.DEVICE_FAULT_TYPE__UNABLE_TO_AUTHENTICATE
     * 10	程序无响应   DeviceFaultTableUtils.DEVICE_FAULT_TYPE__PROGRAM_UNRESPONSIVE
     * 11	社保无法查询  DeviceFaultTableUtils.DEVICE_FAULT_TYPE__SOCIAL_SECURITY_CAN_NOT_QUERY
     * 12	其他故障    DeviceFaultTableUtils.DEVICE_FAULT_TYPE__OTHER_FAULT
     */
    private static final HashSet<String> deviceFaultTables = new HashSet<>();

    /**
     * 设备故障--无法读身份证
     */
    public static final String DEVICE_FAULT_TYPE__UNABLE_TO_READ_ID_CARD = "1";

    /**
     * 设备故障--无法读社保卡
     */
    public static final String DEVICE_FAULT_TYPE__UNABLE_TO_READ_SOCIAL_SECURITY_CARD = "2";

    /**
     * 设备故障--指静脉故障
     */
    public static final String DEVICE_FAULT_TYPE__FINGER_VEIN_MALFUNCTION = "3";

    /**
     * 设备故障--指纹仪故障
     */
    public static final String DEVICE_FAULT_TYPE__FINGERPRINT_INSTRUMENT_FAULT = "4";

    /**
     * 设备故障--网络故障
     */
    public static final String DEVICE_FAULT_TYPE__NETWORK_FAULT = "5";

    /**
     * 设备故障--触摸屏故障
     */
    public static final String DEVICE_FAULT_TYPE__TOUCH_SCREEN_FAULT = "6";

    /**
     * 设备故障--摄像头故障
     */
    public static final String DEVICE_FAULT_TYPE__CAMERA_FAULT = "7";

    /**
     * 设备故障--电话无法使用
     */
    public static final String DEVICE_FAULT_TYPE__THE_PHONE_IS_UNAVAILABLE = "8";

    /**
     * 设备故障--无法进行认证
     */
    public static final String DEVICE_FAULT_TYPE__UNABLE_TO_AUTHENTICATE = "9";

    /**
     * 设备故障--程序无响应
     */
    public static final String DEVICE_FAULT_TYPE__PROGRAM_UNRESPONSIVE = "10";

    /**
     * 设备故障--社保无法查询
     */
    public static final String DEVICE_FAULT_TYPE__SOCIAL_SECURITY_CAN_NOT_QUERY = "11";

    /**
     * 设备故障--其他故障
     */
    public static final String DEVICE_FAULT_TYPE__OTHER_FAULT = "12";
}