package com.hooli.work.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author zq
 * @since 2020-06-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("work_record")
public class WorkRecord extends Model<WorkRecord> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("work_demand_id")
    private Long workDemandId;

    /**
     * 工作状态，0申请中，1工作中，2工作完成
     */
    @TableField("work_status")
    private Integer workStatus;

    /**
     * 开始工作时间
     */
    @TableField("gmt_work_start")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtWorkStart;

    /**
     * 结束工作时间
     */
    @TableField("gmt_work_end")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtWorkEnd;

    /**
     * 兼职人id
     */
    @TableField("worker_id")
    private Long workerId;

    @TableField(value = "is_delete",fill = FieldFill.INSERT)
    private Integer isDelete;

    @TableField(value = "gmt_create",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;

    @TableField(value = "gmt_modified",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
