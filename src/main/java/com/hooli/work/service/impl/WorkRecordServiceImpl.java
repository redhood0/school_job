package com.hooli.work.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hooli.work.entity.WorkRecord;
import com.hooli.work.entity.vo.WorkRecordSketchVo;
import com.hooli.work.mapper.WorkRecordMapper;
import com.hooli.work.service.WorkRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.function.Consumer;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
@Service
public class WorkRecordServiceImpl extends ServiceImpl<WorkRecordMapper, WorkRecord> implements WorkRecordService {
    @Resource
    WorkRecordMapper workRecordMapper;
    @Override
    public WorkRecordSketchVo getWorkRecordSketch(Long userId) {

        QueryWrapper<WorkRecord> workRecordQueryWrapper = new QueryWrapper<>();
        workRecordQueryWrapper.eq("worker_id",userId);
        List<Object> workRecords = workRecordMapper.selectObjs(workRecordQueryWrapper);
        workRecords.stream().forEach(new Consumer<Object>() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
        return null;
    }
}
