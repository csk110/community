package com.example.community.dto;

/**
 * @author ChenSK
 * @date 2019-07-25 - 16:19
 */
public class GitHubUserInfo {
    private String id;
    private String login;
    private String bio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
