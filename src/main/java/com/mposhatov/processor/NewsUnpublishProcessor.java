package com.mposhatov.processor;

import com.mposhatov.dao.UnpublishScheduleRepository;
import com.mposhatov.entity.DbUnpublishSchedule;
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
public class NewsUnpublishProcessor {

    private final Logger logger = LoggerFactory.getLogger(NewsUnpublishProcessor.class);

    @Autowired
    private UnpublishScheduleRepository unpublishScheduleRepository;

    @Scheduled(fixedDelay = 1000)
    public void publish() {
        final Date now = new Date();

        final List<DbUnpublishSchedule> unpublishSchedules = unpublishScheduleRepository.selectBefore(now);

        for (DbUnpublishSchedule unpublishSchedule : unpublishSchedules) {
            try {
                unpublishSchedule.getNews().setStatus(NewsStatus.UNPUBLISHED);
                unpublishScheduleRepository.delete(unpublishSchedule);
            } catch (Exception e) {
                logger.error("Unable to unpublish news", e);
            }
        }
    }

}
