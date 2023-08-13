package com.gray;

import cn.hutool.core.collection.CollectionUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class GrayUtil {
    private GrayUtil() {
    }

    private static final String LOG_OUTPUT = "hitGray,key:{},result:{}";

    private static final String LOG_OUTPUT_2_KEY = "hitGray,key1:{},key2:{},result:{}";

    /**
     * 判断是否命中灰度，字符类型灰度key
     *
     * @param grayConfig
     * @param charGrayKey
     * @return
     */
    public static boolean hitGray(GrayConfig grayConfig, String charGrayKey) {
        if (grayConfig == null) {
            return false;
        }
        if (Objects.equals(grayConfig.getMainSwitch(), true)) {
            return true;
        }
        if (StringUtils.isBlank(charGrayKey)) {
            return false;
        }
        if (CollectionUtil.isNotEmpty(grayConfig.getCharWhiteKeys()) && grayConfig.getCharWhiteKeys().contains(charGrayKey)) {
            return true;
        }
        if (grayConfig.getModulo() == null || grayConfig.getRatio() == null) {
            return false;
        }
        int unSighedHashCode = getUnsignedHashCode(charGrayKey);
        boolean result = unSighedHashCode % grayConfig.getModulo() <= grayConfig.getRatio();
        return result;
    }

    /**
     * 取字符类型grayKey unsignedHashcode
     *
     * @param charGrayKey
     * @return
     */
    private static int getUnsignedHashCode(String charGrayKey) {
        int hashCode = charGrayKey.hashCode();
        if (hashCode < 0) {
            return -hashCode;
        }
        return hashCode;
    }


    /**
     * 判断是否命中灰度，数值类型灰度key
     *
     * @param grayConfig
     * @param numGrayKey
     * @return
     */
    public static boolean hitGray(GrayConfig grayConfig, Long numGrayKey) {
        if (grayConfig == null) {
            return false;
        }
        if (Objects.equals(grayConfig.getMainSwitch(), true)) {
            return true;
        }
        if (numGrayKey == null) {
            return false;
        }
        if (CollectionUtil.isNotEmpty(grayConfig.getNumWhiteKeys()) && grayConfig.getNumWhiteKeys().contains(numGrayKey)) {
            return true;
        }
        if (grayConfig.getModulo() == null || grayConfig.getRatio() == null) {
            return false;
        }
        boolean result = numGrayKey % grayConfig.getModulo() <= grayConfig.getRatio();
        return result;
    }

    /**
     * 判断是否命中灰度，数值、字符 组合灰度key(或关系)，不支持灰度比例控制
     *
     * @param grayConfig
     * @param numGrayKey
     * @param charGrayKey
     * @return
     */
    public static boolean hitGray(GrayConfig grayConfig, Long numGrayKey, String charGrayKey) {
        if (grayConfig == null) {
            return false;
        }
        if (Objects.equals(grayConfig.getMainSwitch(), true)) {
            return true;
        }
        if (numGrayKey == null || charGrayKey == null) {
            return false;
        }
        if (CollectionUtil.isNotEmpty(grayConfig.getCharWhiteKeys()) && grayConfig.getCharWhiteKeys().contains(charGrayKey)) {
            return true;
        }
        if (CollectionUtil.isNotEmpty(grayConfig.getNumWhiteKeys()) && grayConfig.getNumWhiteKeys().contains(numGrayKey)) {
            return true;
        }
        return false;
    }
}
