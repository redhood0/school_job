package com.hooli.work.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: cky
 * @Date: 2020/6/17 08:38
 * @Description:
 */
@Data
public class RemoveUserFavouriteWorkTag {
    private int id;
    private List<TagIds> tagIds;

}

