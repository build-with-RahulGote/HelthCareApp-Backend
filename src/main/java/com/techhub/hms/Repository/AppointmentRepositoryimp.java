package com.techhub.hms.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.techhub.hms.Models.Appointment;
import com.techhub.hms.Models.Receptionist;
@Repository
public class AppointmentRepositoryimp implements AppointmentRepo{

    @Autowired	
	JdbcTemplate jdbctemplate;
	@Override
	public boolean isAddAppointment(Appointment appointment) {
		int value=jdbctemplate.update("insert into Appointments values('0',?,?,?,?,?)",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, appointment.getPatient_id());
				ps.setInt(2, appointment.getDoctor_id());
				ps.setDate(3, appointment.getAppointment_date());
				ps.setString(4, appointment.getTime());
				ps.setString(5, appointment.getStatus());
				
				
				
			}});
		return value>0?true:false;
	}
	@Override
	public List<Appointment> getAllAppointment() {
		List<Appointment>list=jdbctemplate.query("Select * from Appointments",new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Appointment Ap=new Appointment();
				Ap.setAppointment_id(rs.getInt("appointment_id"));
				Ap.setPatient_id(rs.getInt("patient_id"));
				Ap.setDoctor_id(rs.getInt("doctor_id"));
				Ap.setAppointment_date(rs.getDate("Appointment_date"));
				Ap.setTime(rs.getString("time"));
				Ap.setStatus(rs.getString("Status"));
				return Ap;
			}});
		return list;
	}
	@Override
	public boolean isupdate(int id, Appointment appointment) {
	    int value = jdbctemplate.update(
	        "UPDATE Appointments SET patient_id = ?, doctor_id = ?, Appointment_date = ?, time = ?, Status = ? WHERE appointment_id = ?",
	        new PreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps) throws SQLException {
	                ps.setInt(1, appointment.getPatient_id());
	                ps.setInt(2, appointment.getDoctor_id());
	                ps.setDate(3, appointment.getAppointment_date());
	                ps.setString(4, appointment.getTime());
	                ps.setString(5, appointment.getStatus());
	                ps.setInt(6, id);
	            }
	        }
	    );

	    return value > 0 ? true : false;
	}

	@Override
	public List<Appointment> SearchAppointment(String name) {
		String sql = "select a.appointment_id, a.patient_id, a.doctor_id,a.Appointment_date,a.time,a.Status from Appointments a left join patients p on p.patient_id=a.patient_id where p.name like ?";

	    return jdbctemplate.query(sql, new Object[]{"%" + name + "%"}, new RowMapper<Appointment>() {
	        @Override
	        public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Appointment Ap=new Appointment();
	        	Ap.setAppointment_id(rs.getInt("appointment_id"));
				Ap.setPatient_id(rs.getInt("patient_id"));
				Ap.setDoctor_id(rs.getInt("doctor_id"));
				Ap.setAppointment_date(rs.getDate("Appointment_date"));
				Ap.setTime(rs.getString("time"));
				Ap.setStatus(rs.getString("Status"));
	            return Ap;
	        }
	    });
	}
	@Override
	public boolean isDeleteAppointment(int id) {
		String sql="delete from Appointments where appointment_id =?";
		int value=jdbctemplate.update(sql, id);
		return value>0?true:false;
	}
	
	
}
