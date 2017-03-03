package cls.ui.model.selenium.loanreview;

import java.util.List;

import org.apache.bcel.generic.Select;
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

public class HeadQuatersReviewCenterPage extends BaseWebDriver{
	
//	是否家访 是
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/label[1]/input")
	private WebElement visitHome_YesBtn;
	
//	是否家访  否
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/label[2]/input")
	private WebElement visitHome_NoBtn;

//	是否代购 是
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/label[1]/input")
	private WebElement agency_YesBtn;
	
//	是否代购 否 
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/label[2]/input")
	private WebElement agency_NoBtn;
	
//	按公司规定是否安装GPS 是
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div[1]/div[1]/div/label[1]/input")
	private WebElement companyGPS_YesBtn;
	
//	按公司规定是否安装GPS 否
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div[1]/div[1]/div/label[2]/input")
	private WebElement companyGPS_NoBtn;
	
//	按银行规定是否安装GPS 是
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div[1]/div[2]/div/label[1]/input")
	private WebElement bankGPS_YesBtn;
	
//	按银行规定是否安装GPS 否
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div[1]/div[2]/div/label[2]/input")
	private WebElement bankGPS_NoBtn;
	
	
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

//	选择图片按钮
	@FindBy(xpath="/html/body/div[2]/div[1]/div/div[2]/div[4]/div/div[1]/div[2]/div/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div/input")
	private WebElement pic_checkBox;
	
//	资产分发可见按钮
	@FindBy(id="sendContract")
	private WebElement sendContract_btn;
	
	//	提交按钮
	@FindBy(id="btn-opinion-save")
	private WebElement submit_btn;
	
//	确认提交按钮
	@FindBy(id="sureOption")
	private WebElement sureOption_btn;
	
//	最终确定按钮
	@FindBy(id="select-sign-btn")
	private WebElement finalSureOption_btn;
	
	
	
//	选择是否家访
	public void selectIsVisitHome(String isVisitHomeString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		if(isVisitHomeString.equals("是")){
			visitHome_YesBtn.click();
		}
		else {
			visitHome_NoBtn.click();
		}
	}
	
//	选择是否家访
	public void selectIsAgency(String isAgencyString)throws Throwable{
		if(isAgencyString.equals("是")){
			agency_YesBtn.click();
		}
		else {
			agency_NoBtn.click();
		}
	}
	
//	选择是否按公司规定是否安装GPS
	public void selectIsCompanyGps(String isCompanyGpsString)throws Throwable{
		if(isCompanyGpsString.equals("是")){
			companyGPS_YesBtn.click();
		}
		else {
			companyGPS_NoBtn.click();
		}
	}
	
	
//	选择是否按银行规定是否安装GPS
	public void selectIsBankGps(String isBankGpsString)throws Throwable{
		if(isBankGpsString.equals("是")){
			bankGPS_YesBtn.click();
		}
		else {
			bankGPS_NoBtn.click();
		}
	}
	
	
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
	
//	选择资产分发
	public void sendContract()throws Throwable{
		Thread.sleep(2000);
		pic_checkBox.click();
		Thread.sleep(2000);
		sendContract_btn.click();
		
		
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
		Thread.sleep(2000);
//		Thread.sleep(2000);
//		if(driver.findElement(By.xpath("//div[@id='signModal']/div/div/div/h4")).isDisplayed()){
//			List<WebElement> radioButtonListByName = driver.findElements(By.name("userId"));
//			int count = radioButtonListByName.size();
//			for(int i=1; i<=count; i++){
//				if(driver.findElement(By.xpath("//table[@id='table_sign']/tbody/tr["+ i +"]/td[4]")).getText().equals(submitterString)){
//					driver.findElement(By.xpath("//table[@id='table_sign']/tbody/tr["+ i +"]/td[1]/input")).click();
//					Thread.sleep(2000);
//					finalSureOption_btn.click();
//					driver.switchTo().
//				}
//			}
//		}
	
		
	}
	
	
}
