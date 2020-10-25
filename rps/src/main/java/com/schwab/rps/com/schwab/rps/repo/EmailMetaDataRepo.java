package com.schwab.rps.com.schwab.rps.repo;

import com.schwab.rps.com.schwab.rps.pojo.EmailMetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EmailMetaDataRepo  extends JpaRepository<EmailMetaData,Integer> {

    List<EmailMetaData> findByEmailSentOnAfterAndAndName(LocalDateTime date, String name);
}
