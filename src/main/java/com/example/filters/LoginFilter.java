package com.example.filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/login")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String username = req.getParameter("name");
        String password = req.getParameter("password");
        if(username.equals("") || password.equals("")) {
            PrintWriter out = response.getWriter();
            out.println("<h1>One of the field is empty</h1>");
        } else {
            chain.doFilter(request, response);
        }
    }
}
