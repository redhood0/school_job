package com.hooli.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hooli.work.common.ResponseResult;
import com.hooli.work.entity.WorkTag;
import com.hooli.work.entity.dto.WorkTagDto;
import com.hooli.work.entity.vo.TagIds;
import com.hooli.work.entity.vo.WorkTagVo;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
public interface WorkTagService extends IService<WorkTag> {
    /**
     * 查询所有的标签
     * @param page 第几页
     * @param size 一个显示数量
     * @return 一页中的工作需求
     */
    List<WorkTagVo> selectDemandDtoByPage(int page, int size);

    List<WorkTagVo> transDtoToVo(List<WorkTagDto> dto);

    /**
     * 设置我的关注标签
     * @param userId 用户id
     * @param tagId 标签id
     * @param tagName 标签名
     * @return 成功/失败
     */
    ResponseResult setFavouriteTag(int userId, int tagId, String tagName);

    HashMap<Integer,String> getFavouriteTag(int userId);

    ResponseResult removeFavouriteTag(int userId,int tagId);

    ResponseResult setManyFavouriteTag(int userId,List<WorkTagVo> list);

    ResponseResult removeManyFavouriteTag(int userId,List<TagIds> tagIds);
}
