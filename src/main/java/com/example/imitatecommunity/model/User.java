package com.example.imitatecommunity.model;

import lombok.Data;

/**
 * @description:
 * @author: MGZ
 * @createDate: 2019/12/19
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreated;
    private Long gmtModified;
    private String avatarUrl;
}
