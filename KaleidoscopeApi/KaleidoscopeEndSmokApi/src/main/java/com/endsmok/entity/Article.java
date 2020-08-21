package com.endsmok.entity;

import java.util.Date;

/**
 * @zz yyh
 * @time 2020-08
 */
public class Article {
    private int id;      //id
    private String title;   //标题
    private String author;  //作者
    private String intro;   //简介
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private long readNum;   //阅读数
    private long commentNum;//评论数
    private long starNum;   //点赞数
    private String content; //内容


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public long getReadNum() {
        return readNum;
    }

    public void setReadNum(long readNum) {
        this.readNum = readNum;
    }

    public long getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(long commentNum) {
        this.commentNum = commentNum;
    }

    public long getStarNum() {
        return starNum;
    }

    public void setStarNum(long starNum) {
        this.starNum = starNum;
    }
}
