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
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Data data = DataFactory.getInstance();
        // Process register
        doEditUserInfo(data, request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    public void doEditUserInfo(Data data, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get Data from parameter
        //String cmdType = request.getParameter("cmdType");
        String id = request.getParameter("id");
        System.out.println(id);
        String gender = request.getParameter("gender");
        System.out.println(gender);
        String state = request.getParameter("state");
        System.out.println(state);
        String city = request.getParameter("city");
        System.out.println(city);

        String street = request.getParameter("street");
        System.out.println(street);
        String zip = request.getParameter("zip");
        System.out.println(zip);
        String fname = request.getParameter("fname");
        System.out.println(fname);
        String email = request.getParameter("email");
        System.out.println(email);
        String pwd = request.getParameter("pwd");
        System.out.println(pwd);
        String year = request.getParameter("year");
        System.out.println(year);
        // Check email

        User item = data.getUserByEmail(email);
        System.out.println("test in userinfo");
        //System.out.println(item);
        List<User> listUser = data.getUserList();
        int count = listUser.size();

        //GetCurrentUserInfoServlet currInfo = new GetCurrentUserInfoServlet();
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        String nEmail = user.getEmail();

        if (!(nEmail.equals(email))&& item!=null) {

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"status\": \"false\", \"message\": \"email in used\"}");
        }

        User newUser = new User(id, "user", fname, gender, state, city, street,
                zip,parseInt(year) , email, pwd);


        String respJson = new Gson().toJson(newUser);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(respJson);

        updateEditSession(request, newUser, true);
        return;
    }




    public void updateEditSession(HttpServletRequest req, User user , Boolean isLogged) {
        HttpSession session = req.getSession();

        session.setAttribute("user", user);

//
//        session.setAttribute("isLogged", isLogged);
        // Log tracking
        System.out.println("Updated session: " + user.getId() + ", " + user.getUserType() + ", " +user.getFullName()
                + ", "+ user.getGender()+", "+ user.getState()+", "+ user.getCity()+", "+ user.getZipCode()
                +", "+ user.getStreet()+", "+ user.getStreet() +", "+ user.getBirthYear()
                +", "+user.getEmail()+ ", "+ user.getPassword()+ ", "+isLogged);
    }
    public void sendToClient(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String respJson = new Gson().toJson(data.getUserList());
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(respJson);

    }
}
