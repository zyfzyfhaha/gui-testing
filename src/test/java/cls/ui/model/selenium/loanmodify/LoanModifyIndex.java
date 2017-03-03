package cls.ui.model.selenium.loanmodify;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class LoanModifyIndex extends BaseWebDriver{
	
//	 客户名称
	@FindBy(name="customerName")
	private WebElement customerName_textBox;
	
//  查询按钮
	@FindBy(id="btn-search")
	private WebElement search_btn;
	
//	操作按钮
	@FindBy(xpath="//table[@id='table']/tbody/tr/td[9]/button")
	private WebElement operation_btn;
	
//	搜索指定客户
	public void selectSpecificCustomer(String customerNameString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_20");
		customerName_textBox.clear();
		customerName_textBox.sendKeys(customerNameString);
		search_btn.click();
	}
	
//	点击操作按钮
	public void clickOperationButton()throws Throwable{
		Thread.sleep(2000);
		operation_btn.click();
	}
	

	
	
	
	

}
