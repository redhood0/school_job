package com.hooli.work.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: cky
 * @Date: 2020/6/9 11:08
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkDemandVo {
    private Long id;
    private Long bossId;
    private String bossName;
    private String coverUrl;
    private String title;
    private BigDecimal price;
    private String unit;
    private String place;
    private String placeName;
    private String typeName;
    private String state;
    private List<String> tagName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private LocalDateTime gmtModified;
    private String toThisDay;
}
