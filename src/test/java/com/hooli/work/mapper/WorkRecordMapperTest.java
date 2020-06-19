package com.hooli.work.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hooli.work.entity.WorkRecord;
import com.hooli.work.entity.vo.WorkRecordVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @PackgeName: com.hooli.work.mapper
 * @ClassName: WorkRecordMapperTest
 * @Author: redhood
 * Date: 2020/6/19 15:06
 * project name: school_job
 * @Version:
 * @Description:
 */
@SpringBootTest
public class WorkRecordMapperTest {
    @Autowired
    WorkRecordMapper workRecordMapper;

    @Test
    public void getWorkRecordPageByUserIdTest() {
        Page<WorkRecordVo> page = new Page<>(1, 2);
        page = (Page<WorkRecordVo>) workRecordMapper.getWorkRecordPageByUserId(page, 2);

        for (WorkRecordVo workRecordVo : page.getRecords()) {
            System.out.println("=>=>=>" + workRecordVo);
        }
    }
}
