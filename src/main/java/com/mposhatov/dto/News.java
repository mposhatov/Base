package com.mposhatov.dto;

import com.mposhatov.entity.NewsStatus;

import java.util.Date;

public class News {
    private Long id;
    private String name;
    private String content;
    private Date publishAt;
    private Date unpublishAt;
    private NewsStatus status;

    public News(Long id, String name, String content, Date publishAt, Date unpublishAt, NewsStatus status) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.publishAt = publishAt;
        this.unpublishAt = unpublishAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public Date getPublishAt() {
        return publishAt;
    }

    public Date getUnpublishAt() {
        return unpublishAt;
    }

    public NewsStatus getStatus() {
        return status;
    }
}
