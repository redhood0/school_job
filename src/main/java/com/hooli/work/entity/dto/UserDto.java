package com.hooli.work.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author: cky
 * @Date: 2020/6/9 13:19
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String nickname;
    private String avatar;
    private String password;
    private Integer gender;
    private Integer age;
    private String school;
    private String saySomething;
    private String location;
    private String remark;
    private Integer isDelete;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
