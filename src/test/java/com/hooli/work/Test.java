package com.hooli.work;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hooli.work.entity.dto.WorkTagDto;
import com.hooli.work.mapper.UserMapper;
import com.hooli.work.mapper.WorkDemandMapper;
import com.hooli.work.mapper.WorkTagMapper;
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
    @Resource
    WorkTagMapper workTagMapper;

    @org.junit.jupiter.api.Test
    public void test(){
        IPage<WorkTagDto> workDemandDtoIPage = new Page<>(0, 10);
//        log.error("user:{}",mapper.selectDemandDtoByPage(workDemandDtoIPage));
//        System.out.println(mapper.selectDemandDtoByPage(workDemandDtoIPage).getRecords());
//        List<WorkTagDto> allTagNameByDemandId = workTagMapper.findAllTagNameByDemandId(Long.valueOf(1));
//        List<String> tagnames = new ArrayList<>();
//        for(WorkTagDto workTagDto : workTagMapper.findAllTagNameByDemandId((long) 1)){
//            tagnames.add(workTagDto.getTagname());
//        }
//        System.out.println(tagnames);
        IPage<WorkTagDto> workTagDtoIPage = workTagMapper.selectWorkTagByPage(workDemandDtoIPage);
        System.out.println(workTagDtoIPage.getRecords());
    }


}
