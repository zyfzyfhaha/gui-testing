package cls.ui.model.selenium.filetransfer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author lxx  
 */

public class CopyContractPage extends BaseWebDriver{
	//点击汽车信息tab
	public void clickCarInfoTab() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		WebElement carInfoTab = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/ul/li[2]/a"));
		carInfoTab.click();
	}
	
	//输入车架号码
	public void enterCarFrameNo(String carFrameNo) {
		WebElement carFrameNoInput = driver.findElement(By.name("carFrameNo"));
		carFrameNoInput.clear();
		carFrameNoInput.sendKeys(carFrameNo);
	}
	
	//输入发动机号码
	public void enterCarEngineNo(String carEngineNo) {
		WebElement carEngineNoInput = driver.findElement(By.name("carEngineNo"));
		carEngineNoInput.clear();
		carEngineNoInput.sendKeys(carEngineNo);
	}
	
	//输入限乘人数
	public void enterMaxCapacity(String maxCapacity) {
		WebElement maxCapacityInput = driver.findElement(By.name("maxCapacity"));
		maxCapacityInput.clear();
		maxCapacityInput.sendKeys(maxCapacity);
	}
	
	//选择发票日期
	public void selectBillDate() throws Throwable {
		WebElement billDate = driver.findElement(By.name("billDate"));
		billDate.click();
		Thread.sleep(1000);
		WebElement today = driver.findElement(By.xpath("/html/body/div[6]/div[3]/table/tfoot/tr/th"));
		today.click();
	}
	
	//输入发票号码
	public void enterBillNo(String billNo) {
		WebElement billNoInput = driver.findElement(By.name("billNo"));
		billNoInput.clear();
		billNoInput.sendKeys(billNo);
	}
	
	//点击汽车信息-保存按钮
	public void clickSaveCarInfoButton() throws Throwable {
		WebElement saveBtn = driver.findElement(By.id("carBtnSave"));
		saveBtn.click();
		Thread.sleep(2000);
	}
	
	//点击客户信息tab
	public void clickCustomerInfoTab() {
		WebElement customerInfoTab = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/ul/li[3]/a"));
		customerInfoTab.click();
	}
	
	//点击客户信息-保存
	public void clickSaveCustomerInfoButton() throws Throwable {
		WebElement saveBtn = driver.findElement(By.id("btn_saveCustomerInfo"));
		saveBtn.click();
		Thread.sleep(2000);
	}
	
	//点击反担保信息tab
	public void clickCounterTab() throws Throwable {
		WebElement counterTab = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/ul/li[4]/a"));
		counterTab.click();
		Thread.sleep(3000);
	}
	
	//点击反担保信息-保存
	public void clickSaveCounterButton() throws Throwable {
		WebElement saveBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[7]/div/div[3]/form/fieldset/div/div[2]/div/div[2]/button[1]"));
		saveBtn.click();
		Thread.sleep(2000);
	}
	
	//点击项目基本信息tab
	public void clickBasicInfoTab() {
		WebElement basicInfoTab = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/ul/li[1]/a"));
		basicInfoTab.click();
	}
	
	//点击提交按钮
	public void clickSubmitButton() throws Throwable {
		WebElement submitBtn = driver.findElement(By.id("sub"));
		submitBtn.click();
		Thread.sleep(1000);
	}
	
	//点击确认框-确定按钮
	public void clickConfirmButton() throws Throwable {
		WebElement confirmBtn = driver.findElement(By.id("sureOption"));
		confirmBtn.click();
		Thread.sleep(2000);
	}
}