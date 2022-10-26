package com.code;

import java.util.ArrayList;
import java.util.List;

public class TestCode {

    /**
     * 通过list的     subList(int fromIndex, int toIndex)方法实现
     *
     * @param sourList   源list
     * @param batchCount 分组条数
     */
    public static void dealBySubList(List<Object> sourList, int batchCount) {
        int sourListSize = sourList.size();
        int subCount = sourListSize % batchCount == 0 ? sourListSize / batchCount : sourListSize / batchCount + 1;
        int startIndext = 0;
        int stopIndext = 0;
        for (int i = 0; i < subCount; i++) {
            stopIndext = (i == subCount - 1) ? stopIndext + sourListSize % batchCount : stopIndext + batchCount;
            List<Object> tempList = new ArrayList<Object>(sourList.subList(startIndext, stopIndext));
            printList(tempList);
            startIndext = stopIndext;
        }
    }

    /**
     * 通过源list数据的逐条转移实现
     *
     * @param sourList   源list
     * @param batchCount 分组条数
     */
    public static void dealByRemove(List<Object> sourList, int batchCount) {
        List<Object> tempList = new ArrayList<Object>();
        for (int i = 0; i < sourList.size(); i++) {
            tempList.add(sourList.get(i));
            if ((i + 1) % batchCount == 0 || (i + 1) == sourList.size()) {
                printList(tempList);
                tempList.clear();
            }
        }
    }

    /**
     * 打印方法 充当list每批次数据的处理方法
     *
     * @param sourList
     */
    public static void printList(List<Object> sourList) {
        for (int j = 0; j < sourList.size(); j++) {
            System.out.println(sourList.get(j));
        }
        System.out.println("------------------------");
    }

    /**
     * 测试主方法
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        long start = System.nanoTime();
        dealBySubList(list, 3);
//        dealByRemove(list, 10);
        long end = System.nanoTime();
        System.out.println("The elapsed time :" + (end - start));

    }
}
