package ru.infos.dcn.server.service.impl;


import ru.infos.dcn.server.dao.PasswordDao;
import ru.infos.dcn.server.service.SecurityService;

public class SecurityServiceImpl implements SecurityService {

    private PasswordDao passwordDao;

    public void setPasswordDao(PasswordDao passwordDao) {
        this.passwordDao = passwordDao;
    }

    public boolean isPasswordStrong(String password) {
        return !(password == null || password.length() < 8) && (password.matches(".*[0-9].*")
                || password.matches(".*[A-Z].*")
                || password.matches(".*[a-z].*"));
    }

    public boolean isPasswordReused(Long userId, String password) {
        return passwordDao.isPasswordReused(userId, password);
    }
}


