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
@TableName("work_demand_content")
public class WorkDemandContent extends Model<WorkDemandContent> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("demand_id")
    private Long demandId;

    /**
     * 文字内容
     */
    @TableField("content")
    private String content;

    /**
     * 工作时间
     */
    @TableField("worktime")
    private String worktime;

    /**
     * 结算方式（次结，日结，周结，月结）
     */
    @TableField("settlement")
    private String settlement;

    /**
     * 宣传图id
     */
    @TableField("adv_maps_id")
    private Long advMapsId;

    /**
     * 已经招到的人数
     */
    @TableField("already_worker_num")
    private Integer alreadyWorkerNum;

    /**
     * 最大招聘人数
     */
    @TableField("max_worker_num")
    private Integer maxWorkerNum;

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
