package com.example.api.demo.Repository;

import com.example.api.demo.Entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;


public interface HumanRepository extends JpaRepository<Human,Long> {
    /*JpaRepository<Human,Long> 指定實體的類(Human)和實體 id 的類(Human裡面的id)
    當這個存儲庫的一個實例被實例化時，底層邏輯將自動到位以使用我們的Human類
    */
    List<Human> findByEnglishName(String englishName);

    List<Human> findByChineseName(String chineseName);

    //List<Human> deleteByEnglishName(String englishname);

    @Transactional
    List<Human> removeByEnglishName(String englishName);



//    @Query(value = "SELECT * FROM Human h WHERE h.EngliashName = Coco382")
//    List<Human> findSpecifyUsers(Sort sort);


}
