package com.hooli.work.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hooli.work.entity.WorkTag;
import com.hooli.work.entity.dto.WorkTagDto;
import com.hooli.work.entity.vo.WorkTagVo;
import com.hooli.work.mapper.WorkTagMapper;
import com.hooli.work.service.WorkTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
            .id(workTagDto.getId())
            .tagname(workTagDto.getTagname())
            .build());
        }
        return workTagVos;
    }
}
