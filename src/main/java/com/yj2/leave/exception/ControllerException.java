package com.yj2.leave.exception;

import lombok.Data;

import java.util.Map;

@Data
public class ControllerException extends RuntimeException {

    private static final long serialVersionUID = 694905108298102070L;

    private ResultMsg resultMsg;

    private Integer status;
    private String message;
    private Map<String, Object> errorData;

    public ControllerException(String message) {
        this.message = message;
    }

    public ControllerException(ResultMsg resultMsg) {
        this.resultMsg = resultMsg;
    }

    public ResultMsg getResultMsg(){
        return resultMsg;
    }
}
