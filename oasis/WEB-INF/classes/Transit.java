import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import DAO.SaveimgDAO;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;

//멀티파트 어노테이션 (필수)
@MultipartConfig(
        location = "/usr/local/tomcat/upload/tmp",
        maxFileSize = -1,
        maxRequestSize = -1,
        fileSizeThreshold = 1024)
@WebServlet("/transit")
public class Transit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        ImageUpload imageUpload = new ImageUpload();

        request.setAttribute("img", imageUpload.saveImage(request,"oasis_picture"));
        
        
        
        SaveimgDAO img = new SaveimgDAO();
        img.insertimg(response, request, (ArrayList<String>)request.getAttribute("img"));
        img.delivery(request, response);
        
        response.sendRedirect("./pickdownlist?status=");
    }
}
