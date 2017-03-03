package cls.ui.dao.insurancemanagement;

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
public class FirstMaintenanceDao extends BaseDButil{
	
	public List<String> getProjectIdFromDb(String cardNumberString) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select project_id from cls.loan_approve_customer where card_no = '" + cardNumberString + "'");
		List<String> projectIds = (List<String>)jdbcTemplateCls.query(stringBuffer.toString(), new ResultSetExtractor<List<String>>() {

			@Override
			public List<String> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				List<String> projectIds = new ArrayList<String>();
				while(rs.next()){
					String projectId = "";
					projectId = rs.getString("project_id");
					projectIds.add(projectId);
				}
				return projectIds;
			}
		});
		return projectIds;
	}

}
