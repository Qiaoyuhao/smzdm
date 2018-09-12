package com.cskaoyan.smzdm.domain;

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
    private String commentCount;
    private String title;
    private String likeCount;
    private Date createdDate;
    private String link;

    public News() {
    }

    public News(Integer id, String image, String commentCount, String title, String likeCount, Date createdDate) {
        this.id = id;
        this.image = image;
        this.commentCount = commentCount;
        this.title = title;
        this.likeCount = likeCount;
        this.createdDate = createdDate;
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

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
