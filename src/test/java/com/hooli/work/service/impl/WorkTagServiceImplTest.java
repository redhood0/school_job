package com.hooli.work.service.impl;

import com.hooli.work.service.WorkTagService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class WorkTagServiceImplTest {
    @Resource
    WorkTagService workTagService;
    @Test
    void setFavouriteTag() {
        workTagService.getFavouriteTag(1);
    }
}
