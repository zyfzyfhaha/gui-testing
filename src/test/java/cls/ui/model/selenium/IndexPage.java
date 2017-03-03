package cls.ui.model.selenium;


import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.steadystate.css.util.ThrowCssExceptionErrorHandler;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class IndexPage extends BaseWebDriver {

//我的任务按钮
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[2]/a/span[1]")
private WebElement myTask_Panel;

//我的任务 - 我的任务按钮
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[2]/ul/li/a")
private WebElement myTask_Btn;

//客户名称输入框
@FindBy(name="cname")
private WebElement customerName_Textbox;

//贷款编号输入框
@FindBy(name="bNum")
private WebElement loanNum_Textbox;

//搜索按钮
@FindBy(id="btn-search")
private WebElement search_btn;

//征信录入按钮
@FindBy(className="taskType")
private WebElement operation_btn;

//贷前管理按钮	
@FindBy(xpath="//span[contains(text(),'贷前管理')]")
private WebElement ManagementBeforeCredit_panel;

//贷前管理 - 资信管理按钮
@FindBy(xpath="//a[contains(text(),'资信管理')]")
private WebElement CreditManagement_btn;

//贷前管理 - 贷款评审
@FindBy(xpath="//*[@id='side-menu']/li[5]/ul/li[2]/a")
private WebElement loanReview_btn;

//贷前管理 - 贷款修改
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[5]/ul/li[3]/a")
private WebElement loanModify_btn;

//贷前管理-贷款查询
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[5]/ul/li[5]/a")
private WebElement loanInquireBtn;

//贷款管理-贷款作废
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[5]/ul/li[4]/a")
private WebElement loanCancel_btn;

//发起征信按钮
@FindBy(id="launchedCredit")
private WebElement launchCredit_btn;

//客户管理按钮
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[3]/a/span[1]")
private WebElement customerManagement_panel;

//客户管理 - 客户管理按钮
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[3]/ul/li[1]/a")
private WebElement customerManagement_btn;

//车商管理按钮
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[4]/a")
private WebElement carDealerManage_panel;

//车商管理-车商管理按钮
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[4]/ul/li[1]/a")
private WebElement carDealerManage_btn;

//车商管理-车商订单管理按钮
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[4]/ul/li[2]/a")
private WebElement carDealerOrder_btn;

//注销按钮
@FindBy(xpath="/html/body/div[2]/div[2]/div[1]/div[1]/nav/div[2]/div/ul/li[4]/span")
private WebElement logout_btn;

//确认退出按钮
@FindBy(id="exitSure")
private WebElement exitSure_btn;

//文档传递管理panel
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[7]/a/span[1]")
private WebElement fileTransferManagement_panel;

//文档传递按钮
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[7]/ul/li[1]/a")
private WebElement fileTransfer_btn;

//发件管理(公司)
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[7]/ul/li[2]/a")
private WebElement sendManagementForCompany_btn;

//发件管理(银行)
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[7]/ul/li[3]/a")
private WebElement sendManagementForBank_btn;

//文档归档
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[7]/ul/li[4]/a")
private WebElement documentFileAway_btn;

//收件管理(公司)
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[7]/ul/li[5]/a")
private WebElement receiptManagementForCompany_btn;

//收件管理(银行)
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[7]/ul/li[6]/a")
private WebElement receiptManagementForBank_btn;

//二手车管理
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[8]/a")
private WebElement secondHandCarManagement_pannel;

//二手车管理-二手车评估
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[8]/ul/li[1]/a")
private WebElement secondHandCarAssessment_btn;

//二手车管理-二手车过户
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[8]/ul/li[2]/a")
private WebElement secondHandCarTransfer_btn;

//保险管理Panel
@FindBy(xpath="//*[@id='side-menu']/li[9]/a/span[1]")
private WebElement insurance_panel;

//首保登记
@FindBy(xpath="//*[@id='side-menu']/li[9]/ul/li[1]/a")
private WebElement first_maintenance_btn;


//续保管理
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[9]/ul/li[2]/a")
private WebElement renewalInsurance_panel;


//贷中管理
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[6]/a/span[1]")
private WebElement inLoanManagement_panel;

//贷中管理 - 上牌登记
@FindBy(xpath="/html/body/div[2]/nav/div[2]/div[1]/ul/li[6]/ul/li[1]/a")
private WebElement registration_btn;



//点击贷中管理按钮
public void clickInLoanPanel()throws Throwable{
	Thread.sleep(2000);
	inLoanManagement_panel.click();
}

//点击上牌登记按钮
public void clickRegistrationButton()throws Throwable{
	Thread.sleep(2000);
	registration_btn.click();
}


//点击贷前管理按钮
public void clickManagementBeforeCreditPanel()throws Throwable{
	refreshPage();
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	ManagementBeforeCredit_panel.click();
}

//点击贷前管理 - 资信管理按钮
public void clickCreditManagementButton()throws Throwable{
	Thread.sleep(2000);
	CreditManagement_btn.click();
}



//进入发起征信页面
public void navigateToLaunchCreditPage()throws Throwable{
	driver.switchTo().frame("iframe_17");
	new WebDriverWait(driver, 5 ).until(
		     ExpectedConditions.presenceOfElementLocated(By.id("launchedCredit")));
	launchCredit_btn.click();
}

//点击我的任务
public void clickMyTaskPanel()throws Throwable{
	Thread.sleep(2000);
	refreshPage();
	driver.switchTo().defaultContent();
	myTask_Panel.click();
	Thread.sleep(1000);
}

//点击我的任务按钮
public void clickMyTaskButton()throws Throwable{
	myTask_Btn.click();
}

//点击客户管理按钮
public void clickCustomerManagementPanel()throws Throwable{
	Thread.sleep(3000);
	refreshPage();
	driver.switchTo().defaultContent();
	customerManagement_panel.click();
}

//点击客户管理-客户管理按钮
public void clickCustomerManageMentButton()throws Throwable{
	Thread.sleep(3000);
	customerManagement_btn.click();
	
}

//输入客户名称
public void enterCustomerName(String customerNameString)throws Throwable{
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("iframe_12");
	customerName_Textbox.clear();
	customerName_Textbox.sendKeys(customerNameString);
}

//选择流程名称
public void selectProcessName(String processNameString)throws Throwable{
	WebElement ftCode = driver.findElement(By.id("ftCode"));
	Select mySelect = new Select(ftCode);
	mySelect.selectByVisibleText(processNameString);
}

//点击查询按钮
public void clickSearchButton()throws Throwable{
	Thread.sleep(2000);
	search_btn.click();
}

//点击业务操作按钮
public void clickOperationButton()throws Throwable{
	Thread.sleep(2000);
	operation_btn.click();
}

//refresh page
public void refreshPage()throws Throwable{
	driver.navigate().refresh();
}

//点击车商管理
public void clickCarDealerManagePanel()throws Throwable{
	carDealerManage_panel.click();
	Thread.sleep(1000);
}


//点击车商管理-车商管理
public void clickCarDealerManageButton()throws Throwable{
	carDealerManage_btn.click();
	Thread.sleep(2000);
}


// 点击贷款评审按钮
public void clickLoanReviewButton()throws Throwable{
	Thread.sleep(2000);
	loanReview_btn.click();
}

// 注销
public void logout()throws Throwable{
	refreshPage();
	Thread.sleep(1000);
	logout_btn.click();
	Thread.sleep(1000);
	exitSure_btn.click();
}

//点击车商管理-车商订单管理
public void clickCarDealerOrderButton()throws Throwable{
	carDealerOrder_btn.click();
}
// 点击文档传递管理
public void clickFileTransferManagementPanel()throws Throwable{
	Thread.sleep(2000);
	fileTransferManagement_panel.click();
	Thread.sleep(1000);
}

//点击文档传递按钮
public void clickFileTransferButton()throws Throwable{
	Thread.sleep(1000);
	fileTransfer_btn.click();
}

//点击发件管理(公司)
public void clickSendManagementForCompanyButton() throws Throwable {
	sendManagementForCompany_btn.click();
	Thread.sleep(3000);
}

//点击发件管理(银行)
public void clickSendManagementForBankButton() throws Throwable {

	sendManagementForBank_btn.click();
	Thread.sleep(2000);
}

//点击文档归档
public void clickDocumentFileAwayButton() throws Throwable {
	documentFileAway_btn.click();
	Thread.sleep(2000);
}

//点击收件管理(公司)
public void clickReceiptManagementForCompanyButton() throws Throwable {
	receiptManagementForCompany_btn.click();
	Thread.sleep(2000);
}

//点击收件管理(银行)
public void clickReceiptManagementForBankButton() throws Throwable {
	receiptManagementForBank_btn.click();
	Thread.sleep(2000);
}

//点击贷前管理-贷款修改
public void clickLoanModifyButton() throws Throwable{
	Thread.sleep(2000);
	loanModify_btn.click();
}

//点击贷前管理-贷款查询
public void clickLoanInquireButton(){
	loanInquireBtn.click();
}

//点击贷前管理-贷款作废按钮
public void clickLoanCancelButton()throws Throwable{
	Thread.sleep(2000);
	loanCancel_btn.click();
}

//点击二手车管理
public void clickSecondHandCarManagementPanel() throws Throwable {
	secondHandCarManagement_pannel.click();
	Thread.sleep(1000);
}

//点击二手车管理-二手车评估
public void clickSecondHandCarAssessmentButton() throws Throwable {
	secondHandCarAssessment_btn.click();
	Thread.sleep(2000);
}

//点击二手车管理-二手车过户
public void clickSecondHandCarTransferButton() throws Throwable {
	secondHandCarTransfer_btn.click();
	Thread.sleep(2000);
}

//输入贷款编号
public void enterLoanNum(String loanNum)throws Throwable{
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("iframe_12");
	loanNum_Textbox.clear();
	loanNum_Textbox.sendKeys(loanNum);
}


//点击首保登记
public void clickFirstMaintenance()throws Throwable{
	Thread.sleep(2000);
	insurance_panel.click();
	Thread.sleep(1000);
	first_maintenance_btn.click();
}

//点击续保管理
public void clickRenewalInsurancemanagement()throws Throwable{
	Thread.sleep(2000);
	insurance_panel.click();
	Thread.sleep(1000);
	renewalInsurance_panel.click();
}

//切换driver
public void switchToDefaultContent() {
	driver.switchTo().defaultContent();
}

}

