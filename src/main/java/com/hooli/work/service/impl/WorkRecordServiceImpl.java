package com.hooli.work.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hooli.work.entity.User;
import com.hooli.work.entity.WorkRecord;
import com.hooli.work.entity.vo.WorkRecordSketchVo;
import com.hooli.work.entity.vo.WorkRecordVo;
import com.hooli.work.execption.ServiceException;
import com.hooli.work.mapper.UserMapper;
import com.hooli.work.mapper.WorkRecordMapper;
import com.hooli.work.service.WorkRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zq
 * @since 2020-06-11
 */
@Service
public class WorkRecordServiceImpl extends ServiceImpl<WorkRecordMapper, WorkRecord> implements WorkRecordService {
    @Resource
    WorkRecordMapper workRecordMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public Page<WorkRecord> getWorkRecordSketch(long userId, int currentPage, int size) {
        QueryWrapper<WorkRecord> workRecordQueryWrapper = new QueryWrapper<>();
        workRecordQueryWrapper.eq("worker_id", userId);
        List<Object> workRecords = workRecordMapper.selectObjs(workRecordQueryWrapper);
        workRecords.stream().forEach(new Consumer<Object>() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
        return null;
    }

    @Override
    public HashMap<String, Object> getWorkRecordPage(long userId, int currentPage, int size) {
        Page<WorkRecordVo> workRecordVoPage = new Page<>(currentPage, size);
        workRecordVoPage = (Page<WorkRecordVo>) workRecordMapper.getWorkRecordPageByUserId(workRecordVoPage
                , userId);
        List<WorkRecordVo> workRecordVos = workRecordVoPage.getRecords();

        for (WorkRecordVo workRecordVo : workRecordVos) {
            long bossId = workRecordVo.getBossId();//去查boss
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", bossId);
            User user = userMapper.selectOne(queryWrapper);
            workRecordVo.setBoss(user);
        }

        HashMap<String, Object> result = new HashMap<>();
        result.put("workRecords", workRecordVos);
        result.put("pageNum", workRecordVoPage.getPages());
        return result;
    }

    @Override
    public HashMap getWorkRecordPageByWD(long demandId, int currentPage, int size, int worktype) {
        QueryWrapper<WorkRecord> queryWrapper = new QueryWrapper();
        queryWrapper.eq("work_demand_id", demandId);

        if(worktype != 10){
            queryWrapper.eq("work_status", worktype);
        }

        Page<WorkRecord> page = new Page<>(currentPage, size);
        page = workRecordMapper.selectPage(page, queryWrapper);

        List<WorkRecord> workRecords = page.getRecords();
        List<HashMap> result = new ArrayList<>();
        for (WorkRecord workRecord : workRecords) {
            long wokerId = workRecord.getWorkerId();

            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("id", wokerId);
            User user = userMapper.selectOne(userQueryWrapper);

            HashMap<String, Object> data = new HashMap();
            data.put("user", user);
            data.put("workRecord", workRecord);
            result.add(data);
        }
        HashMap<String, Object> rest = new HashMap<>();
        rest.put("result", result);
        rest.put("pageNum", page.getPages());
        return rest;
    }

    /**
     * 增加工作记录
     * @return
     */
    @Override
    public Integer addWorkRecord(WorkRecord workRecord) {
        workRecord.setGmtWorkStart(LocalDateTime.now());
        workRecord.setWorkStatus(0);
        int num = workRecordMapper.insert(workRecord);
        if(num != 1){
            throw new ServiceException("申请工作失败");
        }
        return num;
    }

    @Override
    public Integer updateRecordStatus(Integer workStatus,Long workRecordId) {
        WorkRecord workRecord = new WorkRecord();
        workRecord.setWorkStatus(workStatus);

        UpdateWrapper<WorkRecord> workRecordUpdateWrapper = new UpdateWrapper<>();
        workRecordUpdateWrapper.eq("id",workRecordId);
        int num = workRecordMapper.update(workRecord,workRecordUpdateWrapper);
        if( num != 1){
            throw new ServiceException("工作状态更新失败");
        }
        return num;
    }
}
