package cls.ui.model.selenium.renewalinsurance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author zyf
 * @Email zhuyunfeng@zafh.com.cn
 */

public class InsuranceDetailsPage extends BaseWebDriver {

	// 保单录入按钮
	@FindBy(id = "btn-search")
	private WebElement enterBusiness_btn;

	// 保单号
	@FindBy(xpath = "//*[@id='table1']/tbody/tr[1]/td[3]")
	private WebElement insuranceNo;

	// 保险公司
	@FindBy(xpath = "//*[@id='table1']/tbody/tr[1]/td[4]")
	private WebElement insuranceCompany;

	// 保险类型
	@FindBy(xpath = "//*[@id='table1']/tbody/tr[1]/td[5]")
	private WebElement insuranceType;

	// 保险开始日期
	@FindBy(xpath = "//*[@id='table1']/tbody/tr[1]/td[6]")
	private WebElement insuranceStartDate;

	// 保险结束日期
	@FindBy(xpath = "//*[@id='table1']/tbody/tr[1]/td[7]")
	private WebElement insuranceEndDate;

	// 保费合计
	@FindBy(xpath = "//*[@id='table1']/tbody/tr[1]/td[8]")
	private WebElement insuranceFee;

	// 保险状态
	@FindBy(xpath = "//*[@id='table1']/tbody/tr[1]/td[9]")
	private WebElement insuranceStatus;

	// 登记人
	@FindBy(xpath = "//*[@id='table1']/tbody/tr[1]/td[10]")
	private WebElement registrant;
	
	//	核销状态
	@FindBy(xpath = "//*[@id='table1']/tbody/tr[1]/td[11]")
	private WebElement varificationStatus;
	
	//	是否首保
	@FindBy(xpath = "//*[@id='table1']/tbody/tr[1]/td[12]")
	private WebElement isFirstmaintenance;
	
	// 点击保单录入按钮
	public void clickEnterBusinessButton() throws Throwable {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		enterBusiness_btn.click();
	}
	
//	对比保单号
	public boolean compareInsuranceNo(String insuranceNoString)throws  Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		if(insuranceNoString.equals(insuranceNo.getText())){
			return true;
		}
		else {
			return false;
		}
		
	}
	
//	对比保险公司
	public boolean compareInsuranceCompany(String insuranceCompanyString)throws  Throwable{
		if(insuranceCompanyString.equals(insuranceCompany.getText())){
			return true;
		}
		else {
			return false;
		}
		
	}

//	对比保险类型
	public boolean compareInsuranceType(String insuranceTypeString)throws  Throwable{
		if(insuranceTypeString.equals(insuranceType.getText())){
			return true;
		}
		else {
			return false;
		}
	}
	
//	对比保单开始日期
	public boolean compareInsuranceStartDate(String insuranceStartDateString)throws  Throwable{
		if(insuranceStartDateString.equals(insuranceStartDate.getText())){
			return true;
		}
		else {
			return false;
		}
	}
	
//	对比结束日期
	public boolean compareInsuranceEndDate(String insuranceEndDateString)throws  Throwable{
		if(insuranceEndDateString.equals(insuranceEndDate.getText())){
			return true;
		}
		else {
			return false;
		}
	}
	
//	对比保费
	public boolean compareInsuranceFee(String insuranceFeeString)throws  Throwable{
		if(insuranceFeeString.equals(insuranceFee.getText())){
			return true;
		}
		else {
			return false;
		}
	}
	
//	对比保险状态
	public boolean compareInsuranceStatus(String insuranceStatusString)throws  Throwable{
		if(insuranceStatusString.equals(insuranceStatus.getText())){
			return true;
		}
		else {
			return false;
		}
	}
	
//	对比登记人
	public boolean compareRegistrant(String registrantString)throws  Throwable{
		if(registrantString.equals(registrant.getText())){
			return true;
		}
		else {
			return false;
		}
	}
	
//	对比核销状态
	public boolean compareVarificationStatus(String verificationStatusString)throws  Throwable{
		if(verificationStatusString.equals(varificationStatus.getText())){
			return true;
		}
		else {
			return false;
		}
	}
	
//	对比是否首保
	public boolean compareIsFirstMaintenance(String isFirstMaintenanceString)throws  Throwable{
		if(isFirstMaintenanceString.equals(isFirstmaintenance.getText())){
			return true;
		}
		else {
			return false;
		}
	}

}
