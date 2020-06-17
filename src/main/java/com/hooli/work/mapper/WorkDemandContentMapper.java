package com.hooli.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hooli.work.entity.WorkDemandContent;
import com.hooli.work.entity.dto.WorkDemandContentDto;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
public interface WorkDemandContentMapper extends BaseMapper<WorkDemandContent> {
    WorkDemandContentDto selectWorkDemandContentById(Long id);
}
