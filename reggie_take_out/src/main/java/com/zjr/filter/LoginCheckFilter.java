package com.zjr.filter;

import com.alibaba.fastjson.JSON;
import com.zjr.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();
        log.info("拦截到请求：{}", requestURI);
        String[] urls = new String[]{"/employee/login",
                "employee/logout", "/backend/**", "/front/**"};

        boolean check = check(urls, requestURI);

        if(check){
            log.info("不受限资源");
            filterChain.doFilter(request, response);
            return;
        }

        if(request.getSession().getAttribute("employee")!= null){
            log.info("用户已登录");
            filterChain.doFilter(request, response);
            return;
        }

        response.getWriter().write(JSON.toJSONString(Result.error("NOTLOGIN")));
    }

    public boolean check(String[] urls, String requestURI){
        for(String url: urls){
            boolean match = PATH_MATCHER.match(url, requestURI);
            if(match){
                return true;
            }
        }
        return false;
    }
}
