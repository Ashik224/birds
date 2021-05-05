package com.example.birds;

import com.example.dao.BirdDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scientificName = request.getParameter("scientific");
        BirdDao dao = new BirdDao();
        try {
            dao.delete(scientificName);
            response.sendRedirect("index.jsp");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
