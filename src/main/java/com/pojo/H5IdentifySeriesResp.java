package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author kezhan
 * @since 2023/2/16 15:41
 */
@Data
@AllArgsConstructor
public class H5IdentifySeriesResp implements Serializable {

    private static final long serialVersionUID = -7282109258156990398L;

    private Long productSeriesId;

    private String seriesName;

    private String coverUrl;

    private Long promptId;

    private Long brandId;

    private Integer isOtherSeries = 0;

    @Override
    public String toString() {
        return "H5IdentifySeriesResp{" + "seriesName='" + seriesName + '\'' + '}';
    }
}
