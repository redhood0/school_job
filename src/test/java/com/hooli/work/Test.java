package com.hooli.work;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hooli.work.entity.dto.WorkDemandDto;
import com.hooli.work.mapper.UserMapper;
import com.hooli.work.mapper.WorkDemandMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author: cky
 * @Date: 2020/6/9 12:38
 * @Description:
 */
@SpringBootTest
@Slf4j
public class Test {
    @Resource
    WorkDemandMapper mapper;
    @Resource
    UserMapper userMapper;
    @org.junit.jupiter.api.Test
    public void test(){
        IPage<WorkDemandDto> workDemandDtoIPage = new Page<>(0, 10);
//        log.error("user:{}",mapper.selectDemandDtoByPage(workDemandDtoIPage));
        System.out.println(mapper.selectDemandDtoByPage(workDemandDtoIPage).getRecords());
    }


}
