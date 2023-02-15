package ru.javaops.masterjava.service.mail;

import com.typesafe.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import ru.javaops.masterjava.config.Configs;
import ru.javaops.masterjava.dbi.provider.DBIPersistProvider;
import ru.javaops.masterjava.dbi.provider.DBIProvider;
import ru.javaops.masterjava.service.dao.MailSenderStatusDao;
import ru.javaops.masterjava.service.model.MailSenderStatus;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {

    static {
        DBIProvider.initDBI();
    }

    private static MailSenderStatusDao dao = DBIPersistProvider.getDao(MailSenderStatusDao.class);

    private static final String STATUS_OK = "Ok";

    static void sendMail(List<Addressee> to, List<Addressee> cc, String subject, String body) {
        log.info("Send mail to \'" + to + "\' cc \'" + cc + "\' subject \'" + subject + (log.isDebugEnabled() ? "\nbody=" + body : ""));

        Email email;
        Config mailConfig = Configs.getConfig("mail.conf", "ml");

        List<MailSenderStatus> mailSenderStatuses = new ArrayList<>();
        for (Addressee addressee : to) {
            email = new SimpleEmail();
            email.setHostName(mailConfig.getString("host"));
            email.setSmtpPort(mailConfig.getInt("port"));

            email.setAuthenticator(new DefaultAuthenticator(
                    mailConfig.getString("username"),
                    mailConfig.getString("password")));

            email.setSSLOnConnect(mailConfig.getBoolean("useSSL"));
            email.setStartTLSEnabled(mailConfig.getBoolean("useTLS"));
            email.setDebug(mailConfig.getBoolean("debug"));

            String emailFrome = mailConfig.getString("fromName");
            String emailTo = "";

            try {
                email.setFrom(emailFrome);
                email.setSubject(subject);
                email.setMsg(body + " This is a test mail ... :-)");
                emailTo = addressee.getEmail();
                email.addTo(emailTo);
                mailSenderStatuses.add(new MailSenderStatus(null, emailFrome, emailTo, STATUS_OK));
                email.send();
            } catch (EmailException e) {
                mailSenderStatuses.add(new MailSenderStatus(null, emailFrome, emailTo, e.getMessage()));
            }
        }
        dao.insertBatch(mailSenderStatuses);
    }
}
