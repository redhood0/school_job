package com.hooli.work.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hooli.work.entity.Evalute;
import com.hooli.work.execption.ServiceException;
import com.hooli.work.mapper.EvaluteMapper;
import com.hooli.work.service.EvaluteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.function.Consumer;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
@Service
public class EvaluteServiceImpl extends ServiceImpl<EvaluteMapper, Evalute> implements EvaluteService {

    @Resource
    EvaluteMapper evaluteMapper;

    /**
     * 获取个人的平均分
     *
     * @param workId
     * @return
     */
    @Override
    public String getEvaluteNumAverage(long workId) {
        QueryWrapper<Evalute> evaluteQueryWrapper = new QueryWrapper<>();
        evaluteQueryWrapper.eq("user_id", workId);
        List<Evalute> objects = evaluteMapper.selectList(evaluteQueryWrapper);

        if (objects.size() == 0) {
            return "0";
        }

        Integer score = 0;
        for (Object o : objects) {
            score += ((Evalute) o).getStar();
        }

        Double average = Double.parseDouble(score.toString()) / objects.size();
        BigDecimal bigDecimal = BigDecimal.valueOf(average);
        bigDecimal = bigDecimal.setScale(1, RoundingMode.HALF_DOWN);
        return bigDecimal.toString();
    }

    /**
     * @param useId
     * @return
     */
    @Override
    public Page getEvaluteByPage(long useId,int current,int size, String type) {
        Page<Evalute> page = new Page<>(current, size);
        QueryWrapper queryWrapper = new QueryWrapper();
        switch (type) {
            case "boss":
                queryWrapper.eq("evalutor_id", useId);
                break;
            case "worker":
                queryWrapper.eq("user_id", useId);
                break;
        }
        page = evaluteMapper.selectPage(page, queryWrapper);
        return page;
    }


    @Override
    public int addEvalute(Evalute evalute) {
        int num = evaluteMapper.insert(evalute);
        if (num == 0) {
            throw new ServiceException("评论系统异常，增加失败，请稍后重试");
        }
        return num;
    }

    @Override
    public int updateEvalute(Evalute evalute) {
        UpdateWrapper<Evalute> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", evalute.getId());
        int num = evaluteMapper.update(evalute, updateWrapper);
        if (num == 0) {
            throw new ServiceException("评论系统异常，更新失败，请稍后重试");
        }
        return num;
    }

    @Override
    public int deleteEvalute(Evalute evalute) {
        UpdateWrapper<Evalute> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", evalute.getId());
        int num = evaluteMapper.update(evalute, updateWrapper);

        if (num == 0) {
            throw new ServiceException("评论系统异常，删除失败，请稍后重试");
        }
        return num;
    }
}
