package ru.javaops.masterjava.web;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

public class ThymeleafAppUtil {
    private static TemplateEngine templateEngine;

    static {
        ServletContextTemplateResolver templateResolver =
                new ServletContextTemplateResolver();
        templateResolver.setTemplateMode("XHTML");
        templateResolver.setPrefix("/WEB-INF/jsp/");
        templateResolver.setSuffix(".jsp");
        templateResolver.setCacheTTLMs(3600000L);
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }

    public static TemplateEngine getTemplateEngine() {
        return templateEngine;
    }
}
