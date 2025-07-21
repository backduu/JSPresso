package JSPresso.service;

import JSPresso.DTO.UserRegisterDTO;

public interface UserService {
    UserRegisterDTO findByUserId(String id);
    void signUp(UserRegisterDTO userRegisterDTO);
}
