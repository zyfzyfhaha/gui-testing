package cls.ui.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sourceforge.htmlunit.corejs.javascript.ast.NewExpression;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class ExecuteSqlFiles extends BaseDButil{
	
	/** 
     * 读取 SQL 文件，获取 SQL 语句 
     * @param sqlFile SQL 脚本文件 
     * @return List<sql> 返回所有 SQL 语句的 List 
     * @throws Exception 
     */  
	private static List<String> loadSql(String sqlFile) throws Exception {  
        List<String> sqlList = new ArrayList<String>();  
  
        try {  
            InputStream sqlFileIn = new FileInputStream(sqlFile);  
  
            StringBuffer sqlSb = new StringBuffer();  
            byte[] buff = new byte[1024];  
            int byteRead = 0;  
            while ((byteRead = sqlFileIn.read(buff)) != -1) {  
                sqlSb.append(new String(buff, 0, byteRead));  
            }  
  
            // Windows 下换行是 /r/n, Linux 下是 /n  
            String[] sqlArr = sqlSb.toString().split("(;//s*//r//n)|(;//s*//n)");  
            for (int i = 0; i < sqlArr.length; i++) {  
                String sql = sqlArr[i].replaceAll("--.*", "").trim();  
                if (!sql.equals("")) {  
                    sqlList.add(sql);  
                }  
            }  
            return sqlList;  
        } catch (Exception ex) {  
            throw new Exception(ex.getMessage());  
        }  
    } 
	
	
	/**
     * 传入连接来执行 SQL 脚本文件，这样可与其外的数据库操作同处一个事物中
     * @param conn 传入数据库连接
     * @param sqlFile SQL 脚本文件
     * @throws Exception
     */  
   public static void execute(String dbNameString, String sqlFile) throws Exception {   
         Connection conn = connect(dbNameString);
	   Statement stmt = null;   
        List<String> sqlList = loadSql(sqlFile);   
        stmt = conn.createStatement();   
       for (String sql : sqlList) {   
            stmt.addBatch(sql);
        }   
       int[] rows = stmt.executeBatch(); 
//       
        System.out.println("Row count:" + Arrays.toString(rows));   
    } 
   
   public static void main(String[] args){  
	   try {
		execute("cls", "src/test/resources/sql/test.sql");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
   
   
 
}


