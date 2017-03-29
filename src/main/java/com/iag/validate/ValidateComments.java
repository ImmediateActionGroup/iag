package com.iag.validate;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by beishan on 2017/3/25.
 */
public class ValidateComments {

    @NotBlank(message = "回复内容不能为空")
    private String content;
    @NotNull(message = "帖子id不能为空")
    private Integer pid;
    @NotNull(message = "父节点id不能为空")
    private Integer parentId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
