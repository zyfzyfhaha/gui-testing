package cls.ui.model.selenium.loanreview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.media.webkitAudioContext;

import cucumber.api.java.lu.a;
import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class StartLoanPage extends BaseWebDriver{

//	是否贴息 是
	@FindBy(id="isDiscount1")
	private WebElement isDiscount1_radioBtn;

//	是否贴息 否
	@FindBy(id="isDiscount2")
	private WebElement isDiscount2_radioBtn;
	
//	品牌
	@FindBy(xpath="//*[@id='getBrand']")
	private WebElement brand;
	
//	两岗分离 是
	@FindBy(xpath="/html/body/div[1]/div/div/div/form/div[2]/div[1]/fieldset/div[2]/div[2]/div[2]/div[2]/div/label[1]/input")
	private WebElement separation_yesRadioButton;
	
//	两岗分离 否
	@FindBy(xpath="/html/body/div[1]/div/div/div/form/div[2]/div[1]/fieldset/div[2]/div[2]/div[2]/div[2]/div/label[2]/input")
	private WebElement separation_noRadioButton;
	
//	开票价
	@FindBy(name="billingPrice")
	private WebElement billingPrice_textBox;
	
//	贷款金额
	@FindBy(name="loanAmount")
	private WebElement loanPrice_textBox;
	
//	手续费
	@FindBy(id="handingFee")
	private WebElement handingFee_textBox;
	
//	详细地址
	@FindBy(xpath="//*[@id='address']")
	private WebElement address_textBox;
	
	
//	获取位置
	@FindBy(xpath="//*[@id='getPos']")
	private WebElement getPos_btn;
	
//	坐标位置
	@FindBy(xpath="/html/body/div[1]/div/div/div/form/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[6]/span/div/img")
	private WebElement position;
	
	
//	提交按钮
	@FindBy(id="submit")
	private WebElement submit_btn;
	
//	确定按钮
	@FindBy(xpath="//*[@id='sureOption']")
	private WebElement sureOption_btn;
	
//	最终确定按钮
	@FindBy(xpath="/html/body/div[2]/div/div/div[3]/div/button[1]")
	private WebElement finalSureOption_btn;
	
//	选择是否贴息
	public void selectIsDiscount(String isDiscountString)throws Throwable{
		if(isDiscountString.equals("是")){
			isDiscount1_radioBtn.click();
		}
		else {
			isDiscount2_radioBtn.click();
		}
	}
	
//	选择业务品种
	public void selectBusinessType(String businessTypeString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		WebElement businessType = driver.findElement(By.id("product"));
		Select mySelect= new Select(businessType);
		mySelect.selectByVisibleText(businessTypeString);
	}
	
//	选择金融产品
	public void selectProduct(String productString)throws Throwable{
//		new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.id("productId")));
		Thread.sleep(2000);
		WebElement product = driver.findElement(By.id("productId"));
		Select mySelect= new Select(product);
		mySelect.selectByVisibleText(productString);
	}
	
	
//	选择汽车类型
	public void selectCarType(String carTypeString)throws Throwable{
		Thread.sleep(2000);
		WebElement carType = driver.findElement(By.id("carType"));
		Select mySelect= new Select(carType);
		mySelect.selectByVisibleText(carTypeString);
	}
	
	//选择二手信息
	public void selectSecondHandCarInfo() throws Throwable {
		Thread.sleep(2000);
		WebElement customerBtn = driver.findElement(By.id("customerBtn"));
		customerBtn.click();
		Thread.sleep(2000);
		WebElement selectBtn = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr/td[7]/button"));
		selectBtn.click();
	}
	
//	品牌
	public void clickBrand()throws Throwable{
		Thread.sleep(2000);
		brand.click();
	}
	
//	选择具体品牌
	public void selectDetailBrand(String detailBrandString)throws Throwable{
		Thread.sleep(2000);
		WebElement detailBrand = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/fieldset/div[3]/div[2]/div[1]/div[1]/div/ul/div[1]/li[text()='"+ detailBrandString +"']"));
		detailBrand.click();
	}
	
//	选择具体车系
	public void selectCarSeries(String carSeriesString)throws Throwable{
//		new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.id("getCarList")));
		Thread.sleep(3000);
		WebElement carSeries = driver.findElement(By.id("getCarList"));
		Select mySelect= new Select(carSeries);
		mySelect.selectByVisibleText(carSeriesString);
	}
	
// 选择具体车辆型号
	public void selectCarmodel(String carModelString)throws Throwable{
		Thread.sleep(3000);
		WebElement carModel = driver.findElement(By.id("getCarModel"));
		Select mySelect= new Select(carModel);
		mySelect.selectByVisibleText(carModelString);
	}
	
//	选择是否进口车
	public void selectIsImported(String isImportedString)throws Throwable{
		Thread.sleep(2000);
		if(isImportedString.equals("是")){
		WebElement yes_btn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/fieldset/div[3]/div[2]/div[3]/div[1]/div/label[1]/input"));
		yes_btn.click();
		}
		
		else {
			WebElement no_btn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/fieldset/div[3]/div[2]/div[3]/div[1]/div/label[2]/input"));
			no_btn.click();
		}
	}
	
//	选择车行
	public void selectCarDealer(String carDealerString)throws Throwable{
		Thread.sleep(2000);
		WebElement carDealer = driver.findElement(By.id("carDealer"));
		Select mySelect= new Select(carDealer);
		mySelect.selectByVisibleText(carDealerString);
	}
	
	
//	选择车商经费
	public void selectCarFee(String carFeeString)throws Throwable{
		Thread.sleep(2000);
		WebElement carFee = driver.findElement(By.id("dealerFeeId"));
		Select mySelect= new Select(carFee);
		mySelect.selectByVisibleText(carFeeString);
	}
	
//	输入开票价
	public void enterBillingPrice(String billingPriceString)throws Throwable{
		Thread.sleep(2000);
		billingPrice_textBox.clear();
		billingPrice_textBox.sendKeys(billingPriceString);
	}
	
//	输入贷款金额
	public void enterLoanPrice(String LoanPriceString)throws Throwable{
		loanPrice_textBox.clear();
		loanPrice_textBox.sendKeys(LoanPriceString);
	}
	
//	输入贷款费率
	public void enterHandingFee(String handingFeeString)throws Throwable{
		handingFee_textBox.clear();
		handingFee_textBox.sendKeys(handingFeeString);
		
	}
	
//	选择贷款期限
	public void selectLoanTerm(String loanTermString)throws Throwable{
		Thread.sleep(2000);
		WebElement loanTerm = driver.findElement(By.id("loanTerm"));
		Select mySelect= new Select(loanTerm);
		mySelect.selectByVisibleText(loanTermString);
	}
	
//	上门地址（省）
	public void selectProvince(String provinceString)throws Throwable{
		Thread.sleep(2000);
		WebElement province = driver.findElement(By.id("province"));
		Select mySelect= new Select(province);
		mySelect.selectByVisibleText(provinceString);
	}
	
//	市
	public void selectCity(String cityString)throws Throwable{
		Thread.sleep(2000);
		WebElement city = driver.findElement(By.id("city"));
		Select mySelect= new Select(city);
		mySelect.selectByVisibleText(cityString);
	}
	
//	区
	public void selectArea(String areaString)throws Throwable{
		Thread.sleep(3000);
		WebElement area = driver.findElement(By.id("area"));
		Select mySelect= new Select(area);
		mySelect.selectByVisibleText(areaString);
	}
	
//	详细地址
	public void enterAddress(String addressString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		address_textBox.clear();
		address_textBox.sendKeys(addressString);
	}

//	点击获取位置
	public void getAddress()throws Throwable{
		getPos_btn.click();
	}
	
//	选取坐标
	public void selectPosition()throws Throwable{
//		右击小红点
		Thread.sleep(3000);
		WebElement a = driver.findElement(By.className("BMap_mask"));
		Actions action = new Actions(driver);
		action.contextClick(a);// 鼠标右键点击指定的元素
		action.perform();
		Thread.sleep(3000);
//		点击获取当前位置
		WebElement getCurrentPosition = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/form/div[2]/div[1]/div[2]/div[2]/div[4]/div/span"));
		getCurrentPosition.click();
	}
	
//	点击 提交按钮
	public void clickSubmitButton()throws Throwable{
		Thread.sleep(2000);
		submit_btn.click();
	}
	
//	点击确定
	public void clickSureOption()throws Throwable{
		Thread.sleep(2000);
		sureOption_btn.click();
	}
	
//	选择流转人员
	public void selectSubmitter(String submitterString)throws Throwable{
		Thread.sleep(2000);
		List<WebElement> radioButtonListByName = driver.findElements(By.name("userId"));
		int count = radioButtonListByName.size();
		for(int i=1; i<=count; i++){
			if(driver.findElement(By.xpath("//table[@id='table_3']/tbody/tr["+ i +"]/td[4]")).getText().equals(submitterString)){
				driver.findElement(By.xpath("//table[@id='table_3']/tbody/tr["+ i +"]/td[1]/input")).click();
			}
		}
	}
	
//	点击最终确认按钮
	public void clickfinalSureOptionButton()throws Throwable{
		Thread.sleep(3000);
		finalSureOption_btn.click();
		
	}

	public void selectSeparation(String separationString)throws Throwable {
		Thread.sleep(2000);
		if(separationString.equals("是")){
			separation_yesRadioButton.click();
		}
		else {
			separation_noRadioButton.click();
		}
	}
}
