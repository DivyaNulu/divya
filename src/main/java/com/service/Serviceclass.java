package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.model.Modelclass;

@Service
public class Serviceclass {
	@Autowired
	JdbcTemplate jdbctemplate;

	public String insertdata(Modelclass springpojo) {
		int id = springpojo.getId();
		String name = springpojo.getName();
		String branch = springpojo.getBranch();
		String Query = "insert into studentdetails values(?,?,?)";
		int r = jdbctemplate.update(Query, id, name, branch);

		if (r > 0) {
			return "inserted";
		} else {
			return "not inserted";
		}
	}

	public List<Map<String, Object>> readdata(Modelclass springpojo) {
		String Query = "select * from studentdetails";
		List<Map<String, Object>> result = jdbctemplate.queryForList(Query);
		return result;
	}

	public String change(Modelclass springpojo) {
		String Query = "update studentdetails set name=?,branch=? where id=?";
		int result = jdbctemplate.update(Query, springpojo.getName(), springpojo.getBranch(), springpojo.getId());
		if (result > 0) {
			return "updated";
		} else {
			return "not updated";
		}
	}

	public String delete(Modelclass springpojo) {
		String Query = "delete from studentdetails where id=?";
		int result = jdbctemplate.update(Query, springpojo.getId());
		if (result > 0) {
			return "deleted";
		} else {
			return "not deleted";
		}
	}

}
