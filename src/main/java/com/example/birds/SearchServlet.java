package com.example.birds;

import com.example.BirdInfo;
import com.example.dao.BirdDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BirdInfo> birdInfoList = null;
        String searchData = request.getParameter("search");
        BirdDao dao = new BirdDao();
        System.out.println("Search: "+searchData);
        if(searchData.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                birdInfoList = dao.retrieveSearch(searchData);
                request.setAttribute("birdInfoList", birdInfoList);
                RequestDispatcher rd = request.getRequestDispatcher("filteredData.jsp");
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
