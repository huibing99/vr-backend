package com.example.demo1.Service;

import com.example.demo1.Dao.UserDao;
import com.example.demo1.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class UserService {
    @Resource
    @Autowired
    UserDao userDao;

    public User insertUser(User user){
        return userDao.save(user);
    }

    public List<User> findAllUsers(){
        List<User> allUsers = userDao.findAll();
        for(User user:allUsers){
            System.out.println(user);
        }
        return allUsers;
    }

    public User findByJobNumber(String jobNumber){
        return userDao.findUserByJobNumber(jobNumber);
    }
}
