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

import com.techhub.hms.Models.Doctor;


@Repository
public class DoctorRepositoryImpl implements DoctorRepository{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean isDoctorsAdd(Doctor doctor) {
		
		int value=jdbcTemplate.update("insert into doctors values('0',?,?,?,?)",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,doctor.getName());
				ps.setString(2, doctor.getSpecialization());
				
				ps.setString(3, doctor.getContact());
				ps.setString(4,doctor.getAvailability());
				
			}
			
		});
		return value>0?true:false;


	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor>list=jdbcTemplate.query("select * from doctors", new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Doctor dp=new Doctor();
			dp.setDoctorid(rs.getInt("doctor_id"));
			dp.setName(rs.getString("name"));
			dp.setSpecialization(rs.getString("specialization"));
			dp.setContact(rs.getString("contact"));
			dp.setAvailability(rs.getString("availability"));
			return dp;
				
			}
			   
			
			
		});
	 return  list;
	}

	@Override
	public boolean isupdate(int id, Doctor doctor) {
		
		int value =jdbcTemplate.update("UPDATE doctors SET Name = ?, specialization = ?, contact = ?, availability = ? WHERE doctor_id = ?",new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setString(1, doctor.getName());
		               ps.setString(2,doctor.getSpecialization());
		               ps.setString(3,doctor.getContact());
		               ps.setString(4, doctor.getAvailability());
		                ps.setInt(5, id);

					}
					
		});
		
		
		return value>0?true:false;

		
	}
		

}
