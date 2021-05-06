package com.example.birds;

import com.example.BirdInfo;
import com.example.dao.BirdDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scientificName = request.getParameter("scientificName");
        BirdDao dao = new BirdDao();
        try {
            BirdInfo birdInfo = dao.retrieve(scientificName);
            String birdName = birdInfo.getName();
            String category = birdInfo.getCategory();
            String region = birdInfo.getRegion();
            String description = birdInfo.getDescription();
            String image = birdInfo.getRealImage();

            request.setAttribute("name", birdName);
            request.setAttribute("scientificName", scientificName);
            request.setAttribute("category", category);
            request.setAttribute("region", region);
            request.setAttribute("description", description);
            request.setAttribute("image", image);

            RequestDispatcher rd = request.getRequestDispatcher("details.jsp");
            rd.forward(request,response);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }
}
