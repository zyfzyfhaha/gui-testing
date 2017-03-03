package cls.ui.dao;

import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.io.InputStream;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;  

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cls.ui.dao.SQLReader;
import cls.ui.util.FileUtil;
import com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor;

	/** 
	 * 数据库工具类 
	 *  
	 * @author zyf 
	 *  
	 */
	@Repository
	public class BaseDButil{  
		
		protected static final Logger LOGGER = Logger.getLogger(BaseDButil.class);
		protected static JdbcTemplate jdbcTemplateCls;
		protected static JdbcTemplate jdbcTemplateZaAdmin;
		protected static JdbcTemplate jdbcTemplateAuto;
		 
		 public void setJdbcTemplate(final JdbcTemplate template) {
		        this.jdbcTemplateCls = template;
		    }

		    public JdbcTemplate getJdbcTemplate() {
		        return jdbcTemplateCls;
		    }
		
		    
		    
		    
		    @Resource(name = "clsDataSource")
		    public void setClsdataSource(final DataSource dataSource) {
		    	jdbcTemplateCls = new JdbcTemplate(dataSource);
		    }
		    
		    @Resource(name = "zaAdminDataSource")
		    public void setZaAdminDataSource(final DataSource dataSource) {
		    	jdbcTemplateZaAdmin = new JdbcTemplate(dataSource);
		    }
		    
		    @Resource(name = "autoDataSource")
		    public void setAutoDataSource(final DataSource dataSource) {
		    	jdbcTemplateAuto = new JdbcTemplate(dataSource);
		    }
		    
		    
		    /**
		     * query sql to return result.
		     * @param sqlState
		     *                sql used to query.
		     * @return query result list
		     */
		    public List<Map<String, Object>> querySQL(final String sqlState) {
		        return getJdbcTemplate().queryForList(sqlState);
		    }
		    
		    /**
		     * Execute update sql.
		     * @param sqlState
		     *                sql used to query.
		     */
		    public void executeSQL(final String sqlState) {
		        getJdbcTemplate().update(sqlState);
		    }
		    
		    /**
		     * Batch execute update sqls.
		     * @param sqls
		     *                all the sqls used to query.
		     */
		    public void executeSQL(final List<String> sqls) {
		        String[] arraySqls = new String[sqls.size()];
		        for (int i = 0; i < arraySqls.length; i++) {
		            arraySqls[i] = sqls.get(i);
		        }
		        getJdbcTemplate().batchUpdate(arraySqls);
		    }

		    /**
		     * Read and batch execute update sqls.
		     * @param keys
		     *                all the sql used to query.
		     */
		    public void fetchAndRunSQLs(String[] keys) {
		        if (keys.length == 0) {
		            LOGGER.warn("Skiping the sql execution as the keys is empty.");
		        }
		        List<String> consolidatedSqls = new ArrayList<String>();

		        for (String key : keys) {
		            List<String> sqls = SQLReader.getInstance().getSql(key);
		            if (sqls != null) {
		                consolidatedSqls.addAll(sqls);
		            } else {
		                LOGGER.warn("Skipping the sql key {"+key+"} as the sql doesn't not exists.");
		            }
		        }

		        if (consolidatedSqls.size() > 0) {
		            executeSQL(consolidatedSqls);
		        } else {
		            LOGGER.warn("Skiping the sql execution as the sqls for keys {"+keys.toString()+"} does not exist.");
		        }
		    }
		    
		    public String generateInsertPreSql(String tableName, List<String> columnHeaders){
		        StringBuilder sqlBuilder = new StringBuilder("Insert into ");
		        StringBuilder parameterBuilder = new StringBuilder("");
		        sqlBuilder.append(tableName).append("(");
		        for(String column : columnHeaders){
		            sqlBuilder.append("").append(column).append(",");
		            parameterBuilder.append("?").append(",");
		        }
		        sqlBuilder.deleteCharAt(sqlBuilder.length()-1);
		        parameterBuilder.deleteCharAt(parameterBuilder.length()-1);
		        sqlBuilder.append(") values(").append(parameterBuilder).append(")");
		        return sqlBuilder.toString();
		    }
		    
		    public String generateDeletePreSql(String tableName, List<String> columnHeaders){
		        StringBuilder sqlBuilder = new StringBuilder("Delete from ");
		        sqlBuilder.append(tableName).append(" where ");
		        for(String column : columnHeaders){
		            sqlBuilder.append(column).append("=? and ");
		        }
		        sqlBuilder.delete(sqlBuilder.lastIndexOf("and"), sqlBuilder.length());
		        return sqlBuilder.toString();
		    }
		    
		    public void executeSqlFile(String fileName){
		    	String content = FileUtil.readFile(fileName).trim(); 
				String[] sql_ar = content.split(";#\n");
		        getJdbcTemplate().batchUpdate(sql_ar);
		    }
		    
		    public void executeSqlFileWithOneParameter(String fileName, String parameter){
		    	String content = FileUtil.readFileWithOneParamter(fileName, parameter).trim(); 
				String[] sql_ar = content.split(";#\n");
		        getJdbcTemplate().batchUpdate(sql_ar);
		    }
		    
		    
			public void addSql(String folderName, String storyName) {
		        executeSqlFile("sql/" + folderName + "/" + storyName + "-Add.sql");
			}
			
			public void deleteSql(String folderName, String storyName){
				 executeSqlFile("sql/" + folderName + "/" + storyName + "-Delete.sql");
			}
			
			
			public void addSqlWithOneParamter(String folderName, String storyName, List<String> parameters) {
				for(String parameter : parameters){
					executeSqlFileWithOneParameter("sql/" + folderName + "/" + storyName + "-Add.sql", parameter);
				}
				
			}
			
			public void deleteSqlWithOneParamter(String folderName, String storyName, List<String> parameters){
				for(String parameter : parameters){
				executeSqlFileWithOneParameter("sql/" + folderName + "/" + storyName + "-Delete.sql", parameter);
				}
			}
			
			public void updateSqlWithOneParamter(String folderName, String storyName, List<String> parameters) {
				for(String parameter : parameters){
					executeSqlFileWithOneParameter("sql/" + folderName + "/" + storyName + "-Update.sql", parameter);
				}
				
			}
			  
		    /**
		     * query sql to return only top result by field.
		     * @param sqlState
		     *                sql used to query.
		     * @return query result list
		     */
		    public String getUniqueResultByQuerySQL(final String sqlState, String field) {
		    	List<Map<String, Object>> tmpResult = getJdbcTemplate().queryForList(sqlState);
		    	if(tmpResult.size() == 0 || tmpResult.get(0).get(field) == null){
		    		return null;
		    	}else{
		    		return tmpResult.get(0).get(field).toString();
		    	}
		    }
		    
		    public Map<String, Object> getTopResultByQuerySQL(final String sqlState){
		    	List<Map<String, Object>> tmpResult = getJdbcTemplate().queryForList(sqlState);
		    	if(tmpResult.size() == 0) return null;
		    	return tmpResult.get(0);
		    }
		    
		    public List<String> getResultListBuQuerySQL(final String sqlState, String field){
		    	List<Map<String, Object>> tmpResult = getJdbcTemplate().queryForList(sqlState);
		    	List<String> tmpList = new ArrayList<String>();
		    	for(Map<String, Object> res: tmpResult){
		    		tmpList.add(res.get(field)==null?null:res.get(field).toString());
		    	}
		       return tmpList;
		    }
		    
		    
	    /** 
	     * 连接数据库 
	     *  
	     * @return 数据库连接对象 
	     */  
	    public static Connection connect(String db) {  
	        Properties pro = new Properties();  
	        String driver = null;  
	        String url = null;  
	        String username = null;  
	        String password = null;  
	  
	        try {  
	            InputStream is = BaseDButil.class.getClassLoader()  
	                    .getResourceAsStream("db.properties");  
	            // System.out.println(is.toString());  
	            pro.load(is);  
	            
	            driver = pro.getProperty("jdbc.mysql.driver");  
	            url = pro.getProperty("jdbc."+ db +".url");  
	            username = pro.getProperty("jdbc."+ db +".username");  
	            password = pro.getProperty("jdbc."+ db +".password");  
	              
//	           System.out.println(driver + ":" + url + ":" + username + ":"  
//	           + password);  
	            Class.forName(driver);  
	            Connection conn = DriverManager.getConnection(url, username,  
	                    password);  
	            return conn;  
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } catch (ClassNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        return null;  
	    }  
	  
	    /** 
	     * 关闭数据库 
	     *  
	     */  
	    public static void close(Connection con) {  
	        if (con != null) {  
	            try {  
	                con.close();  
	            } catch (SQLException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    }  
	  
	  public static void main(String[] args) {  
	      Connection con = new BaseDButil().connect("clsAutoTest"); 
	      System.out.println(con);  
	  }  
	    
	}  


