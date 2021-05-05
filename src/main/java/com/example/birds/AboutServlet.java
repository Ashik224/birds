package com.example.birds;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/about")
public class AboutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        BirdDao birdDao = new BirdDao();
//        try {
//            BirdInfo birdInfo = birdDao.retrieve();
//            String name = birdInfo.getName();
//            String category = birdInfo.getCategory();
//            System.out.println("Name: "+name);
//            System.out.println("Category: "+category);
//
//        } catch (SQLException | ClassNotFoundException throwable) {
//            throwable.printStackTrace();
//        }
    }
}
