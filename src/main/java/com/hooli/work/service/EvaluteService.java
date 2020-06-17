package com.hooli.work.service;

import com.hooli.work.entity.Evalute;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
public interface EvaluteService extends IService<Evalute> {

    String getEvaluteNumAverage(long workId);

    int addEvalute(Evalute evalute);

}
