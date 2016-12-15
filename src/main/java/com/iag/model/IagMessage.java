package com.iag.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xueshan.wei on 12/13/2016.
 */
@Entity
@Table(name = "iag_message")
public class IagMessage {
    private Integer id;
    private String content;
    private IagUser sender;
    private IagUser resiver;
    private Date sendTime;
    private Integer isRead;
    private Integer isReply;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public IagUser getSender() {
        return sender;
    }

    public void setSender(IagUser sender) {
        this.sender = sender;
    }

    public IagUser getResiver() {
        return resiver;
    }

    public void setResiver(IagUser resiver) {
        this.resiver = resiver;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Integer getIsReply() {
        return isReply;
    }

    public void setIsReply(Integer isReply) {
        this.isReply = isReply;
    }
}
