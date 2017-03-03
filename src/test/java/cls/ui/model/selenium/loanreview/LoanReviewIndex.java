package cls.ui.model.selenium.loanreview;

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

public class LoanReviewIndex extends BaseWebDriver{
	
	//	客户名称
	@FindBy(xpath="/html/body/div[1]/div/div/div[1]/div/form/div[1]/div[1]/div/input")
	public WebElement customerName_textbox;
	
	//	搜索按钮
	@FindBy(xpath="//*[@id='btn-search']")
	public WebElement search_btn;
	
	// 发起贷款按钮	
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr/td[10]/button")
	public WebElement operation_btn;
	
	

	public void enterCustomerName(String customerNameString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_18");
		customerName_textbox.clear();
		customerName_textbox.sendKeys(customerNameString);
	}

	public void clickSearchButton()throws Throwable{
		new WebDriverWait(driver, 5 ).until(
			     ExpectedConditions.presenceOfElementLocated(By.id("btn-search")));
		search_btn.click();
	}
	
	public void clickOperationButton()throws Throwable{
		Thread.sleep(2000);
		operation_btn.click();
	}
	
	

}
