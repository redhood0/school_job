package com.hooli.work.controller;


import com.hooli.work.common.ResponseResult;
import com.hooli.work.entity.Evalute;
import com.hooli.work.service.EvaluteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
@RestController
@RequestMapping("/evalute")
public class EvaluteController {
    @Autowired
    EvaluteService evaluteService;

    @PostMapping("/getEvaluteNumAverage")
    public ResponseResult getEvaluteNumAverage(@RequestBody HashMap<String,Long> params) {
        String average = evaluteService.getEvaluteNumAverage(params.get("userId"));
        return ResponseResult.success(average);
    }

    @PostMapping("/addEvalute")
    public ResponseResult addEvalute(@RequestBody Evalute evalute) {
        evaluteService.addEvalute(evalute);
        return ResponseResult.success("增加评论成功");
    }

}
