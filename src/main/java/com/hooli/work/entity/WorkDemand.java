package com.hooli.work.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author dylan
 * @since 2020-06-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("work_demand")
public class WorkDemand extends Model<WorkDemand> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     *  老板id
     */
    @TableField("boss_id")
    private Long bossId;

    /**
     * 封面
     */
    @TableField("cover_url")
    private String coverUrl;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 价格
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 工作地点
     */
    @TableField("place_name")
    private String placeName;

    /**
     * 单位（每天或每小时）
     */
    @TableField("unit")
    private String unit;

    /**
     * 工作地址
     */
    @TableField("place")
    private String place;

    /**
     * 工作类型
     */
    @TableField("type_id")
    private Long typeId;

    /**
     * 工作状态，0招人中，1停止招聘
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
