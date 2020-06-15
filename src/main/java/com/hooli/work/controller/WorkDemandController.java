package com.hooli.work.controller;


import com.hooli.work.common.ResponseResult;
import com.hooli.work.common.ResultCode;
import com.hooli.work.entity.WorkDemand;
import com.hooli.work.service.WorkDemandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cky
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/api/workdemand")
public class WorkDemandController {
    @Resource
    WorkDemandService workDemandService;


    @PostMapping("/search")
    public ResponseResult selectWorkDemandByPage(@RequestBody Map<String, Object> params) {
        if (params.get("page") == null || params.get("size") == null) {
            return ResponseResult.failure(ResultCode.PARAMS_ERROR);
        }
        if (params.get("id") == null) {
            return ResponseResult.success(workDemandService.selectDemandDtoByPage(
                    (Integer) params.get("page"),
                    (Integer) params.get("size")));
        }
        return ResponseResult.success(workDemandService.selectDemandByUserId(
                (Integer) params.get("page"),
                (Integer) params.get("size"),
                (Integer) params.get("id")));
    }

    @PostMapping("/add")
    public ResponseResult addWorkDemand(@RequestBody WorkDemand workDemand) {
        if (workDemand.getBossId() == null) {
            return ResponseResult.failure(ResultCode.PARAMS_ERROR);
        }
        int insert = workDemandService.insert(workDemand);
        if (insert < 1) {
            return ResponseResult.failure(ResultCode.DATA_IS_WRONG);
        }
        return ResponseResult.success(workDemand);
    }

    @PostMapping("/delete")
    public ResponseResult deleteWorkDemand(@RequestBody Map<String, Long> params) {
        if (params.get("id") == null) {
            return ResponseResult.failure(ResultCode.PARAMS_ERROR);
        }
        Long id = params.get("id");
        WorkDemand workDemand = workDemandService.getById(id);
        workDemand.setIsDelete(1);
        int update = workDemandService.update(workDemand);
        if (update < 1) {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
        return ResponseResult.success(id);
    }

    @PostMapping("/update")
    public ResponseResult updateWorkDemand(@RequestBody WorkDemand workDemand) {
        Integer isDelete = workDemandService.getById(workDemand.getId()).getIsDelete();
        if (isDelete == 1) {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
        int update = workDemandService.update(workDemand);
        if (update < 1) {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
        return ResponseResult.success("更新成功");
    }
}