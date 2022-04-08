package com.ztax.feign.intercepter;

import com.ztax.common.constants.AuthConstants;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理token透传
 */
@Component
public class FeignIntercepter implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //添加token
        String token = request.getHeader(AuthConstants.JWT_TOKEN_HEADER);
        if (StringUtils.isNotBlank(token)) {
            requestTemplate.header(AuthConstants.JWT_TOKEN_HEADER, token);
        }
    }
}
