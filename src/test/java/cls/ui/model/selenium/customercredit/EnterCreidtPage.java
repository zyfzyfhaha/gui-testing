package cls.ui.model.selenium.customercredit;

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

public class EnterCreidtPage extends BaseWebDriver{
	
	
	@FindBy(xpath="/html/body/div[1]/div/div/div/form/fieldset/div[1]/div/div[2]/div[2]/div[2]/fieldset/div[3]/div/textarea")
	private WebElement customerRemark;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div/form/fieldset/div[3]/div/div[2]/div[2]/div[2]/fieldset/div[3]/div/textarea")
	private WebElement relavanteRemark;
	
//	客户调查日期
	@FindBy(name="relavants[0].checkDate")
	private WebElement researchDate_borrower;
	
//	客户日历今天
	@FindBy(xpath="/html/body/div[5]/div[3]/table/tfoot/tr/th")
	private WebElement today_borrower;
	
//	关系人调查日期
	@FindBy(name="relavants[1].checkDate")
	private WebElement researchDate_realationship;
	
//	关系人日历今天
	@FindBy(xpath="/html/body/div[6]/div[3]/table/tfoot/tr/th")
	private WebElement today_relationship;
	
//	选择客户调查方式
	public void selectCustomerResearchBank(String researchTypeString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		WebElement customerResearchBank = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/fieldset/div[1]/div/div[2]/div[2]/div[2]/fieldset/div[1]/div[1]/div/select[@name='relavants[0].checkType']"));
		Select mySelect = new Select(customerResearchBank);
		mySelect.selectByVisibleText(researchTypeString);
	}
	
//	选择客户调查结果
	public void selectCustomerResearchResult(String researchResultString)throws Throwable{
		WebElement customerResearchBank = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/fieldset/div[1]/div/div[2]/div[2]/div[2]/fieldset/div[1]/div[2]/div/select"));
		Select mySelect = new Select(customerResearchBank);
		mySelect.selectByVisibleText(researchResultString);
	}
	
//	填写客户调查日期
	public void enterResearchDateForBorrower()throws Throwable{
		Thread.sleep(2000);
		researchDate_borrower.click();
		Thread.sleep(1000);
		today_borrower.click();
	}
	
	
//	客户备注
	public void enterCustomerRemark(String remarkString)throws Throwable{
		customerRemark.clear();
		customerRemark.sendKeys(remarkString);
	}

//	选择担保人调查方式
	public void selectRelavantResearchBank(String researchTypeString)throws Throwable{
		WebElement customerResearchBank = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/fieldset/div[3]/div/div[2]/div[2]/div[2]/fieldset/div[1]/div[1]/div/select[@name='relavants[1].checkType']"));
		Select mySelect = new Select(customerResearchBank);
		mySelect.selectByVisibleText(researchTypeString);
	}
	
//	选择担保人调查结果
	public void selectRelavantResearchResult(String researchResultString)throws Throwable{
		WebElement relavantResearchResult = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/fieldset/div[3]/div/div[2]/div[2]/div[2]/fieldset/div[1]/div[2]/div/select"));
		Select mySelect = new Select(relavantResearchResult);
		mySelect.selectByVisibleText(researchResultString);
	}
	
//	填写关系人调查日期
	public void enterResearchDateForRelationship()throws Throwable{
		Thread.sleep(2000);
		researchDate_realationship.click();
		Thread.sleep(1000);
		today_relationship.click();
	}
	
//	担保人备注
	public void enterRelavantRemark(String remarkString)throws Throwable{
		relavanteRemark.clear();
		relavanteRemark.sendKeys(remarkString);
	}
	
	
}
