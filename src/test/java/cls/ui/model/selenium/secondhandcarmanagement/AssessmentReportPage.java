package cls.ui.model.selenium.secondhandcarmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cls.ui.base.BaseWebDriver;

public class AssessmentReportPage extends BaseWebDriver{
	public void switchDriver() throws Throwable {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
	}
	
	//点击提交按钮
	public void clickSubmitButton() throws Throwable{
		WebElement submitBtn = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[8]/div/button[1]"));
		submitBtn.click();
		Thread.sleep(1000);
	}
	
	//点击YES按钮
	public void clickConfirmYesButton()throws Throwable{
		WebElement confirmYes_Btn = driver.findElement(By.id("sureOption"));
		confirmYes_Btn.click();
		Thread.sleep(3000);
	}
}