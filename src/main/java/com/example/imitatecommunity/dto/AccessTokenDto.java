package com.example.imitatecommunity.dto;

import lombok.Data;

/**
 * @description:
 * @author: MGZ
 * @createDate: 2019/12/18
 */
@Data
public class AccessTokenDto {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
