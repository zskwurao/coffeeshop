package cn.cs.mapper;

import cn.cs.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zhangsk
 * @create: 2018-12-05 13:06
 **/
@Repository
public interface UserMapper {
    public int insertUser(User user);

    User isUser(User user);

    int isEmail(String email);

    int isTele(String telephone);

    List<User> getUserList();

    void deleteUser(Integer id);
}
