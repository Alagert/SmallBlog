package ru.infos.dcn.server.service;


public interface UserAuthenticationService {
    public Boolean authenticateUser(String nickName, String password);
}
