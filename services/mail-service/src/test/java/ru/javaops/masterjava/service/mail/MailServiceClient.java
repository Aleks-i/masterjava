package ru.javaops.masterjava.service.mail;

import com.google.common.collect.ImmutableList;
import com.typesafe.config.Config;
import ru.javaops.masterjava.config.Configs;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class MailServiceClient {

    public static void main(String[] args) throws MalformedURLException {
        Config mailConfig = Configs.getConfig("mail.conf", "ml");

        Service service = Service.create(
                new URL("http://localhost:8080/mail/mailService?wsdl"),
                new QName("http://mail.service.masterjava.javaops.ru/", "MailServiceImplService"));

        MailService mailService = service.getPort(MailService.class);
        mailService.sendMail(ImmutableList.of(new Addressee(mailConfig.getString("toName"), null),
                        new Addressee(mailConfig.getString("toName2"), null),
                        new Addressee("badMail", null),
                        new Addressee("badMail@lkme", null)),
                null, "Subject", "Body");
    }
}
