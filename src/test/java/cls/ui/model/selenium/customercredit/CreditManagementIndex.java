package cls.ui.model.selenium.customercredit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class CreditManagementIndex extends BaseWebDriver{

	@FindBy(name="customerName")
	private WebElement customerName;
	
	@FindBy(id="btn-search")
	private WebElement search_btn;
	
	public void enterCustomerName(String customerNameString)throws Throwable{
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_17");
		customerName.clear();
		customerName.sendKeys(customerNameString);
	}
	
	public void clickSearchButton()throws Throwable{
		search_btn.click();
		Thread.sleep(2000);
	}
	
	
	public boolean isCreidtPassed(String creditResultString)throws Throwable{
		WebElement creditResult = driver.findElement(By.xpath("//table[@id='table']/tbody/tr/td[7]"));
		if(!creditResult.getText().equals(creditResultString)){
			return false;
		}
		return true;
	}
	
	
}
