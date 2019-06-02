package cn.cs.service.Impl;

import cn.cs.mapper.UserMapper;
import cn.cs.pojo.User;
import cn.cs.service.UserService;
import cn.cs.utils.CSResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public CSResult insertUser(User user) {
        int count = userMapper.insertUser(user);
        System.out.println(count);
        if(count>0){
            return CSResult.ok();
        }else{
            return CSResult.build(0,"插入失败");
        }
    }

    @Override
    public User isUser(User user) {
        User u = userMapper.isUser(user);
        return u;
    }

    @Override
    public CSResult isEmail(String email) {
        int count = userMapper.isEmail(email);
        //System.out.println(count + " x x " +email);
        if(count==0){
            return CSResult.ok();
        }
        else {
            return CSResult.build(0,"邮箱已被注册");
        }
    }

    @Override
    public CSResult isTele(String telephone) {
        int count = userMapper.isTele(telephone);
       // System.out.println(count + " x x " +email);
        if(count==0){
            return CSResult.ok();
        }
        else {
            return CSResult.build(0,"手机号已被注册");
        }
    }

    @Override
    public CSResult getUserList() {
        List<User> list = userMapper.getUserList();
        if(list!=null){
            return CSResult.ok(list);
        }else {
            return CSResult.build(0,"查询出错");
        }
    }

    @Override
    public CSResult deleteUser(Integer id) {
        userMapper.deleteUser(id);
        return CSResult.ok();
    }
}
