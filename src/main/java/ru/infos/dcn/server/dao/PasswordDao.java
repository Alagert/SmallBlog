package ru.infos.dcn.server.dao;

public interface PasswordDao {
    public boolean isPasswordReused(Long userId, String password);
}
