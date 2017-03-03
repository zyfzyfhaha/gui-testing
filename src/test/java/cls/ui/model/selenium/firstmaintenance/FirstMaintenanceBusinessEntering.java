package cls.ui.model.selenium.firstmaintenance;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class FirstMaintenanceBusinessEntering extends BaseWebDriver{
	
//	录入按钮
	@FindBy(xpath="//*[@id='editInsurance']/a")
	private WebElement businessEntering_btn;
	
//	保单号
	@FindBy(xpath="//*[@id='table']/tbody/tr/td[1]")
	private WebElement insuranceNo;
	
//	保险公司
	@FindBy(xpath="//*[@id='table']/tbody/tr/td[2]")
	private WebElement insuranceCompany;
	
//	保险类型
	@FindBy(xpath="//*[@id='table']/tbody/tr/td[3]")
	private WebElement insuranceType;
	
//	保险开始日期
	@FindBy(xpath="//*[@id='table']/tbody/tr/td[4]")
	private WebElement insuranceStartDate;
	
//	保险结束日期
	@FindBy(xpath="//*[@id='table']/tbody/tr/td[5]")
	private WebElement insuranceEndDate;
	
//	保费合计
	@FindBy(xpath="//*[@id='table']/tbody/tr/td[6]")
	private WebElement insuranceFee;
	
//	保险状态
	@FindBy(xpath="//*[@id='table']/tbody/tr/td[7]")
	private WebElement insuranceStatus;
	
//	登记人
	@FindBy(xpath="//*[@id='table']/tbody/tr/td[8]")
	private WebElement registrant;
	
	public void clickBusinessEnteringButton()throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		businessEntering_btn.click();
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
	
//	刷新页面
	public void refreshPage()throws Throwable{
		Thread.sleep(2000);
		refreshPage();
		
	}
	
}
