package cls.ui.model.selenium.secondhandcarmanagement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cls.ui.base.BaseWebDriver;

public class PreliminaryAssessmentPage extends BaseWebDriver{
	public void init() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
	}
	
	//选择评审结果来源
	public void selectFirstEstimateSource(String firstEstimateSourceKey){
		WebElement reslutSelect = driver.findElement(By.id("firstEstimateSourceKey"));
		Select mySelect = new Select(reslutSelect);
		mySelect.selectByVisibleText(firstEstimateSourceKey);
	}
	
	//输入初评价格
	public void enterFirstEstimatePrice(String firstEstimatePrice) {
		WebElement priceInput = driver.findElement(By.name("firstEstimatePrice"));
		priceInput.clear();
		priceInput.sendKeys(firstEstimatePrice);
	}
	
	//输入初评描述
	public void enterFirstEstimateDesc(String firstEstimateDesc) {
		WebElement DescInput = driver.findElement(By.name("firstEstimateDesc"));
		DescInput.clear();
		DescInput.sendKeys(firstEstimateDesc);
	}
	
	//点击提交
	public void clickSubmitButton() throws Throwable {
		WebElement submitBtn = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[4]/div/button[1]"));
		submitBtn.click();
		Thread.sleep(1000);
	}	
	
	//点击确认框-确定按钮
	public void clickConfirmButtom() throws Throwable {
		WebElement confrimBtn = driver.findElement(By.id("sureOption"));
		confrimBtn.click();
		Thread.sleep(2000);
	}
	
	//选择流转人员
	public void selectNextOperator(String operator)throws Throwable{
		List<WebElement> userIdLst = driver.findElements(By.name("userId"));
		
		int lstSize = userIdLst.size();
		int userId = 0;
		
		for(int i=1;i<=lstSize;i++){
			String tempName = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[1]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/table/tbody/tr["+i+"]/td[4]")).getText();
			if(tempName.equals(operator)){
				userId = i-1;
				break;
			}
		}
		
		WebElement selectUserId = userIdLst.get(userId);
		selectUserId.click();
	}
	
	//点击流转人员确认框-确定按钮
	public void clickConfirmOperatorButton(){
		WebElement confirmBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[1]/div/div[2]/div/div/div[3]/div/button[1]"));
		confirmBtn.click();
	}
	
	//选择复评师
	public void selectSecondEstimateUserId(String secondEstimateUserId) {
		WebElement secondEstimateUserIdSelect = driver.findElement(By.name("secondEstimateUserId"));
		Select mySelect = new Select(secondEstimateUserIdSelect);
		mySelect.selectByVisibleText(secondEstimateUserId);
	}
	
	//输入复评价格
	public void enterSecondEstimatePrice(String secondEstimatePrice) {
		WebElement priceInput = driver.findElement(By.name("secondEstimatePrice"));
		priceInput.clear();
		priceInput.sendKeys(secondEstimatePrice);
	}
	
	//输入最高评估书价格
	public void enterInvoicePrice(String invoicePrice) {
		WebElement invoicePriceInput = driver.findElement(By.name("invoicePrice"));
		invoicePriceInput.clear();
		invoicePriceInput.sendKeys(invoicePrice);
	}
	
	//输入复评描述
	public void enterSecondEstimateDesc(String secondEstimateDesc) {
		WebElement descInput = driver.findElement(By.name("secondEstimateDesc"));
		descInput.clear();
		descInput.sendKeys(secondEstimateDesc);
	}
	
	//点击完成评估
	public void clickCompleteButton() throws Throwable {
		WebElement completeBtn = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[5]/div/button[1]"));
		completeBtn.click();
		Thread.sleep(1000);
	}
}