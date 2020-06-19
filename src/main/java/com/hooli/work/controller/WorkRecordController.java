package com.hooli.work.controller;


import com.hooli.work.service.WorkRecordService;
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


}
