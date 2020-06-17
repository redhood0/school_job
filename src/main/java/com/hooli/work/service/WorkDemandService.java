package com.hooli.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hooli.work.entity.WorkDemand;
import com.hooli.work.entity.dto.WorkDemandDto;
import com.hooli.work.entity.vo.WorkDemandVo;

import java.util.List;

/**
 *
 * @author cky
 * @since 2020-06-09
 */
public interface WorkDemandService extends IService<WorkDemand> {
    /**
     * 查询所有的工作需求
     * @param page 第几页
     * @param size 一个显示数量
     * @return 一页中的工作需求
     */
    List<WorkDemandVo> selectDemandDtoByPage(int page, int size);

    int insert(WorkDemand workDemand);

    int update(WorkDemand workDemand);

    /**
     * 查询指定人的工作需求
     * @param page
     * @param size
     * @param userId 需要查询的用户id
     * @return
     */
    List<WorkDemandVo> selectDemandByUserId(int page,int size,int userId);

    /**
     * 将dto转换成vo
     * @param dto 数据对象
     * @return 视图对象
     */
    List<WorkDemandVo> transDtoToVo(List<WorkDemandDto> dto);

    List<WorkDemandVo> selectDemandByWorkTag(int page,int size,int tagId);

}
