package com.hooli.work.entity.vo;

import com.hooli.work.entity.AdvMaps;
import com.hooli.work.entity.WorkDemandContent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private WorkDemandContent workDemandContent;
    private AdvMaps advMaps;
}
