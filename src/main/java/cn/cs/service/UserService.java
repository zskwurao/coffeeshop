package cn.cs.service;

import cn.cs.pojo.User;
import cn.cs.utils.CSResult;

public interface UserService {
    CSResult insertUser(User user);

    User isUser(User user);

    CSResult isEmail(String email);

    CSResult isTele(String telephone);

    CSResult getUserList();

    CSResult deleteUser(Integer id);
}
