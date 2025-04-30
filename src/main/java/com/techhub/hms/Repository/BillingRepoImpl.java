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

import com.techhub.hms.Models.Appointment;
import com.techhub.hms.Models.Billing;

@Repository
public class BillingRepoImpl implements BillingRepo{

	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public boolean isAddBill(Billing billing) {
		int value=jdbctemplate.update("insert into billing values('0',?,?,?,?)",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, billing.getPatients_id());
				ps.setDouble(2, billing.getTotal_amount());
				ps.setString(3, billing.getPayment_Status());
				ps.setString(4, billing.getPayment_mode());
				
				
				
			}});
		return value>0?true:false;
	}

	@Override
	public List<Billing> getAllBills() {
		
		List<Billing>list=jdbctemplate.query("Select * from billing",new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Billing bp=new Billing();
				bp.setBill_id(rs.getInt("bill_id"));
				bp.setPatients_id(rs.getInt("patient_id"));
				bp.setTotal_amount(rs.getDouble("total_amount"));
				bp.setPayment_Status(rs.getString("payment_Status"));
				bp.setPayment_mode(rs.getString("payment_mode"));
				
				return bp;
			}});
		return list;
	}

	@Override
	public List<Billing> getallbillsById(int patients_id) {
		
		String sql = "SELECT * FROM billing WHERE patient_id = ?";

	    return jdbctemplate.query(sql, new Object[]{patients_id}, (rs, rowNum) -> {
	        Billing bill = new Billing();
	        bill.setBill_id(rs.getInt("bill_id"));
	        bill.setPatients_id(rs.getInt("patient_id"));
	        bill.setTotal_amount(rs.getDouble("total_amount"));
	        bill.setPayment_Status(rs.getString("payment_Status"));
	        bill.setPayment_mode(rs.getString("payment_mode"));
	        return bill;
	    });
	}

	@Override
	public List<Billing> getAllBillsWithPatientName() {
		String sql = "SELECT b.bill_id, b.patient_id, p.name AS patient_name, " +
                "b.total_amount, b.payment_status, b.payment_mode " +
                "FROM billing b " +
                "JOIN patients p ON b.patient_id = p.patient_id";
		return jdbctemplate.query(sql, (rs, rowNum) -> {
	        Billing  bill = new Billing();
	        bill.setBill_id(rs.getInt("bill_id"));
	        bill.setPatients_id(rs.getInt("patient_id"));
	        bill.setPatientName(rs.getString("patient_name"));
	        bill.setTotal_amount(rs.getDouble("total_amount"));
	        bill.setPayment_Status(rs.getString("payment_Status"));
	        bill.setPayment_mode(rs.getString("payment_mode"));
	        return bill;
	    });
		
	}

	@Override
	public int updatePaymentMode(int billId, String paymentMode) {
		String sql = "UPDATE Billing SET payment_mode = ?, payment_status = 'Paid' WHERE bill_id = ?";
	    return jdbctemplate.update(sql, paymentMode, billId);
		
	}

	@Override
	public Billing getBillById(int id) {
		String sql = """
		        SELECT b.bill_id, b.total_amount, b.payment_status, b.payment_mode, p.Name 
		        FROM Billing b 
		        JOIN patients p ON b.patient_id = p.patient_id 
		        WHERE b.bill_id = ?
		        """;
		return jdbctemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
	        Billing bill = new Billing();
	        bill.setBill_id(rs.getInt("bill_id"));
	        bill.setTotal_amount(rs.getDouble("total_amount"));
	        bill.setPayment_Status(rs.getString("payment_status"));
	        bill.setPayment_mode(rs.getString("payment_mode"));
	        bill.setPatientName(rs.getString("Name")); 
	        return bill;
	    });
	}
}
