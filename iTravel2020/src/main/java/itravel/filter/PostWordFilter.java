package itravel.filter;

import itravel.model.Data;
import itravel.model.DataFactory;
import itravel.model.WordFilter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Hailian
 * @Poject name iTravel2020
 * @creat2020-11-16 12:09 PM
 */

@WebFilter(filterName = "WordsFilter", urlPatterns ={"/resources/homePage.jsp", "/resources/user_PostManagement.jsp"})
public class PostWordFilter implements Filter {
    List<WordFilter> wordFiltersList = DataFactory.getInstance().getWordFilterList();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
//        String uri = httpServletRequest.getRequestURI();
         String post =  (String) servletRequest.getParameter("content");//sentence
         for(WordFilter wordFilter : wordFiltersList){
             if (wordFilter.getValue().equals(post)) {
                 // servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);//把结果发回去的网址
                 session.setAttribute("content","false");
                 break;
             } else {
// 让程序继续往下访问用户的目标资源
                 session.setAttribute("content","true");
             }
             filterChain.doFilter(servletRequest,servletResponse);
         }

    }
}
