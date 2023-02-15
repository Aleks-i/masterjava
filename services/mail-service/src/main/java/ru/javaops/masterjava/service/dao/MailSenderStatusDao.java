package ru.javaops.masterjava.service.dao;

import com.bertoncelj.jdbi.entitymapper.EntityMapperFactory;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlBatch;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import ru.javaops.masterjava.dbi.dao.AbstractDao;
import ru.javaops.masterjava.service.model.MailSenderStatus;

import java.util.Collection;

@RegisterMapperFactory(EntityMapperFactory.class)
public abstract class MailSenderStatusDao implements AbstractDao {

    @SqlUpdate("TRUNCATE mail_sender_status CASCADE")
    @Override
    public abstract void clean();

    @SqlBatch("INSERT INTO mail_sender_status (email_from, email_to, cause) VALUES (:emailFrom, :emailTo, :cause)")
    public abstract void insertBatch(@BindBean Collection<MailSenderStatus> statuses);
}
