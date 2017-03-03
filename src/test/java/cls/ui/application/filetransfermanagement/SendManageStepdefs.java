package cls.ui.application.filetransfermanagement;

import java.net.IDN;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.selenium.webdriven.commands.Click;

import cls.ui.base.SpringContextHolder;
import cls.ui.dao.filetransfermanagement.FileTransferDao;
import cls.ui.dao.sendmanagement.SendManageDao;
import cls.ui.model.selenium.IndexPage;
import cls.ui.model.selenium.sendmanagement.SendCompanyIndex;
import cls.ui.model.selenium.sendmanagement.ExpressEnteringPage;
import cls.ui.model.selenium.sendmanagement.ReceiptBankIndex;
import cls.ui.model.selenium.sendmanagement.ReceiptCompanyIndex;
import cls.ui.model.selenium.sendmanagement.SendBankIndex;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author lxx  
 */

public class SendManageStepdefs {
	IndexPage indexPage = PageFactory.initElements(IndexPage.getWebDriver(), IndexPage.class);
	SendCompanyIndex sendCompanyIndex = PageFactory.initElements(SendCompanyIndex.getWebDriver(), SendCompanyIndex.class);
	ExpressEnteringPage expressEnteringPage = PageFactory.initElements(ExpressEnteringPage.getWebDriver(), ExpressEnteringPage.class);
	ReceiptBankIndex receiptBankIndex = PageFactory.initElements(ReceiptBankIndex.getWebDriver(), ReceiptBankIndex.class);
	SendBankIndex sendBankIndex = PageFactory.initElements(SendBankIndex.getWebDriver(), SendBankIndex.class);
	ReceiptCompanyIndex receiptCompanyIndex = PageFactory.initElements(ReceiptBankIndex.getWebDriver(), ReceiptCompanyIndex.class);
	
	FileTransferDao fileTransferDao = (FileTransferDao)SpringContextHolder.getBean(FileTransferDao.class);
	SendManageDao sendManageDao = (SendManageDao)SpringContextHolder.getBean(SendManageDao.class);
	
	@Given("^Login to system for Send Manage Company$")
	public void login(final List<Map<String, String>> args) throws Throwable {
		fileTransferDao = (FileTransferDao)SpringContextHolder.getBean(FileTransferDao.class);
		// Login to system
		indexPage.init();
		Assert.assertTrue(indexPage.isLoginSuccess());
		
		String idNumber = args.get(0).get("idNumber");
		
		List<String> projectIds = fileTransferDao.getProjectIdFromDb(idNumber);
		sendManageDao.deleteSqlWithOneParamter("sendmanagement", "SendManage", projectIds);
		sendManageDao.updateSqlWithOneParamter("sendmanagement", "SendManage", projectIds);
	}
	
	@Given("^Navigate to send manage company index$")
	public void navigateToSendManageCompanyIndex() throws Throwable {
		indexPage.clickFileTransferManagementPanel();
		indexPage.clickSendManagementForCompanyButton();
	}
	
	@And("^Find my client in index$")
	public void findClient(final List<Map<String, String>> args) throws Throwable {
		String customerName = args.get(0).get("customerName");
		sendCompanyIndex.enterCustomerName(customerName);
		sendCompanyIndex.clickSearchButton();
	}
	
	@And("^Click the add parcel button$")
	public void clickAddParcelButton() throws Throwable{
		sendCompanyIndex.clickAddParcelButton();
	}
	
	@When("^Click the add express button$")
	public void clickAddExpressButton() throws Throwable{
		sendCompanyIndex.clickAddExpressButton();
	}
	
	@Then("^Enter express info in expressEntering page$")
	public void enterExpressInfo(final List<Map<String, String>> args) throws Throwable{
		String expressCompany = args.get(0).get("expressCompany");
		String billNo = args.get(0).get("billNo");
		
		//选择快递公司
		expressEnteringPage.selectExpressCompany(expressCompany);
		//输入快递单号
		expressEnteringPage.enterBillNo(billNo);
		//选择发件时间
		expressEnteringPage.selectSendTime();
		//勾选合同资料
		expressEnteringPage.selectContractInfo();
		//勾选抵押资料
		expressEnteringPage.selectMortgageInfo();
	}
	
	@And("^Click submit button in expressEntering page$")
	public void clickSubmitButton() throws Throwable{
		expressEnteringPage.clickSendButton();
	}
	
	@Then("^Check if send express successfully$")
	public void checkIfSuccessfully(final List<Map<String, String>> args) throws Throwable{
		String customerName = args.get(0).get("customerName");
		String billNo = args.get(0).get("billNo");
		String expressCompany = args.get(0).get("expressCompany");
		String status = args.get(0).get("status");
		
		sendCompanyIndex.clickSendTab();
		sendCompanyIndex.enterCustomerName(customerName);
		sendCompanyIndex.clickSearchButton();
		Assert.assertTrue(sendCompanyIndex.equalsBillNo(billNo));
		Assert.assertTrue(sendCompanyIndex.equalsExpressCompany(expressCompany));
		Assert.assertTrue(sendCompanyIndex.equalsStatus(status));
	}
	
