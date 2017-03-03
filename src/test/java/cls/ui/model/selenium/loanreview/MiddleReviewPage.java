package cls.ui.model.selenium.loanreview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class MiddleReviewPage extends BaseWebDriver{
	
//	意见说明
	@FindBy(id="opinionText")
	private WebElement opinionText_textBox;
	
//	影像管理 tab
	@FindBy(xpath="/html/body/div[2]/div[1]/div/ul/li[5]/a")
	private WebElement imageManagement_tab;
	
//	客户身份信息
	@FindBy(id="tree_4_span")
	private WebElement clientIdentifyInformation_tree;
	
//	图片
	@FindBy(xpath="/html/body/div[2]/div[1]/div/div[2]/div[4]/div/div[1]/div[2]/div/div[2]/div/div[1]/div[2]/div/div/div/div[1]/img")
	private WebElement picture;
	
//	关闭图片按钮
	@FindBy(xpath="/html/body/div[2]/div[1]/div/div[2]/div[4]/div/div[1]/div[2]/div/div[2]/div/div[1]/div[3]/div[4]")
	private WebElement closePic_btn;

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
	
//	点击影像管理tab
	public void clickImageManagementTab()throws Throwable{
		imageManagement_tab.click();
	}
	
//	点击客户身份信息
	public void clickClientIdentifyInformation()throws Throwable{
		Thread.sleep(2000);
		clientIdentifyInformation_tree.click();
	}
	
//	点击图片
	public void clickPicture()throws Throwable{
		Thread.sleep(2000);
		picture.click();
	}
	
//	关闭图片
	public void closePicture()throws Throwable{
		Thread.sleep(2000);
//		new Actions(driver).moveToElement(closePic_btn).click().perform();
//		driver.switchTo().activeElement();
//		new Actions(driver).moveToElement(closePic_btn).perform();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].focus(); arguments[0].click(); return true", closePic_btn);
//		closePic_btn.click();
	}
	
//	点击提交按钮
	public void clickSubmitButton()throws Throwable{
		submit_btn.click();
	}
	
//	 点击确认提交按钮
	public void clickFinalConfirmButton(String submitterString)throws Throwable{
		Thread.sleep(2000);
		sureOption_btn.click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//div[@id='signModal']/div/div/div/h4")).getText().equals("任务提交")){
			List<WebElement> radioButtonListByName = driver.findElements(By.name("userId"));
			int count = radioButtonListByName.size();
			for(int i=1; i<=count; i++){
				if(driver.findElement(By.xpath("//table[@id='table_sign']/tbody/tr["+ i +"]/td[4]")).getText().equals(submitterString)){
					driver.findElement(By.xpath("//table[@id='table_sign']/tbody/tr["+ i +"]/td[1]/input")).click();
					Thread.sleep(2000);
					finalSureOption_btn.click();
				}
			}
		}
	
		Thread.sleep(2000);
	}


}
