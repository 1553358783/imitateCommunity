package com.example.imitatecommunity.model;

import lombok.Data;

/**
 * @description:
 * @author: MGZ
 * @createDate: 2019/12/24
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreated;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
}
