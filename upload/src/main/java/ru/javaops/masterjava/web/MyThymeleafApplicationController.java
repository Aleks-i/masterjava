package ru.javaops.masterjava.web;

import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyThymeleafApplicationController {
    public void process(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        WebContext ctx = new WebContext(request, response, request.getServletContext(),
                request.getLocale());
        ThymeleafAppUtil.getTemplateEngine().process("fileUpload", ctx, response.getWriter());
    }
}
