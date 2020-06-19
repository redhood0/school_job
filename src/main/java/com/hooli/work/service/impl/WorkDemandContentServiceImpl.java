package com.hooli.work.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hooli.work.entity.AdvMaps;
import com.hooli.work.entity.WorkDemandContent;
import com.hooli.work.entity.dto.WorkDemandContentDto;
import com.hooli.work.entity.vo.AdvMapsVo;
import com.hooli.work.entity.vo.WorkDemandContentVo;
import com.hooli.work.mapper.AdvMapsMapper;
import com.hooli.work.mapper.WorkDemandContentMapper;
import com.hooli.work.service.WorkDemandContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
@Service
public class WorkDemandContentServiceImpl extends ServiceImpl<WorkDemandContentMapper, WorkDemandContent> implements WorkDemandContentService {
    @Resource
    WorkDemandContentMapper workDemandContentMapper;
    @Resource
    AdvMapsMapper advMapsMapper;

    @Override
    public WorkDemandContentVo selectWorkDemandContentVoById(Long id) {
        WorkDemandContentDto workDemandContentDtos = workDemandContentMapper.selectWorkDemandContentById(id);
        WorkDemandContentVo workDemandContentVo = transDtoToVo(workDemandContentDtos);
        return workDemandContentVo;
    }

    @Override
    public WorkDemandContentVo transDtoToVo(WorkDemandContentDto dto) {
        AdvMaps advMaps = advMapsMapper.selectById(dto.getAdvMapsId());
        WorkDemandContentVo vo = WorkDemandContentVo.builder()
                .id(dto.getId())
                .demandId(dto.getDemandId())
                .content(dto.getContent())
                .worktime(dto.getWorktime())
                .advMapsVos(AdvMapsVo.builder()
                        .id(advMaps.getId())
                        .advMap1(advMaps.getAdvMap1())
                        .advMap2(advMaps.getAdvMap2())
                        .advMap3(advMaps.getAdvMap3()).build())
                .alreadyWorkerNum(dto.getAlreadyWorkerNum())
                .gmtModified(dto.getGmtModified())
                .maxWorkerNum(dto.getMaxWorkerNum())
                .settlement(dto.getSettlement())
                .build();
        return vo;
    }

//    @Override
//    public int insert(WorkDemandContent workDemandContent,AdvMaps advMaps) {
//        advMapsMapper.insert(advMaps);
//        workDemandContent.setAdvMapsId(advMaps.getId());
//        return workDemandContentMapper.insert(workDemandContent);
//    }


    @Override
    public int update(WorkDemandContent workDemandContent,AdvMaps advMaps) {
        advMapsMapper.updateById(advMaps);
        workDemandContent.setAdvMapsId(advMaps.getId());
        return workDemandContentMapper.updateById(workDemandContent);
    }

}
