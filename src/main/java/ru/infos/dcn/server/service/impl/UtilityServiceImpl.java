package ru.infos.dcn.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import ru.infos.dcn.common.dto.CommentDTO;
import ru.infos.dcn.common.dto.PostDTO;
import ru.infos.dcn.common.dto.UserDTO;
import ru.infos.dcn.server.dao.entity.Comment;
import ru.infos.dcn.server.dao.entity.Post;
import ru.infos.dcn.server.dao.entity.User;
import ru.infos.dcn.server.service.UtilityService;

public class UtilityServiceImpl implements UtilityService {

    public UserDTO userToDTO(User user) {
        final List<PostDTO> posts = new ArrayList<PostDTO>();
        for(Post post : user.getPosts()) {
            posts.add(postToDTO(post));
        }
        return new UserDTO(user.getName(), user.getNickName(), user.getPassword(), posts);
    }


    public PostDTO postToDTO(Post post) {
        final List<CommentDTO> comments = new ArrayList<CommentDTO>();
        for (Comment comment : post.getComments()) {
            comments.add(commentToDTO( comment));
        }
        return new PostDTO(post.getPostId(), post.getSubject(), post.getText(), post.getTimestamp(), comments);
    }


    public Post dtoToPost(PostDTO post) {
        final Post newPost = new Post();
        post.setSubject(post.getSubject());
        post.setText(post.getText());
        post.setTimestamp(post.getTimestamp());
        return newPost;
    }

    public CommentDTO commentToDTO(Comment comment) {
        return new CommentDTO(comment.getComment(), comment.getAuthorId(), comment.getTimestamp());
    }


    public Comment dtoToComment(CommentDTO comment) {
        final Comment newComment = new Comment();
        comment.setAuthorId(comment.getAuthorId());
        comment.setComment(comment.getComment());
        comment.setTimestamp(comment.getTimestamp());
        return newComment; 
    }
}
