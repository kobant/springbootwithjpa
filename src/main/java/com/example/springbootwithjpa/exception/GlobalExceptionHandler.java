package com.example.springbootwithjpa.exception;

import com.example.springbootwithjpa.enums.CommonErrorConstant;
import com.example.springbootwithjpa.enums.ErrCode;
import com.example.springbootwithjpa.utils.ExceptionStackTraceUtil;
import com.example.springbootwithjpa.utils.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/4/27 14:07
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Value("${application.name}")
    private String serviceName;

    /**
     * Insert或Update数据时违反了完整性，例如违反了唯一性限制
     *
     * @param e 异常
     * @return 返回对象
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Object handlerException(DataIntegrityViolationException e) {
        log.error(ExceptionStackTraceUtil.getStackTrace(e));
        return new ResponseData<>(ErrCode.DATA_INTEGRITY_VIOLATION_EXCEPTION.getCode(),
                ErrCode.DATA_INTEGRITY_VIOLATION_EXCEPTION.getMsgZ(), "");
    }


    @ResponseBody
    @ExceptionHandler(JMException.class)
    public ResponseData<Object> handleException(JMException e) {
        log.error(ExceptionStackTraceUtil.getStackTrace(e));
        return new ResponseData<>(e.getErrCode(), e.getMsgZ(), e.getMsgE());
    }


    /**
     * 校验参数绑定的错误信息
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseData<Object> handleBindException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        //log.error(ExceptionStackTraceUtil.getStackTrace(e));
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            if (!errors.isEmpty()) {
                // 这里列出了全部错误参数，按正常逻辑，只需要第一条错误即可
                FieldError fieldError = (FieldError) errors.get(0);
                return new ResponseData<>(CommonErrorConstant.COMMON_REQ_MISSING.getCode(),
                        fieldError.getDefaultMessage(), "");
            }
        }
        return new ResponseData<>(CommonErrorConstant.COMMON_ERROR.getCode(),
                CommonErrorConstant.COMMON_ERROR.getMsg(),
                "The server is abnormal, please contact the administrator, Microservice is " + serviceName + "");
    }

    /**
     * 对于其他错误的全局捕捉
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseData<Object> handleException(Exception e) {
        log.error(ExceptionStackTraceUtil.getStackTrace(e));
        return new ResponseData<>(CommonErrorConstant.COMMON_ERROR.getCode(),
                CommonErrorConstant.COMMON_ERROR.getMsg(),
                "The server is abnormal, please contact the administrator, Microservice is " + serviceName + "");
    }



}