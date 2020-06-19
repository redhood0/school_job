package com.hooli.work.controller;


import com.hooli.work.common.ResponseResult;
import com.hooli.work.common.ResultCode;
import com.hooli.work.entity.vo.WorkDemandContentAdvMaps;
import com.hooli.work.service.WorkDemandContentService;
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
 * @author dylan
 * @since 2020-06-11
 */
@RestController
@RequestMapping("/api/workdemandcontent")
public class WorkDemandContentController {
    @Resource
    private WorkDemandContentService workDemandContentService;

    @PostMapping("/search")
    public ResponseResult selectWorkDemandContentById(@RequestBody Map<String, Long> params) {
        if (params.get("id") == null) {
            return ResponseResult.failure(ResultCode.PARAMS_ERROR);
        }

        return ResponseResult.success(workDemandContentService.selectWorkDemandContentVoById(params.get("id")));
    }

//    @PostMapping("/add")
//    public ResponseResult addWorkDemandContent(@RequestBody WorkDemandContentAdvMaps workDemandContentAdvMaps) {
//
//        int insert = workDemandContentService.insert(workDemandContentAdvMaps.getWorkDemandContent(),workDemandContentAdvMaps.getAdvMaps());
//        if (insert < 1) {
//            return ResponseResult.failure(ResultCode.DATA_IS_WRONG);
//        }
//        return ResponseResult.success(workDemandContentAdvMaps);
//    }

    @PostMapping("/update")
    public ResponseResult updateWorkDemandContent(@RequestBody WorkDemandContentAdvMaps workDemandContentAdvMaps) {

        int update = workDemandContentService.update(workDemandContentAdvMaps.getWorkDemandContent(),workDemandContentAdvMaps.getAdvMaps());
        if (update < 1) {
            return ResponseResult.failure(ResultCode.DATA_IS_WRONG);
        }
        return ResponseResult.success(workDemandContentAdvMaps);
    }

}
