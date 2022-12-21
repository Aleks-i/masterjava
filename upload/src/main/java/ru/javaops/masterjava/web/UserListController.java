package ru.javaops.masterjava.web;

import org.thymeleaf.context.WebContext;
import ru.javaops.masterjava.xml.schema.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class UserListController {
    public void process(HttpServletRequest request, HttpServletResponse response, Set<User> users)
            throws IOException {
        WebContext ctx = new WebContext(request, response, request.getServletContext(),
                request.getLocale());
        ctx.setVariable("users", users);
        ThymeleafAppUtil.getTemplateEngine().process("userList", ctx, response.getWriter());
    }
}
