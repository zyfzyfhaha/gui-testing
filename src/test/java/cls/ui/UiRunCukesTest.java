package cls.ui;

import java.io.File;
import java.sql.Connection;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cls.ui.dao.BaseDButil;
import cls.ui.dao.DBExportImport;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * cucumber auto test suit.
 * 
 * @author zyf
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@test"}, features = {
		

//		ALL FEATURES
//		"src/test/resources/features"
		
//		***************************************贷前管理***************************************************

//		FOLDER
//		"src/test/resources/features/beforeloanmanagement",
		
	//		征信
			"src/test/resources/features/beforeloanmanagement/Step1-CustomerCredit/CustomerCredit.feature",
			
	//		贷款评审
//			"src/test/resources/features/beforeloanmanagement/Step2-LoanReview/LoanReview.feature",
			
	//		贷款修改
//			"src/test/resources/features/beforeloanmanagement/Step3-LoanModify/LoanModify.feature",
			
	//		贷款查询
	//		"src/test/resources/features/beforeloanmanagement/Step4-LoanInquire/LoanInquire.feature",
			
	//		贷款作废
	//		"src/test/resources/features/beforeloanmanagement/Step5-LoanCancel/LoanCancel.feature"
		
	
		
		
		
//		***************************************车商管理***************************************************

//		FOLDER
//		"src/test/resources/features/cardealermanage",
		
	//		车商管理
	//		"src/test/resources/features/cardealermanage/Step1-CarDealerManager/CarDealerManage.feature",
			
	//		车商订单管理
	//		"src/test/resources/features/cardealermanage/Step2-CarDealerOrder/CarDealerOrder.feature",


		
		
		
		
		
//		***************************************二手车***************************************************
		
//		 FOLDER
//		"src/test/resources/features/secondhandcarmanagement",
		
	//		二手车评估
//			"src/test/resources/features/secondhandcarmanagement/step1/StartAssessment.feature",
			
	//		征信  - 贷款评审
//			"src/test/resources/features/secondhandcarmanagement/step2/CustomerCredit.feature",
//			"src/test/resources/features/secondhandcarmanagement/step2/LoanReview.feature",
			
	//		二手车过户
//			"src/test/resources/features/secondhandcarmanagement/step3/StartTransfer.feature",
			
	
		
//		***************************************保险管理***************************************************
		
//		FOLDER
//		"src/test/resources/features/insurancemanagement",
		
//		首保登记
//		"src/test/resources/features/insurancemanagement/Step1/FirstMaintenance.feature",
		
//		续保管理
//		"src/test/resources/features/insurancemanagement/Step2/RenewalInsurance.feature",
		
		
		
//		***************************************贷中管理***************************************************	
		
		

		
		}, monochrome = true, format = {
        "pretty", "html:target/cucumber",
        "json:target/cucumber/test-report.json",
        "junit:target/cucumber/test-report.xml" })



public class UiRunCukesTest extends BaseDButil{
	
//	private static String TEST_DIR = DBExportImport.class.getResource("/").getPath();
//	
//	@BeforeClass
//	public static void backUpDb()throws Throwable{
//	    File file = new File(TEST_DIR + "backup.xml");  
//        Connection connection = BaseDButil.connect("clsAutoTest");  
//        String[] tableNames = new String[] { "customer_credit","customer_credit_relavant","business_object_process_info"};  
//        // 导出指定的表的数据到xml文件  
//        DBExportImport.exportTables(connection, tableNames, file); 
//        // 导出所有表的数据到xml文件  
////         exportAllTables(file, connection); 
//        // 将xml数据文件中的数据导入到数据库中  
////        DBExportImport.importData(file, connection); 
//}

}
