package com.mposhatov.entity;

import javax.persistence.*;

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

    protected DbNews() {
    }

    public DbNews(String name, String content, NewsStatus status) {
        this.name = name;
        this.content = content;
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

    public NewsStatus getStatus() {
        return status;
    }
}
