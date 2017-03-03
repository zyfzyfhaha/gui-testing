package cls.ui.model.selenium.loanreview;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class BranchCompanyPayPage extends BaseWebDriver{
	
//	说明
	@FindBy(name="dealerPaymentRemark")
	private WebElement dealerPaymentRemark_textBox;
	
//	意见说明
	@FindBy(id="opinionText")
	private WebElement advice_textBox;
	
//	提交按钮
	@FindBy(id="btn-opinion-save")
	private WebElement submit_btn;
	
//	确认提交按钮
	@FindBy(id="sureOption")
	private WebElement sureOption_btn;
	
//	输入说明
	public void enterDealerPaymentRemark(String remarkString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		dealerPaymentRemark_textBox.clear();
		dealerPaymentRemark_textBox.sendKeys(remarkString);
	}
	
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
	

}
