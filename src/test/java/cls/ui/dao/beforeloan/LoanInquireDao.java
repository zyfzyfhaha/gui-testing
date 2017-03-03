package cls.ui.dao.beforeloan;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import cls.ui.dao.BaseDButil;

/**
 * 
 * @author lxx  
 */

@Repository
public class LoanInquireDao extends BaseDButil{

	//获取合作银行Id
	public String getCooperationBankId(String cooperationBankName) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select id from cooperation_bank_info where bank_name = '" + cooperationBankName + "'");
		String cooperationBankId = (String)jdbcTemplateZaAdmin.query(stringBuffer.toString(), new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				String id = "";
				while(rs.next()){
					
					id = rs.getString("id");
				}
				return id;
			}
		});
		return cooperationBankId;
	}
	
	//获取期数
	public String getPeriodNumber(String cardNo) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select loan_term from loan_approve_project where project_id=(select Min(apply_id) from loan_customer_info where card_no = '" + cardNo + "')");
		String periodNumber = (String)jdbcTemplateCls.query(stringBuffer.toString(), new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				String loan_term = "";
				while(rs.next()){
					
					loan_term = rs.getString("loan_term");
				}
				return loan_term;
			}
		});
		return periodNumber;
	}
	
	//获取金融产品ID
	public String getProductId(String cardNo) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select product_id from loan_approve_project where project_id=(select Min(apply_id) from loan_customer_info where card_no = '" + cardNo + "')");
		String productId = (String)jdbcTemplateCls.query(stringBuffer.toString(), new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				String product_id = "";
				while(rs.next()){
					
					product_id = rs.getString("product_id");
				}
				return product_id;
			}
		});
		return productId;
	}
	
	//获取基准利率(单位%)
	public String getBenchmarkRate(String productId) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select benchmark_rate from bank_financial_product where id = '" + productId + "'");
		String benchmarkRate = (String)jdbcTemplateZaAdmin.query(stringBuffer.toString(), new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				String benchmark_rate = "";
				while(rs.next()){
					
					benchmark_rate = rs.getString("benchmark_rate");
				}
				return benchmark_rate;
			}
		});
		return benchmarkRate;
	}
	
	//获取是否贴息
	public boolean getIsDiscount(String cardNo){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select is_discount from loan_approve_project where project_id=(select Min(apply_id) from loan_customer_info where card_no = '" + cardNo + "')");
		String isDiscountStr = (String)jdbcTemplateCls.query(stringBuffer.toString(), new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				String is_discount = "";
				while(rs.next()){
					
					is_discount = rs.getString("is_discount");
				}
				return is_discount;
			}
		});
		
		boolean isDiscount;
		switch (isDiscountStr) {
		case "1":
			isDiscount = true;
			break;
		case "2":
			isDiscount = false;
			break;
		default:
			isDiscount = false;
			break;
		}
		
		return isDiscount;
	}
	
	//获取贴息政策Id
	public String getDiscountCaseId(String cardNo){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select discount_case_id from loan_approve_project where project_id in (select Min(apply_id) from loan_customer_info where card_no = '" + cardNo + "'");
		String discountCaseId = (String)jdbcTemplateCls.query(stringBuffer.toString(), new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				String discount_case_id = "";
				while(rs.next()){
					
					discount_case_id = rs.getString("discount_case_id");
				}
				return discount_case_id;
			}
		});
		return discountCaseId;
	}
	
	//获取贴息金额（百分比或者金额）
	public String getDiscountRate(String discountCaseId,String nper){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("SELECT discount_rate from dis_policy_scheme_nper where scheme_id = '"+discountCaseId +"'14 and nper = '" + nper + "'");
		String discountRate = (String)jdbcTemplateCls.query(stringBuffer.toString(), new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				String discount_rate = "";
				while(rs.next()){
					
					discount_rate = rs.getString("discount_rate");
				}
				return discount_rate;
			}
		});
		return discountRate;
	}
	
	//获取贴息是否百分比	1：是，0：否
	public String getIsPercent(String discountCaseId,String nper){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("SELECT is_per_cent from dis_policy_scheme_nper where scheme_id = '"+discountCaseId +"'14 and nper = '" + nper + "'");
		String isPercent = (String)jdbcTemplateCls.query(stringBuffer.toString(), new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				String is_per_cent = "";
				while(rs.next()){
					
					is_per_cent = rs.getString("is_per_cent");
				}
				return is_per_cent;
			}
		});
		return isPercent;
	}
	
}
