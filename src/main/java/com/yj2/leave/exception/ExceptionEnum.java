package com.yj2.leave.exception;

public enum ExceptionEnum implements ResultMsg{

    //login
    ACCOUNT_NULL(500, "账号不能为空"),
    ACCOUNT_OR_PASSWORD_NOT_NULL(500,"账号或密码不能为空"),




    ACCOUNT_NO_EXIST(600, "账号被冻结"),
    ERROR＿PASSWORD(600, "密码错误"),
    ERROE_CREATE_TOKEN(600,"token创建失败"),
    ERROR_TOKEN(600, "账号异常，未登录"),
    TOKEN_EXPIRE(800, "账号过期，请重新登录"),

    NOT_EXIST(700, "账号不存在"),
    FILE_NOT_EXIST(700,"文件不存在"),
    DEPARTMENT_NOT_EXIST(700, "该部门不存在"),
    PID_NOT_EXIST(700, "父节点不存在"),
    AREA_NOT_EXIST(700, "该节点不存在"),


    ACCOUNT_EXIST(501,"账号已存在"),
    DEPARTMENT_EXIST(501, "该部门已经生成，不能重复"),
    FILE_EXIST(501, "文件已存在"),

    DEPARTMENT_DELETE_ERROR(505, "该部门不能删除"),

    AREA_EXIST(501,"该节点已存在"),
    PASSWORD_ERROE(500, "密码长度应在6-18位"),
    PRIZE_OVER(500, "该奖品已抽完"),
    WINNER_EXIST(500, "该人员已经中奖，不能重复"),
    TITLE_NULL(500, "活动标题不能为空"),
    CUSTOMER_ID_NULL(500, "抽奖人员ID不能为空"),
    PRIZE_INFO_NULL(500, "奖品信息不能为空"),
    PRIZE_ID_NULL(500, "奖品ID为空"),
    AREA_OR_PID_NULL(500, "节点名或父节点ID为空"),
    AREA_OR_ID_NULL(500, "节点名或节点ID为空"),
    AREAID_NULL(500, "区域ID为空"),

    INFO_NULL(500,"信息不能为空"),
    FILE_ID_NULL(500,"文件ID为空"),
    DEPARTMENT_NULL(500,"部门不能为空"),
    ERROR_CREATE_FILE(500, "文件创建失败");

    private Integer code;
    private String errorMsg;

    ExceptionEnum(Integer code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }


    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
