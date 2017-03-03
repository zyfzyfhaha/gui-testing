package cls.ui.model.selenium.registration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class RegistrationIndex extends BaseWebDriver{

//	客户名称
	@FindBy(name="customerName")
	private WebElement customerName_textBox;
	
//	搜索按钮
	@FindBy(id="btn-search")
	private WebElement search_btn;
	
//	上班录入按钮
	@FindBy(xpath="/html/body/div/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/table/tbody/tr/td[11]/div")
	private WebElement operation_btn;
	
//	输入客户名称
	public void enterCustomerName(String customerNameString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_28");
		customerName_textBox.clear();
		customerName_textBox.sendKeys(customerNameString);
	}
	
//	点击搜索按钮
	public void clickSearchButton()throws Throwable{
		search_btn.click();
	}
	
	
//	点击上牌录入按钮
	public void clickOperationButton()throws Throwable{
		Thread.sleep(2000);
		operation_btn.click();
	}
	
	
	
}
