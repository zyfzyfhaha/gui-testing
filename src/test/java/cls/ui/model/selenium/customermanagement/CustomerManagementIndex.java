package cls.ui.model.selenium.customermanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class CustomerManagementIndex extends BaseWebDriver{
	
//	输入客户名称
	@FindBy(xpath="/html/body/div[1]/div/div/div[1]/div/form/div[1]/div[1]/div/input")
	private WebElement customerName_textbox;
	
//	查询按钮
	@FindBy(xpath="//*[@id='btn-search']")
	private WebElement search_btn;
	
//  客户名称
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr/td[1]")
	private WebElement customerName;
	
//	证件号码
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr/td[3]")
	private WebElement idNumber;
	
	
	public void enterCustomerName(String customerName)throws Throwable{
		Thread.sleep(3000);
		driver.switchTo().frame("iframe_14");
		customerName_textbox.clear();
		customerName_textbox.sendKeys(customerName);
	}
	
	public void clickSearchButton()throws Throwable{
//		new WebDriverWait(driver, 5 ).until(
//		         ExpectedConditions.presenceOfElementLocated(By.id("btn-search")));
		Thread.sleep(3000);
		search_btn.click();
	}
	
	public Boolean isCustomerNameExist(String customerNameString)throws Throwable{
		Thread.sleep(3000);
		String a = customerName.getText();
		if (!a.equals(customerNameString)) {
			return false;
		}
		return true;
	}
	
	public Boolean isIdNumberexist(String idNumberString)throws Throwable{
		Thread.sleep(3000);
		if(!idNumber.getText().equals(idNumberString)){
			return false;
		}
		return true;
	}
	
	
}
