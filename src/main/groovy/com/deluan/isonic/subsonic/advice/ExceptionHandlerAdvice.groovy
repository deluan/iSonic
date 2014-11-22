package com.deluan.isonic.subsonic.advice

import com.deluan.isonic.subsonic.responses.SubsonicError
import com.deluan.isonic.subsonic.responses.SubsonicResponse
import com.deluan.isonic.util.Loggable
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

import javax.servlet.http.HttpServletRequest

@ControllerAdvice(basePackageClasses = AdvisableController)
public class ExceptionHandlerAdvice implements Loggable {

    @ExceptionHandler(value = [Exception.class])
    @ResponseBody
    public defaultErrorHandler(HttpServletRequest request, Exception exception) {
        logger.error("Error caused by request ${request}:", exception)
        SubsonicResponse.withError(SubsonicError.GENERIC)
    }
}