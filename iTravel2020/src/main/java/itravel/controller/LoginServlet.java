package itravel.controller;

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
// System.out.println("");

@WebServlet({"/loginServlet", "/", "/login"})
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // doPost(req, resp);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Data data = DataFactory.getInstance();
        // Process login
        doLogin(data, req, resp);
   }

    public void doLogin(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // Get Data from parameter
        String userName = req.getParameter("txtUserName");
        String password = req.getParameter("txtPassword");
        System.out.println(userName + " ----- " + userName);
        // Check userName, Password
        User item = data.login(userName, password);
        if (item == null) {
            // process error login
            System.out.println("login....FAIL!!!!");
            resp.sendRedirect("login?error=true");
        } else {
            String userId   = item.getId();
            String userType = item.getUserType();
            if (userType.equals("admin")) {
                System.out.println("admin.... login....SUCCESS ..... !!!!");
                updateLoginSession(req, userId, userType, true);
                // Redirect to Admin page
                resp.sendRedirect("admin.jsp");
            } else if (userType.equals("user")) {
                System.out.println("user.... login....SUCCESS ..... !!!!");
                updateLoginSession(req, userId, userType, true);
                // Redirect to User page
                resp.sendRedirect("user.jsp");
            }
        }
    }

    public void updateLoginSession(HttpServletRequest req, String userID, String userType, Boolean isLogged) {
        HttpSession session = req.getSession();
        session.setAttribute("userID", userID);
        session.setAttribute("userType", userType);
        session.setAttribute("isLogged", isLogged);
        // Log tracking
        System.out.println("Updated session: " + userID + ", " + userType + ", " + isLogged);
    }
}

