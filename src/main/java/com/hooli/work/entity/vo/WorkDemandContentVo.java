package com.hooli.work.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class WorkDemandContentVo {
    private Long id;
    private Long demandId;
    private String content;
    private String worktime;
    private String settlement;
    private AdvMapsVo advMapsVos;
    private Integer alreadyWorkerNum;
    private Integer maxWorkerNum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private LocalDateTime gmtModified;
}
