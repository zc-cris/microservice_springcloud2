package com.cris.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName MyFilter
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@Component
public class MyFilter extends ZuulFilter {

    // 过滤规则
    @Override
    public String filterType() {
        return "pre";
    }

    // 过滤顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    // 是否需要过滤，一般开启
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 认证规则
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        if (token == null){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
                currentContext.getResponse().getWriter().write("token is missing!,please login or call administrator");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
