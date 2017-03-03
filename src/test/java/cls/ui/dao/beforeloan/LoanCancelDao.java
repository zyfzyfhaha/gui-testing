package cls.ui.dao.beforeloan;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import cls.ui.dao.BaseDButil;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

@Repository
public class LoanCancelDao extends BaseDButil{

	public String getApplyId(String cardNumberString) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select apply_id from cls.loan_customer_info where card_no = '" + cardNumberString + "'");
		String applyId = (String)jdbcTemplateCls.query(stringBuffer.toString(), new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				String applyId = "";
				while(rs.next()){
					
					applyId = rs.getString("apply_id");
				}
				return applyId;
			}
		});
		return applyId;
	}
	
	
	
	
}
