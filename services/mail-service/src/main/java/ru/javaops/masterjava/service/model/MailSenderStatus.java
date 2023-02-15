package ru.javaops.masterjava.service.model;

import com.bertoncelj.jdbi.entitymapper.Column;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class MailSenderStatus {
    Integer id;
    @Column("email_from")
    String emailFrom;
    String emailTo;
    String cause;

    public boolean isNew() {
        return id == null;
    }
}
