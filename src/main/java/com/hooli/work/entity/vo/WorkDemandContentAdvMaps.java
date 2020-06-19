package com.hooli.work.entity.vo;

import com.hooli.work.entity.AdvMaps;
import com.hooli.work.entity.WorkDemand;
import com.hooli.work.entity.WorkDemandContent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: cky
 * @Date: 2020/6/17 13:23
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkDemandContentAdvMaps {
    private WorkDemand workDemand;
    private WorkDemandContent workDemandContent;
    private AdvMaps advMaps;
    private List<WorkTagVo> tagIds;
}
