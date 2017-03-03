package cls.ui.application.beforeloan;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cls.ui.base.SpringContextHolder;
import cls.ui.dao.beforeloan.CustomerCreditDao;
import cls.ui.model.selenium.IndexPage;
import cls.ui.model.selenium.customercredit.AcceptCreditPage;
import cls.ui.model.selenium.customercredit.CreditManagementIndex;
import cls.ui.model.selenium.customercredit.EnterCreidtPage;
import cls.ui.model.selenium.customercredit.LaunchCreditPage;
import cls.ui.model.selenium.customermanagement.CustomerManagementIndex;

/**
 * 
 * @author zyf
 * @Email zhuyunfeng@zafh.com.cn
 */

public class CustomerCreditStepdefs {

	private CustomerCreditDao customerCreditDao;
	private IndexPage indexPage = PageFactory.initElements(IndexPage.getWebDriver(), IndexPage.class);
	private LaunchCreditPage launchCreditPage = PageFactory.initElements(LaunchCreditPage.getWebDriver(), LaunchCreditPage.class);
	private EnterCreidtPage enterCreidtPage = PageFactory.initElements(EnterCreidtPage.getWebDriver(), EnterCreidtPage.class);
	private AcceptCreditPage acceptCreidtPage = PageFactory.initElements(AcceptCreditPage.getWebDriver(), AcceptCreditPage.class);
	private CustomerManagementIndex customerManagementIndex = PageFactory.initElements(CustomerManagementIndex.getWebDriver(), CustomerManagementIndex.class);
	private CreditManagementIndex creditManagementIndex = PageFactory.initElements(CreditManagementIndex.getWebDriver(), CreditManagementIndex.class);
	@Given("Login to system for testing CustomerCreidt")
	public void inti(
			final List<Map<String, String>> args) throws Throwable {
		customerCreditDao = (CustomerCreditDao)SpringContextHolder.getBean(CustomerCreditDao.class);
		// Login to system
		indexPage.init();
		Assert.assertTrue(indexPage.isLoginSuccess());
		
		// delete test data
		String cardNum = args.get(0).get("cardNum");
		List<String> cardNumList=Arrays.asList(cardNum);
		customerCreditDao.deleteSqlWithOneParamter("beforeloanmanagement", "CustomerCredit", cardNumList);
		
	}

	@Given("Navigate to Manage Customer Credit page")
	public void navigateToCustomerCreditPage() throws Throwable {
		indexPage.clickManagementBeforeCreditPanel();
		indexPage.clickCreditManagementButton();
	}

	@And("Navigate to LaunchCredit page")
	public void navigateToLaunchCreditPage() throws Throwable {
		indexPage.navigateToLaunchCreditPage();
	}

	@And("Enter customer details in LaunchCredit page")
	public void enterCustomerDetailsInLaunchCreditPage(
			final List<Map<String, String>> args) throws Throwable {

		// 输入客户名称
		String customerNameString = args.get(0).get("customerName");
		launchCreditPage.enterCustomerName(customerNameString);

		// 选择证件类型
		String customerIdentifyString = args.get(0).get("customerIdentify");
		launchCreditPage.selectCustomerIdentify(customerIdentifyString);

		// 输入证件号码
		String idNo = args.get(0).get("idNumber");
		launchCreditPage.enterIdNumber(idNo);

		// 选择婚姻状况
		String maritalStatusString = args.get(0).get("maritalStatus");
		launchCreditPage.selectMaritalStatus(maritalStatusString);

		// 选择调查银行
		String bankString = args.get(0).get("bank");
		launchCreditPage.selectBank(bankString);

		// 输入手机号
		String phoneNumberString = args.get(0).get("phoneNumber");
		launchCreditPage.enterPhoneNumber(phoneNumberString);

		// 上传文件
		launchCreditPage.uploadFiles();

		// 添加担保人
		launchCreditPage.clickAddPartyButton();

		// 输入担保人姓名
		String guaranteeNameString = args.get(0).get("guaranteeName");
		launchCreditPage.enterGuaranteeName(guaranteeNameString);

		// 选择担保人证件类型
		String guaranteeIdentifyString = args.get(0).get("guaranteeCardType");
		launchCreditPage.selectGuaranteeIdentify(guaranteeIdentifyString);

		// 输入担保人身份证号
		String guaranteeIdNumString = args.get(0).get("guaranteeIdNum");
		launchCreditPage.enterGuaranteeIdNumber(guaranteeIdNumString);
		
		// 输入担保人手机号
		String guaranteePhoneNumString = args.get(0).get("guaranteePhoneNum");
		launchCreditPage.enterGuaranteePhoneNumber(guaranteePhoneNumString);
		
		// 选择借款人关系
		String relationshipString = args.get(0).get("relationship");
		launchCreditPage.selectRelationship(relationshipString);
		
		// 选择担保关系
		String guaranteeRelationshipString = args.get(0).get("guaranteeRelationship");
		launchCreditPage.selectGuaranteeRelationship(guaranteeRelationshipString);
	}
	
