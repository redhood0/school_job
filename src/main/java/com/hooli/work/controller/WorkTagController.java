package com.hooli.work.controller;


import com.hooli.work.common.ResponseResult;
import com.hooli.work.common.ResultCode;
import com.hooli.work.entity.PageInfo;
import com.hooli.work.service.WorkTagService;
import com.hooli.work.util.RedisUtil;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api/worktag")
public class WorkTagController {
    @Resource
    WorkTagService workTagService;
    @Resource
    private RedisUtil redisUtil;

    @PostMapping("/search")
    public ResponseResult selectWorkTagByPage(@RequestBody PageInfo pageInfo) {
        if (pageInfo.getSize() == null || pageInfo.getPage() == null) {
            return ResponseResult.failure(ResultCode.PARAMS_ERROR);
        }
        return ResponseResult.success(workTagService.selectDemandDtoByPage(pageInfo.getPage(), pageInfo.getSize()));
    }

    @PostMapping("/favourite/set")
    public ResponseResult setFavouriteTag(@RequestBody Map<String, Object> params) {
        if (params.get("id")==null || params.get("tag")==null){
            return ResponseResult.failure(ResultCode.PARAMS_ERROR);
        }
        if (redisUtil.sHasKey(params.get("id")+"favouriteTag", params.get("tag"))) {
            return ResponseResult.failure(ResultCode.DATA_ALREADY_EXISTED);
        }
        redisUtil.sSet(params.get("id")+"favouriteTag", params.get("tag"));
        return ResponseResult.success("添加" + params.get("tag") + "成功");
    }

    @PostMapping("/favourite/get")
    public ResponseResult getFavouriteTag(@RequestBody Map<String, String> params) {
        if (params.get("id")==null ){
            return ResponseResult.failure(ResultCode.PARAMS_ERROR);
        }
        return ResponseResult.success(redisUtil.sGet(params.get("id")+"favouriteTag"));
    }

    @PostMapping("/favourite/remove")
    public ResponseResult removeFavouriteTag(@RequestBody Map<String, String> params){
        if (params.get("id")==null || params.get("tag")==null){
            return ResponseResult.failure(ResultCode.PARAMS_ERROR);
        }
        redisUtil.setRemove(params.get("id")+"favouriteTag",params.get("tag"));
        return ResponseResult.success("删除" + params.get("tag") + "成功");
    }
}
