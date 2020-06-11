package com.hooli.work.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2020-06-11
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
