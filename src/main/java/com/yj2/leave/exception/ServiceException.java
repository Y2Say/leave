package com.yj2.leave.exception;

import lombok.Data;

import java.util.Map;

@Data
public class ServiceException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private ResultMsg resultMsg;

    private Integer code;
    private String message;
    private Map<String, Object> errorData;

    public ServiceException(String message) {
        this.message = message;
    }

    public ServiceException(ResultMsg resultMsg) {
        super();
        this.resultMsg = resultMsg;
        this.code = resultMsg.getCode();
        this.message = resultMsg.getErrorMsg();
    }

    public ServiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
