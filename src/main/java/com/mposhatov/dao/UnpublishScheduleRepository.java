package com.mposhatov.dao;

import com.mposhatov.entity.DbUnpublishSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UnpublishScheduleRepository extends JpaRepository<DbUnpublishSchedule, Long> {

    @Query("select us from DbUnpublishSchedule us where us.at <= ?1 and us.news.status = com.mposhatov.entity.NewsStatus.CREATED")
    List<DbUnpublishSchedule> selectBefore(Date from);

}
