package com.egorius.rawstory.entitys;

import javax.persistence.*;

import org.hibernate.annotations.Type;


@SuppressWarnings("unused")
@Entity
@Table(name = "blog")
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String date;

    @Column(
            name = "description",
            columnDefinition = "text"
    )
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
