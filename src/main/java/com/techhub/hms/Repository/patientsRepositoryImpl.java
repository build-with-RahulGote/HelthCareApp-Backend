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
@Repository
public class patientsRepositoryImpl implements patientsRepository{
	@Autowired
	JdbcTemplate jdbctemplate;


	@Override
	public boolean isPatientsAdd(Patients patiets) {
		
		int value=jdbctemplate.update("insert into Patients values('0',?,?,?,?,?,?,?,?)",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,patiets.getName());
				ps.setDate(2, patiets.getDob());
				ps.setString(3,patiets.getGender());
				ps.setString(4,patiets.getMaritalstatus());
				ps.setString(5,patiets.getEmail());
				ps.setString(6, patiets.getMobailenumber());
				ps.setString(7, patiets.getWpnumber());
				ps.setString(8, patiets.getAddress());
				
			}
			
		});
		return value>0?true:false;

			
	}


	@Override
	public List<Patients> getAllPatients() {
		List<Patients>list=jdbctemplate.query("select * from Patients", new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Patients pmp=new Patients();
			pmp.setPatientId(rs.getInt("patient_id"));
			pmp.setName(rs.getString("name"));
			pmp.setGender(rs.getString("gender"));
			pmp.setDob(rs.getDate("dob"));
			pmp.setMaritalstatus(rs.getString("Maritalstaus"));
			pmp.setAddress(rs.getString("address"));
			pmp.setEmail(rs.getString("email"));
			pmp.setWpnumber(rs.getString("wpnumber"));
			pmp.setMobailenumber(rs.getString("mobailenumber"));
			return pmp;
				
			}
			   
			
			
		});
	 return  list;
	}

}
