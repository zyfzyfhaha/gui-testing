package cls.ui.model.selenium.sendmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author lxx  
 */

public class ReceiptBankIndex extends BaseWebDriver{
	//输入客户名称
	public void enterCustomerName(String customerName) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_26");
		WebElement customerNameInput = driver.findElement(By.name("customerName"));
		customerNameInput.clear();
		customerNameInput.sendKeys(customerName);
	}
	
	//点击查询按钮
	public void clickSearchButton() throws Throwable {
		WebElement searchBtn = driver.findElement(By.id("btn-search"));
		searchBtn.click();
		Thread.sleep(3000);
	}
	
	//点击收件
	public void clickReceiptButton() throws Throwable {
		WebElement receiptBtn = driver.findElement(By.className("receipt"));
		receiptBtn.click();
		Thread.sleep(1000);
	}
	
	//点击确认框-是按钮
	public void clickConfirmButton() throws Throwable {
		WebElement confirmBtn = driver.findElement(By.id("ok"));
		confirmBtn.click();
		Thread.sleep(2000);
	}
}
