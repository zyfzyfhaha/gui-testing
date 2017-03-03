package cls.ui.model.selenium.secondhandcarmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cls.ui.base.BaseWebDriver;

public class TransferIndex extends BaseWebDriver{

	public void init() {
		driver.switchTo().frame("iframe_37");
	}
	
	//输入客户名称
	public void enterCustomerName(String customerName) {
		WebElement customerNameInput = driver.findElement(By.name("customerName"));
		customerNameInput.clear();
		customerNameInput.sendKeys(customerName);
	}
	
	//输入证件号码
	public void enterCardNo(String cardNo) {
		WebElement cardNoInput = driver.findElement(By.name("cardNo"));
		cardNoInput.clear();
		cardNoInput.sendKeys(cardNo);
	}
	
	//点击查询
	public void clickSearchButton() throws Throwable{
		WebElement searchBtn = driver.findElement(By.id("btn-search1"));
		searchBtn.click();
		Thread.sleep(3000);
	}
	
	//点击发起过户
	public void clickTransferButton() throws Throwable {
		WebElement transferBtn = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr/td[11]/button"));
		transferBtn.click();
		Thread.sleep(2000);
	}
	
	//点击已发起过户
	public void clickTransferedTab(){
		WebElement transferedTab = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/ul/li[2]/a"));
		transferedTab.click();
	}
	
	//检查过户状态
	public boolean isReusltPassed(String result) {
		WebElement resultText = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/table/tbody/tr/td[9]"));
		if(resultText.getText().equals(result)){
			return true;
		}
		return false;
	}
}