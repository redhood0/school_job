package com.hooli.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hooli.work.entity.AdvMaps;
import com.hooli.work.entity.WorkDemandContent;
import com.hooli.work.entity.dto.WorkDemandContentDto;
import com.hooli.work.entity.vo.WorkDemandContentVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
public interface WorkDemandContentService extends IService<WorkDemandContent> {
    WorkDemandContentVo selectWorkDemandContentVoById(Long id);

    WorkDemandContentVo transDtoToVo(WorkDemandContentDto dto);

//    int insert(WorkDemandContent workDemandContent, AdvMaps advMaps);

    int update(WorkDemandContent workDemandContent, AdvMaps advMaps);
}
