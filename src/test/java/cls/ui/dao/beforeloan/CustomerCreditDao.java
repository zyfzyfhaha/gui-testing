package cls.ui.dao.beforeloan;

import java.io.File;
import java.sql.Connection;

import org.springframework.stereotype.Repository;

import cls.ui.dao.BaseDButil;
import cls.ui.dao.DBExportImport;;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

@Repository
public class CustomerCreditDao extends BaseDButil{
	
	private static String TEST_DIR = DBExportImport.class.getResource("/").getPath();
	
	public void backUpDb(String db)throws Throwable{
		
		    File file = new File(TEST_DIR + "backup.xml");  
	        Connection connection = BaseDButil.connect(db);  
	        String[] tableNames = new String[] { "customer_credit","customer_credit_relavant","business_object_process_info"};  
	        // 导出指定的表的数据到xml文件  
	        DBExportImport.exportTables(connection, tableNames, file); 
	        // 导出所有表的数据到xml文件  
//	         exportAllTables(file, connection); 
	        // 将xml数据文件中的数据导入到数据库中  
//	        DBExportImport.importData(file, connection); 
	}
	

}
