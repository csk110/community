package com.example.community.util;

import cn.hutool.json.JSONUtil;
import com.example.community.dto.AccessDTO;
import com.example.community.dto.GitHubUserInfo;
import okhttp3.*;

import java.io.IOException;

/**
 * @author ChenSK
 * @date 2019-07-23 - 16:15
 */
public class GitHubUtil {

    public static String getAccessToken(AccessDTO accessDTO) {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, JSONUtil.toJsonStr(accessDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static GitHubUserInfo getUserInfo(String token) {
        OkHttpClient client = new OkHttpClient();


        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+token)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            String string = response.body().string();
            return JSONUtil.toBean(string, GitHubUserInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
