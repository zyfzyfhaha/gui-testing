package cls.ui.model.selenium.loaninquire;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cls.ui.base.BaseWebDriver;

public class LoanInquireIndex extends BaseWebDriver{
	
	//输入客户名称
	public void enterCustomerName(String customerName){
		WebElement customerNameText = driver.findElement(By.name("customerName"));
		customerNameText.clear();
		customerNameText.sendKeys(customerName);
	}
	
	//点击查询
	public void clickSearchButton() throws Throwable {
		WebElement searchBtn = driver.findElement(By.id("btn-search-query"));
		searchBtn.click();
		Thread.sleep(2000);
	}
	
	public void clickOperationButton() throws Throwable {
		WebElement detailBtn = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[12]/button"));
		detailBtn.click();
		Thread.sleep(2000);
	}
	
	public void init() {
		driver.switchTo().frame("iframe_19");
	}
}