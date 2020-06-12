package com.hooli.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hooli.work.entity.WorkTag;
import com.hooli.work.entity.dto.WorkTagDto;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
public interface WorkTagMapper extends BaseMapper<WorkTag> {
    List<WorkTagDto> findAllTagNameByDemandId(Long demandId);

    IPage<WorkTagDto> selectWorkTagByPage(IPage<?> iPage);

}
