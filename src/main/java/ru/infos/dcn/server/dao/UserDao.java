package ru.infos.dcn.server.dao;


import java.util.List;

import ru.infos.dcn.common.exceptions.UserRegistrationFailedException;
import ru.infos.dcn.server.dao.entity.User;


public interface UserDao {
    public User registerUser(String name, String nickName, String password) throws UserRegistrationFailedException;
    public Boolean authorizeUser(String nickName, String password);
    public void updateUser(User user);
    public User getUserById(Long userId);
    public User getUserByNickName(String nickName);
    public List<User> getAllUsers();
}
