package com.hooli.work.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author: cky
 * @Date: 2020/6/17 10:48
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkDemandContentDto {
    private Long id;
    private Long demandId;
    private String content;
    private String worktime;
    private String settlement;
    private Long advMapsId;
    private Integer alreadyWorkerNum;
    private Integer maxWorkerNum;
    private Integer isDelete;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
