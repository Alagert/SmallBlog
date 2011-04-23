package ru.infos.dcn.server.service.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import ru.infos.dcn.server.dao.UserDao;
import ru.infos.dcn.server.service.UserAuthenticationService;


@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
public class UserAuthenticationServiceImpl implements UserAuthenticationService {
    private UserDao userDao;

    public Boolean authenticateUser(String nickName, String password) {
        return userDao.authorizeUser(nickName, password);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
