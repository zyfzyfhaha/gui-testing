package cls.ui.application.secondhandcar;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import cls.ui.model.selenium.IndexPage;
import cls.ui.model.selenium.secondhandcarmanagement.AssessmentReportPage;
import cls.ui.model.selenium.secondhandcarmanagement.StartTransferPage;
import cls.ui.model.selenium.secondhandcarmanagement.TransferIndex;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StartTransferStepdefs{
	private IndexPage indexPage = PageFactory.initElements(IndexPage.getWebDriver(), IndexPage.class);
	private TransferIndex transferIndex = PageFactory.initElements(TransferIndex.getWebDriver(), TransferIndex.class);
	private StartTransferPage startTransferPage = PageFactory.initElements(StartTransferPage.getWebDriver(), StartTransferPage.class);
	private AssessmentReportPage assessmentReportPage = PageFactory.initElements(AssessmentReportPage.getWebDriver(), AssessmentReportPage.class);
	
	@Given("Login to system for testing Start Transfer")
	public void init()throws Throwable{
		// Login to system
		indexPage.init();
		Assert.assertTrue(indexPage.isLoginSuccess());
	}
	
	@Given("Navigate to TransferIndex page")
	public void navigateToTransferIndex() throws Throwable{
		indexPage.clickSecondHandCarManagementPanel();
		indexPage.clickSecondHandCarTransferButton();
	}
	
	@And("Navigate to Start Transfer Page")
	public void navigateToStartTransferPage(final List<Map<String, String>> args) throws Throwable {
		transferIndex.init();
		
		//输入身份证号
		String cardNo = args.get(0).get("cardNo");
		transferIndex.enterCardNo(cardNo);
		transferIndex.clickSearchButton();
		
		//点击发起过户
		transferIndex.clickTransferButton();
	}
	
	@Then("Enter Detail In Transfer Page")
	public void enterDetailInTransfePage(final List<Map<String, String>> args) throws Throwable {
		startTransferPage.init();
		
		//选择过户日期
		startTransferPage.enterTransferDate();
		
		//输入备注
		String commit = args.get(0).get("commit");
		startTransferPage.enterCommit(commit);
	}
	
	@And("^Click Submit button In Transfer Page$")
	public void clickSubmitButton() throws Throwable{
		startTransferPage.clickSubmitButton();
		startTransferPage.clickConfirmButton();
	}
	
	@Then("Check if secondhand car transfer successfully")
	public void checkIfSuccessfully(final List<Map<String, String>> args) throws Throwable {
		indexPage.refreshPage();
		//打开二手车过户页面
		indexPage.clickSecondHandCarManagementPanel();
		indexPage.clickSecondHandCarTransferButton();
		
		String customerName = args.get(0).get("customerName");
		String cardNo = args.get(0).get("cardNo");
		String result = args.get(0).get("result");
		
		//查询对应二手车
		transferIndex.init();
		transferIndex.clickTransferedTab();
		transferIndex.enterCustomerName(customerName);
		transferIndex.enterCardNo(cardNo);
		transferIndex.clickSearchButton();
		
		//检查过户状态
		Assert.assertTrue(transferIndex.isReusltPassed(result));
		
		indexPage.quit();
	}
	
	@When("^Click the submit button in assessment report page$")
	public void clickSubmitButtonInAssessmentReport() throws Throwable{
		assessmentReportPage.switchDriver();
		assessmentReportPage.clickSubmitButton();
		assessmentReportPage.clickConfirmYesButton();
	}
}