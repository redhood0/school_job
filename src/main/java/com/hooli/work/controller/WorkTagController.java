package com.hooli.work.controller;


import com.hooli.work.common.ResponseResult;
import com.hooli.work.common.ResultCode;
import com.hooli.work.entity.PageInfo;
import com.hooli.work.entity.vo.UserFavouriteWorkTag;
import com.hooli.work.entity.vo.WorkTagVo;
import com.hooli.work.service.WorkTagService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

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

    @PostMapping("/search")
    public ResponseResult selectWorkTagByPage(@RequestBody PageInfo pageInfo) {
        if (pageInfo.getSize() == null || pageInfo.getPage() == null) {
            return ResponseResult.failure(ResultCode.PARAMS_ERROR);
        }
        return ResponseResult.success(workTagService.selectDemandDtoByPage(pageInfo.getPage(), pageInfo.getSize()));
    }

    @PostMapping("/favourite/set")
    public ResponseResult setFavouriteTag(@RequestBody Map<String, Object> params) {
        if (params.get("id") == null || params.get("tagId") == null || params.get("tagName") == null) {
            return ResponseResult.failure(ResultCode.PARAMS_ERROR);
        }
        ResponseResult responseResult = workTagService.setFavouriteTag((int) params.get("id"), (int) params.get("tagId"), (String) params.get("tagName"));
        return responseResult;
    }

    @PostMapping("/favourite/setmany")
    public ResponseResult setManyFavouriteTag(@RequestBody UserFavouriteWorkTag workTag) {
        if (workTag.getWorkTagVo() == null) {
            return ResponseResult.failure(ResultCode.PARAMS_ERROR);
        }
        ResponseResult responseResult = workTagService.setManyFavouriteTag( workTag.getId(), workTag.getWorkTagVo());
        return responseResult;
    }

    @PostMapping("/favourite/get")
    public ResponseResult getFavouriteTag(@RequestBody Map<String, String> params) {
        if (params.get("id") == null) {
            return ResponseResult.failure(ResultCode.PARAMS_ERROR);
        }
        HashMap<Integer, String> tags = workTagService.getFavouriteTag(Integer.parseInt(params.get("id")));
        if (tags == null){
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
        List<WorkTagVo> list = new ArrayList<>();
        for (Iterator<Map.Entry<Integer,String>> it = tags.entrySet().iterator(); it.hasNext();){
            Map.Entry<Integer, String> entry = it.next();
            String key = String.valueOf(entry.getKey());
            String value = entry.getValue();
            list.add(new WorkTagVo(Long.valueOf(key),value));
        }
        return ResponseResult.success(list);
    }

    @PostMapping("/favourite/remove")
    public ResponseResult removeFavouriteTag(@RequestBody Map<String, String> params) {
        if (params.get("id") == null || params.get("tagId") == null) {
            return ResponseResult.failure(ResultCode.PARAMS_ERROR);
        }
        ResponseResult responseResult = workTagService.removeFavouriteTag(Integer.parseInt(params.get("id")), Integer.parseInt(params.get("tagId")));
        return responseResult;
    }
    @PostMapping("/favourite/removemany")
    public ResponseResult removeManyFavouriteTag(@RequestBody UserFavouriteWorkTag workTag){
        if (workTag.getWorkTagVo()==null){
            return ResponseResult.failure(ResultCode.PARAMS_ERROR);
        }
        ResponseResult responseResult = workTagService.removeManyFavouriteTag(workTag.getId(), workTag.getWorkTagVo());
        return responseResult;
    }
}
