package cls.ui.model.selenium.loancancel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class LoanCancelIndex extends BaseWebDriver{
//	客户名称
	@FindBy(name="customerName")
	private WebElement customerName_TextBox;
	
//	搜索按钮
	@FindBy(id="btn-search")
	private WebElement search_btn;
	
//	操作按钮
	@FindBy(xpath="/html/body/div/div/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr/td[9]/button")
	private WebElement operation_btn;
	
//	输入客户名称
	public void enterCustomerName(String customerNameString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_21");
		customerName_TextBox.clear();
		customerName_TextBox.sendKeys(customerNameString);
	}
	
//	点击搜索按钮
	public void clickSearchButton()throws Throwable{
		Thread.sleep(2000);
		search_btn.click();
	}
	
//	点击操作按钮
	public void clickOperationButton()throws Throwable{
		Thread.sleep(2000);
		operation_btn.click();
	}
	
	
}
