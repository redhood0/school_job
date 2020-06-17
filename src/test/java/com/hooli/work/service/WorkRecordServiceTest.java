package com.hooli.work.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @PackgeName: com.hooli.work.service
 * @ClassName: WorkRecordServiceTest
 * @Author: redhood
 * Date: 2020/6/17 9:09
 * project name: school_job
 * @Version:
 * @Description:
 */
@SpringBootTest
public class WorkRecordServiceTest {

    @Autowired
    WorkRecordService workRecordService;

    @Test
    public void setWorkRecordService(){
        workRecordService.getWorkRecordSketch(2L);
    }

}
