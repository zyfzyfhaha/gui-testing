package cls.ui.model.selenium.secondhandcarmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cls.ui.base.BaseWebDriver;

public class AssessmentIndex extends BaseWebDriver{

	public void init() {
		driver.switchTo().frame("iframe_36");
	}
	
	public void clickAssessmentButton() throws Throwable {
		WebElement assessmentBtn = driver.findElement(By.id("assessment"));
		assessmentBtn.click();
		Thread.sleep(2000);
	}
	
	//输入二手车评估单号
	public void enterEstimateNum(String estimateNum){
		WebElement estimateNumInput = driver.findElement(By.name("estimateNum"));
		estimateNumInput.clear();
		estimateNumInput.sendKeys(estimateNum);
	}
	
	//点击查询
	public void clickSearchButton() throws Throwable {
		WebElement searchBtn = driver.findElement(By.id("btn-search"));
		searchBtn.click();
		Thread.sleep(2000);
	}
	
	//检查评估结果
	public boolean isResultPassed(String result) {
		WebElement resultText = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr/td[5]"));
		if(resultText.getText().equals(result)){
			return true;
		}
		return false;
	}
}