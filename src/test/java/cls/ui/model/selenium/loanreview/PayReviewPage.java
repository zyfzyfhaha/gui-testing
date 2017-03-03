package cls.ui.model.selenium.loanreview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class PayReviewPage extends BaseWebDriver{
	
//	意见说明
	@FindBy(id="opinionText")
	private WebElement advice_textBox;
	
//	提交按钮
	@FindBy(id="btn-opinion-save")
	private WebElement submit_btn;
	
//	确认提交按钮
	@FindBy(id="sureOption")
	private WebElement sureOption_btn;
	
	
//	最终确定按钮
	@FindBy(id="select-sign-btn")
	private WebElement finalSureOption_btn;
	
	
//	选择按钮
	@FindBy(id="accountSelect3")
	private WebElement select_btn; 	
	
//	选择账户按钮
	@FindBy(xpath="//*[@id='table_pay3']/tbody/tr[1]/td[1]/a")
	private WebElement accountSelect_btn;
	
//	填写意见说明
	public void enterOpinionText(String adviceString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		advice_textBox.clear();
		advice_textBox.sendKeys(adviceString);
	}
	
	
//	选择资金部账户
	public void selectFinanceAccount()throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		Thread.sleep(2000);
		select_btn.click();
		Thread.sleep(2000);
		accountSelect_btn.click();
		
	}
	
//	点击提交按钮
	public void clickSubmitButton()throws Throwable{
		Thread.sleep(2000);
		submit_btn.click();
	}
	
//	 点击确认提交按钮
	public void clickSureOptionButton()throws Throwable{
		Thread.sleep(2000);
		sureOption_btn.click();
	}
	
	
// 	选择流转人员
	public void selectSubmitter(String submitterString)throws Throwable{
		Thread.sleep(2000);
			List<WebElement> radioButtonListByName = driver.findElements(By.name("userId"));
			int count = radioButtonListByName.size();
			for(int i=1; i<=count; i++){
				if(driver.findElement(By.xpath("//table[@id='table_sign']/tbody/tr["+ i +"]/td[4]")).getText().equals(submitterString)){
					driver.findElement(By.xpath("//table[@id='table_sign']/tbody/tr["+ i +"]/td[1]/input")).click();
					finalSureOption_btn.click();
				}
			}
	} 
	
	

}
