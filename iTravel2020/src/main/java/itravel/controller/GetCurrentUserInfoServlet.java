package itravel.controller;

import com.google.gson.Gson;
import itravel.model.Data;
import itravel.model.DataFactory;
import itravel.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/GetCurrentUserInfoServlet")
public class GetCurrentUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //System.out.println(user.getFullName()+", "+user.getEmail()+", "+user.getBirthYear());
//        request.setAttribute("htmlTagData", "<br/> creates a new line.");
//        request.setAttribute("url", "userTravelInfo.jsp");
//        RequestDispatcher rd = getServletContext().getRequestDispatcher("signupForm.jsp");
//        rd.forward(request, response);
        Data data = DataFactory.getInstance();
        // Process register
        displayUserInfo(data, request, response);
    }
    public void displayUserInfo(Data data, HttpServletRequest request, HttpServletResponse resp)throws IOException, ServletException{
        HttpSession session = request.getSession();
//        User item = data.getUser();
//        System.out.println(item);
//
//        System.out.println(session.toString());
        User user = (User) session.getAttribute("user");
        //System.out.println(user.getFullName()+", "+user.getEmail()+", "+user.getBirthYear());
        String respJson = new Gson().toJson(user);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(respJson);
    }
}
