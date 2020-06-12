package com.hooli.work.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: cky
 * @Date: 2020/6/12 08:50
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkTagDto {
    private Long id;
    private String tagname;
}
