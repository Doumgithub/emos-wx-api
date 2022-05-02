package com.example.emos.wx.config.xss;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName XssFilter.java
 * @Description
 * @createTime 2022-04-27 13:15:00
 */
@WebFilter("/*")
public class XssFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        XssHttpServletRequestWarpper warpper = new XssHttpServletRequestWarpper(request);
        filterChain.doFilter(warpper,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
