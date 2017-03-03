package cls.ui.model.selenium.customercredit;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import cls.ui.base.BaseWebDriver;
import cls.ui.base.Config;
import cls.ui.dao.beforeloan.CustomerCreditDao;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class LaunchCreditPage extends BaseWebDriver {
	
	private static Config config = new Config();
	
//	客户名称
	@FindBy(name="customerName")
	private WebElement customerName_testBox;

	//	证件号码
	@FindBy(id="cardNo")
	private WebElement idNumber;

	//	手机号码
	@FindBy(name="relavants[0].mobile")
	private WebElement phoneNumber;

	//	征信文件上传
	@FindBy(xpath="/html/body/div[1]/div/div/div/form/div[3]/div/div[2]/div[3]/div[1]/button")
	private WebElement upload_Btn;

	//	添加担保人
	@FindBy(id="addParty")
	private WebElement addParty_btn;

	//	担保人姓名
	@FindBy(name="relavants[1].fullName")
	private WebElement guarantee_name;

	//	担保人证件号码
	@FindBy(name="relavants[1].cardId")
	private WebElement guarantee_idNum;

	//	担保人号码
	@FindBy(name="relavants[1].mobile")
	private WebElement guarantee_phoneNum;

	//	提交按钮
	@FindBy(id="save")
	private WebElement submit_btn;

	//	确认YES按钮
	@FindBy(id="sureOption")
	private WebElement confirmYes_Btn;

	//	确认按钮
	@FindBy(xpath="/html/body/div[4]/div/div/div[3]/div/button[1]")
	private WebElement finalConfirm_Btn;
	
	
//	输入客户名称
	public void enterCustomerName(String name)throws Throwable{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		customerName_testBox.clear();
		customerName_testBox.sendKeys(name);
	}
	
//	证件类型
	public void selectCustomerIdentify(String customerIdentifyString)throws Throwable{
		WebElement customerIdentify = driver.findElement(By.id("cardType"));
		Select mySelect= new Select(customerIdentify);
		mySelect.selectByVisibleText(customerIdentifyString);
	}
	
//	输入证件号码
	public void enterIdNumber(String idNo)throws Throwable{
		idNumber.clear();
		idNumber.sendKeys(idNo);
	}
	
//婚姻状态 
	public void selectMaritalStatus(String maritalStatusString)throws Throwable{
		WebElement maritalStatus = driver.findElement(By.id("maritalStatus"));
		Select mySelect= new Select(maritalStatus);
		mySelect.selectByVisibleText(maritalStatusString);
	}

	
//调查银行 - 选择Automation Bank
	public void selectBank(String bankString){
		WebElement bank = driver.findElement(By.id("bankDeraler"));
		Select mySelect= new Select(bank);
		mySelect.selectByVisibleText(bankString);
	}

//输入手机号码
	public void enterPhoneNumber(String phoneNumberString)throws Throwable{
		phoneNumber.clear();
		phoneNumber.sendKeys(phoneNumberString);
	}

//	点击征信文件上传按钮
	public void clickUploadFileButton()throws Throwable{
		upload_Btn.click();
	}
	
//	上传文件
	public void uploadFiles()throws Throwable{
		upload_Btn.click();
		  try {
		   Runtime.getRuntime().exec(getUploadFilePath());
		   Thread.sleep(3000);
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		 }

//	点击添加担保人按钮
	public void clickAddPartyButton()throws Throwable{
		Thread.sleep(1000);
		addParty_btn.click();
	}
	
//	输入担保人姓名
	public void enterGuaranteeName(String name)throws Throwable{
		guarantee_name.clear();
		guarantee_name.sendKeys(name);
	}
	
//	担保人证件类型
	public void selectGuaranteeIdentify(String guaranteeIdentifyString)throws Throwable{
		WebElement guaranteeIdentify = driver.findElement(By.name("relavants[1].cardType"));
		Select mySelect= new Select(guaranteeIdentify);
		mySelect.selectByVisibleText(guaranteeIdentifyString);
	}
	
//	输入担保人证件号码
	public void enterGuaranteeIdNumber(String idNum)throws Throwable{
		guarantee_idNum.clear();
		guarantee_idNum.sendKeys(idNum);
	}
	
//	输入担保人手机号
	public void enterGuaranteePhoneNumber(String phoneNum)throws Throwable{
		guarantee_phoneNum.clear();
		guarantee_phoneNum.sendKeys(phoneNum);
	}
	
// 选择借款人关系
	public void selectRelationship(String relationshipString)throws Throwable{
		WebElement relationship = driver.findElement(By.name("relavants[1].borrowerRelationship"));
		Select mySelect= new Select(relationship);
		mySelect.selectByVisibleText(relationshipString);
	}
	
//	选择担保关系
	public void selectGuaranteeRelationship(String guaranteeRelationshipString)throws Throwable{
		WebElement guaranteeRelationship = driver.findElement(By.name("relavants[1].guaranteeRelationship"));
		Select mySelect= new Select(guaranteeRelationship);
		mySelect.selectByVisibleText(guaranteeRelationshipString);
	}
	
//	点击提交按钮
	public void clickSubmitButton()throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		submit_btn.click();
		Thread.sleep(2000);
	}
	
//	点击YES按钮
	public void clickConfirmYesButton()throws Throwable{
		confirmYes_Btn.click();
		Thread.sleep(3000);
	}
	
//	选择提交人
	public void selectSubmitter(String submitterString)throws Throwable{
		
		List<WebElement> radioButtonListByName = driver.findElements(By.name("btSelectItem"));
		int count = radioButtonListByName.size();
		for(int i=1; i<=count; i++){
			if(driver.findElement(By.xpath("//table[@id='table_3']/tbody/tr["+ i +"]/td[4]")).getText().equals(submitterString)){
				driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[2]/div[2]/div[2]/table/tbody/tr["+ i +"]/td[1]/input")).click();
			}
		}
		
//		WebElement submitter = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[1]/input" +"[@username='"+ submitterString +"']"));
//		submitter.click();
	}
	
//	点击最终确定按钮
	public void clickFinalConfirmButton()throws Throwable{
		finalConfirm_Btn.click();
		refreshPage();
	}
	
	public void refreshPage()throws Throwable{
		driver.navigate().refresh();
	}
	
}
