package com.hooli.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hooli.work.entity.WorkRecord;
import com.hooli.work.entity.vo.WorkRecordVo;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
public interface WorkRecordMapper extends BaseMapper<WorkRecord> {

//    List<WorkRecord> getWorkRecordSketch(String username);

    IPage<WorkRecordVo> getWorkRecordPageByUserId(Page<?> page,long userId);

}
