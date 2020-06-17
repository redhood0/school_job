package com.hooli.work.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: cky
 * @Date: 2020/6/17 08:23
 * @Description:
 */
@Data
public class UserFavouriteWorkTag {
    private int id;
    private List<WorkTagVo> workTagVo;
}
