package com.poizon;

import com.poizon.fusion.utils.JsonUtils;

public class Main {


    public static void main(String[] args) {
        String s = "{\n" +
                "    \"orderNo\": \"510105639152751881\",\n" +
                "    \"subOrderNo\": \"110105639152741881\",\n" +
                "    \"closeType\": 15,\n" +
                "    \"refundOrderInfo\": {\n" +
                "        \"refundNo\": \"RE101000107561131881\",\n" +
                "        \"orderNo\": \"510105639152751881\",\n" +
                "        \"subOrderNo\": \"110105639152741881\",\n" +
                "        \"bizType\": \"20\",\n" +
                "        \"bizChannel\": \"trade_orderDetail\",\n" +
                "        \"bizCode\": \"duapp.general\",\n" +
                "        \"bizId\": \"\",\n" +
                "        \"buyerId\": 106551881,\n" +
                "        \"buyerName\": \"独立黑魂h4t1P\",\n" +
                "        \"sellerId\": 112281966,\n" +
                "        \"sellerName\": \"du_114c6ca7ba5c2\",\n" +
                "        \"refundType\": 10,\n" +
                "        \"refundStatus\": 3000,\n" +
                "        \"refundReasonCode\": 46,\n" +
                "        \"refundReason\": \"买贵了\",\n" +
                "        \"skuId\": 6039926149,\n" +
                "        \"skuTitle\": \"测试数据同步\",\n" +
                "        \"skuPrice\": 54900,\n" +
                "        \"skuCount\": 1,\n" +
                "        \"itemInfo\": \"{\\\"skuId\\\":6039926149,\\\"skuPic\\\":\\\"https://cdn.poizon.com/pro-img/origin-img/20230113/8db104f396f84871bec66da65817f63e.png\\\",\\\"skuCategory\\\":302,\\\"skuTitle\\\":\\\"测试数据同步\\\",\\\"spuId\\\":1000579986,\\\"spuTitle\\\":\\\"测试数据同步\\\",\\\"skuProp\\\":{\\\"6\\\":\\\"M\\\"},\\\"skuTagType\\\":20,\\\"signupPrice\\\":0,\\\"authPrice\\\":0,\\\"articleNumber\\\":\\\"SYNC-TEST-001\\\",\\\"otherNumbers\\\":\\\"\\\",\\\"preSellDeliverTime\\\":0,\\\"isSelf\\\":0,\\\"sellLimitPurchase\\\":0,\\\"preSellLimitPurchase\\\":0,\\\"level1CategoryId\\\":2,\\\"level2CategoryId\\\":3,\\\"categoryTag\\\":\\\"{\\\\\\\"PAYMENT\\\\\\\":[\\\\\\\"PAYMENT_HUABEI\\\\\\\",\\\\\\\"PAYMENT_HUABEI_STAGING\\\\\\\"]}\\\",\\\"goodsType\\\":1,\\\"brandId\\\":144,\\\"brandName\\\":\\\"Nike\\\",\\\"relationBrandIds\\\":\\\"\\\",\\\"fitId\\\":2,\\\"receiveMinTime\\\":8,\\\"receiveMaxTime\\\":18,\\\"receiveStandardTime\\\":8,\\\"customizationProcessTime\\\":0,\\\"textLengthLimit\\\":12,\\\"saleAfterFlag\\\":0,\\\"unconditionalReturn\\\":0,\\\"hasQualityLabel\\\":false,\\\"categoryMigratedAt210606\\\":false,\\\"spuBizType\\\":0,\\\"hasEducationSpu\\\":false,\\\"belongLuxury\\\":false,\\\"storePickUpFlag\\\":false,\\\"version\\\":1677750233000,\\\"additionVoiceCardFlag\\\":false,\\\"skuLableList\\\":[],\\\"brandLogoUrl\\\":\\\"https://cdn.poizon.com/pro-img/cut-img/20230801/b87991f8c1f24cab86c6ccec3477a1bb.jpg\\\"}\",\n" +
                "        \"buyerNote\": \"\",\n" +
                "        \"feature\": \"{\\\"spreadPrice\\\":0,\\\"disAmount\\\":0,\\\"originalMoney\\\":0,\\\"price\\\":0,\\\"deposit\\\":0,\\\"trueMoney\\\":0,\\\"needRecoverSaleInv\\\":false,\\\"needReturnDeposit\\\":false,\\\"deductDeposit\\\":false,\\\"needReturnEarnest\\\":false,\\\"hpde\\\":false,\\\"accbuyer\\\":false,\\\"sopd\\\":false,\\\"overseaCanCompensateSeller\\\":true,\\\"beforeShipRiskReject\\\":true}\",\n" +
                "        \"isDel\": 0,\n" +
                "        \"createTime\": \"2024-01-07 15:34:17.781\",\n" +
                "        \"modifyTime\": \"2024-01-07 15:34:17.781\",\n" +
                "        \"tradeCloseType\": 15,\n" +
                "        \"refundMoneyStatus\": 0,\n" +
                "        \"sellerType\": 8,\n" +
                "        \"operatorId\": 0,\n" +
                "        \"operatorType\": 2,\n" +
                "        \"buyerDel\": 0,\n" +
                "        \"sellerDel\": 0,\n" +
                "        \"responsibleParty\": 1,\n" +
                "        \"fromSubOrderStatus\": 2010,\n" +
                "        \"reasonDesc\": \"12\",\n" +
                "        \"beyondCoolingPeriod\": true\n" +
                "    },\n" +
                "    \"returnDeposit\": 0\n" +
                "}";
        OverseaOrderCancelDataSynInfo info = JsonUtils.deserialize(s, OverseaOrderCancelDataSynInfo.class);
        System.out.println(info.getRefundOrderInfo().getFeature());
    }
}
