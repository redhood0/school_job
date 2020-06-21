package com.hooli.work.controller;


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
 * @author dylan
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
}
