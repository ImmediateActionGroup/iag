package com.iag.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by beishan on 2017/3/21.
 */
@Entity
@Table(name = "iag_darkroom")
public class IagDarkroom {
    private Integer id;
    private IagUser user; //被关进小黑屋的人
    private Integer darkTime; //持续时间 ,单位为天
    private Date beginTime; // 开始的时间
    private Date endTime; // 结束的时间
    private Integer status; //是否还被关在小黑屋里
    private Integer isAbort; //是否被提前释放
    private String reason; //关押的理由
    private String abortReason; //提前释放的理由
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public IagUser getUser() {
        return user;
    }

    public void setUser(IagUser user) {
        this.user = user;
    }
    @Column(name = "dark_time", nullable = false)
    public Integer getDarkTime() {
        return darkTime;
    }

    public void setDarkTime(Integer darkTime) {
        this.darkTime = darkTime;
    }
    @Column(name = "begin_time", nullable = false)
    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }
    @Column(name = "end_time")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    @Column(name = "status", nullable = false)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    @Column(name = "is_abort", nullable = false)
    public Integer getIsAbort() {
        return isAbort;
    }

    public void setIsAbort(Integer isAbort) {
        this.isAbort = isAbort;
    }
    @Column(name = "reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    @Column(name = "abort_reason")
    public String getAbortReason() {
        return abortReason;
    }

    public void setAbortReason(String abortReason) {
        this.abortReason = abortReason;
    }
}
