package com.schwab.rps.com.schwab.rps.service;

import com.schwab.rps.com.schwab.rps.pojo.EmailMetaData;
import com.schwab.rps.com.schwab.rps.repo.EmailMetaDataRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmailMetaDataService {

    private static final Logger logger = LoggerFactory.getLogger(EmailMetaDataService.class);

    @Autowired
    EmailMetaDataRepo emailMetaDataRepo;

    public List<EmailMetaData> getEmailMetaData(Integer days, String name){
        logger.info("Inside class EmailMetaDataService meth getEmailMetaData along with Params:"+days+","+name);
        LocalDateTime date=LocalDateTime.now().minusDays(days);
        logger.info("The current_date is:"+date);
        //LocalDateTime final_date=LocalDateTime.(LocalDateTime.now().minusDays(days).getYear(),LocalDateTime.now().minusDays(days).getMonth(),LocalDateTime.now().minusDays(days).getDayOfMonth());
        //logger.info("The final_date is:"+final_date);
        return emailMetaDataRepo.findByEmailSentOnAfterAndAndName( (date),name);
    }
}
