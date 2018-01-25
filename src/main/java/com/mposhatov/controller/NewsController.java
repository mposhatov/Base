package com.mposhatov.controller;

import com.mposhatov.dao.NewsRepository;
import com.mposhatov.dto.News;
import com.mposhatov.entity.DbNews;
import com.mposhatov.exception.LogicException;
import com.mposhatov.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@Transactional(noRollbackFor = LogicException.class)
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @Value("${news.page}")
    private Integer defaultPage;

    @Value("${news.page.size}")
    private Integer defaultPageSize;

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<News> getNewsList(@RequestParam(value = "id", required = true) Long id) {

        final DbNews dbNews = newsRepository.findOne(id);

        return new ResponseEntity<>(EntityConverter.toNews(dbNews), HttpStatus.OK);
    }

    @RequestMapping(value = "/news-list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<News>> getNewsList(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size) {

        final List<DbNews> dbNewsList =
                newsRepository.findAll(
                        new PageRequest(
                                page != null ? page : defaultPage,
                                size != null ? size : defaultPageSize))
                        .getContent();

        final List<News> newsList = dbNewsList.stream().map(EntityConverter::toNews).collect(Collectors.toList());

        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @RequestMapping(value = "/news", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<News> addNews(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "content", required = true) String content,
            @RequestParam(value = "publishAt", required = true) Date publishAt,
            @RequestParam(value = "unpublishAt", required = true) Date unpublishAt) {

        final DbNews dbNews = newsRepository.saveAndFlush(new DbNews(name, content, publishAt, unpublishAt));

        return new ResponseEntity<>(EntityConverter.toNews(dbNews), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/news", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<News> addNews(
            @RequestParam(value = "id", required = true) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "content", required = false) String content,
            @RequestParam(value = "publishAt", required = false) Date publishAt,
            @RequestParam(value = "unpublishAt", required = false) Date unpublishAt) {

        final DbNews dbNews = newsRepository.findOne(id);

        Optional.ofNullable(name).ifPresent(dbNews::setName);
        Optional.ofNullable(content).ifPresent(dbNews::setContent);
        Optional.ofNullable(publishAt).ifPresent(dbNews::setPublishSchedule);
        Optional.ofNullable(unpublishAt).ifPresent(dbNews::setUnpublishSchedule);

        return new ResponseEntity<>(EntityConverter.toNews(dbNews), HttpStatus.OK);
    }

    @RequestMapping(value = "/news", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Void> addNews(@RequestParam(value = "id", required = true) Long id) {

        newsRepository.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
