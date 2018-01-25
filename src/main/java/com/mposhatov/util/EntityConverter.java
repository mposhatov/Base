package com.mposhatov.util;

import com.mposhatov.dto.News;
import com.mposhatov.entity.DbNews;
import org.springframework.stereotype.Service;

@Service
public class EntityConverter {

    public static News toNews(DbNews dbNews) {
        return new News(
                dbNews.getId(),
                dbNews.getName(),
                dbNews.getContent(),
                dbNews.getPublishSchedule().getAt(),
                dbNews.getUnpublishSchedule().getAt(),
                dbNews.getStatus());
    }

}
