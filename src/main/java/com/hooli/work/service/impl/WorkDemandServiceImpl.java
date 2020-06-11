package com.hooli.work.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hooli.work.entity.WorkDemand;
import com.hooli.work.entity.dto.UserDto;
import com.hooli.work.entity.dto.WorkDemandDto;
import com.hooli.work.entity.vo.WorkDemandVo;
import com.hooli.work.mapper.UserMapper;
import com.hooli.work.mapper.WorkDemandMapper;
import com.hooli.work.service.WorkDemandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cky
 * @since 2020-06-09
 */
@Service
@Slf4j
public class WorkDemandServiceImpl extends ServiceImpl<WorkDemandMapper, WorkDemand> implements WorkDemandService {
    @Resource
    private WorkDemandMapper workDemandMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public List<WorkDemandVo> selectDemandDtoByPage(int page, int size) {
        IPage<WorkDemandDto> workDemandDtoIPage = new Page<>(page, size);
        workDemandDtoIPage = workDemandMapper.selectDemandDtoByPage(workDemandDtoIPage);
        List<WorkDemandDto> records = workDemandDtoIPage.getRecords();
        return transDtoToVo(records);
    }

    @Override
    public int insert(WorkDemand workDemand) {
        return workDemandMapper.insert(workDemand);
    }

    @Override
    public int update(WorkDemand workDemand) {
        workDemand.setGmtModified(LocalDateTime.now());
        return workDemandMapper.updateById(workDemand);
    }

    @Override
    public List<WorkDemandVo> selectDemandByUserId(int page,int size,int userId) {
        IPage<WorkDemandDto> workDemandDtoIPage = new Page<>(page, size);
        workDemandDtoIPage = workDemandMapper.selectDemandDtoByUserId(workDemandDtoIPage,userId);
        List<WorkDemandDto> records = workDemandDtoIPage.getRecords();
        return transDtoToVo(records);
    }

    @Override
    public List<WorkDemandVo> transDtoToVo(List<WorkDemandDto> dto) {
        List<WorkDemandVo> workDemandVos = new ArrayList<>();
        for (WorkDemandDto workDemand : dto) {
            UserDto userDto = userMapper.selectUserByUserId(workDemand.getBossId());
            workDemandVos.add(WorkDemandVo.builder()
                    .id(workDemand.getId())
                    .bossId(workDemand.getBossId())
                    .bossName(userDto.getUsername())
                    .coverUrl(workDemand.getCoverUrl())
                    .title(workDemand.getTitle())
                    .price(workDemand.getPrice())
                    .unit(workDemand.getUnit())
                    .place(workDemand.getPlace())
                    .typeName((workDemand.getTypeName()==null)?"无":workDemand.getTypeName())
                    .state(workDemand.getState())
                    .gmtModified(workDemand.getGmtModified()).build());
        }
        return workDemandVos;
    }
}
