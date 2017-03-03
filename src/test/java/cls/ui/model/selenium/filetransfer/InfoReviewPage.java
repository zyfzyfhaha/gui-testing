package cls.ui.model.selenium.filetransfer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author lxx  
 */

public class InfoReviewPage extends BaseWebDriver{
	//点击提交按钮
	public void clickSubmitButton() throws Throwable {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		WebElement submitBtn = driver.findElement(By.id("sub"));
		submitBtn.click();
		Thread.sleep(1000);
	}
	
	//点击确认框-确定按钮
	public void clickConfirmButton() throws Throwable {
		WebElement confirmBtn = driver.findElement(By.id("sureOption"));
		confirmBtn.click();
		Thread.sleep(2000);
	}
}