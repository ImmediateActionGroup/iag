package com.iag.api.model.user;

import com.google.gson.annotations.Expose;
import com.iag.model.IagUser;

/**
 * Created by beishan on 2017/4/8.
 */
public class ApiUser {
    @Expose
    private Integer id;
    @Expose
    private String username;
    @Expose
    private String nickname;
    @Expose
    private String email;
    @Expose
    private long lastLoginTime;
    @Expose
    private String avatars;

    public ApiUser() {
    }

    public ApiUser(IagUser user){
        if(user != null){
            id = user.getId();
            username = user.getUsername();
            nickname = user.getNickname();
            email = user.getEmail();
            if(user.getLastLoginTime() != null){
                lastLoginTime = user.getLastLoginTime().getTime();
            }
            avatars = user.getAvatars();
        }
    }

    public String getAvatars() {
        return avatars;
    }

    public void setAvatars(String avatars) {
        this.avatars = avatars;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
