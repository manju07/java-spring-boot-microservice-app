package com.sample.springboot.microservices.zuulapigatewayserver.config;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author Manjunath Asundi
 */
@Component
public class ZuulLoggingFilter extends ZuulFilter {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("request is -> {}, request url->{}", request, request.getRequestURI()); 
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public String filterType() {
        return "pre";
    }
}