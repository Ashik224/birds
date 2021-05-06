package com.example.birds;

import com.example.BirdInfo;
import com.example.dao.BirdDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        String name = null;
        String scientificName = null;
        String category = null;
        String region = null;
        String description = null;
        String image = null;
        String prevImage = null;

        System.out.println("Ashsi");

        ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
        try {
            List<FileItem> file = sf.parseRequest(request);
            int c = 0;
            for (FileItem item : file) {
                if(c == 0) {
                    id = Integer.parseInt(item.getString());
                    System.out.println("ID: "+id);
                }
                if(c == 1) {
                    prevImage = item.getString();
                    System.out.println("Prev Image: "+prevImage);
                }
                if(c == 2) {
                    name = item.getString();
                }
                if(c == 3) {
                    scientificName = item.getString();
                }
                if(c == 4) {
                    category = item.getString();
                }
                if(c == 5) {
                    region = item.getString();
                }
                if(c == 6) {
                    description = item.getString();
                }
                if(c == 7) {
                    image = item.getName();
                    if (!image.equals("")) {
                        item.write(new File("C:\\Users\\ashik\\Downloads\\birds\\src\\main\\webapp\\uploadedFiles\\" + item.getName()));
                    } else {
                        image = prevImage;
                    }
                }
                c++;
            }
            BirdDao dao = new BirdDao();
            dao.update(new BirdInfo(id, name, scientificName, category, region, description, image));
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
