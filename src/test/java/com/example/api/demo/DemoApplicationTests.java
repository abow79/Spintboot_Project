package com.example.api.demo;

import com.example.api.demo.Controller.DataBaseLoader;
import com.example.api.demo.Entity.Human;
import com.example.api.demo.Repository.HumanRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class DemoApplicationTests {

	@Mock
	List<String> mocklist;

	@Autowired
	DataBaseLoader dataBaseLoader;

	@Mock
	HumanRepository mockhumanRepository;

	public List<Human> getHuman(){
//		Human human =new Human();
//		human.setChineseName("哈哈");
//		human.setEnglishName("Test");
		//mockhumanRepository.saveAndFlush(any(com.example.api.demo.Entity.Human.class));
		List<Human> human=mockhumanRepository.findByEnglishName("HaHa");
		return human;
	}



	@Test
	public void whenMockAnnotation() {
		//驗證與確切參數的交互
		//如果下面的方法僅調用過一次則為通過
		mocklist.add("one");
		//下面這個和verify(mocklist,times(1))是一樣的
		Mockito.verify(mocklist).add("one");
		assertEquals(0, mocklist.size());
		when(mocklist.size()).thenReturn(100);
		assertEquals(100, mocklist.size());
	}

	@BeforeAll
	public static void Start() {
		System.out.println("開始正式測試!");
	}

	@Test
	void Insert_Test(){
		dataBaseLoader.insert("哈哈","HaHa");
		when(mockhumanRepository.findByEnglishName("HaHa")).thenReturn(getHuman());
		//when(mockhumanRepository.saveAndFlush(any(Human.class))).thenReturn(human);
		//when(dataBaseLoader.insert("哈哈","HaHa")).thenReturn(getHuman());
		assertEquals(dataBaseLoader.findbyenglishname2("HaHa"),getHuman());
	}

	@Test
	void updateOrInsert_Test(){

	}












}
