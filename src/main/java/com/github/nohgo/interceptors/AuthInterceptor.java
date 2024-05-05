package com.github.nohgo.interceptors;

import com.github.nohgo.services.AuthService;
import com.github.nohgo.models.Individual;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@AllArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final AuthService authService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        Individual individual = authService.login(username, password);
        if (individual != null) {
            request.setAttribute("individual", individual);
            return true;
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
    }
}
