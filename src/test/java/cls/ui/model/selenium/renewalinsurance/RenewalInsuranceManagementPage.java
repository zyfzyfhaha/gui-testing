package cls.ui.model.selenium.renewalinsurance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class RenewalInsuranceManagementPage extends BaseWebDriver{
	
//	客户名称
	@FindBy(name="customerName")
	private WebElement customerName_textBox;
	
//	开始日期
	@FindBy(name="startTime")
	private WebElement startTime_textBox;
	
//	结束日期
	@FindBy(name="endTime")
	private WebElement endTime_textBox;
	
//	搜索按钮
	@FindBy(id="btn-search")
	private WebElement search_btn;
	
//	@操作按钮
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/table/tbody/tr/td[15]/div/button")
	private WebElement operation_btn;
	
//	@保单管理
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/table/tbody/tr/td[15]/div/ul/li[1]/a")
	private WebElement insuranceManagement_btn;
	
//	输入客户名称， 除去日期
	public void enterCustomerName(String customerNameString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_11019");
		customerName_textBox.clear();
		customerName_textBox.sendKeys(customerNameString);
		startTime_textBox.clear();
		endTime_textBox.clear();
	}
	
//	点击搜索按钮
	public void clickSearchButton()throws Throwable{
		search_btn.click();
	}

//	点击操作按钮并进入保单管理页面
	public void enterInsruanceManagementPage()throws Throwable{
		Thread.sleep(2000);
		operation_btn.click();
		insuranceManagement_btn.click();
	}
	
}
