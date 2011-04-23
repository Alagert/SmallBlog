package ru.infos.dcn.server.service.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import ru.infos.dcn.common.dto.UserDTO;
import ru.infos.dcn.common.exceptions.UserRegistrationFailedException;
import ru.infos.dcn.server.dao.UserDao;
import ru.infos.dcn.server.service.UserRegistrationService;
import ru.infos.dcn.server.service.UtilityService;

@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private UtilityService utilityService;

    private UserDao userDao;

    public UserDTO registerUser(String name, String nickName, String password) throws UserRegistrationFailedException {
         return utilityService.userToDTO(userDao.registerUser(name, nickName, password));
    }


    public void setUtilityService(UtilityService utilityService) {
        this.utilityService = utilityService;
    }


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
