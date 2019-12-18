package com.example.imitatecommunity.dto;

/**
 * @description:
 * @author: MGZ
 * @createDate: 2019/12/18
 */

public class User {
    private long id;
    private String name;
    private String blog;

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

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }
}
