package ru.infos.dcn.server.service;


import ru.infos.dcn.server.dao.PasswordDao;

public interface SecurityService {
    public void setPasswordDao(PasswordDao passwordDao);
    public boolean isPasswordStrong(String password);
    public boolean isPasswordReused(Long userId, String password);
}
