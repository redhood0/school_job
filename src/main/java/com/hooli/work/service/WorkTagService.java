package com.hooli.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hooli.work.entity.WorkTag;
import com.hooli.work.entity.dto.WorkTagDto;
import com.hooli.work.entity.vo.WorkTagVo;

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
}
