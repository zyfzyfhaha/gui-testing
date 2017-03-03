package cls.ui.dao.beforeloan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
public class LoanModifyDao extends BaseDButil{

	public List<String> getApplyId(String cardNumberString) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("SELECT MAX(id) FROM cls.loan_apply WHERE relative_apply_id IN (SELECT apply_id FROM cls.loan_customer_info WHERE card_no = '"+ cardNumberString +"')");
		List<String> applyIds = (List<String>)jdbcTemplateCls.query(stringBuffer.toString(), new ResultSetExtractor<List<String>>() {

			@Override
			public List<String> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				List<String> applyIds = new ArrayList<String>();
				while(rs.next()){
					String applyId = "";
					if(rs.getString("MAX(id)") != null){
						applyId = rs.getString("MAX(id)");
						applyIds.add(applyId);
					}
					
				}
				return applyIds;
			}
		});
		return applyIds;
	}
	

}
