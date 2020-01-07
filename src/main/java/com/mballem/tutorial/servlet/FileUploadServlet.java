package com.mballem.tutorial.servlet;

import com.mballem.tutorial.service.FileService;
import com.mballem.tutorial.util.BaseDir;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Marcio Ballem on 15/04/2014.
 */
@WebServlet(urlPatterns = "/upload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1MB
        maxFileSize = 1024 * 1024 * 4,   // 4MB
        maxRequestSize = 1024 * 1024 * 4 // 4MB
)
public class FileUploadServlet extends HttpServlet {

    private static Logger logger = LogManager.getLogger(FileUploadServlet.class);

    private static final String BASE_DIR = BaseDir.PATH_ROOT;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        FileService service = new FileService();

        Path destination = service.createFolder(BASE_DIR);

        for (Part part : request.getParts()) {
            if (Files.exists(destination)) {
                service.saveFile(destination, part);
            }
        }

        request.setAttribute("message", "Upload has been done successfully!");
        request.setAttribute("fileEntities", service.findAll());

        getServletContext()
                .getRequestDispatcher("/file-list.jsp")
                .forward(request, response);
    }
}
