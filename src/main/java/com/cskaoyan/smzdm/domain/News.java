package com.cskaoyan.smzdm.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 12:02 2018/9/12
 * @Modified By:
 */
public class News {

    private Integer id;
    private String image;
    private Integer commentCount=0;
    private String title;
    private Integer likeCount=0;
    private Date createdDate;
    private String link;
    private Integer uid;

    public News() {
    }

    public News(Integer id, String image, Integer commentCount, String title, Integer likeCount, Date createdDate) {
        this.id = id;
        this.image = image;
        this.commentCount = commentCount;
        this.title = title;
        this.likeCount = likeCount;
        this.createdDate = createdDate;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
