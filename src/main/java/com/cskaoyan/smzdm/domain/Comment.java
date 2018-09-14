package com.cskaoyan.smzdm.domain;

import java.util.Date;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 17:42 2018/9/14
 * @Modified By:
 */
public class Comment {

    private Integer id;
    private String content;
    private Date createdDate;
    private Integer uid;
    private Integer nid;

    public Comment() {
    }

    public Comment(String content, Date createdDate, Integer uid, Integer nid) {
        this.content = content;
        this.createdDate = createdDate;
        this.uid = uid;
        this.nid = nid;
    }

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }
}
