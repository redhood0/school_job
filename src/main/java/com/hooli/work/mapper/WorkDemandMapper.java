package com.hooli.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hooli.work.entity.WorkDemand;
import com.hooli.work.entity.dto.WorkDemandDto;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cky
 * @since 2020-06-09
 */
public interface WorkDemandMapper extends BaseMapper<WorkDemand> {

    IPage<WorkDemandDto> selectDemandDtoByPage(IPage<?> iPage);

    IPage<WorkDemandDto> selectDemandDtoByUserId(IPage<?> iPage,int userId);
}
