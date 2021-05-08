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
        String name = "";
        String scientificName = "";
        String category = "";
        String region = "";
        String description = "";
        String image = "";
        System.out.println("happy");

        System.out.println(("Response: "+request));
        ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
        try {
            List<FileItem> file = sf.parseRequest(request);
            System.out.println("Size: "+file.size());
            int c = 0;
            for (FileItem item : file) {
                if(c == 0) {
                    name = item.getString();
                    System.out.println("Servlet name: " +name);
                }
                if(c == 1) {
                    scientificName = item.getString();
                    System.out.println(scientificName);
                }
                if(c == 2) {
                    category = item.getString();
                    System.out.println("Category: "+category);
                }
                if(c == 3) {
                    region = item.getString();
                    System.out.println("Region: "+region);
                }
                if(c == 4) {
                    description = item.getString();
                    System.out.println(description);
                }
                if(c == 5) {
                    image = item.getName();
                    if(!image.equals(""))
                        item.write(new File("C:\\Users\\ashik\\Downloads\\birds\\src\\main\\webapp\\uploadedFiles\\" + item.getName()));
                    System.out.println(image);
                }
                c++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(name.equals("") || scientificName.equals("") || description.equals("") || image.equals("")) {
            PrintWriter out = response.getWriter();
            out.println("<h1>One of the field is empty</h1>");
        } else {
            BirdDao birdDao = new BirdDao();
            try {
                birdDao.insert(new BirdInfo(name, scientificName, category, region, description, image));
                response.sendRedirect("index.jsp");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}