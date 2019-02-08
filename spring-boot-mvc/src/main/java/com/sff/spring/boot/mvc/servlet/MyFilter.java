package com.sff.spring.boot.mvc.servlet;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("do myFilter");
        chain.doFilter(request, response);
    }
}
