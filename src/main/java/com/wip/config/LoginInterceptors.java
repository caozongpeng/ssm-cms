/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/20 10:12
 **/
package com.wip.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
public class LoginInterceptors implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("UTF-8");
        StringBuffer requestURL = request.getRequestURL();
        if (requestURL.toString().contains("admin") &&
                !requestURL.toString().contains("admin/login") &&
                !requestURL.toString().contains("admin/dologin")) {
            Object user = request.getSession().getAttribute("user");
            if (null == user) {
                response.sendRedirect("/admin/login");
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
