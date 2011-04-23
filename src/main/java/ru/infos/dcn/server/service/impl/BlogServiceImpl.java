package ru.infos.dcn.server.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import ru.infos.dcn.common.dto.CommentDTO;
import ru.infos.dcn.common.dto.PostDTO;
import ru.infos.dcn.common.dto.UserDTO;
import ru.infos.dcn.common.exceptions.PostNotFoundException;
import ru.infos.dcn.common.exceptions.UserNotFoundException;
import ru.infos.dcn.server.dao.PostDao;
import ru.infos.dcn.server.dao.UserDao;
import ru.infos.dcn.server.dao.entity.Post;
import ru.infos.dcn.server.dao.entity.User;
import ru.infos.dcn.server.service.BlogService;
import ru.infos.dcn.server.service.UtilityService;


@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
public class BlogServiceImpl implements BlogService {
    private UtilityService utilityService;

    private UserDao userDao;
    private PostDao postDao;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUtilityService(UtilityService utilityService) {
        this.utilityService = utilityService;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    public List<UserDTO> getAllUsers() {
        final List<User> users = userDao.getAllUsers();
        final List<UserDTO> result = new ArrayList<UserDTO>();
        for (User user : users) {
            result.add(utilityService.userToDTO(user));
        }
        return result;
    }

    @Transactional(readOnly = false)
    public void post(Long userId, PostDTO post) throws UserNotFoundException {
        final User user = userDao.getUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found!");
        } else {
            user.getPosts().add(utilityService.dtoToPost(post));
            userDao.updateUser(user);
        }
    }

    public UserDTO getUser(String nickName) throws UserNotFoundException {
        final User user = userDao.getUserByNickName(nickName);
        if (user == null) {
            throw new UserNotFoundException("User " + nickName + " not found!");
        } else {
            return utilityService.userToDTO(user);
        }
    }

    public List<PostDTO> getUserPosts(String nickName) throws UserNotFoundException {
        return getUser(nickName).getPosts();
    }

    public List<CommentDTO> getPostComments(Long postId) {
        final Post post = postDao.getPostById(postId);
        return utilityService.postToDTO(post).getComments();
    }

    @Transactional(readOnly = false)
    public void comment(Long postId, CommentDTO comment) throws PostNotFoundException {
        final Post post = postDao.getPostById(postId);
        if (post == null) {
            throw new PostNotFoundException("Post not found!");
        } else {
            post.getComments().add(utilityService.dtoToComment(comment));
            postDao.updatePost(post);
        }
    }
}
