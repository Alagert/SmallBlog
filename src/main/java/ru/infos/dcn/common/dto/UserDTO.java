package ru.infos.dcn.common.dto;

import java.util.List;


public class UserDTO {
    private String name;
    private String nickName;
    private String password;
    private final List<PostDTO> posts;


    public UserDTO(String name, String nickName, String password, List<PostDTO> posts) {
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.posts = posts;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<PostDTO> getPosts() {
        return posts;
    }
}
