package ru.javaops.masterjava.web;

import com.google.common.io.Resources;
import ru.javaops.masterjava.xml.schema.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Cache-Control", "no-cache");
        res.setDateHeader("Expires", 0);
        MyThymeleafApplicationController application = new MyThymeleafApplicationController();
        application.process(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Cache-Control", "no-cache");
        res.setDateHeader("Expires", 0);
        String path = this.getClass().getClassLoader().getResource("").getPath();
        String fullPath = URLDecoder.decode(path, "UTF-8");
        Collection<Part> parts = req.getParts();
        String filePath = "";
        for (Part part : parts) {
            System.out.println("Name:");
            System.out.println(part.getName());
            System.out.println("Header: ");
            for (String headerName : part.getHeaderNames()) {
                System.out.println(headerName);
                System.out.println(part.getHeader(headerName));
            }
            System.out.println("Size: ");
            System.out.println(part.getSize());
            filePath = fullPath + part.getSubmittedFileName();
            part.write(filePath);
        }

        URL payloadUrl = Resources.getResource("payload.xml");
        Set<User> users = Collections.EMPTY_SET;
        try {
            users = MainXml.processUsersByStax(payloadUrl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        UserListController application = new UserListController();
        application.process(req, res, users);
    }
}