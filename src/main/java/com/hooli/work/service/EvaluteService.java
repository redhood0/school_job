package com.hooli.work.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    Page getEvaluteByPage(long useId,int current,int size, String type);

    int addEvalute(Evalute evalute);

    int updateEvalute(Evalute evalute);

    int deleteEvalute(Evalute evalute);

}
