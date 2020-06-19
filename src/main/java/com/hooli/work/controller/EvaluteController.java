package com.hooli.work.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hooli.work.common.ResponseResult;
import com.hooli.work.entity.Evalute;
import com.hooli.work.service.EvaluteService;
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
@RequestMapping("/evalute")
public class EvaluteController {
    @Autowired
    EvaluteService evaluteService;

    @PostMapping("/getEvaluteNumAverage")
    public ResponseResult getEvaluteNumAverage(@RequestBody HashMap<String, Long> params) {
        String average = evaluteService.getEvaluteNumAverage(params.get("userId"));
        HashMap<String, String> data = new HashMap<>();
        data.put("average", average);
        return ResponseResult.success(data);
    }

    @PostMapping("/addEvalute")
    public ResponseResult addEvalute(@RequestBody Evalute evalute) {
        evaluteService.addEvalute(evalute);
        return ResponseResult.success("增加评论成功");
    }

    @PostMapping("/updateEvalute")
    public ResponseResult updateEvalute(@RequestBody Evalute evalute) {
        evaluteService.updateEvalute(evalute);
        return ResponseResult.success("更新评论成功");
    }

    @PostMapping("/deleteEvalute")
    public ResponseResult deleteEvalute(@RequestBody Evalute evalute) {
        evalute.setIsDelete(1);
        evaluteService.deleteEvalute(evalute);
        return ResponseResult.success("删除评论成功");
    }

    @PostMapping("/getEvalutePageByBoss")
    public ResponseResult getEvalutePageByBoss(@RequestBody HashMap<String, Object> param) {
        Page page = evaluteService.getEvaluteByPage(Long.parseLong(param.get("userId").toString()),
                (Integer) param.get("current"), (Integer) param.get("size"), "boss");
        List<Evalute> evalutes = page.getRecords();
        long pages = page.getPages();
        HashMap<String, Object> result = new HashMap<>();
        result.put("evalutes", evalutes);
        result.put("pageNum", pages);
        return ResponseResult.success(result);
    }

    @PostMapping("/getEvalutePageByWorker")
    public ResponseResult getEvalutePageByWorker(@RequestBody HashMap<String, Object> param) {
        Page page = evaluteService.getEvaluteByPage(Long.parseLong(param.get("userId").toString()),
                (Integer) param.get("current"), (Integer) param.get("size"), "worker");
        List<Evalute> evalutes = page.getRecords();
        long pages = page.getPages();
        HashMap<String, Object> result = new HashMap<>();
        result.put("evalutes", evalutes);
        result.put("pageNum", pages);
        return ResponseResult.success(result);
    }

}
