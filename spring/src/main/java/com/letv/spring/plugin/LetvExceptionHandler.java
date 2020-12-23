package com.letv.spring.plugin;

import com.letv.spring.util.MessageUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class LetvExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(LetvExceptionHandler.class);

    public static String LETV_LEKA_RECHARGE_ERROR = "1201";// 乐卡充值失败

    @ExceptionHandler(Exception.class)
    // 将返回值转成json格式
    @ResponseBody
    // 返回状态码
    @ResponseStatus(value = HttpStatus.OK)
    public CommonError handleException(Exception e) {
        LOGGER.error("handleException: ", e);
        String errorCode = "-100";
        String message = MessageUtils.getMessage("SYSTEM_ERROR");
        if (StringUtils.isBlank(message)) {
            message = "服务异常请重试! ";
        }
        CommonError commonError = new CommonError();
        commonError.setResultStatus("0");
        commonError.setMessage(message);
        commonError.setErrorCode(errorCode);
        return commonError;
    }
}
