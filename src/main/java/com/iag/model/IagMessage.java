package com.iag.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xueshan.wei on 12/13/2016.
 */
@Entity
@Table(name = "iag_message")
public class IagMessage {
    private Integer id; //主键
    private String content; //信息内容
    private IagUser sender; // 发送人
    private IagUser resiver; // 接收人
    private Date sendTime; // 发送时间
    private Integer isRead; // 是否已读
    private Integer isReply; // 是否已回复
    private Integer isDelete; // 是否删除
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "content", nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    public IagUser getSender() {
        return sender;
    }

    public void setSender(IagUser sender) {
        this.sender = sender;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resiver_id")
    public IagUser getResiver() {
        return resiver;
    }

    public void setResiver(IagUser resiver) {
        this.resiver = resiver;
    }

    @Column(name = "send_time", nullable = false)
    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
    @Column(name = "is_read", nullable = false)
    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }
    @Column(name = "is_reply", nullable = false)
    public Integer getIsReply() {
        return isReply;
    }

    public void setIsReply(Integer isReply) {
        this.isReply = isReply;
    }

    @Column(name = "is_delete", nullable = false)
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
