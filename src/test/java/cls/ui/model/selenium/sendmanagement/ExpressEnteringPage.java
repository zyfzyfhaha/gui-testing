package cls.ui.model.selenium.sendmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author lxx  
 */

public class ExpressEnteringPage extends BaseWebDriver{
	//选择快递公司
	public void selectExpressCompany(String expressCompany) {
		WebElement expressCompanySelect = driver.findElement(By.id("expressCompanyCode"));
		Select mySelect = new Select(expressCompanySelect);
		mySelect.selectByVisibleText(expressCompany);
	}
	
	//输入快递单号
	public void enterBillNo(String billNo) {
		WebElement billNoInput = driver.findElement(By.name("billNo"));
		billNoInput.click();
		billNoInput.sendKeys(billNo);
	}
	
	//选择发件时间
	public void selectSendTime() throws Throwable {
		WebElement sendTime = driver.findElement(By.name("sendTime"));
		sendTime.click();
		Thread.sleep(1000);
		WebElement todayBtn = driver.findElement(By.xpath("/html/body/div[3]/div[3]/table/tfoot/tr/th"));
		todayBtn.click();
	}
	
	//勾选合同资料
	public void selectContractInfo() {
		WebElement contractInfoBox = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr/td[7]/input"));
		contractInfoBox.click();
	}
	
	//勾选抵押资料
	public void selectMortgageInfo() {
		WebElement mortgageInfoBox = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr/td[8]/input"));
		mortgageInfoBox.click();
	}
	
	//勾选抵押合同
	public void selectMortgageContract() {
		WebElement mortgageContractBox = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr/td[7]/input"));
		mortgageContractBox.click();
	}
	
	//勾选抵押委托书
	public void selectMortgageProxy () {
		WebElement mortgageProxyBox = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr/td[9]/input"));
		mortgageProxyBox.click();
	}
	
	//勾选还款卡
	public void selectRepaymentCard() {
		WebElement repaymentCardBox = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr/td[8]/input")) ;
		repaymentCardBox.click();
	}
	
	
	//点击发件按钮
	public void clickSendButton() throws Throwable {
		WebElement sendBtn = driver.findElement(By.id("ok"));
		sendBtn.click();
		Thread.sleep(3000);
	}
}
