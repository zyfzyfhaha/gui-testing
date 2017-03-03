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

public class OrderInvestigationVicePage extends BaseWebDriver{
	
//	同意按钮
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/div/div/form/div[1]/div[2]/div[1]/div/div/label[1]/input")
	private WebElement agree_btn;
	
//	不同意按钮
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/div/div/form/div[1]/   div[2]/div[1]/div/div/label[2]/input")
	private WebElement disagree_btn;
	
//	意见说明
	@FindBy(id="opinionText")
	private WebElement advice_textBox;
	
//	影像管理
	@FindBy(xpath="/html/body/div[2]/div[1]/div/ul/li[2]/a")
	private WebElement imageManagement_tab;
	
//	客户身份信息
	@FindBy(id="tree_4_span")
	private WebElement clientIdentifyInformation_tree;
	
	
//	提交按钮
	@FindBy(id="btn-opinion-save")
	private WebElement submit_btn;
	
//	确认提交按钮
	@FindBy(id="sureOption")
	private WebElement sureOption_btn;

//	最终确认按钮
	@FindBy(id="select-sign-btn")
	private WebElement finalConfirm_btn;
	
	
//	选择是否同意
	public void selectAgreeOption(String agreeOptionString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		if(agreeOptionString.equals("同意")){
			agree_btn.click();
		}
		else {
			disagree_btn.click();
		}
	}
	
//	填写意见说明
	public void enterAdvice(String adviceString)throws Throwable{
		advice_textBox.clear();
		advice_textBox.sendKeys(adviceString);
	}
	
//	切换到影像管理
	public void navigateToImageManagement()throws Throwable{
		imageManagement_tab.click();
	}
	
//	点击客户身份信息
	public void clickClientIdentifyInformation()throws Throwable{
		Thread.sleep(3000);
		clientIdentifyInformation_tree.click();
	}
	
//	点击提交按钮
	public void clickSubmitButton()throws Throwable{
		submit_btn.click();
	}
	
//	点击确定提交按钮
	public void clickSureOptionButton()throws Throwable{
		Thread.sleep(2000);
		sureOption_btn.click();
		Thread.sleep(2000);
	}
	
//	选择提交人
	public void selectSubmitter(String submitterString)throws Throwable{
		List<WebElement> radioButtonListByName = driver.findElements(By.name("userId"));
		int count = radioButtonListByName.size();
		for(int i=1; i<=count; i++){
			if(driver.findElement(By.xpath("//table[@id='table_sign']/tbody/tr["+ i +"]/td[4]")).getText().equals(submitterString)){
				driver.findElement(By.xpath("//table[@id='table_sign']/tbody/tr["+ i +"]/td[1]/input")).click();
			}
		}
	}
	
//	点击最终确认
	public void clickFinalConfirmButton()throws Throwable{
		Thread.sleep(2000);
		finalConfirm_btn.click();
		Thread.sleep(2000);
	}
	
}
