package JSPresso.DAO;

import JSPresso.DTO.UserRegisterDTO;
import org.apache.ibatis.annotations.Mapper;

public interface UserDao {
    UserRegisterDTO findByUserId(String id);
    int saveUser(UserRegisterDTO user);
    int saveAuthorities(UserRegisterDTO user);
}
