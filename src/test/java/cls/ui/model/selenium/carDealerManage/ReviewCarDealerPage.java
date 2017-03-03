package cls.ui.model.selenium.carDealerManage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cls.ui.base.BaseWebDriver;

public class ReviewCarDealerPage extends BaseWebDriver{
	
	//点击提交按钮
	public void clickSubmitButton()throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		WebElement submitBtn = driver.findElement(By.id("btn-opinion-save"));
		submitBtn.click();
		Thread.sleep(2000);
	}
	
	//点击YES按钮
	public void clickConfirmYesButton()throws Throwable{
		WebElement confirmYesBtn =  driver.findElement(By.id("sureOption"));
		confirmYesBtn.click();
		Thread.sleep(2000);
	}
	
	//选择流转人员
	public void selectNextUserName(String submitterName)throws Throwable{
		List<WebElement> userIdLst = driver.findElements(By.name("userId"));
		
		int lstSize = userIdLst.size();
		int userId = 0;
		
		for(int i=1;i<=lstSize;i++){
			String tempName = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr["+i+"]/td[4]")).getText();
			if(tempName.equals(submitterName)){
				userId = i-1;
				break;
			}
		}
		
		WebElement selectUserId = userIdLst.get(userId);
		selectUserId.click();
	}
	//选择流转人员--分公司财务审核流转
	public void selectNextUserNameDiv(String submitterName)throws Throwable{
		Thread.sleep(2000);
		List<WebElement> userIdLst = driver.findElements(By.name("userId"));
		
		int lstSize = userIdLst.size();
		int userId = 0;
		
		for(int i=1;i<=lstSize;i++){
			String tempName = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr["+i+"]/td[4]")).getText();
			if(tempName.equals(submitterName)){
				userId = i-1;
				break;
			}
		}
		
		WebElement selectUserId = userIdLst.get(userId);
		selectUserId.click();
	}
	
	//点击任务提交的确定按钮
	public void clickSubmitYesButton()throws Throwable{
		WebElement confirmBtn = driver.findElement(By.id("select-sign-btn"));
		confirmBtn.click();
		Thread.sleep(2000);
	}
}