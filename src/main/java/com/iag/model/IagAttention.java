package com.iag.model;

import javax.persistence.*;

/**
 * Created by xueshan.wei on 12/13/2016.
 */
@Entity
@Table(name = "iag_user_attention")
public class IagAttention {
    private Integer id;
    private IagUser attention; //关注人
    private IagUser attentioned; //被关注人
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attention_id", nullable = false)
    public IagUser getAttention() {
        return attention;
    }

    public void setAttention(IagUser attention) {
        this.attention = attention;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attentioned_id", nullable = false)
    public IagUser getAttentioned() {
        return attentioned;
    }

    public void setAttentioned(IagUser attentioned) {
        this.attentioned = attentioned;
    }
}
