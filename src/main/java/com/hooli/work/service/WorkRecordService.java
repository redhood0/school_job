package com.hooli.work.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hooli.work.entity.WorkRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hooli.work.entity.vo.WorkRecordSketchVo;

import java.util.HashMap;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
public interface WorkRecordService extends IService<WorkRecord> {

    Page<WorkRecord> getWorkRecordSketch(long userId,int currentPage,int size);

    HashMap<String,Object> getWorkRecordPage(long userId, int currentPage, int size);

}
