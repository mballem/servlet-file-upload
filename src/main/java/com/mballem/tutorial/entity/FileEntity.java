package com.mballem.tutorial.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Marcio Ballem on 15/04/2014.
 */
@Entity
@Table(name = "FILE_UPLOAD")
public class FileEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "FILE_NAME", unique = true)
    private String name;
    @Column(name = "FILE_YEAR")
    private String year;
    @Column(name = "FILE_MONTH")
    private String month;
    @Column(name = "FILE_CONTENT_TYPE")
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
