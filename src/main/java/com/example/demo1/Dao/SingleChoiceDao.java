package com.example.demo1.Dao;

import com.example.demo1.Entity.SingleChoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingleChoiceDao extends MongoRepository<SingleChoice,String> {
    List <SingleChoice> findAll();
    SingleChoice save(SingleChoice singleChoice);
}
