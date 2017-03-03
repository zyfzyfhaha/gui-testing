package cls.ui.model.selenium.renewalinsurance;

import java.util.List;

import javax.xml.xpath.XPath;

import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class RenewalBusinessEnteringPage extends BaseWebDriver{
	
//	frame框架
	@FindBy(xpath="//*[@id='content-main']/iframe[4]")
	private WebElement frame;
	
//	获取险种清单按钮
	@FindBy(id="reLoadTable")
	private WebElement reLoadTable_btn;
	
//	保费
	@FindBy(name="loanInsuranceRenewalDetailList[0].insuranceFee")
	private WebElement insuranceFee;
	
//	保额
	@FindBy(name="loanInsuranceRenewalDetailList[0].insuranceMoney")
	private WebElement insuranceMoney;
	
//	确认按钮
	@FindBy(id="btn-save")
	private WebElement save_btn;
	
// 保单开始日期
	@FindBy(id="insuranceStartTime")
	private WebElement insuranceStartTime_textBox;
	
// 保单结束日期
	@FindBy(id="insuranceEndTime")
	private WebElement insuranceEndTime_textBox;
	
//	保单单号
	@FindBy(xpath="//*[@id='insuranceNo']")
	private WebElement insuranceNo_textBox;
	
//	选择保险状态
	public void selectInsuranceStatus(String insuranceStatusString)throws Throwable{
		Thread.sleep(2000);
		WebElement insuranceStatus = driver.findElement(By.name("insuranceStatus"));
		Select mySelect= new Select(insuranceStatus);
		mySelect.selectByVisibleText(insuranceStatusString);
	}

	
//	选择具体险种
	public void selectSpecificInsurance(String insuranceNameString)throws Throwable{
		reLoadTable_btn.click();
		Thread.sleep(2000);
		WebElement insuranceName = driver.findElement(By.xpath("//*[@id='insuranceListTable']/tbody/tr/td[4]"));
		if(insuranceName.getText().equals(insuranceNameString)){
			driver.findElement(By.xpath("//*[@id='insuranceListTable']/tbody/tr/td[1]/input")).click();
			driver.findElement(By.id("sureBtn_2")).click();
		}
	}
	
//	选择保险公司
	public void selectInsuranceCompany(String insuranceCompanyString)throws Throwable{
		WebElement insuranceCompanySelect = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/form/fieldset/div[1]/div[1]/div/div/button"));
		insuranceCompanySelect.click();
		List<WebElement> insuranceCompanys = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/form/fieldset/div[1]/div[1]/div/div/div/ul/li"));
		for(WebElement insuranceCompany : insuranceCompanys){
			if(insuranceCompany.getText().equals(insuranceCompanyString)){
				insuranceCompany.click();
			}
		}
		
	}
	
	
//	选择保险类型
	public void selectInsuranceType(String insuranceTypeString)throws Throwable{
		Thread.sleep(2000);
		WebElement insuranceType = driver.findElement(By.name("insuranceTypeKey"));
		Select mySelect= new Select(insuranceType);
		mySelect.selectByVisibleText(insuranceTypeString);
	}
	
	
//	填写保险单号
	public void enterInsuranceNo(String InsuranceNoString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame);
		insuranceNo_textBox.clear();
		insuranceNo_textBox.sendKeys(InsuranceNoString);
	}
	
//	填写保费
	public void enterFee(String FeeString)throws Throwable{
		Thread.sleep(2000);
		insuranceFee.clear();
		insuranceFee.sendKeys(FeeString);
	}
	
//	填写保额
	public void enterMoney(String MoneyString)throws Throwable{
		Thread.sleep(2000);
		insuranceMoney.clear();
		insuranceMoney.sendKeys(MoneyString);
	}
	
//	填写保单开始日期
	public void enterInsuranceStartTime(String insuranceStartTimeString)throws Throwable{
		insuranceStartTime_textBox.clear();
		insuranceStartTime_textBox.sendKeys(insuranceStartTimeString);
		insuranceStartTime_textBox.click();
	}
	
	
//	填写保单结束日期
	public void enterInsuranceEndTime(String insuranceEndTimeString)throws Throwable{
		insuranceEndTime_textBox.clear();
		insuranceEndTime_textBox.sendKeys(insuranceEndTimeString);
		insuranceEndTime_textBox.click();
	}
	
//	点击保存按钮
	public void clickSaveButton()throws Throwable{
		save_btn.click();
		Thread.sleep(2000);
	}

}
