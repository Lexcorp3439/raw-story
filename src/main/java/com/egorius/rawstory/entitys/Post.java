package com.egorius.rawstory.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import org.hibernate.annotations.Type;


@SuppressWarnings("unused")
@Entity
@Table(name = "blog")
public class Post extends BaseEntity {

    @Column
    private String name;

    @Column
    private String date;

    @Column
    private String description;

    @Type( type = "string-array" )
    @Column(
            name = "images",
            columnDefinition = "text[]"
    )
    private String[] paths;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getPaths() {
        return paths;
    }

    public void setPaths(String[] paths) {
        this.paths = paths;
    }
}
