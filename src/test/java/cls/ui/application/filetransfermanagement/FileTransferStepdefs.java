package cls.ui.application.filetransfermanagement;

import java.sql.DriverManager;
import java.util.List;
import java.util.Map;






import org.junit.Assert;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cls.ui.base.SpringContextHolder;
import cls.ui.dao.filetransfermanagement.FileTransferDao;
import cls.ui.model.selenium.IndexPage;
import cls.ui.model.selenium.filetransfer.CopyContractPage;
import cls.ui.model.selenium.filetransfer.FileTransferIndex;
import cls.ui.model.selenium.filetransfer.InfoReviewPage;
import cls.ui.model.selenium.filetransfer.StartFileTransferpage;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class FileTransferStepdefs {
	
	FileTransferDao fileTransferDao = (FileTransferDao)SpringContextHolder.getBean(FileTransferDao.class);
	IndexPage indexPage = PageFactory.initElements(IndexPage.getWebDriver(), IndexPage.class);
	FileTransferIndex fileTransferIndex = PageFactory.initElements(FileTransferIndex.getWebDriver(), FileTransferIndex.class);
	StartFileTransferpage startFileTransferpage = PageFactory.initElements(StartFileTransferpage.getWebDriver(), StartFileTransferpage.class);
	InfoReviewPage infoReviewPage = PageFactory.initElements(InfoReviewPage.getWebDriver(), InfoReviewPage.class);
	CopyContractPage copyContractPage = PageFactory.initElements(CopyContractPage.getWebDriver(), CopyContractPage.class);
	@Given("^Login to system for File Transfer$")
	public void login_to_system_for_File_Transfer(final List<Map<String, String>> args) throws Throwable {
		fileTransferDao = (FileTransferDao)SpringContextHolder.getBean(FileTransferDao.class);
		// Login to system
		indexPage.init();
		Assert.assertTrue(indexPage.isLoginSuccess());
		
		
		String idNumber = args.get(0).get("idNumber");
		List<String> projectIds = fileTransferDao.getProjectIdFromDb(idNumber);
//		还原文档传递数据至贷款评审时状态
		fileTransferDao.updateSqlWithOneParamter("filetransfermanagement", "FileTransfer", projectIds);
	}

	@And("^Click the submit button in infoReview page when document delivery$")
	public void clickSubmitButtonInInfoReviewPage() throws Throwable {
		Thread.sleep(3000);
		infoReviewPage.clickSubmitButton();
		infoReviewPage.clickConfirmButton();
	}
	
	@When("^Navigate to car info tab$")
	public void navigateToCarInfoTab() throws Throwable{
		Thread.sleep(3000);
		copyContractPage.clickCarInfoTab();
	}
	
	@Then("^Enter car info in carInfo tab$")
	public void enterCarInfo(final List<Map<String, String>> args) throws Throwable {
		String carFrameNo = args.get(0).get("carFrameNo");
		String carEngineNo = args.get(0).get("carEngineNo");
		String maxCapacity = args.get(0).get("maxCapacity");
		String billNo = args.get(0).get("billNo");
		
		copyContractPage.enterCarFrameNo(carFrameNo);
		copyContractPage.enterCarEngineNo(carEngineNo);
		copyContractPage.enterMaxCapacity(maxCapacity);
		copyContractPage.selectBillDate();
		copyContractPage.enterBillNo(billNo);
	}
	
	@And("^Click the save button in carInfo tab$")
	public void clickSaveInCarInfoButton() throws Throwable{
		copyContractPage.clickSaveCarInfoButton();
	}
	
	@When("^Navigate to customer info tab$")
	public void navigateToCustomerInfoTab() throws Throwable{
		Thread.sleep(3000);
		copyContractPage.clickCustomerInfoTab();
	}
	
	@Then("^Click the save button in customerInfo tab$")
	public void clickSaveCustomerInfoButton() throws Throwable{
		copyContractPage.clickSaveCustomerInfoButton();
	}
	
	@When("^Navigate to counter tab$")
	public void navigateToCounterTab() throws Throwable{
		Thread.sleep(3000);
		copyContractPage.clickCounterTab();
	}
	
	@Then("^Click the save button in counter tab$")
	public void clickSaveCounterButton() throws Throwable{
		copyContractPage.clickSaveCounterButton();
	}
	
	@When("^Navigate to basic info tab$")
	public void navigateToBasicInfoTab(){
		copyContractPage.clickBasicInfoTab();
	}
	
	@And("^Click the submit button in copyContract page when document delivery$")
	public void clickSubmitButtonInCopyContractPage() throws Throwable {
		copyContractPage.clickSubmitButton();
		copyContractPage.clickConfirmButton();
	}
	
	@Given("^Navigate to File Transfer Page$")
	public void navigate_to_File_Transfer_Page() throws Throwable {
		indexPage.clickFileTransferManagementPanel();
		indexPage.clickFileTransferButton();
	}

	@Given("^Navigate to Start File Transfer Page$")
	public void navigate_to_Start_File_Transfer_Page(final Map<String, String> args) throws Throwable {
		
		String customerNameString = args.get("customerName");

		//		进入文档传递编辑
		fileTransferIndex.enterCustomerName(customerNameString);
		fileTransferIndex.clickSearchButton();
		fileTransferIndex.clickOperationButton();
		fileTransferIndex.clickstartFlieTransferButton();
	}
	
	@When("^Add a file record in Start File Transfer Page$")
	public void add_a_file_record_in_Start_File_Transfer_Page() throws Throwable {
		startFileTransferpage.clickAddRecordButton();
	}

	@When("^Click the Submit button in Start File Transfer Page$")
	public void click_the_Submit_button_in_Start_File_Transfer_Page() throws Throwable {
		startFileTransferpage.clickSubmitButton();
	}

	@When("^Click the final confrim button in Start File Transfer Page$")
	public void click_the_final_confrim_button_in_Start_File_Transfer_Page() throws Throwable {
		startFileTransferpage.clickSureOptionButton();
	}
	
	@Then("^Check if file transfer successfully$")
	public void checkIfSuccessfully(final List<Map<String, String>> args) throws Throwable{
		String customerNameString = args.get(0).get("customerName");
		String currentNode = args.get(0).get("currentNode");
		
		indexPage.clickFileTransferManagementPanel();
		indexPage.clickFileTransferButton();
		
		fileTransferIndex.enterCustomerName(customerNameString);
		fileTransferIndex.clickAlreadyFileTransferTab();
		fileTransferIndex.clickSearchButton();
		Thread.sleep(2000);
		Assert.assertTrue(fileTransferIndex.equalsCurrentNode(currentNode));
	}

}
