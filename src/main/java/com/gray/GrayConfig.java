package com.gray;

import lombok.Data;

import java.util.List;

@Data
public class GrayConfig {

    /**
     * 总开关
     */
    private Boolean mainSwitch;

    /**
     * 字符类型白名单
     */
    private List<String> charWhiteKeys;

    /**
     * 数值类型白名单
     */
    private List<Long> numWhiteKeys;

    /**
     * 灰度比例，取模后数值
     */
    private Integer ratio;

    /**
     * 模数
     */
    private Integer modulo;
}