	@When("^Click the submit button$")
	public void clickSubmitButton()throws Throwable{
		//点击提交按钮
		launchCreditPage.clickSubmitButton();
	}
	
	@Then("^Click the confirm YES button$")
	public void clickConfirmYesButton()throws Throwable{
//		点击Yes按钮
		launchCreditPage.clickConfirmYesButton();
	}
	
	@And("^Select a submitter$")
	public void selectSubmitter(List<Map<String, String>> args)throws Throwable{
//		选择提交人
		String submitterString = args.get(0).get("submmiter");
		launchCreditPage.selectSubmitter(submitterString);
	}
	
	@And("^Click the Final Confirm button$")
	public void clickConfirmButton()throws Throwable{
//		点击最后确认按钮
		launchCreditPage.clickFinalConfirmButton();
		
//		customerCreditDao.deleteSql("CustomerCredit", "CustomerCredit");
	}

	@Given("^Click My Task panel$")
	public void clickMyTaskPanel()throws Throwable{
//		点击我的任务
		indexPage.clickMyTaskPanel();
	}
	
	@And("^Click My Task button$")
	public void clickMyTaskButton()throws Throwable{
//		点击我的任务 - 我的任务
		indexPage.clickMyTaskButton();
	}
	
	@And("^Find my client$")
	public void findMyClient(List<Map<String, String>> args)throws Throwable{
//		输入客户名称 点击查询
		String customerNameString = args.get(0).get("customerName");
		String processNameString = args.get(0).get("processName");
		indexPage.enterCustomerName(customerNameString);
		indexPage.selectProcessName(processNameString);
		indexPage.clickSearchButton();
	}
	
	@And("^Click the operation button$")
	public void click_the_operation_Start_Credit() throws Throwable {
//		点击征信录入按钮
		indexPage.clickOperationButton();
	}
	
	@Given("^Enter details in EnterCredit page$")
	public void enter_details_in_EnterCredit_page(List<Map<String, String>> args) throws Throwable{
//		选择客户调查方式
		String customerResearchTypeString = args.get(0).get("customerResearchType");
		enterCreidtPage.selectCustomerResearchBank(customerResearchTypeString);
		
//		选择客户调查结果
		String customerResearchResultString = args.get(0).get("customerResearchResult");
		enterCreidtPage.selectCustomerResearchResult(customerResearchResultString);
		
//		输入客户调查日期
		enterCreidtPage.enterResearchDateForBorrower();
		
//		输入客户备注
		String customerRemarkString = args.get(0).get("customerRemark");
		enterCreidtPage.enterCustomerRemark(customerRemarkString);
		
//		选择担保人调查方式
		String relavantResearchTypeString = args.get(0).get("relavantResearchType");
		enterCreidtPage.selectRelavantResearchBank(relavantResearchTypeString);
		
//		选择担保人调查结果
		String relavantResearchResult = args.get(0).get("relavantResearchResult");
		enterCreidtPage.selectRelavantResearchResult(relavantResearchResult);

//		输入担保人调查日期
		enterCreidtPage.enterResearchDateForRelationship();
		
//		输入担保人备注
		String relavantRemarkString = args.get(0).get("relavantRemark");
		enterCreidtPage.enterRelavantRemark(relavantRemarkString);
	}
	
	
	@Then("^Check if customer credit successfully$")
	public void Check_if_customer_credit_successfully(final List<Map<String, String>> args)throws Throwable{
		String customerNameString = args.get(0).get("customerName");
		String idNumberString = args.get(0).get("idNumber");
		String creditResultString =args.get(0).get("creditResult");
		
//		Check the customer management
		indexPage.clickCustomerManagementPanel();
		indexPage.clickCustomerManageMentButton();
		customerManagementIndex.enterCustomerName(customerNameString);
		customerManagementIndex.clickSearchButton();
		Assert.assertTrue(customerManagementIndex.isCustomerNameExist(customerNameString));
		Assert.assertTrue(customerManagementIndex.isIdNumberexist(idNumberString));

//		Check the credit management
		indexPage.clickManagementBeforeCreditPanel();
		indexPage.clickCreditManagementButton();
		creditManagementIndex.enterCustomerName(customerNameString);
		creditManagementIndex.clickSearchButton();
		Assert.assertTrue(creditManagementIndex.isCreidtPassed(creditResultString));
		indexPage.quit();
	}
	
	
	
	
}
