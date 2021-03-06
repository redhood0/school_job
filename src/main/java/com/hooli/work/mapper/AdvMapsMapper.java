package com.hooli.work.mapper;

import com.hooli.work.entity.AdvMaps;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dylan
 * @since 2020-06-11
 */
public interface AdvMapsMapper extends BaseMapper<AdvMaps> {
    List<AdvMaps> selectAdvMapsById(Long id);


}
