package com.example.demo1.controller;

import com.example.demo1.Dao.SingleChoiceDao;
import com.example.demo1.Entity.SingleChoice;
import com.example.demo1.Service.SingleChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SingleChoiceController {
    @Autowired
    SingleChoiceService singleChoiceService;

    @GetMapping(value="/GETALLSINGLECHOICES",produces = {"application/json;charset=UTF-8"})
    public List <SingleChoice> getAllSingleChoices(){
        return singleChoiceService.findAllSingleChoices();
    }

    @PostMapping(value = "/CREATESINGLECHOICE")
    public SingleChoice createSingleChoice(@RequestParam("content") String content,
                                           @RequestParam("option1") String option1,
                                           @RequestParam("option2") String option2,
                                           @RequestParam("option3") String option3,
                                           @RequestParam("option4") String option4,
                                           @RequestParam("answer") String answer){
        SingleChoice singleChoice = new SingleChoice();
        singleChoice.setContent(content);
        singleChoice.setOption1(option1);
        singleChoice.setOption2(option2);
        singleChoice.setOption3(option3);
        singleChoice.setOption4(option4);
        singleChoice.setAnswer(answer);
        singleChoiceService.insertSingleChoice(singleChoice);

        return singleChoice;
    }

    @GetMapping(value = "/hi")
    public String getHello(){
        return "测试页面";
    }

}
