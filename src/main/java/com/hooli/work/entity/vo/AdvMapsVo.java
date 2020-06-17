package com.hooli.work.entity.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AdvMapsVo extends Model<AdvMapsVo> {
    private Long id;
    private String advMap1;
    private String advMap2;
    private String advMap3;
}
