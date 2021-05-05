package com.example.birds;

import com.example.BirdInfo;
import com.example.dao.BirdDao;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        System.out.println("Called");
//        System.out.println("request URI=" + request.getRequestURI());
//        request.setAttribute("key", "hii");
        PrintWriter out = response.getWriter();
        BirdDao dao = new BirdDao();
        try {
            List<BirdInfo> infos = dao.retrieveAll();
            request.setAttribute("birdInfo", infos);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
//        response.sendRedirect("index.jsp");
    }
}