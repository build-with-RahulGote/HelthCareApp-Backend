package com.techhub.hms.Repository;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
		int value=jdbctemplate.update("insert into checkup values('0',?,?,?,?,?,?)",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1,checkup.getAppointment_id());
				ps.setInt(2, checkup.getPatient_id());
				ps.setString(3,checkup.getSymptoms());
				ps.setString(4, checkup.getMedicine());
				ps.setString(5, checkup.getTests_suggested());
				ps.setDouble(6, checkup.getTotal_bill());
			}});
		return value>0?true:false;
	}

	@Override
	public List<Checkup> getCheckupDetailsByPatientId(int patientsId) {
		String sql = "SELECT c.checkupid, c.appointment_id, p.name AS patient_name, " +
                "c.symptoms, c.medicine, c.tests_suggested, c.total_bill " +
                "FROM checkup c " +
                "JOIN appointments a ON c.appointment_id = a.appointment_id " +
                "JOIN patients p ON a.patient_id = p.patient_id " +
                "WHERE p.patient_id = ?";

		  return jdbctemplate.query(sql, new Object[]{patientsId}, (rs, rowNum) -> {
		        Checkup ckup = new Checkup();
		        ckup.setCheckupid(rs.getInt("checkupid"));
		        ckup.setAppointment_id(rs.getInt("appointment_id"));
		        ckup.setPatientName(rs.getString("patient_name"));
		        ckup.setSymptoms(rs.getString("symptoms"));
		        ckup.setMedicine(rs.getString("medicine"));
		        ckup.setTests_suggested(rs.getString("tests_suggested"));
		        ckup.setTotal_bill(rs.getDouble("total_bill"));
		        return ckup;
		    });
		 
	}
	

}
