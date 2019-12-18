package com.example.imitatecommunity.provider;

import com.alibaba.fastjson.JSON;
import com.example.imitatecommunity.dto.AccessTokenDto;

import com.example.imitatecommunity.dto.User;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @description:
 * @author: MGZ
 * @createDate: 2019/12/18
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDto accessTokenDto){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDto));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String accessToken = string.split("&")[0].split("=")[1];
            return accessToken;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public User getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            User user = JSON.parseObject(string, User.class);
            System.out.println(user.getName());
            return user;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
