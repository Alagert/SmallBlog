package ru.infos.dcn.server.dao.entity;
// Generated 08.11.2009 17:20:23 by Hibernate Tools 3.2.0.b11


import java.util.HashSet;
import java.util.Set;


/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {


    private Long userId;
    private Integer version;
    private String name;
    private String nickName;
    private String password;
    private Set<Post> posts = new HashSet<Post>(0);

    public User() {
    }


    public User(String name, String nickName, String password) {
        this.name = name;
        this.nickName = nickName;
        this.password = password;
    }

    public User(String name, String nickName, String password, Set<Post> posts) {
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.posts = posts;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Post> getPosts() {
        return this.posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }


}


