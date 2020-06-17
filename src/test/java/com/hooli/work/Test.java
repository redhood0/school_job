package com.hooli.work;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hooli.work.entity.AdvMaps;
import com.hooli.work.entity.dto.WorkTagDto;
import com.hooli.work.mapper.UserMapper;
import com.hooli.work.mapper.WorkDemandMapper;
import com.hooli.work.mapper.WorkTagMapper;
import com.hooli.work.service.WorkDemandContentService;
import com.hooli.work.service.WorkTagService;
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
    @Resource
    WorkTagService workTagService;
    @Resource
    WorkDemandContentService workDemandContentService;

    @org.junit.jupiter.api.Test
    public void test() {
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


//    @org.junit.jupiter.api.Test
//    void setFavouriteTag() {
//        List<WorkTagVo> list = new ArrayList<>();
//        list.add(new WorkTagVo(1L,"美术"));
//        list.add(new WorkTagVo(2L,"安卓"));
//        System.out.println(workTagService.setManyFavouriteTag(2,list));
//    }

//    @org.junit.jupiter.api.Test
//    void selectWorkDemandContent(){
//        System.out.println(workDemandContentService.selectWorkDemandContentVoById(1L));
//    }

    @org.junit.jupiter.api.Test
    void setWorkDemandContent() {
        AdvMaps advMaps = new AdvMaps();
        advMaps.setAdvMap1("111");
        System.out.println(workDemandContentService.insert(null,advMaps));
    }
}
