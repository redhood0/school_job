package com.hooli.work.service;

/**
 * @PackgeName: com.hooli.work.service
 * @ClassName: EvaluteServiceTest
 * @Author: redhood
 * Date: 2020/6/17 10:08
 * project name: school_job
 * @Version:
 * @Description:
 */

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EvaluteServiceTest {
    @Autowired
    EvaluteService evaluteService;

    @Test
    public void getEvaluteNumAverageTest() {
        System.out.println(evaluteService.getEvaluteNumAverage(4l));
    }

    @Test
    public void getEvaluteByPageTest() {
        Page page = evaluteService.getEvaluteByPage(3, 1,2,"worker");
        System.out.println(page.getRecords());
    }
}
