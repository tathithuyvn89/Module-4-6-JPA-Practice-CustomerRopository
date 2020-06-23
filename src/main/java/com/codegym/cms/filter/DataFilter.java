package com.codegym.cms.filter;

import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "DataFilter",urlPatterns = "*/")
public class DataFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
       req.setCharacterEncoding("UTF-8");
       resp.setContentType("tex/html; charset=UTF-8");
       resp.setCharacterEncoding("UTF-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
