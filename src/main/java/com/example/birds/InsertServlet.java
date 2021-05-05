package com.example.birds;

import com.example.BirdInfo;
import com.example.dao.BirdDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
        String name = null;
        String scientificName = null;
        String category = null;
        String region = null;
        String description = null;
        String image = null;

        ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
        try {
            List<FileItem> file = sf.parseRequest(request);
            int c = 0;
            for (FileItem item : file) {
                if(c == 0) {
                    name = item.getString();
                    System.out.println(name);
                }
                if(c == 1) {
                    scientificName = item.getString();
                    System.out.println(scientificName);
                }
                if(c == 2) {
                    category = item.getString();
                    System.out.println(category);
                }
                if(c == 3) {
                    region = item.getString();
                    System.out.println(region);
                }
                if(c == 4) {
                    description = item.getString();
                    System.out.println(description);
                }
                if(c == 5) {
                    item.write(new File("C:\\Users\\ashik\\Downloads\\birds\\src\\main\\webapp\\uploadedFiles\\" + item.getName()));
                    image = item.getName();
                    System.out.println(image);
                }
                c++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        BirdDao birdDao = new BirdDao();
        try {
            birdDao.insert(new BirdInfo(name, scientificName, category, region, description, image));
            response.sendRedirect("index.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}