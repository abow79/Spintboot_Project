package com.example.api.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class FoodController {
    private final List<Food> foodDB=new ArrayList<>();
    //Controller 被建立後，自動執行該方法，新增預設的產品資料
    @PostConstruct
    private void initDB() {
        foodDB.add(new Food("1","Pork Dumplings",80));
        foodDB.add(new Food("2","Beef Noodles",130));
        foodDB.add(new Food("3","Seafood Spaghetti",110));
        foodDB.add(new Food("4","Roast Chicken",200));
    }


    @GetMapping("/Food/{id}")
    public ResponseEntity<Food> getFood(@PathVariable("id") String id){
        Optional<Food> Foodop=foodDB.stream().filter(food -> food.getId().equals(id)).findFirst();
        if(Foodop.isPresent()){
            Food food=Foodop.get();
            return ResponseEntity.ok().body(food);
        }else {
            //return new ResponseEntity("Content Not Found", HttpStatus.NOT_FOUND);
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Content Not Found!");
            return ResponseEntity.notFound().build();
        }

        /*
        Food food =new Food();
        food.setId(id);
        food.setName("Ham Egg Fried Rice");
        food.setPrice(90);
        return ResponseEntity.ok().body(food);
         */
    }
    @PostMapping("/Food")
    public ResponseEntity<Food> createFood(@RequestBody Food request){
        boolean isduplicated=foodDB.stream().anyMatch(food -> food.getId().equals(request.getId()));
        if(isduplicated){
            //這邊就是語法正確Server可以理解但是無法處理
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }








        return ResponseEntity.ok().build();
    }

}
