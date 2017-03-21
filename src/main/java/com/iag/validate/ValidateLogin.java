package com.iag.validate;

import org.hibernate.validator.constraints.NotBlank;

/**
 * user login validate class
 * Created by beishan on 2017/3/19.
 */
public class ValidateLogin {
    @NotBlank(message = "用户登录账户不能为空")
    private String account;
    @NotBlank(message = "用户登录密码不能为空")
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
