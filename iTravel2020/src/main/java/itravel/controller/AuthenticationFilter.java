package itravel.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// @WebFilter("/*")
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String action = req.getServletPath();
        if("/".equals(action) || "/login".equals(action) || "/login.jsp".equals(action)
//                || "/*.css".equals(action)
//                || "/*.js".equals(action)
//                || "/loginServlet".equals(action)
//                || "/index.jsp".equals(action)
//                // Using for Ha
//                || "/signupForm.jsp".equals(action)
//                || "/register.js".equals(action)
//                || "/RegisterServlet".equals(action)
//                || "/userTravelInfo.jsp".equals(action)
//                || "/GetCurrentUserInfoServlet".equals(action)

                || "/loginServlet".equals(action)
                || "/index.jsp".equals(action)
                // Using for Ha
                || "/signupForm.jsp".equals(action)
                || "/register.js".equals(action)
                || "/RegisterServlet".equals(action)
                || "/userTravelInfo.jsp".equals(action)
                || "/GetCurrentUserInfoServlet".equals(action)
        ){
            filterChain.doFilter(servletRequest, servletResponse);
        } else{
            Object isLoggedObj = req.getSession().getAttribute("isLogged");
            if(isLoggedObj != null){
                boolean isLoggedIn = (Boolean) isLoggedObj;
                if(isLoggedIn){
                    filterChain.doFilter(servletRequest, servletResponse);
                    return;
                }
            }
//            http://localhost:8080/filter_demo_war_exploded/
            String path = req.getContextPath()+ "/";
            resp.sendRedirect(path);
        }
//        System.out.println("AuthenticationFilter ---2-------");
    }
}
