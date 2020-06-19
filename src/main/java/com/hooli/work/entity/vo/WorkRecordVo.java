package com.hooli.work.entity.vo;

import com.hooli.work.entity.User;
import com.hooli.work.entity.WorkDemand;
import com.hooli.work.entity.WorkRecord;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @PackgeName: com.hooli.work.entity.vo
 * @ClassName: WorkRecordVo
 * @Author: redhood
 * Date: 2020/6/19 11:22
 * project name: school_job
 * @Version:
 * @Description:
 */
@Data
public class WorkRecordVo {
    private Long id;
    private Long workDemandId;
    private int workStatus;
    private LocalDateTime gmtWorkStart;
    private LocalDateTime gmtWorkEnd;
    private Long bossId;
    private User boss;
    private String coverUrl;
    private String title;
    private BigDecimal price;
    private String place;
    private String unit;
    private String placeName;
    private Integer typeId;



}
