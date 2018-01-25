package com.mposhatov.dao;

import com.mposhatov.entity.DbPublishSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PublishScheduleRepository extends JpaRepository<DbPublishSchedule, Long> {

    @Query("select ps from DbPublishSchedule ps where ps.at <= ?1 and ps.news.status = com.mposhatov.entity.NewsStatus.CREATED")
    List<DbPublishSchedule> selectBefore(Date from);

}
