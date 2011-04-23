package ru.infos.dcn.common.dto;

import java.util.Date;
import java.util.List;


public class PostDTO {
    private Long postId;
    private String subject;
    private String text;
    private Date timestamp;
    private final List<CommentDTO> comments;


    public PostDTO(Long postId, String subject, String text, Date timestamp, List<CommentDTO> comments) {
        this.postId = postId;
        this.subject = subject;
        this.text = text;
        this.timestamp = timestamp;
        this.comments = comments;
    }


    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public List<CommentDTO> getComments() {
        return comments;
    }
}
