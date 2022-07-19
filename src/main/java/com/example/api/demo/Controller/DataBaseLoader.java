package com.example.api.demo.Controller;

import com.example.api.demo.Entity.Human;
import com.example.api.demo.Repository.HumanRepository;
import com.example.api.demo.Exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@Component
public class DataBaseLoader {
    @Autowired
    HumanRepository humanRepository;


    @GetMapping("/insert/{chineseName}/{englishName}")
    public void insert(@PathVariable String chineseName,@PathVariable String englishName){
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

    @RequestMapping("/update/{id}/{chineseName}/{englishName}")
    public void updateOrInsert(@PathVariable int id,@PathVariable String chineseName,@PathVariable String englishName ) throws IdNotFoundException {
        //這邊是如果id已存在的話就更新,如果不存在就新增
        Optional<Human> optional=humanRepository.findById((long)id);
        Human human=new Human();
        if(optional.isPresent()){
            human=humanRepository.getOne((long)id);
            human.setChineseName(chineseName);
            human.setEnglishName(englishName);
            humanRepository.saveAndFlush(human);
        }else{
            throw new IdNotFoundException("無法找到對應id為"+id+"的物件!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        //long id2 = 5L;
        Optional<Human> optional = humanRepository.findById((long)id);
        if (optional.isPresent()) {
            //humanRepository.delete(optional.get());
            humanRepository.deleteById((long)id);
        }
//          List list=humanRepository.findAll();
//          List result=list.stream().filter()
    }

    @GetMapping("/humans/englishname")
    public ResponseEntity<List<Human>> findbyenglishname(@RequestParam String englishname) {
        return new ResponseEntity<List<Human>>(humanRepository.findByEnglishName(englishname), HttpStatus.OK);
    }

    @GetMapping("/humans/chinesename")
    public ResponseEntity<List<Human>> findbychinesename(@RequestParam String chinesename) {
        return new ResponseEntity<List<Human>>(humanRepository.findByChineseName(chinesename), HttpStatus.OK);
    }

    public List<Human> findbyenglishname2(String name) {
        return humanRepository.findByEnglishName(name);
    }

    public List<Human> findbychinesename2(String name) {
        return humanRepository.findByEnglishName(name);
    }



    @RequestMapping("/find/{id}")
    public Human find(@PathVariable long id){
        return humanRepository.findById(id).orElse(null);
    }

    @RequestMapping("/allData")
    public List<Human> allData(){
        return humanRepository.findAll();
        //list.forEach(e-> System.out.println(e.toString()));
    }

    @DeleteMapping("/delete2/{name}")
    public List<Human> deleteUser(@PathVariable String name){
        //List<Human> list = humanRepository.findByEnglishName(name);
        //humanRepository.deleteAll(list);
        List<Human> list=humanRepository.removeByEnglishName(name);
        return list;
        //return humanRepository.findSpecifyUsers(Sort.by("id"));
        //list.forEach(e-> System.out.println(e.toString()));
    }







}
