package com.mposhatov.processor;

import com.mposhatov.dao.PublishScheduleRepository;
import com.mposhatov.entity.DbPublishSchedule;
import com.mposhatov.entity.NewsStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class NewsPublishProcessor {

    private final Logger logger = LoggerFactory.getLogger(NewsPublishProcessor.class);

    @Autowired
    private PublishScheduleRepository publishScheduleRepository;

    @Scheduled(fixedDelay = 1000)
    public void publish() {
        final Date now = new Date();

        final List<DbPublishSchedule> publishSchedules = publishScheduleRepository.selectBefore(now);

        for (DbPublishSchedule publishSchedule : publishSchedules) {
            try {
                publishSchedule.getNews().setStatus(NewsStatus.PUBLISHED);
                publishScheduleRepository.delete(publishSchedule);
            } catch (Exception e) {
                logger.error("Unable to publish news", e);
            }
        }
    }

}
