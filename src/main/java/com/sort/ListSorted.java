package com.sort;

import com.pojo.H5IdentifySeriesResp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListSorted {
    public static void main(String[] args) {
        List<H5IdentifySeriesResp> sortedList = new ArrayList<>();
        sortedList.add(new H5IdentifySeriesResp(1L, "name1", "url2", 2L, 2L, 0));
        sortedList.add(new H5IdentifySeriesResp(2L, "name2", "url7", 7L, 7L, 0));
        sortedList.add(new H5IdentifySeriesResp(3L, "name3", "url3", 3L, 3L, 0));
        sortedList.add(new H5IdentifySeriesResp(4L, "name4", "url4", 4L, 4L, 0));
        sortedList.add(new H5IdentifySeriesResp(5L, "name5", "url1", 1L, 1L, 0));
        sortedList.add(new H5IdentifySeriesResp(6L, "name6", "url6", 6L, 6L, 0));
        sortedList.add(new H5IdentifySeriesResp(7L, "name7", "url5", 5L, 5L, 0));

        List<Long> ids = Arrays.asList(4L, 7L);

        Comparator<H5IdentifySeriesResp> cmp = new Comparator<H5IdentifySeriesResp>() {
            @Override
            public int compare(H5IdentifySeriesResp o1, H5IdentifySeriesResp o2) {
                boolean id1_in = ids.contains(o1.getProductSeriesId());
                boolean id2_in = ids.contains(o2.getProductSeriesId());
                if (id1_in && id2_in) {
                    return Integer.compare(ids.indexOf(o1.getProductSeriesId()), ids.indexOf(o2.getProductSeriesId()));
                } else if (id1_in) {
                    return -1;
                } else if (id2_in) {
                    return 1;
                } else {
                    return Long.compare(o1.getProductSeriesId(), o2.getProductSeriesId());
                }
            }
        };

        sortedList.sort(cmp);
        System.out.println(sortedList);
    }

}
