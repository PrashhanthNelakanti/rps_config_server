package com.schwab.rps.com.schwab.rps.controller;

import com.schwab.rps.com.schwab.rps.pojo.EmailMetaData;
import com.schwab.rps.com.schwab.rps.repo.EmailMetaDataRepo;
import com.schwab.rps.com.schwab.rps.service.EmailMetaDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
public class RpsCommonController {

    private static final String URL="/fetch/{name}/{days}";
    private static final String URL1="/sampleData";

    private static final Logger logger = LoggerFactory.getLogger(RpsCommonController.class);

    @Autowired
    EmailMetaDataService emailMetaDataService;

    @Autowired
    EmailMetaDataRepo repo;

    @GetMapping(URL)
    public ResponseEntity<?> getEmailMetaData( @PathVariable("name") String name,@PathVariable(value="days",required = false) Integer days){
        if(days==null)
            days=90;
        logger.info("Inside class RpsCommonController in meth getEmailMetaData and Params:"+days+","+name);
        List<EmailMetaData> emailMetaDataList= emailMetaDataService.getEmailMetaData(days,name);
        return ResponseEntity.status(HttpStatus.OK).body(emailMetaDataList);
    }

    @GetMapping(URL1)
    public ResponseEntity<?> sampleData(){
        EmailMetaData em= new EmailMetaData();
        em.setName("Allen");
        em.setId(0);
        LocalDateTime date=LocalDateTime.now().minusDays(12);
        em.setEmailSentOn(date);
        repo.save(em);
        return ResponseEntity.status(HttpStatus.OK).body(em);
    }

}
