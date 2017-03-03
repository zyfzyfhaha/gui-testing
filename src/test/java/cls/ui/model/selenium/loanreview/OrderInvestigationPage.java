package cls.ui.model.selenium.loanreview;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cls.ui.base.BaseWebDriver;
import cls.ui.base.Config;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class OrderInvestigationPage extends BaseWebDriver {

	private static Config config = new Config();
	
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
	
//	上传文件按钮
	@FindBy(xpath="/html/body/div[2]/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/ul/li[2]/a")
	private WebElement uploadFile_btn;
	
//	上传图片按钮
	@FindBy(id="upImage")
	private WebElement upImage_btn;
	
//	开始上传按钮
	@FindBy(id="upload")
	private WebElement upload_btn;
	
//	基本信息
	@FindBy(xpath="/html/body/div[2]/div[1]/div/ul/li[1]/a")
	private WebElement basicInformation_tab;
	
//	提交按钮
	@FindBy(id="btn-opinion-save")
	private WebElement submit_btn;
	
//	确认提交按钮
	@FindBy(id="sureOption")
	private WebElement sureOption_btn;
	
	
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
	
//	点击上传文件
	public void clickUploadFile()throws Throwable{
		Thread.sleep(2000);
		uploadFile_btn.click();
	}
	
//	点击上传图片
	public void clickUpImage()throws Throwable{
		upImage_btn.click();
		  try {
			   Runtime.getRuntime().exec(getUploadFilePath());
			   Thread.sleep(3000);
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
	}
	
//	点击开始上传
	public void clickUpload()throws Throwable{
		upload_btn.click();
		Thread.sleep(3000);
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
	
}
