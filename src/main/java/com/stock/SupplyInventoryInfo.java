package com.stock;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 渠道库存表
 */
@Data
public class SupplyInventoryInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 自增ID
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * dewu
     */
    private String supplyName;

    /**
     * spu_id
     */
    private Long spuId;

    /**
     * sku_id
     */
    private Long skuId;

    /**
     * 出价类型
     */
    private Long biddingType;

    /**
     * 销售数量
     */
    private Long quantity;

    /**
     * 按天分区时间
     */
    private String ptDay;

    /**
     * 按小时分区时间
     */
    private String ptHour;


}