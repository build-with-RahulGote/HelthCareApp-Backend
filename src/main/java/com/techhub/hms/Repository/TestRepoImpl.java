package com.techhub.hms.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.techhub.hms.Models.Patients;
import com.techhub.hms.Models.Tests;

@Repository
public class TestRepoImpl implements TestRepo {
	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public boolean isTestAdded(Tests tests) {
		int value=jdbctemplate.update("insert into tests values('0',?,?,?,?)", new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,tests.getTest_name());
				ps.setDouble(2,tests.getFess());
				ps.setString(3,tests.getDescription());
				ps.setString(4,tests.getCategory());
				
			}
			
		});
		return value>0?true:false;
	}

	@Override
	public List<Tests> getTests() {
		List<Tests>list=jdbctemplate.query("select * from tests",new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Tests tests=new Tests();
				tests.setTest_id(rs.getInt("test_id"));
				tests.setTest_name(rs.getString("test_name"));
				tests.setFess(rs.getDouble("fees"));
				tests.setDescription(rs.getString("description"));
				tests.setCategory(rs.getString("category"));
				return tests;
			}});
		return list;
	}
	
	

}
