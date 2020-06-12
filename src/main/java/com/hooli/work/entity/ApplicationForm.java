package com.hooli.work.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
 * @author dylan
 * @since 2020-06-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("application_form")
public class ApplicationForm extends Model<ApplicationForm> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 申请的工作id
     */
    @TableField("work_demand_id")
    private Long workDemandId;

    /**
     * 申请人id
     */
    @TableField("applicat_id")
    private Long applicatId;

    /**
     * 申请时间
     */
    @TableField("gmt_apply")
    private LocalDateTime gmtApply;

    /**
     * 申请消息
     */
    @TableField("msg")
    private String msg;

    /**
     * 申请状态，0申请中，1已通过，2已拒绝，3已取消
     */
    @TableField("state")
    private Integer state;

    @TableField(value = "is_delete",fill = FieldFill.INSERT)
    private Integer isDelete;

    @TableField(value = "gmt_create",fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(value = "gmt_modified",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
