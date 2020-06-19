package com.hooli.work.entity.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TagDemandVo extends Model<TagDemandVo> {
    private Long tagId;
    private Long demandId;
}
