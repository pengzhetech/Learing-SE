package com.poizon;

import lombok.Data;

import java.util.Date;

/**
 * @program: trade-order-center
 * @description: 海外 订单取消数据同步信息
 * @author: shicong yang
 * @create: 2020-03-02 15:49
 **/
@Data
public class OverseaOrderCancelDataSynInfo {

    /**
     * 主单号
     */
    private String orderNo;

    /**
     * 子单号
     */
    private String subOrderNo;

    /**
     * 关闭类型
     */
    private Integer closeType;

    /**
     * 退款信息
     */
    private RefundOrder refundOrderInfo;

    /**
     * 是否退押金 0.不退押金 1.退押金 2.退押金（关闭出价）
     */
    private Integer returnDeposit;

    @Data
    public static class RefundOrder {
        /**
         * 退货单号
         */
        private String refundNo;

        /**
         * 主订单编号
         */
        private String orderNo;

        /**
         * 关联的子订单号
         */
        private String subOrderNo;

        /**
         * 产品维度划分，闪电直发等
         */
        private String bizType;

        /**
         * 购买渠道，海外购，秒杀等
         */
        private String bizChannel;

        /**
         * 垂直行业领域划分, 鞋子，数码等
         */
        private String bizCode;

        /**
         * 订单号，外部生成
         */
        private String bizId;

        /**
         * 买家ID
         */
        private Long buyerId;

        /**
         * 买家昵称
         */
        private String buyerName;

        /**
         * 卖家ID
         */
        private Long sellerId;

        /**
         * 卖家昵称
         */
        private String sellerName;

        /**
         * 退款类型，10 退款，20 退货退款，30 换货单，40 自动补单
         */
        private Integer refundType;

        /**
         * 退款状态
         */
        private Integer refundStatus;

        /**
         * 退款原因code
         */
        private Long refundReasonCode;

        /**
         * 定制服务单取消责任方(1买家 2卖家 3平台)
         */
        private Integer responsibleParty;

        /**
         * 子订单from状态
         */
        private Integer fromSubOrderStatus;

        /**
         * 退款原因
         */
        private String refundReason;

        /**
         * skuId
         */
        private Long skuId;

        /**
         * 商品标题
         */
        private String skuTitle;

        /**
         * 商品单价
         */
        private Long skuPrice;

        /**
         * 商品数量
         */
        private Integer skuCount;

        /**
         * 商品信息JSON
         */
        private String itemInfo;

        /**
         * 买家退款留言
         */
        private String buyerNote;

        /**
         * 拓展属性
         */
        private String feature;

        /**
         * 删除标记，0默认，1表示删除
         */
        private Integer isDel;

        /**
         * 创建时间
         */
        private Date createTime;

        /**
         * 更新时间
         */
        private Date modifyTime;

        /**
         * 退换货单关闭类型
         */
        private Integer refundCloseType;

        /**
         * 关闭时间
         */
        private Date refundCloseTime;

        /**
         * 订单关闭类型，0默认
         */
        private Integer tradeCloseType;

        /**
         * 0: 初始状态
         */
        private Long refundMoneyStatus;

        /**
         * 卖家类型
         */
        private Integer sellerType;

        /**
         * 操作人id
         */
        private Long operatorId;

        /**
         * 操作人类型 0：买家，1：系统 2：客服
         */
        private Integer operatorType;

        /**
         * 买家删除标识，0默认
         */
        private Integer buyerDel;

        /**
         * 卖家删除标识，0默认'
         */
        private Integer sellerDel;
        /**
         * 退款原因描述
         */
        private String reasonDesc;
        /**
         * 扣除买家违约金金额
         */
        private Long deductBuyerAmount;

        /**
         * true: 冷静期外取消,false: 冷静期内取消
         */
        private Boolean beyondCoolingPeriod;

        /**
         * 赔付卖家的标
         */
        private Boolean overseaCanCompensateSeller;
    }
}
