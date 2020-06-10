package com.hooli.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hooli.work.entity.WorkDemand;
import com.hooli.work.entity.vo.WorkDemandVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yy
 * @since 2020-06-09
 */
public interface WorkDemandService extends IService<WorkDemand> {
    List<WorkDemandVo> selectDemandDtoByPage(int page, int size);

    int insert(WorkDemand workDemand);

    int update(WorkDemand workDemand);
}
