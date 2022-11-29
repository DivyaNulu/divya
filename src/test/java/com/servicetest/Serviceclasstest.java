package com.servicetest;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Modelclass;
import com.service.Serviceclass;



@SpringBootTest
public class Serviceclasstest {
@InjectMocks
Serviceclass springservice;
@Mock
JdbcTemplate jdbctemplate;
public Modelclass springmodeldata() {
	Modelclass springmodel=new Modelclass();
	springmodel.setId(501);
	springmodel.setName("saranya");
	springmodel.setBranch("CSE");
	
	return springmodel;
}
@Test
public void insertdatatest()
{
	Mockito.when(jdbctemplate.update(Mockito.anyString(),Mockito.anyInt(),Mockito.anyString(),Mockito.anyString())).thenReturn(1);
  String response=springservice.insertdata(springmodeldata());
  assertEquals("inserted",response);
}
@Test
public void insertdatatestCase()
{
	Mockito.when(jdbctemplate.update(Mockito.anyString(),Mockito.anyInt(),Mockito.anyString(),Mockito.anyString())).thenReturn(0);
  String response=springservice.insertdata(springmodeldata());
  assertEquals("not inserted",response);
}
//@Test
//public void insertdataException()
//{
//	Mockito.when(jdbctemplate.update(Mockito.anyString(),Mockito.anyInt(),Mockito.anyString(),Mockito.anyString())).thenThrow(NullPointerException.class);
//  Map<String, String> response=springservice.insertdata(springmodeldata());
//  assertTrue(response.isEmpty());
//}
@Test
public void readdatatest()
{
	Mockito.when(jdbctemplate.queryForList(Mockito.anyString())).thenReturn(springmodeldata1());
  List<Map<String, Object>> response=springservice.readdata(springmodeldata());
  assertEquals(springmodeldata1(),response);
}
public List<Map<String, Object>> springmodeldata1() {
	List<Map<String, Object>> l=new ArrayList<>();
	return l;
}
@Test
public void changetest()
{
	Mockito.when(jdbctemplate.update(Mockito.anyString(),Mockito.any(),Mockito.anyString(),Mockito.any())).thenReturn(1);
  String response=springservice.change(springmodeldata());
  assertEquals("updated",response);
}
@Test
public void changetestCase()
{
	Mockito.when(jdbctemplate.update(Mockito.anyString(),Mockito.any(),Mockito.anyString(),Mockito.any())).thenReturn(0);
  String response=springservice.change(springmodeldata());
  assertEquals("not updated",response);
}
@Test
public void deletetest()
{
	Mockito.when(jdbctemplate.update(Mockito.anyString(),Mockito.anyInt())).thenReturn(1);
  String response=springservice.delete(springmodeldata());
  assertEquals("deleted",response);
}
@Test
public void deletetestCase()
{
	Mockito.when(jdbctemplate.update(Mockito.anyString(),Mockito.anyInt())).thenReturn(0);
  String response=springservice.delete(springmodeldata());
  assertEquals("not deleted",response);
}
}
