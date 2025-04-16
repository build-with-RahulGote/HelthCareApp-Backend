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

import com.techhub.hms.Models.Pharmacy;
@Repository
public class PharmacyRepositoryimp implements PharmacyRepository{
	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Override
	public boolean addPharmacy(Pharmacy pharmacy) {
		int value=jdbctemplate.update("insert into Pharmacy values('0',?,?,?,?)",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			
				ps.setString(1,pharmacy.getName());
				ps.setString(2, pharmacy.getStock());
				ps.setDouble(3, pharmacy.getPrice());
				ps.setString(4, pharmacy.getSymptoms());
				
				
			}});
		return value>0?true:false;
	}

	@Override
	public List<Pharmacy> getAllPharmacy() {
		List<Pharmacy> list=jdbctemplate.query("Select * from Pharmacy",new RowMapper(){

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Pharmacy p=new Pharmacy();
				p.setMedicine_id(rs.getInt("medicine_id"));
				p.setName(rs.getString("name"));
				p.setStock(rs.getString("stock"));
				p.setPrice(rs.getDouble("price"));
				p.setSymptoms(rs.getString("symptoms"));
				
				return p;
			}});
		return list;
	}

	@Override
	public List<Pharmacy> Searchmedicine(String name) {
		List<Pharmacy> list=jdbctemplate.query("select * from Pharmacy where name Like ?",new Object[] {"%"+name+"%"},new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Pharmacy p=new Pharmacy();
				p.setMedicine_id(rs.getInt("medicine_id"));
				p.setName(rs.getString("name"));
				p.setStock(rs.getString("stock"));
				p.setPrice(rs.getDouble("price"));
				p.setSymptoms(rs.getString("symptoms"));
				
				return p;
			}});
		
		return list;
	}

	@Override
	public boolean isUpdatePharmacy(int id, Pharmacy pharmacy) {
		int value=jdbctemplate.update("update Pharmacy set name=?, stock=?, price=?, symptoms=? where medicine_id=?",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, pharmacy.getName());
				ps.setString(2,pharmacy.getStock());
				ps.setDouble(3,pharmacy.getPrice() );
				ps.setString(4,pharmacy.getSymptoms());
				ps.setInt(5, id);
				
			}});
		return value>0?true:false;
	}

	@Override
	public boolean isDeletePharmacy(int id) {
		int value=jdbctemplate.update("DELETE FROM Pharmacy WHERE medicine_id = ?",id);
		return value>0?true:false;
	}

}
