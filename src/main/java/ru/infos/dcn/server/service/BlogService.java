package ru.infos.dcn.server.service;

import java.util.List;

import ru.infos.dcn.common.dto.CommentDTO;
import ru.infos.dcn.common.dto.PostDTO;
import ru.infos.dcn.common.dto.UserDTO;
import ru.infos.dcn.common.exceptions.PostNotFoundException;
import ru.infos.dcn.common.exceptions.UserNotFoundException;


public interface BlogService {
    public List<UserDTO> getAllUsers();
    public UserDTO getUser(String nickName) throws UserNotFoundException;

    public List<PostDTO> getUserPosts(String nickName) throws UserNotFoundException;
    public List<CommentDTO> getPostComments(Long postId);

    public void post(Long userId, PostDTO post) throws UserNotFoundException;
    public void comment(Long postId, CommentDTO comment) throws PostNotFoundException;
}
