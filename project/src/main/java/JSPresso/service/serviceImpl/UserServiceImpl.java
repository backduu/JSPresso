package JSPresso.service.serviceImpl;

import JSPresso.DAO.UserDao;
import JSPresso.DTO.UserRegisterDTO;
import JSPresso.exception.LoginBackduuException;
import JSPresso.service.UserService;
import JSPresso.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public UserRegisterDTO findByUserId(String userId) {
        return userDao.findByUserId(userId);
    }

    public void signUp(UserRegisterDTO userRegisterDTO) {
        if(userDao.findByUserId(userRegisterDTO.getId()) != null){
            throw new LoginBackduuException(ErrorCode.EXIST_ID);
        }

        // 비밀번호 암호화
        userRegisterDTO.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        int a = userDao.saveUser(userRegisterDTO);
        // 유저 저장 완료되면 권한 관리 위한 삽입 실행
        if(a == 1) {
            Map<String, Object> map = new HashMap<>();
            userRegisterDTO.setAuthority(List.of("ROLE_USER"));

            userDao.saveAuthorities(userRegisterDTO);
        }
    }
}
