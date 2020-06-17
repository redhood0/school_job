package com.hooli.work.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @PackgeName: com.hooli.work.entity.vo
 * @ClassName: WorkRecordSketchVo
 * @Author: redhood
 * Date: 2020/6/17 8:51
 * project name: school_job
 * @Version:
 * @Description:工作记录简单描述
 */
@Data
@AllArgsConstructor
public class WorkRecordSketchVo {
    //平均分
    private BigDecimal averageScore;
    //工作次数
    private int workTimes;

}
