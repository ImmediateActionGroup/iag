package com.iag.validate;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by beishan on 2017/3/22.
 */
public class ValidatePosts {
    @NotBlank(message = "标题不能为空")
    private String title;
    @NotBlank(message = "内容能为空")
    private String content;
    @NotNull(message = "编辑器类型不能为空")
    private Integer editType;
    @NotNull(message = "板块id不能为空")
    private Integer bid;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getEditType() {
        return editType;
    }

    public void setEditType(Integer editType) {
        this.editType = editType;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }
}
