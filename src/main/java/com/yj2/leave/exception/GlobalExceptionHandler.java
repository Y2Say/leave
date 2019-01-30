package com.yj2.leave.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /*@ExceptionHandler(value = Exception.class)
    @ResponseStatus
    @ResponseBody
    public ServerResponse handlerException(Exception e) throws Exception {
        if (e instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) e;
            return ServerResponse.errorMessage(serviceException.getCode(), serviceException.getMessage());
        } else {
            throw e;
        }
    }*/
}
