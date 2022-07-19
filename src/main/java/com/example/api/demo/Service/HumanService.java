package com.example.api.demo.Service;


import com.example.api.demo.Entity.Human;
import com.example.api.demo.Repository.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;



@Service
public class HumanService {
    @Autowired
    HumanRepository humanRepository;
    public void insert(@PathVariable String chineseName, @PathVariable String englishName){
        //這個方法是直接新增
        Human human=new Human();
        human.setChineseName(chineseName);
        human.setEnglishName(englishName);
        humanRepository.saveAndFlush(human);
        //humanRepository.findById();
        //System.out.println(humanRepository.count());
        //上面這一行是因為save()方法返回保存的實體，包括更新後的id字段
        //System.out.println("ID = "+human.getId()+" ChineseName = "+human.getChineseName()+" EnglishName = "+human.getEnglishName());
    }
}
