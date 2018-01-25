package com.mposhatov.dao;

import com.mposhatov.entity.DbNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<DbNews, Long> {
}
