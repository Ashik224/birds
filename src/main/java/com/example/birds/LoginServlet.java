package com.example.birds;

import com.example.LoginInfo;
import com.example.dao.LoginDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("name");
        String password = request.getParameter("password");

        LoginDao dao = new LoginDao();
        try {
            LoginInfo loginInfo = dao.retrieveLogin(userName);
            String dbUsername = loginInfo.getUserName();
            String dbPassword = loginInfo.getPassword();
            if(userName.equals(dbUsername) && password.equals(dbPassword)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", userName);
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