	@Given("^Navigate to receipt manage bank index$")
	public void navigateToReceiptManageBankIndex() throws Throwable{
		indexPage.switchToDefaultContent();
		indexPage.clickReceiptManagementForBankButton();
	}
	
	@When("^Find my client in receiptBank index$")
	public void findClientInReceiptBank(final List<Map<String, String>> args) throws Throwable{
		String customerName = args.get(0).get("customerName");
		
		receiptBankIndex.enterCustomerName(customerName);
		receiptBankIndex.clickSearchButton();
	}
	
	@And("^Click the receipt button in receiptBank Index$")
	public void clickReceiptBankButton() throws Throwable{
		receiptBankIndex.clickReceiptButton();
		receiptBankIndex.clickConfirmButton();
	}
	
	@Then("^Check if bank receipt successfully$")
	public void checkIfBankReceiptSuccessfully(final List<Map<String, String>> args) throws Throwable{
		String customerName = args.get(0).get("customerName");
		String billNo = args.get(0).get("billNo");
		String expressCompany = args.get(0).get("expressCompany");
		String status = args.get(0).get("status");
		
		indexPage.switchToDefaultContent();
		indexPage.clickSendManagementForCompanyButton();
		sendCompanyIndex.enterCustomerName(customerName);
		sendCompanyIndex.clickSearchButton();
		Assert.assertTrue(sendCompanyIndex.equalsBillNo(billNo));
		Assert.assertTrue(sendCompanyIndex.equalsExpressCompany(expressCompany));
		Assert.assertTrue(sendCompanyIndex.equalsStatus(status));
	}
	
	@Given("^Navigate to send manage bank index$")
	public void navigateToSendManageBankIndex() throws Throwable{
		indexPage.switchToDefaultContent();
		indexPage.clickSendManagementForBankButton();
	}
	
	@When("^Find my client in sendBank index$")
	public void findClientInSendBank(final List<Map<String, String>> args) throws Throwable{
		String customerName = args.get(0).get("customerName");
		
		sendBankIndex.enterCustomerName(customerName);
		sendBankIndex.clickSearchButton();
	}
	
	@And("^Click the add express button in send bank index$")
	public void clickAddExpressForBank() throws Throwable{
		sendBankIndex.selectData();
		sendBankIndex.clickAddExpress();
	}
	
	@Then("^Enter express info for send bank in expressEntering page$")
	public void enterExpressInfoForSendBank(final List<Map<String, String>> args) throws Throwable{
		String expressCompany = args.get(0).get("expressCompany");
		String billNo = args.get(0).get("billNo");
		
		//选择快递公司
		expressEnteringPage.selectExpressCompany(expressCompany);
		//输入快递单号
		expressEnteringPage.enterBillNo(billNo);
		//选择发件时间
		expressEnteringPage.selectSendTime();
		//勾选抵押合同
		expressEnteringPage.selectMortgageContract();
		//勾选还款卡
		expressEnteringPage.selectRepaymentCard();
		//勾选抵押委托书
		expressEnteringPage.selectMortgageProxy();
	}
	
	@Then("^Check if send bank express successfully$")
	public void checkIfSendBankExpressSuccessfully(final List<Map<String, String>> args) throws Throwable{
		String billNo = args.get(0).get("billNo");
		String expressCompany = args.get(0).get("expressCompany");
		String status = args.get(0).get("status");
		
		sendBankIndex.clickSendTab();
		sendBankIndex.enterBillNo(billNo);
		sendBankIndex.clickSearchButton();
		Assert.assertTrue(sendBankIndex.equalsBillNo(billNo));
		Assert.assertTrue(sendBankIndex.equalsExpressCompany(expressCompany));
		Assert.assertTrue(sendBankIndex.equalsStatus(status));
	}
	
	@Given("^Navigate to receipt manage company index$")
	public void navigateToReceiptManageCompanyIndex() throws Throwable{
		indexPage.switchToDefaultContent();
		indexPage.clickReceiptManagementForCompanyButton();
	}
	
	@When("^Find my client in receiptCompany index$")
	public void findClientInReceiptCompany(final List<Map<String, String>> args) throws Throwable{
		String customerName = args.get(0).get("customerName");
		
		receiptCompanyIndex.enterCustomerName(customerName);
		receiptCompanyIndex.clickSearchButton();
	}
	
	@And("^Click the receipt button in receiptCompany Index$")
	public void clickReceiptCompanyButton() throws Throwable{
		receiptCompanyIndex.clickReceiptButton();
		receiptCompanyIndex.clickConfirmButton();
	}
	
	@Then("^Check if company receipt successfully$")
	public void checkIfCompanyReceiptSuccessfully(final List<Map<String, String>> args) throws Throwable{
		String billNo = args.get(0).get("billNo");
		String expressCompany = args.get(0).get("expressCompany");
		String status = args.get(0).get("status");
		
		indexPage.switchToDefaultContent();
		indexPage.clickSendManagementForBankButton();
		sendBankIndex.enterBillNo(billNo);
		sendBankIndex.clickSearchButton();
		Assert.assertTrue(sendBankIndex.equalsBillNo(billNo));
		Assert.assertTrue(sendBankIndex.equalsExpressCompany(expressCompany));
		Assert.assertTrue(sendBankIndex.equalsStatus(status));
	}
}