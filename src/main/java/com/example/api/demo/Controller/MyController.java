package com.example.api.demo.Controller;

import com.example.api.demo.People;
import com.example.api.demo.Printer;
import com.example.api.demo.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.catalina.mapper.Mapper;
import org.apache.coyote.Request;
import org.apache.poi.sl.usermodel.ObjectMetaData;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class MyController {
    @Autowired
    @Qualifier("hpPrinter")
    private Printer printer;

    @Autowired
    HttpServletRequest request;

    @Autowired
    ObjectMapper mapper;

    @RequestMapping("/test")
    public String test(){
        printer.print("Hello World!");
        return "Hello World" +"\n"+"This is Abow~";
    }

    @GetMapping("/parameters/{id}/{food}")
    public String parameters(@PathVariable("id") String id,@PathVariable("food") String food){
        System.out.println("id is"+id);
        System.out.println("food is "+food);
        return "parameter 1 is "+id+" parameter 2 is "+food;
    }

    @GetMapping("/parameters2")
    public String parameters2(@RequestParam Map<String,String> paramMap){
        String id=paramMap.get("id");
        String food=paramMap.get("food");
        return "id is "+id+" food is "+food;
    }

    @RequestMapping(value = "/parameters3",method = RequestMethod.GET)
    public String parameter3(@RequestParam(defaultValue = "") String id,@RequestParam(defaultValue = "") String food){
        return "id ="+id+" food = "+food;
    }

    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public String parameters5(@RequestBody List<Map<String,String>> mapList){
        //System.out.println(mapList.get(0));
        //下面這邊等於是用map去取List裡面的值
        for(Map<String,String> map:mapList){
            System.out.println(map);
            for(Map.Entry<String,String> entry: map.entrySet()){
                System.out.println("key = "+entry.getKey()+" ,value= "+entry.getValue());
            }
        }
        return null;
    }

    @RequestMapping(value = "/mapper",method = RequestMethod.POST)
    public String parameters6(@RequestBody String request) throws IOException {
        //mapper.readValue(request,People.class);
        People a=mapper.readValue(request,People.class);
        System.out.println(a.getId()+a.getName()+a.getGender());
        return a.getId()+ a.getName() +a.getGender();
    }

    @RequestMapping(value = "/entity",method = RequestMethod.POST,consumes = APPLICATION_JSON_VALUE,produces = APPLICATION_JSON_VALUE)
    public String parameters7(@RequestBody HttpEntity<String> request){
            String json=request.getBody();
            System.out.println(json);
            return json;
    }



//    @RequestMapping(value = "/servlet",method = RequestMethod.POST,consumes = APPLICATION_JSON_VALUE,produces = APPLICATION_JSON_VALUE)
//    public String parameters8(@RequestBody HttpServletRequest request) throws IOException {
//        //String json= request.getInputStream().toString();
//        String json= request.getInputStream().toString();
//        return json;
//    }


    @RequestMapping(value = "/greeting", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public String greetingJson(@RequestBody String raw) {
        System.out.println("json = " + raw);
        JSONObject jsonobject=new JSONObject(raw);
        int id= jsonobject.getInt("id");
        String name=jsonobject.getString("name");
        String male=jsonobject.getString("gender");
        return "id = "+id+",name = "+name+",gender= "+male;
        //return null;
    }

    @RequestMapping(value = "/analysis", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public void analysis(@RequestBody String raw)throws Exception{
        JSONObject j=new JSONObject(raw);
        //下面這一行是如果我們的json是key裡面又一個物件的話可以用getJSONObject去抓取他裡面物件中的全部資料
        //Object result=j.getJSONObject("Data");
        //下面這行是如果想要物件中某個特定的屬性資料的話
        Object Name=j.getJSONObject("Data").get("Name");
        Object Phone=j.getJSONObject("Data").getJSONArray("Phone").get(0);
        System.out.println("Name = "+Name.toString()+"\nPhone = "+Phone.toString());
    }

    @PostMapping(value = "/gson")
    public String gson(@RequestBody String raw) {
        Student student=new Gson().fromJson(raw,Student.class);
        //return student.getId()+student.getName()+student.getAge();
        //下面這行是java對象轉json
        String json=new Gson().toJson(student);
        return json;
    }

    @PostMapping(value = "/gson2")
    public String gson2(@RequestBody String raw) {
        //使用GSON轉換字串為實體類
        List<Student> list1=new Gson().fromJson(raw,new TypeToken<List<Student>>() {}.getType());
        for(Student student:list1){
            System.out.println("ID: "+student.getId()+" Name: "+student.getName()+" Age: "+student.getAge());
            System.out.println("----------------------------");
        }
        return null;
    }


}
