package ru.infos.dcn.server.service;


import ru.infos.dcn.common.dto.CommentDTO;
import ru.infos.dcn.common.dto.PostDTO;
import ru.infos.dcn.common.dto.UserDTO;
import ru.infos.dcn.server.dao.entity.Comment;
import ru.infos.dcn.server.dao.entity.Post;
import ru.infos.dcn.server.dao.entity.User;

public interface UtilityService {
    public UserDTO userToDTO(User user);
    public PostDTO postToDTO(Post post);
    public Post dtoToPost(PostDTO post);
    public CommentDTO commentToDTO(Comment comment);
    public Comment dtoToComment(CommentDTO comment);
}
