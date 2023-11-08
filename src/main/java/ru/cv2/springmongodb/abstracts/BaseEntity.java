package ru.cv2.springmongodb.abstracts;

import org.springframework.data.annotation.Id;

import javax.annotation.processing.Generated;

public abstract class BaseEntity {
    @Id
    protected String id;
}
