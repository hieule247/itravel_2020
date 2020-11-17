package itravel.controller;

import com.google.gson.Gson;
import itravel.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
/**
 * @author Hailian
 * @Poject name iTravel2020
 * @creat2020-11-16 11:01 AM
 */
@WebServlet("/AdminPostServlet")
public class AdminPostServlet extends HttpServlet {
    protected void getUserList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Check isLogged first
        if (isLogged(req, resp) == false)
            return;

        Data data = DataFactory.getInstance();
        Page<Post> pagePost = data.getPostPage();
        String cmdType = req.getParameter("cmdType");
        // Check
        if (cmdType.equals("init")) {
            doLoadInitUsers(data, req, resp);
        }else if (cmdType.equals("ShowOnPage")) {
            doShowOnPage(pagePost, data, req, resp);
        }else if (cmdType.equals("updActType")) {
            doUpdUserActiveType(data, req, resp);
        }else if(cmdType.equals("nextPage")) {
            doNextPage(pagePost, data, req, resp);
        }else if(cmdType.equals("prePage")){
            doPrePage(pagePost, data, req, resp);
        }
    }


    public void doLoadInitUsers(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // send data to client
        System.out.println("doLoadInitUsers......");
        sendToClient(data, req, resp);
    }

    public Boolean isLogged(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        // Write to log for debug
        String strType = (String) session.getAttribute("userType");
        String strId = (String) session.getAttribute("userID");
        Boolean logged = (Boolean) session.getAttribute("isLogged");
        System.out.println("Before Updated session: " + strId + ", " + strType + ", " + logged);
        // isLogged == invalid
        if (logged == null || logged == false) {
            System.out.println("Need to login......! ");
            // Send Redirect to Login Page
            resp.sendRedirect("login.jsp");
            return false;
        }
        // isLogged
        return true;
    }

    public void sendToClient(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String respJson = new Gson().toJson(data.getPostList());
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(respJson);
    }
    public void doShowOnPage(Page<Post> pagePost, Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int pageNo = pagePost.getPageNo();

        System.out.println("doShowOnPage pageNo: "+pageNo);
        //int pageSize = Integer.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int pageSize = pagePost.getPageSize();

        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Post> page = data.postPage(pageNo, pageSize);
        List<Post> postList = page.getItems();
        //page.setUrl("admin2/AdminServlet?action=page");
        //3 保存Page对象到Request域中
        //req.setAttribute("page",page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        //req.getRequestDispatcher("/admin2.jsp").forward(req,resp);
        String respJson = new Gson().toJson(postList);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().write(respJson);//resp里面的都是返回到action里面的，这里是把json的字符串返回到ajax的action里

    }

    public void doUpdUserActiveType(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get Data from parameter
        String id = req.getParameter("id");
        // Update the book
        Post post = data.getPost(id);//这个确定是哪个
        data.changePostActiveType(post);
        sendToClient(data, req, resp);

    }
    public void doNextPage(Page<Post> pagePost, Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int pageNo = pagePost.getPageNo() + 4;
        System.out.println("进入doNextPage后的 pageNo: " + pageNo);
        int pageSize = pagePost.getPageSize() + 4;
        System.out.println("进入doNextPage后的 pageSize:" + pageNo);
        pagePost.setPageNo(pageNo);
        pagePost.setPageSize(pageSize);
        doShowOnPage(pagePost, data, req, resp);
    }
    public void doPrePage(Page<Post> pagePost, Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int pageNo = pagePost.getPageNo()-4;
        System.out.println("进入doNextPage后的 pageNo: "+pageNo);
        int pageSize = pagePost.getPageSize()-4;
        System.out.println("进入doNextPage后的 pageSize:"+pageNo);
        pagePost.setPageNo(pageNo);
        pagePost.setPageSize(pageSize);
        doShowOnPage(pagePost, data, req, resp);
    }


}