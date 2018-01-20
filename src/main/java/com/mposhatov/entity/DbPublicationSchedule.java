package com.mposhatov.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PUBLICATION_SCHEDULE")
public class DbPublicationSchedule {

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

    protected DbPublicationSchedule() {
    }

    public DbPublicationSchedule(DbNews news, Date at) {
        this.news = news;
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
