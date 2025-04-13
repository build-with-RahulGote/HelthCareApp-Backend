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
import com.techhub.hms.Models.Receptionist;



@Repository
public class ReceptionistRepositoryimp implements ReceptionistRepository{
 
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean isaddReceptionist(Receptionist receptionist) {
		 int value = jdbcTemplate.update("INSERT INTO receptionist (Receptionisted_id, name, UserName, password) VALUES (?, ?, ?, ?)",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, receptionist.getReceptionisted_id());
                ps.setString(2, receptionist.getName());
                ps.setString(3, receptionist.getUserName());
                ps.setString(4, receptionist.getPassword());
				
			}});
		return value>0?true:false;
			    
	}

	@Override
	public List<Receptionist> GetAllReceptionist() {
		List<Receptionist> list=jdbcTemplate.query("select * from receptionist",new RowMapper(){

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Receptionist r=new Receptionist();
				r.setReceptionisted_id(rs.getInt("receptionisted_id"));
				r.setName(rs.getString("name"));
				r.setUserName(rs.getString("userName"));
				r.setPassword(rs.getString("password"));
				
				return r;
			}});
		return list;
	}

	@Override
	public boolean updateReceptionistById(int id, Receptionist receptionist) {
	    String sql = "UPDATE receptionist SET receptionisted_id = ?, name = ?, userName = ?, password = ? WHERE receptionisted_id = ?";
	    
	    int value = jdbcTemplate.update(sql, new PreparedStatementSetter() {
	        @Override
	        public void setValues(PreparedStatement ps) throws SQLException {
	            ps.setInt(1, receptionist.getReceptionisted_id());
	            ps.setString(2, receptionist.getName());
	            ps.setString(3, receptionist.getUserName());
	            ps.setString(4, receptionist.getPassword());
	            ps.setInt(5, id); 
	        }
	    });

	    return value > 0?true:false;
	}

	@Override
	public List<Receptionist> searchReceptionistByName(String receptionist_name) {
	    String sql = "SELECT * FROM receptionist WHERE name LIKE ?";

	    return jdbcTemplate.query(sql, new Object[]{"%" + receptionist_name + "%"}, new RowMapper<Receptionist>() {
	        @Override
	        public Receptionist mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Receptionist r = new Receptionist();
	            r.setReceptionisted_id(rs.getInt("receptionisted_id"));
	            r.setName(rs.getString("name"));
	            r.setUserName(rs.getString("userName"));
	            r.setPassword(rs.getString("password"));
	            return r;
	        }
	    });
	}

	@Override
	public boolean isdeletesReceptionist(int id) {
		int value=jdbcTemplate.update("delete from Receptionist where receptionisted_id="+id);
		return value>0?true:false;
	}


	}


