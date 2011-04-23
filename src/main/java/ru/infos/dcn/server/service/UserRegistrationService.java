package ru.infos.dcn.server.service;


import ru.infos.dcn.common.dto.UserDTO;
import ru.infos.dcn.common.exceptions.UserRegistrationFailedException;

public interface UserRegistrationService {
    public UserDTO registerUser(String name, String nickName, String password) throws UserRegistrationFailedException;
}
