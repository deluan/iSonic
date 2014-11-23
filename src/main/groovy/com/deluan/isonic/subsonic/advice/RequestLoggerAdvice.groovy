package com.deluan.isonic.subsonic.advice

import com.deluan.isonic.util.Loggable
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class RequestLoggerAdvice extends HandlerInterceptorAdapter implements Loggable {
    @Override
    boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        def queryString = request.queryString ? "?${request.queryString}" : ''
        def parameters = request.parameterMap ? " | Parameters=${request.parameterMap}" : ''
        logger.debug "Request from ${request.remoteAddr}: ${request.method} ${request.requestURI}${queryString}${parameters}"
        super.preHandle(request, response, handler)
    }

    @Override
    void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView)
        logger.debug "Response to ${request.remoteAddr}: status=${response.status}, contentType=${response.contentType}"
    }
}
