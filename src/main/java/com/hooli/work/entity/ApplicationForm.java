package com.hooli.work.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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

    @TableField("is_delete")
    private Integer isDelete;

    @TableField("gmt_create")
    private LocalDateTime gmtCreate;

    @TableField("gmt_modified")
    private LocalDateTime gmtModified;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
