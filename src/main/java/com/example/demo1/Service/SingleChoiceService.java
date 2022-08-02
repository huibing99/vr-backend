package com.example.demo1.Service;


import com.example.demo1.Dao.SingleChoiceDao;
import com.example.demo1.Entity.SingleChoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


@Transactional
@Service
public class SingleChoiceService {

    @Resource
    @Autowired
    private SingleChoiceDao singleChoiceDao;

    public SingleChoice insertSingleChoice(SingleChoice singleChoice){
        return singleChoiceDao.save(singleChoice);
    }

    public List<SingleChoice> findAllSingleChoices(){
        List<SingleChoice> allSingleChoices = singleChoiceDao.findAll();
        for (SingleChoice singleChoice:allSingleChoices)
            System.out.println(singleChoice);
        return allSingleChoices;

    }

    public void contextLoads(){
//        SingleChoice s = new SingleChoice("题目3","AAA","BBB","CCC","DDD","答案是答案");
//        singleChoiceDao.save(s);
//
//        Example<SingleChoice> example = Example.of(s);
//        Optional<SingleChoice> one = singleChoiceDao.findOne(example);
//        System.out.println(one);

        List<SingleChoice> singleChoiceList = singleChoiceDao.findAll();
        for(SingleChoice singleChoice : singleChoiceList){
            System.out.println(singleChoice);
        }
    }

}
