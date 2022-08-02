package com.example.demo1.Dao;

import com.example.demo1.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends MongoRepository<User,String> {
    List<User> findAll();
    User findUserByJobNumber(String jobNumber);
    User save(User user);
}
