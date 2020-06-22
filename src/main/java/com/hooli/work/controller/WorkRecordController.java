package com.hooli.work.controller;


import com.hooli.work.common.ResponseResult;
import com.hooli.work.entity.WorkRecord;
import com.hooli.work.service.WorkRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zq
 * @since 2020-06-11
 */
@RestController
@RequestMapping("/workRecord")
public class WorkRecordController {
    @Autowired
    WorkRecordService workRecordService;

    @PostMapping("/getWorkRecordPages")
    public HashMap getWorkRecordsByPage(@RequestBody HashMap<String, Object> param) {

        HashMap result = workRecordService.getWorkRecordPage(Long.parseLong(param.get("userId").toString())
                , Integer.parseInt(param.get("currentPage").toString())
                , Integer.parseInt(param.get("pageSize").toString()));
        return result;
    }

    /**
     * 获取某个工作的所有申请的员工
     * worktype:0-申请中，1-工作中，2-工作完成，3-工作拒绝, 10-全部类型
     * @param param
     * @return
     */
    @PostMapping("/getWorkRecordPages/ByWorkDemand")
    public HashMap getWorkRecordPagesByWorkDemand(@RequestBody HashMap<String, Object> param) {

        HashMap result = workRecordService.getWorkRecordPageByWD(Long.parseLong(param.get("demandId").toString())
                , Integer.parseInt(param.get("currentPage").toString())
                , Integer.parseInt(param.get("pageSize").toString())
                , Integer.parseInt(param.get("worktype").toString()));
        return result;
    }

    /**
     * 工作申请
     * @param workRecord
     * @return
     */
    @PostMapping("/addWorkRecord")
    public ResponseResult addWorkRecord(@RequestBody WorkRecord workRecord){
        workRecordService.addWorkRecord(workRecord);
        return ResponseResult.success("增加数据成功");
    }

    /**
     * 工作状态修改,0-申请中，1-工作中，2-已完成，3-已拒绝
     * @param param
     * @return
     */
    @PostMapping("/updateRecordStatus")
    public ResponseResult updateRecordStatus(@RequestBody HashMap<String,String> param){
        Integer workStatus = Integer.parseInt(param.get("workStatus"));
        Long workRecordId = Long.parseLong(param.get("workRecordId"));
        workRecordService.updateRecordStatus(workStatus,workRecordId);
        return ResponseResult.success("更新工作状态");
    }
}
