package com.hooli.work.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @PackgeName: com.hooli.work.entity
 * @ClassName: QQAccessEntity
 * @Author: redhood
 * Date: 2020/6/12 13:57
 * project name: school_job
 * @Version:
 * @Description:
 */
@Data
public class QQAccessEntity {
    private String openid;
    private String accessToken;

}
