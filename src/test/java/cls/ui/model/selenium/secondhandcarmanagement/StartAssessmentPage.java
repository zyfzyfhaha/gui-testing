package cls.ui.model.selenium.secondhandcarmanagement;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cls.ui.base.BaseWebDriver;

public class StartAssessmentPage extends BaseWebDriver{

	public String assessmentCode = "";
	public void init() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
	}
	
	//保存二手车业务单号
	public void setAssessmentCode() {
		WebElement codeInput = driver.findElement(By.name("estimateNum"));
		assessmentCode = codeInput.getAttribute("value");
	}
	//选择车辆品牌
	public void selectBrand(String letter,String brand) throws Throwable {
		WebElement brandInput = driver.findElement(By.id("getBrand"));
		brandInput.click();
		
		List<WebElement> letterLst = driver.findElements(By.xpath("/html/body/div/div/div/div/div/div[2]/div[1]/div/div[1]/div/div/form/div[2]/div[2]/div[2]/div[1]/div/ul/div[2]/a"));
		for(int i=0;i<letterLst.size();i++){
			WebElement letterBtn =letterLst.get(i);
			if(letterBtn.getText().equals(letter)){
				letterBtn.click();
				break;
			}
		}
		
		List<WebElement> brandLst = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[1]/div/div[1]/div/div/form/div[2]/div[2]/div[2]/div[1]/div/ul/div[1]/li"));
		for(int i=0;i<brandLst.size();i++){
			WebElement brandBtn =brandLst.get(i);
			if(brandBtn.getText().equals(brand)){
				brandBtn.click();
				break;
			}
		}
		
		Thread.sleep(1000);
	}
	
	//选择车系
	public void selectCarSeries(String carSeries) throws Throwable {
		WebElement carSeriesSelect = driver.findElement(By.id("getCarList"));
		Select mySelect = new Select(carSeriesSelect);
		mySelect.selectByVisibleText(carSeries);
		Thread.sleep(1000);
	}
	
	//选择车型
	public void selectCarModel(String carModel) {
		WebElement carModelSelect = driver.findElement(By.id("getCarModel"));
		Select mySelect = new Select(carModelSelect);
		mySelect.selectByVisibleText(carModel);
	}
	
	//输入上牌时间
	public void enterLicenseDate(String licenseDate) {
		WebElement licenseDateInput = driver.findElement(By.name("licenseDate"));
		licenseDateInput.clear();
		licenseDateInput.sendKeys(licenseDate);
		licenseDateInput.click();
	}
	
	//输入里程数
	public void entreKilometres(String kilometres) {
		WebElement kilometresInput = driver.findElement(By.name("kilometres"));
		kilometresInput.clear();
		kilometresInput.sendKeys(kilometres);
	}
	
	//输入车身颜色
	public void enterCarColour(String carColour) {
		WebElement carColourInput = driver.findElement(By.name("carColour"));
		carColourInput.clear();
		carColourInput.sendKeys(carColour);
	}
	
	//输入车架号码
	public void enterCarIdentifyNum(String carIdentifyNum) {
		WebElement carIdentifyNumInput = driver.findElement(By.name("carIdentifyNum"));
		carIdentifyNumInput.clear();
		carIdentifyNumInput.sendKeys(carIdentifyNum);
	}
	
	//输入商业险到期日
	public void enterCommercialInsuranceDate(String commercialInsuranceDate) {
		WebElement commercialInsuranceDateInput = driver.findElement(By.name("commercialInsuranceExpiredDate"));
		commercialInsuranceDateInput.clear();
		commercialInsuranceDateInput.sendKeys(commercialInsuranceDate);
		commercialInsuranceDateInput.click();
	}
	
	//输入交强险到期日
	public void enterCompulsoryInsuranceDate(String compulsoryInsuranceDate) {
		WebElement compulsoryInsuranceDateInput = driver.findElement(By.name("trafficCompulsoryInsuranceExpiredDate"));
		compulsoryInsuranceDateInput.clear();
		compulsoryInsuranceDateInput.sendKeys(compulsoryInsuranceDate);
		compulsoryInsuranceDateInput.click();
	}
	
	//输入现行新车价
	public void enterNewCarPrice(String newCarPrice) {
		WebElement newCarPriceInput = driver.findElement(By.name("newCarPrice"));
		newCarPriceInput.clear();
		newCarPriceInput.sendKeys(newCarPrice);
	}
	
	//输入二手车销售价
	public void enterSecondHandCarPrice(String secondHandCarPrice) {
		WebElement secondHandCarPriceInput = driver.findElement(By.name("secondHandCarPrice"));
		secondHandCarPriceInput.clear();
		secondHandCarPriceInput.sendKeys(secondHandCarPrice);
	}
	
	//输入备注
	public void enterComment(String comment) {
		WebElement commentInput = driver.findElement(By.name("memo"));
		commentInput.clear();
		commentInput.sendKeys(comment);
	}
	
	//点击提交
	public void clickSubmitButton() throws Throwable {
		WebElement submitBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[2]/div/button[1]"));
		submitBtn.click();
		Thread.sleep(1000);
	}	
	
	//点击确认框-确定按钮
	public void clickConfirmButtom() throws Throwable {
		WebElement confrimBtn = driver.findElement(By.id("sureOption"));
		confrimBtn.click();
		Thread.sleep(2000);
	}
}