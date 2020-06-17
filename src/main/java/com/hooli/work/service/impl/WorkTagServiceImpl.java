package com.hooli.work.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hooli.work.common.ResponseResult;
import com.hooli.work.common.ResultCode;
import com.hooli.work.entity.WorkTag;
import com.hooli.work.entity.dto.WorkTagDto;
import com.hooli.work.entity.vo.TagIds;
import com.hooli.work.entity.vo.WorkTagVo;
import com.hooli.work.mapper.WorkTagMapper;
import com.hooli.work.service.WorkTagService;
import com.hooli.work.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
@Service
public class WorkTagServiceImpl extends ServiceImpl<WorkTagMapper, WorkTag> implements WorkTagService {
    @Resource
    private WorkTagMapper workTagMapper;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public List<WorkTagVo> selectDemandDtoByPage(int page, int size) {
        IPage<WorkTagDto> workTagDtoIPage = new Page<>(page,size);
        workTagDtoIPage = workTagMapper.selectWorkTagByPage(workTagDtoIPage);
        List<WorkTagDto> records = workTagDtoIPage.getRecords();
        return transDtoToVo(records);
    }

    @Override
    public List<WorkTagVo> transDtoToVo(List<WorkTagDto> dto) {
        List<WorkTagVo> workTagVos = new ArrayList<>();
        for(WorkTagDto workTagDto : dto){
            workTagVos.add(WorkTagVo.builder()
            .tagId(workTagDto.getId())
            .tagName(workTagDto.getTagname())
            .build());
        }
        return workTagVos;
    }

    @Override
    public ResponseResult setFavouriteTag(int userId, int tagId, String tagName) {
        HashMap<Integer, String> historyTag;
        if (getFavouriteTag(userId) !=null) {
            historyTag = getFavouriteTag(userId);
            for (Map.Entry<Integer, String> item : historyTag.entrySet()) {
                if ((tagId + "").equals(item.getKey() + "")) {
                    return ResponseResult.failure(ResultCode.DATA_ALREADY_EXISTED);
                }
            }
        }else {
            historyTag = new HashMap<>();
        }
        historyTag.put(tagId,tagName);
        redisUtil.hset("favourite_tag", userId + "", historyTag);
        return ResponseResult.success("添加" + tagName + "成功");
    }

    @Override
    public ResponseResult setManyFavouriteTag(int userId,List<WorkTagVo> list){
        System.out.println(list);
        HashMap<Integer, String> historyTag;
        if (getFavouriteTag(userId) !=null) {
            historyTag = getFavouriteTag(userId);
            for (Map.Entry<Integer, String> item : historyTag.entrySet()) {
                for (WorkTagVo workTagVo : list){
                    if ((workTagVo.getTagId() + "").equals(item.getKey() + "")) {
                        return ResponseResult.failure(ResultCode.DATA_ALREADY_EXISTED);
                    }
                }
            }
        }else {
            historyTag = new HashMap<>();
        }
        for (WorkTagVo workTagVo : list){
            System.out.println(workTagVo.getTagId());
            historyTag.put(Integer.parseInt(workTagVo.getTagId()+""),workTagVo.getTagName());
        }
        redisUtil.hset("favourite_tag", userId + "", historyTag);
        return ResponseResult.success("添加" + list + "成功");

    }

    @Override
    public HashMap<Integer, String> getFavouriteTag(int userId) {
        HashMap<Integer,String> favouriteTag = (HashMap) redisUtil.hget("favourite_tag", userId + "");
        return favouriteTag;
    }

    @Override
    public ResponseResult removeFavouriteTag(int userId, int tagId) {
        HashMap<Integer, String> historyTag = getFavouriteTag(userId);
        for (Iterator<Map.Entry<Integer,String>> it = historyTag.entrySet().iterator();it.hasNext();){
            Map.Entry<Integer, String> next = it.next();
            if ((tagId+"").equals(next.getKey()+"")){
                it.remove();
                redisUtil.hset("favourite_tag", userId + "", historyTag);
                return ResponseResult.success("删除成功");
            }else {
                return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
            }
        }
        return ResponseResult.failure(ResultCode.SYSTEM_INNER_ERROR);
    }

    @Override
    public ResponseResult removeManyFavouriteTag(int userId,List<TagIds> tagIds){
        HashMap<Integer, String> historyTag = getFavouriteTag(userId);
        for (Iterator<Map.Entry<Integer,String>> it = historyTag.entrySet().iterator();it.hasNext();){
            Map.Entry<Integer, String> next = it.next();
            for (TagIds tagId : tagIds){
                if ((tagId.getTagId()+"").equals(next.getKey()+"")){
                    it.remove();
                    redisUtil.hset("favourite_tag", userId + "", historyTag);
                    return ResponseResult.success("批量删除成功");
                }else {
                    return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
                }
            }
        }
        return ResponseResult.failure(ResultCode.SYSTEM_INNER_ERROR);
    }

}
