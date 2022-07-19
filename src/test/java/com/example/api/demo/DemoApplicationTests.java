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
//		human.setChineseName("����");
//		human.setEnglishName("Test");
		//mockhumanRepository.saveAndFlush(any(com.example.api.demo.Entity.Human.class));
		List<Human> human=mockhumanRepository.findByEnglishName("HaHa");
		return human;
	}



	@Test
	public void whenMockAnnotation() {
		//���һP�T���Ѽƪ��椬
		//�p�G�U������k�ȽեιL�@���h���q�L
		mocklist.add("one");
		//�U���o�өMverify(mocklist,times(1))�O�@�˪�
		Mockito.verify(mocklist).add("one");
		assertEquals(0, mocklist.size());
		when(mocklist.size()).thenReturn(100);
		assertEquals(100, mocklist.size());
	}

	@BeforeAll
	public static void Start() {
		System.out.println("�}�l��������!");
	}

	@Test
	void Insert_Test(){
		dataBaseLoader.insert("����","HaHa");
		when(mockhumanRepository.findByEnglishName("HaHa")).thenReturn(getHuman());
		//when(mockhumanRepository.saveAndFlush(any(Human.class))).thenReturn(human);
		//when(dataBaseLoader.insert("����","HaHa")).thenReturn(getHuman());
		assertEquals(dataBaseLoader.findbyenglishname2("HaHa"),getHuman());
	}

	@Test
	void updateOrInsert_Test(){

	}












}
