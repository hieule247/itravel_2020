package itravel.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Hailian
 * @Poject name iTravel2020
 * @creat2020-11-16 12:09 PM
 */
public class PostWordFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        HttpSession session = httpServletRequest.getSession();
//        Object user = session.getAttribute("user");
//// 如果等于 null，说明还没有登录
//        if (user == null) {
//            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
//            return;
//        } else {
//// 让程序继续往下访问用户的目标资源
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
    }
}
