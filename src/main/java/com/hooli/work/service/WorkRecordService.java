package com.hooli.work.service;

import com.hooli.work.entity.WorkRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hooli.work.entity.vo.WorkRecordSketchVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
public interface WorkRecordService extends IService<WorkRecord> {

    WorkRecordSketchVo getWorkRecordSketch(Long userId);

}
