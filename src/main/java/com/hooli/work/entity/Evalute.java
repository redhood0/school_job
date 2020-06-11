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
@TableName("evalute")
public class Evalute extends Model<Evalute> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 评价内容
     */
    @TableField("content")
    private String content;

    /**
     * 内容图片
     */
    @TableField("content_img1")
    private String contentImg1;

    /**
     * 内容图片
     */
    @TableField("content_img2")
    private String contentImg2;

    /**
     * 内容图片
     */
    @TableField("content_img3")
    private String contentImg3;

    /**
     * 星数
     */
    @TableField("star")
    private Integer star;

    /**
     * 老板id
     */
    @TableField("evalutor_id")
    private Long evalutorId;

    /**
     * 被评价人
     */
    @TableField("user_id")
    private Long userId;

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
