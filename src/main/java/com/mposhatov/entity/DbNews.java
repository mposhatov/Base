package com.mposhatov.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NEWS")
public class DbNews {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", length = 200, nullable = false)
    private String name;

    @Column(name = "CONTENT", length = 32700, nullable = false)
    private String content;

    @Column(name = "STATUS", nullable = false)
    @Convert(converter = NewsStatusConverter.class)
    private NewsStatus status;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "news")
    private DbPublishSchedule publishSchedule;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "news")
    private DbUnpublishSchedule unpublishSchedule;

    protected DbNews() {
    }

    public DbNews(String name, String content, Date publishAt, Date unpublishAt) {
        this.name = name;
        this.content = content;
        this.status = NewsStatus.CREATED;
        this.publishSchedule = new DbPublishSchedule(this, publishAt);
        this.unpublishSchedule = new DbUnpublishSchedule(this, unpublishAt);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStatus(NewsStatus status) {
        this.status = status;
    }

    public void setPublishSchedule(Date at) {
        this.publishSchedule.setAt(at);
    }

    public void setUnpublishSchedule(Date at) {
        this.unpublishSchedule.setAt(at);
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

    public NewsStatus getStatus() {
        return status;
    }

    public DbPublishSchedule getPublishSchedule() {
        return publishSchedule;
    }

    public DbUnpublishSchedule getUnpublishSchedule() {
        return unpublishSchedule;
    }
}
