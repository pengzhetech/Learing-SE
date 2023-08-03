package com.stock;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.javaman.classloader.D;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        SupplyInventoryInfoSnapshot snapshot999 = new SupplyInventoryInfoSnapshot();

        snapshot999.setId(10L);
        snapshot999.setQuantity(10L);
        snapshot999.setBiddingType(1L);
        snapshot999.setCreateTime(new Date());
        snapshot999.setModifyTime(new Date());
        snapshot999.setPtDay("20282323");
        snapshot999.setPtHour("234324");

        SupplyInventoryInfo info999 = new SupplyInventoryInfo();
        SupplyInventoryInfo info99988 = new SupplyInventoryInfo();

        BeanUtil.copyProperties(snapshot999, info999);
        BeanUtil.copyProperties(snapshot999, info99988,"id");

        System.out.println("info999"+JSON.toJSONString(info999));
        System.out.println("info99988"+JSON.toJSONString(info99988));


        List<SupplyInventoryInfo> supplyInventoryInfos = Lists.newArrayList();
        SupplyInventoryInfo info1 = new SupplyInventoryInfo();
        info1.setSkuId(1L);
        info1.setQuantity(1L);
        SupplyInventoryInfo info2 = new SupplyInventoryInfo();
        info2.setSkuId(2L);
        info2.setQuantity(2L);
        SupplyInventoryInfo info3 = new SupplyInventoryInfo();
        info3.setSkuId(3L);
        info3.setQuantity(3L);
        SupplyInventoryInfo info4 = new SupplyInventoryInfo();
        info4.setSkuId(4L);
        info4.setQuantity(4L);
        SupplyInventoryInfo info5 = new SupplyInventoryInfo();
        info5.setSkuId(5L);
        info5.setQuantity(10L);
        SupplyInventoryInfo info6 = new SupplyInventoryInfo();
        info6.setSkuId(9L);
        info6.setQuantity(6L);
        supplyInventoryInfos.add(info1);
        supplyInventoryInfos.add(info2);
        supplyInventoryInfos.add(info3);
        supplyInventoryInfos.add(info4);
        supplyInventoryInfos.add(info5);
        supplyInventoryInfos.add(info6);

        List<SupplyInventoryInfoSnapshot> supplyInventoryInfoSnapshots = Lists.newArrayList();
        SupplyInventoryInfoSnapshot snapshot1 = new SupplyInventoryInfoSnapshot();
        snapshot1.setSkuId(1L);
        snapshot1.setQuantity(1L);
        SupplyInventoryInfoSnapshot snapshot2 = new SupplyInventoryInfoSnapshot();
        snapshot2.setSkuId(2L);
        snapshot2.setQuantity(2L);
        SupplyInventoryInfoSnapshot snapshot3 = new SupplyInventoryInfoSnapshot();
        snapshot3.setSkuId(3L);
        snapshot3.setQuantity(3L);
        SupplyInventoryInfoSnapshot snapshot4 = new SupplyInventoryInfoSnapshot();
        snapshot4.setSkuId(4L);
        snapshot4.setQuantity(4L);
        SupplyInventoryInfoSnapshot snapshot5 = new SupplyInventoryInfoSnapshot();
        snapshot5.setSkuId(5L);
        snapshot5.setQuantity(5L);
        SupplyInventoryInfoSnapshot snapshot6 = new SupplyInventoryInfoSnapshot();
        snapshot6.setSkuId(6L);
        snapshot6.setQuantity(6L);
        SupplyInventoryInfoSnapshot snapshot7 = new SupplyInventoryInfoSnapshot();
        snapshot7.setSkuId(7L);
        snapshot7.setQuantity(7L);
        supplyInventoryInfoSnapshots.add(snapshot1);
        supplyInventoryInfoSnapshots.add(snapshot2);
        supplyInventoryInfoSnapshots.add(snapshot3);
        supplyInventoryInfoSnapshots.add(snapshot4);
        supplyInventoryInfoSnapshots.add(snapshot5);
        supplyInventoryInfoSnapshots.add(snapshot6);
        supplyInventoryInfoSnapshots.add(snapshot7);

        List<SupplyInventoryInfo> commonSkus = Lists.newArrayList();
        supplyInventoryInfos.forEach(info -> supplyInventoryInfoSnapshots.forEach(snapshot -> {
            boolean common = info.getSkuId().equals(snapshot.getSkuId())
                    && Objects.equals(info.getQuantity(), snapshot.getQuantity());
            if (common) commonSkus.add(info);

        }));

        Set<SupplyInventoryInfo> commonSkuSet = new HashSet<>(commonSkus);
        List<SupplyInventoryInfo> deleteInfos = supplyInventoryInfos.stream()
                .filter(info -> !commonSkuSet.contains(info))
                .collect(Collectors.toList());
    }
}
