package com.mposhatov.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UNPUBLISH_SCHEDULE")
public class DbUnpublishSchedule {

    @Id
    @GeneratedValue(generator = "news")
    @GenericGenerator(name = "news", strategy = "foreign", parameters = {@org.hibernate.annotations.Parameter(name = "property", value = "news")})
    @Column(name = "NEWS_ID")
    private Long newsId;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NEWS_ID", nullable = false)
    private DbNews news;

    @Column(name = "AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date at;

    protected DbUnpublishSchedule() {
    }

    public DbUnpublishSchedule(DbNews news, Date at) {
        this.news = news;
        this.at = at;
    }

    public void setAt(Date at) {
        this.at = at;
    }

    public Long getNewsId() {
        return newsId;
    }

    public DbNews getNews() {
        return news;
    }

    public Date getAt() {
        return at;
    }
}
