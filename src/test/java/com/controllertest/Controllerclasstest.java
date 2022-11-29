package com.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.controller.Controllerclass;
import com.model.Modelclass;
import com.service.Serviceclass;

@SpringBootTest
public class Controllerclasstest {
	@InjectMocks
	Controllerclass controllerclass;
	
	@Mock
	Serviceclass serviceclass;
	
	public Modelclass jas()
	{
		Modelclass s=new Modelclass();
		s.setId(10);
		s.setName("Jaswanth");
		s.setBranch("BCA");
		return s;
	}
	
	
	
	
	@Test
	void insert()
	{
		Mockito.when(serviceclass.insertdata(Mockito.any(Modelclass.class))).thenReturn("inserted");
		String response=controllerclass.insert(jas());
		assertEquals("inserted",response);
	}
	
	
	public List<Map<String, Object>> jas1()
	{
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		return list;
	}
	
	@Test
	void fetch()
	{
		Mockito.when(serviceclass.readdata(Mockito.any(Modelclass.class))).thenReturn(jas1());
		List<Map<String, Object>> l=controllerclass.sub(jas());
		assertEquals(jas1(),l);
	}
	
	@Test
	void update()
	{
		Mockito.when(serviceclass.change(Mockito.any(Modelclass.class))).thenReturn("Updated");
		String response=controllerclass.change(jas());
		assertEquals("Updated",response);
	}
	
	
	@Test
	void delete()
	{
		Mockito.when(serviceclass.delete(Mockito.any(Modelclass.class))).thenReturn("Deleted");
		String response=controllerclass.delete(jas());
		assertEquals("Deleted",response);
	}
}
