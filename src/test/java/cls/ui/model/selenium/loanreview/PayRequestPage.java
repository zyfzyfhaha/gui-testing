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

public class PayRequestPage extends BaseWebDriver{
	
//	经销商账户全称选择按钮
	@FindBy(id="accountSelect2")
	private WebElement accountSelect2_btn;
	
//	收款人确定按钮
	@FindBy(id="select-pay-btn2")
	private WebElement PayConfirm_btn;
	
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
	
//	点击经销商账户全称选择按钮
	public void clickaccountSelect2Button()throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		accountSelect2_btn.click();
	}
	
	
	
//	选择收款人
	public void selectPay(String payNameString)throws Throwable{
		Thread.sleep(2000);
		List<WebElement> mySelect = driver.findElements(By.xpath("//table[@id='table_pay2']/tbody/tr/td[1]/a"));
		int count = mySelect.size();
		for(int i=1; i<=count; i++){
			if(driver.findElement(By.xpath("//table[@id='table_pay2']/tbody/tr["+ i +"]/td[2]")).getText().equals(payNameString)){
				driver.findElement(By.xpath("//table[@id='table_pay2']/tbody/tr["+ i +"]/td[1]/a")).click();
			}
		}
		
	}
	
////	点击确定收款人按钮
//	public void clickPayConfirmButton()throws Throwable{
//		Thread.sleep(2000);
//		PayConfirm_btn.click();
//	}
	
	
//	填写意见说明
	public void enterOpinionText(String adviceString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		advice_textBox.clear();
		advice_textBox.sendKeys(adviceString);
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
