package com.hooli.work.common;


import java.util.ArrayList;
import java.util.List;

/**
 * @author wl
 * @ClassNameasdad
 * @Description TODO
 * @Date 2020/1/1
 * @Version 1.0
 */

public enum ResultCode {

    /**
     * 统一的枚举维护 命名规则：模块前缀_具体错误原因 举例 用户模块账户不存在  USER_ACCOUNT_NOT_EXIT()
     * 状态码在规定范围内执行
     */
    /* 成功状态码 */
    SUCCESS(1, "成功"),

    /* 参数错误：10001-19999 */

    /* 用户模块：20000-21500 */

    USER_NOT_EXIT(20000,"用户不存在"),
    /*  教务管理模块  :21600-22100 */

    /*  基础管理模块  :22200-22700 */

    /*  配置管理模块  :22800-23300 */

    /*  通讯模块  :23400-23900 */

    /*  一卡通模块  24000-24500 */

    /*  图书管理模块  :24600-25100 */
    BOOK_HAS_BORROW(24601,"图书已被借阅"),

    /*  资讯管理模块  :25200-25700 */
    NEWS_NOT_EXIT(25201,"资讯不存在"),

    /* 业务错误：30001-39999 */

    /* 系统错误：40001-49999 */

    /* 数据错误：50001-599999 */

    /* 接口错误：60001-69999 */

    /* 权限错误：70001-79999 */







    /* 业务错误：30001-39999 */
    SPECIFIED_QUESTIONED_USER_NOT_EXIST(30001, "某业务出现问题"),

    /* 系统错误：40001-49999 */
    SYSTEM_INNER_ERROR(40001, "系统繁忙，请稍后重试"),

    /* 数据错误：50001-599999 */
    RESULT_CODE_DATA_NONE(50001, "数据未找到"),
    DATA_IS_WRONG(50002, "数据有误"),
    DATA_ALREADY_EXISTED(50003, "数据已存在"),


    /* 接口错误：60001-69999 */
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
    INTERFACE_OUTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),
    PARAMS_ERROR(60007,"请求参数错误"),

    /* 权限错误：70001-79999 */
    PERMISSION_NO_ACCESS(70001, "无访问权限");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }



    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }


    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return this.name();
    }




    /**
     * 校验重复的code值
     *
     * @param args
     */
    public static void main(String[] args) {
        ResultCode[] ApiResultCodes = ResultCode.values();
        List<Integer> codeList = new ArrayList<Integer>();
        for (ResultCode ApiResultCode : ApiResultCodes) {
            if (codeList.contains(ApiResultCode.code)) {
                System.out.println(ApiResultCode.code);
            } else {
                codeList.add(ApiResultCode.code());
            }
        }
    }
}

