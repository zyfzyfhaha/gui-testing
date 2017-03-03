package cls.ui.model.selenium.carDealerManage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cls.ui.base.BaseWebDriver;

public class CarDealerOrderListPage extends BaseWebDriver{
	
	//输入客户名称
	public void enterCustomerName(String customerName) {
		WebElement customerNameText = driver.findElement(By.name("customerName"));
		customerNameText.clear();
		customerNameText.sendKeys(customerName);
	}
	
	//输入证件号码
	public void enterCardNo(String cardNo){
		WebElement cardNoText = driver.findElement(By.name("cardNo"));
		cardNoText.clear();
		cardNoText.sendKeys(cardNo);
	}
	
	//输入手机号码
	public void enterPhone(String phone) {
		WebElement phoneText = driver.findElement(By.name("customerMobile"));
		phoneText.clear();
		phoneText.sendKeys(phone);
	}
	
	//选择征信状态
	public void selectCreditStatus(String creditStatus) {
		WebElement creditStatusSelect = driver.findElement(By.name("creditStatus"));
		Select mySelect = new Select(creditStatusSelect);
		mySelect.selectByVisibleText(creditStatus);
	}
	
	//选择汽车类型
	public void selectCarType(String carType) {
		WebElement selectCarType = driver.findElement(By.name("carType"));
		Select mySelect = new Select(selectCarType);
		mySelect.selectByVisibleText(carType);
	}
	
	//点击查询
	public void clickSearchButton() throws Throwable {
		WebElement searchBtn = driver.findElement(By.id("btn-search"));
		searchBtn.click();
		Thread.sleep(2000);
	}
	
	//点击清楚查询条件
	public void clickClearButton() {
		WebElement clearchBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/form/div[3]/div/button[2]"));
		clearchBtn.click();
	}
	
	//点击发起征信
	public void clickLaunchCredit() throws Throwable {
		WebElement operateBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr/td[14]/div/button"));
		operateBtn.click();
		WebElement launchCreditBtn = driver.findElement(By.className("creditApply"));
		launchCreditBtn.click();
		Thread.sleep(2000);
	}
	
	//点击退回订单
	public void clickBackOrder() throws Throwable {
		WebElement operateBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr/td[14]/div/button"));
		operateBtn.click();
		WebElement backOrderBtn = driver.findElement(By.className("backOrder"));
		backOrderBtn.click();
		Thread.sleep(2000);
	}
	
	//driver焦点切换至车商订单tab
	public void switchDriverToCarDealerOrder() throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().frame("iframe_11014");
		
	}
	
	//点击接受订单
	public void clickAcceptButton() throws Throwable{
		WebElement accpetBtn = driver.findElement(By.className("takeOrder"));
		accpetBtn.click();
		Thread.sleep(2000);
	}
	
	//点击已接单tab
	public void clickAcceptedTab() {
		WebElement acceptedTab = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/ul/li[2]/a"));
		acceptedTab.click();
	}

	//点击已接单tab
	public void clickUnacceptedTab() {
		WebElement unacceptedTab = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/ul/li[1]/a"));
		unacceptedTab.click();
	}
	
	//检查是否存在查询结果
	public Boolean isExistResult() {
//		/html/body/div[1]/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/table/tbody/tr/td[1]
//		/html/body/div[1]/div/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr/td[1]
		List<WebElement> resultList = driver.findElements(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr/td[2]"));
		Boolean ret = false;
		
		if(resultList.size() > 0){
			ret = true;
		}
		
		return ret;
	}
}