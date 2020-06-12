package com.hooli.work.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: cky
 * @Date: 2020/6/9 10:54
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkDemandDto {
    private Long id;
    private Long bossId;
    private String coverUrl;
    private String title;
    private BigDecimal price;
    private String unit;
    private String place;
    private String placeName;
    private String typeName;
    private Integer state;
    private Integer isDelete;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
