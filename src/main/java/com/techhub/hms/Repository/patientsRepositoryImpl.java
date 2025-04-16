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
				ps.setDate(2, new java.sql.Date(patiets.getDob().getTime()));
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
		List<Patients>list=jdbctemplate.query("select * from patients", new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Patients pmp=new Patients();
				pmp.setPatientId(rs.getInt("patient_id"));
				pmp.setName(rs.getString("Name"));
				pmp.setDob(rs.getDate("Dob"));
				pmp.setGender(rs.getString("gender"));
				pmp.setMaritalstatus(rs.getString("Maritalstaus"));
				pmp.setEmail(rs.getString("Email"));
				pmp.setMobailenumber(rs.getString("mobailenumber"));
				pmp.setWpnumber(rs.getString("wpnumber"));
				pmp.setAddress(rs.getString("Address"));
				return pmp;
				
			}
			   
			
			
		});
	 return  list;
	}


	public boolean updatePatientById(int id, Patients patients) {
	    int value = jdbctemplate.update(
	    		"UPDATE Patients SET Name = ?, Dob = ?, gender = ?, Maritalstaus = ?, email = ?,mobailenumber = ?, wpnumber = ?, Address = ? WHERE patient_id = ?",

	        new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setString(1, patients.getName());
	                ps.setDate(2, new java.sql.Date(patients.getDob().getTime()));
	                ps.setString(3, patients.getGender());
	                ps.setString(4, patients.getMaritalstatus());
	                ps.setString(5, patients.getEmail());
	                ps.setString(6, patients.getMobailenumber());
	                ps.setString(7, patients.getWpnumber());
	                ps.setString(8, patients.getAddress());
	                ps.setInt(9, id);
 					}
 					
 		});
 		
 		
 		return value>0?true:false;
 
 		
 	}

@Override
	public List<Patients> searchPatientsByName(String patients_name) {
		String sql="select  * from Patients where Name LIKE ?";
		
		return jdbctemplate.query(sql,new Object[] {"%"+patients_name+"%"},new RowMapper<Patients>() {

			@Override
			public Patients mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				 Patients patient = new Patients();
		            patient.setPatientId(rs.getInt("patient_id"));
		            patient.setName(rs.getString("Name"));
		            patient.setDob(rs.getDate("Dob"));
		            patient.setGender(rs.getString("gender"));
		            patient.setMaritalstatus(rs.getString("Maritalstaus"));
		            patient.setEmail(rs.getString("email"));
		            patient.setMobailenumber(rs.getString("mobailenumber")); 
		            patient.setWpnumber(rs.getString("wpnumber"));
		            patient.setAddress(rs.getString("Address"));
		            return patient;
			}});
	}

	@Override
	public boolean isDeletePatients(int id) {
		String sql="delete from Patients where patient_id =?";
		int value=jdbctemplate.update(sql, id);
		return value>0?true:false;
	}


}
