package cls.ui.model.selenium.sendmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author lxx  
 */

public class SendCompanyIndex extends BaseWebDriver{
	//输入客户名称
	public void enterCustomerName(String customerName) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_23");
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
	
	//点击放入包裹按钮
	public void clickAddParcelButton() throws Throwable {
		WebElement addParcelBtn = driver.findElement(By.className("addParcel"));
		addParcelBtn.click();
		Thread.sleep(1000);
	}
	
	//点击新增发件
	public void clickAddExpressButton() throws Throwable {
		WebElement addExpressBtn = driver.findElement(By.id("addExpress"));
		addExpressBtn.click();
		Thread.sleep(2000);
	}
	
	//点击已发件tab
	public void clickSendTab() throws Throwable {
		WebElement sendTab = driver.findElement(By.id("sendTab"));
		sendTab.click();
		Thread.sleep(1000);
	}
	
	//检查快递单号是否一致
	public boolean equalsBillNo(String billNo) {
		WebElement billNoText = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr/td[1]"));
		boolean ret = billNoText.getText().equals(billNo);
		return ret;
	}
	
	//检查快递公司是否一致
	public boolean equalsExpressCompany(String expressCompany) {
		WebElement expressCompanyText = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr/td[2]"));
		boolean ret = expressCompanyText.getText().equals(expressCompany);
		return ret;
	}
	
	//检查收件状态是否一致
	public boolean equalsStatus(String status) {
		WebElement statusText = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr/td[7]"));
		boolean ret = statusText.getText().equals(status);
		return ret;
	}
}
