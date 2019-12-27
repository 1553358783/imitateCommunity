package com.example.imitatecommunity.dto;

import com.example.imitatecommunity.model.User;
import lombok.Data;

/**
 * @description:
 * @author: MGZ
 * @createDate: 2019/12/26
 */
@Data
public class QuestionDto {
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
    private User user;
}
