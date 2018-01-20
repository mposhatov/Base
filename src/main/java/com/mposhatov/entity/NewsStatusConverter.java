package com.mposhatov.entity;

import javax.persistence.AttributeConverter;

public class NewsStatusConverter implements AttributeConverter<NewsStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(NewsStatus newsStatus) {
        return newsStatus != null ? newsStatus.getCode() : null;
    }

    @Override
    public NewsStatus convertToEntityAttribute(Integer code) {
        return code != null ? NewsStatus.byCode(code) : null;
    }
}
