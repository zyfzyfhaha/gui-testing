package cls.ui.dao.beforeloan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.htmlunit.corejs.javascript.ast.NewExpression;

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
public class LoanReviewDao extends BaseDButil{

	public List<String> getApplyIds(String cardNumberString) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select apply_id from cls.loan_customer_info where card_no = '" + cardNumberString + "'");
		List<String> applyIds = (List<String>)jdbcTemplateCls.query(stringBuffer.toString(), new ResultSetExtractor<List<String>>() {

			@Override
			public List<String> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				ArrayList<String> applyIds = new ArrayList<String>();
				while(rs.next()){
					String applyId = "";
					applyId = rs.getString("apply_id");
					applyIds.add(applyId);
				}
				return applyIds;
			}
		});
		return applyIds;
	}
	

}
