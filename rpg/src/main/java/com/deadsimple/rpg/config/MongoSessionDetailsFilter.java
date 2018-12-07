package com.deadsimple.rpg.config;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class MongoSessionDetailsFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.setAttribute("SESSION_DETAILS", "flargh");
        }
    }
}
