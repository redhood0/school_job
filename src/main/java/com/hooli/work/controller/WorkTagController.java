package com.hooli.work.controller;


import com.hooli.work.common.ResponseResult;
import com.hooli.work.common.ResultCode;
import com.hooli.work.entity.PageInfo;
import com.hooli.work.service.WorkTagService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
@RestController
@RequestMapping("/api/worktag")
public class WorkTagController {
    @Resource
    WorkTagService workTagService;

    @PostMapping("/search")
    public ResponseResult selectWorkTagByPage(@RequestBody PageInfo pageInfo){
        if (pageInfo.getSize()==null || pageInfo.getPage()==null){
            return ResponseResult.failure(ResultCode.PARAMS_ERROR);
        }
        return ResponseResult.success(workTagService.selectDemandDtoByPage(pageInfo.getPage(),pageInfo.getSize()));
    }
}
