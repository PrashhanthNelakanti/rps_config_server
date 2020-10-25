package com.schwab.rps.com.schwab.rps.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
public class EmailMetaData {

    @Id
    private int id;
    private String name;
    private LocalDateTime emailSentOn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getEmailSentOn() {
        return emailSentOn;
    }

    public void setEmailSentOn(LocalDateTime emailSentOn) {
        this.emailSentOn = emailSentOn;
    }
}
