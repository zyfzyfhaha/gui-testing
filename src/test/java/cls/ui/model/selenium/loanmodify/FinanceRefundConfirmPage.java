package cls.ui.model.selenium.loanmodify;

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

public class FinanceRefundConfirmPage extends BaseWebDriver{

//	意见说明
	@FindBy(id="opinionText")
	private WebElement opinionText_textBox;
	
	//	提交按钮
	@FindBy(id="btn-opinion-save")
	private WebElement submit_btn;
	
//	确认提交按钮
	@FindBy(id="sureOption")
	private WebElement sureOption_btn;
	
//	最终确定按钮
	@FindBy(id="select-sign-btn")
	private WebElement finalSureOption_btn;
	
//	输入意见
	public void enterOpinionText(String adviceString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		opinionText_textBox.clear();
		opinionText_textBox.sendKeys(adviceString);
	}
	
//	点击提交按钮
	public void clickSubmitButton()throws Throwable{
		Thread.sleep(2000);
		submit_btn.click();
	}
	
//	 点击确认提交按钮
	public void clickFinalConfirmButton()throws Throwable{
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
			Thread.sleep(2000);
	}
	
}
