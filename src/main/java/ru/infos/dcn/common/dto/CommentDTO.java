package ru.infos.dcn.common.dto;

import java.util.Date;


public class CommentDTO {
    private String comment;
    private Long authorId;
    private Date timestamp;


    public CommentDTO(String comment, Long authorId, Date timestamp) {
        this.comment = comment;
        this.authorId = authorId;
        this.timestamp = timestamp;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
