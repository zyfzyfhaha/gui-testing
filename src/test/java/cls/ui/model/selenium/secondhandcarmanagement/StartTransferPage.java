package cls.ui.model.selenium.secondhandcarmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cls.ui.base.BaseWebDriver;

public class StartTransferPage extends BaseWebDriver{
	
	public void init() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
	}
	
	//填写客户调查日期
	public void enterTransferDate()throws Throwable{
		WebElement dateControl = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[1]/div/div[1]/div/div/form/div[5]/div[2]/div[1]/div[1]/div/input"));
		dateControl.click();
		Thread.sleep(1000);
		WebElement todayButton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/table/tfoot/tr/th"));
		todayButton.click();
	}
	
	//输入备注
	public void enterCommit(String commit) {
		WebElement commitInput = driver.findElement(By.name("transferMemo"));
		commitInput.clear();
		commitInput.sendKeys(commit);
	}
	
	//点击提交按钮
	public void clickSubmitButton() throws Throwable {
		WebElement submitBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[3]/div/button[1]"));
		submitBtn.click();
		Thread.sleep(1000);
	}
	
	//点击确认框确定按钮
	public void clickConfirmButton() throws Throwable {
		WebElement confirmBtn = driver.findElement(By.id("sureOption"));
		confirmBtn.click();
		Thread.sleep(2000);
	}

}