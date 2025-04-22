package com.techhub.hms.Repository;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.techhub.hms.Models.Checkup;
@Repository
public class CheckupRepoImpl implements CheckupRepo {
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public boolean isAddPrecription(Checkup checkup) {
		int value=jdbctemplate.update("insert into checkup values('0',?,?,?,?)",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1,checkup.getAppointment_id());
				ps.setString(2,checkup.getSymptoms());
				ps.setString(3, checkup.getMedicine());
				ps.setString(4, checkup.getTests_suggested());	
			}});
		return value>0?true:false;
	}
	

}
