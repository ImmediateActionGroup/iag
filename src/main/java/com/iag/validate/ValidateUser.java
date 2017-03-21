package com.iag.validate;

import com.iag.validate.group.UserAdd;
import com.iag.validate.group.UserRegister;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by xueshan.wei on 3/21/2017.
 */
public class ValidateUser {
    @Email(message = "邮箱格式不对", groups = {UserAdd.class, UserRegister.class})
    @NotBlank(message = "邮箱不能为空", groups = {UserAdd.class, UserRegister.class})
    private String email;

    @NotBlank(message = "密码不能为空", groups = {UserAdd.class, UserRegister.class})
    @Length(min = 6, max = 30, message = "密码长度必须在6~30之间", groups = {UserAdd.class, UserRegister.class})
    private String password;

    @NotNull(message = "用户角色值不能为空", groups = {UserAdd.class})
    private Integer roleValue;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(Integer roleValue) {
        this.roleValue = roleValue;
    }
}
