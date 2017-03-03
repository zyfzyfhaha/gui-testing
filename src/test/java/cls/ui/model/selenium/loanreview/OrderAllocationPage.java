package cls.ui.model.selenium.loanreview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.steadystate.css.util.ThrowCssExceptionErrorHandler;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class OrderAllocationPage extends BaseWebDriver{
	
//	主签单员选择按钮
	@FindBy(id="mainSignSelect")
	private WebElement mainSignSelect_btn;
	
//	主签单员权重
	@FindBy(id="mainSignerWeight")
	private WebElement mainSignerWeight_textBox;
	
//	次签单员选择按钮
	@FindBy(id="viceSignSelect")
	private WebElement viceSignSelect_btn;
	
//	次签单员权重
	@FindBy(id="viceSignerWeight")
	private WebElement viceSignerWeight_textBox;
	
//	提交按钮
	@FindBy(id="btn-opinion-save")
	private WebElement submit_btn;
	
//	提交确认按钮
	@FindBy(id="sureOption")
	private WebElement sureOption_btn;
	
//	同意按钮
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div/div/label[1]/input")
	private WebElement agree_radioBtn;
	
//	不同意按钮
	@FindBy(xpath="//html/body/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div/div/label[2]/input")
	private WebElement disagree_radioBtn;
	
//	意见说明
	@FindBy(id="opinionText")
	private WebElement opinionText_textBox;
	
	
//	点击主签单员选择按钮
	public void clickMainSignSelectButton()throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		mainSignSelect_btn.click();
	}
	
//	选择主签单员
	public void selectMainSign(String mainSignNameString)throws Throwable{
		Thread.sleep(2000);
		List<WebElement> selectMainSignButton = driver.findElements(By.xpath("//table[@id='table_sign_main']/tbody/tr"));
		int count = selectMainSignButton.size();
		for(int i=1; i<=count; i++){
			if(driver.findElement(By.xpath("//table[@id='table_sign_main']/tbody/tr["+ i +"]/td[4]")).getText().equals(mainSignNameString)){
				driver.findElement(By.xpath("//table[@id='table_sign_main']/tbody/tr["+ i +"]/td[1]/a")).click();
			}
		}
	}
	
//	输入主签单员权重
	public void enterMainSignerWeight(String mainSignerWeightString)throws Throwable{
		Thread.sleep(2000);
		mainSignerWeight_textBox.clear();
		mainSignerWeight_textBox.sendKeys(mainSignerWeightString);
	}
	
//	点击次签单员选择按钮
	public void clickViceSignSelectButton()throws Throwable{
		Thread.sleep(2000);
		viceSignSelect_btn.click();
	}
	
//	选择次签单员
	public void selectViceSign(String viceSignNameString)throws Throwable{
		Thread.sleep(2000);
		List<WebElement> selectMainSignButton = driver.findElements(By.xpath("//table[@id='table_sign_vice']/tbody/tr"));
		int count = selectMainSignButton.size();
		for(int i=1; i<=count; i++){
			if(driver.findElement(By.xpath("//table[@id='table_sign_vice']/tbody/tr["+ i +"]/td[4]")).getText().equals(viceSignNameString)){
				driver.findElement(By.xpath("//table[@id='table_sign_vice']/tbody/tr["+ i +"]/td[1]/a")).click();
			}
		}
	}
	
//	输入次签单员权重
	public void enterViceSignerWeight(String viceSignerWeightString)throws Throwable{
		viceSignerWeight_textBox.clear();
		viceSignerWeight_textBox.sendKeys(viceSignerWeightString);
	}
	
	
//	选择是否同意
	public void selectAgreeOption(String agreeOptionString)throws Throwable{
		Thread.sleep(2000);
		if (agreeOptionString.equals("同意")) {
			agree_radioBtn.click();
		}
		else {
			disagree_radioBtn.click();
		}
	}
	
//	输入意见说明
	public void enterAdvice(String adviceString)throws Throwable{
		Thread.sleep(2000);
		opinionText_textBox.clear();
		opinionText_textBox.sendKeys(adviceString);
	}
	
//	点击提交按钮
	public void clickSubmitButton()throws Throwable{
		Thread.sleep(2000);
		submit_btn.click();
	}
	
//	点击提交确认阿牛
	public void clickSureOptionbutton()throws Throwable{
		Thread.sleep(2000);
		sureOption_btn.click();
		Thread.sleep(3000);
	}
	

}
