package cls.ui.model.selenium.carDealerManage;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cls.ui.base.BaseWebDriver;
import cls.ui.base.Config;

public class BasicInfoPage extends BaseWebDriver{	
	
	private static Config config = new Config();
	
	//判断是否加载完成
	public Boolean isLoadSuccess() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		new WebDriverWait(driver, 5 ).until(
			     ExpectedConditions.presenceOfElementLocated(By.id("dealerName")));
		Boolean flag = false;
		WebElement dealerName = driver.findElement(By.id("dealerName"));
		if(dealerName != null){
			flag = true;
		}
		return flag;
	}
	
	//输入车行名称
	public void enterDealerName(String dealerNameString)throws Throwable{
		WebElement dealerName = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[1]/div[1]/div/input"));
		dealerName.clear();
		dealerName.sendKeys(dealerNameString);
	}
	
	//点击获取企业信息按钮
	public void clickGetInfo()throws Throwable{
		WebElement getInfoBtn = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[1]/div[2]/div/button"));
		getInfoBtn.click();
	}
	
	//选择车商类型
	public void selectCarDealerType(String carDealerTypeString)throws Throwable{
		WebElement carDealerType = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[2]/fieldset/div[1]/div/select"));
		Select mySelect = new Select(carDealerType);
		mySelect.selectByVisibleText(carDealerTypeString);
	}
	
	//选择经销商名称，车商类型选择推荐商时才需要填写
	public void selectRecommendName(String recommendName)throws Throwable{
		WebElement recommendNameSelect = driver.findElement(By.id("employDealerId"));
		Select mySelect = new Select(recommendNameSelect);
		mySelect.selectByVisibleText(recommendName);
	}
	
	//输入联系人姓名
	public void enterContactName(String contactNameString)throws Throwable{
		WebElement contactName = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[3]/div[1]/div/input"));
		contactName.clear();
		contactName.sendKeys(contactNameString);
	}
	
	//输入联系人手机号
	public void enterContactPhone(String contactPhoneString)throws Throwable{
		WebElement contactPhone = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[3]/div[2]/div/input"));
		contactPhone.clear();
		contactPhone.sendKeys(contactPhoneString);
	}
	
	//选择是否贴息 是：true 否：false
	public void selectDiscount(String isDiscount)throws Throwable{
		WebElement discount = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[3]/div[3]/div/label[1]/input"));
		WebElement unDiscount = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[3]/div[3]/div/label[2]/input"));
		if(isDiscount.equalsIgnoreCase("true") == true){
			discount.click();
		}else{
			unDiscount.click();
		}
	}
	
	//选择省份
	public void selectProvince(String province)throws Throwable{
		WebElement provinceSelect = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[4]/div[1]/div/select"));
		Select mySelect = new Select(provinceSelect);
		mySelect.selectByVisibleText(province);
		Thread.sleep(1000);
	}
	
	//选择城市
	public void selectCity(String city)throws Throwable{
		WebElement citySelect = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[4]/div[2]/div/select"));
		Select mySelect = new Select(citySelect);
		mySelect.selectByVisibleText(city);
		Thread.sleep(1000);
	}
	
	//选择地区
	public void selectArea(String area)throws Throwable{
		WebElement areaSelect = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[4]/div[3]/div/select"));
		Select mySelect = new Select(areaSelect);
		mySelect.selectByVisibleText(area);
	}
	
	//输入详细地址
	public void enterDetailAddress(String detailAddress)throws Throwable{
		WebElement detailAddressInput = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[5]/div/div/input"));
		detailAddressInput.clear();
		detailAddressInput.sendKeys(detailAddress);
	}
	
	//输入法人代表证件号码
	public void enterCardNo(String cardNo)throws Throwable{
		WebElement cardNoInput = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[8]/div[3]/div/input"));
		cardNoInput.clear();
		cardNoInput.sendKeys(cardNo);
	}
	
	//输入在职员工数
	public void enterEmployeeNum(String employeeNum)throws Throwable{
		WebElement employeeNumInput = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[9]/div[1]/div/input"));
		employeeNumInput.clear();
		employeeNumInput.sendKeys(employeeNum);
	}
	
	//输入营业场所面积
	public void enterPlaceProportion(String placeProportion)throws Throwable{
		WebElement placeProportionInput = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[9]/div[2]/div/input"));
		placeProportionInput.clear();
		placeProportionInput.sendKeys(placeProportion);
	}
	
	//输入月销售量
	public void enterSalesVolume(String salesVolume)throws Throwable{
		WebElement salesVolumeInput = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[9]/div[3]/div/input"));
		salesVolumeInput.clear();
		salesVolumeInput.sendKeys(salesVolume);
	}
	
	//上传营业执照
	public void uploadBusinessLicense()throws Throwable{
		WebElement businessLicenseBtn = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[11]/div/div/button[1]"));
		businessLicenseBtn.click();
		Thread.sleep(1000);
		uploadFileAfterClick();
	}
	
	//上传图片（点击选择图片后）
	private void uploadFileAfterClick() throws Throwable{
		try {
			
			Runtime.getRuntime().exec(getUploadFilePath());
			Thread.sleep(3000);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	//上传营业场所照片
	public void uploadBusinessPlace()throws Throwable{
		WebElement businessPlaceBtn = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[12]/div/div/button[1]"));
		businessPlaceBtn.click();
		uploadFileAfterClick();
	}
	
	//删除车商确认单
	public void uploadConfirmation()throws Throwable{
		WebElement confirmationBtn = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[13]/div/div/button[1]"));
		confirmationBtn.click();
		uploadFileAfterClick();
	}
	
	//上传合作协议
	public void uploadAgreement()throws Throwable{
		WebElement agreementBtn = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[1]/div[2]/div[14]/div/div/button[1]"));
		agreementBtn.click();
		uploadFileAfterClick();
	}
	
	//点击保存
	public void clickSaveButton()throws Throwable{
		WebElement saveBtn = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[2]/div/button"));
		saveBtn.click();
	}
	
	//点击新增账户
	public void clickAddAccountButton()throws Throwable{
		WebElement addAccountBtn = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div[1]/div/div/div/form/fieldset/div[3]/div/div[1]/div[2]/ul/li/a"));
		addAccountBtn.click();
		Thread.sleep(2000);
	}
	
	//输入户名
	public void enterAccountName(String accountName)throws Throwable{
		WebElement accountNameText = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/form/div[1]/div[1]/div[1]/div/input"));
		accountNameText.clear();
		accountNameText.sendKeys(accountName);
	}
	
	
	//选择开户银行
	public void selectBankName(String bankName)throws Throwable{
		WebElement bankNameSelect = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/form/div[1]/div[1]/div[2]/div/select"));
		Select mySelect = new Select(bankNameSelect);
		mySelect.selectByVisibleText(bankName);
	}
	
	//输入支行名称
	public void enterSubBankName(String subBankName)throws Throwable{
		WebElement subBankNameText = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/form/div[1]/div[2]/div[1]/div/input"));
		subBankNameText.clear();
		subBankNameText.sendKeys(subBankName);
	}
	
	//输入卡号
	public void enterBankCardNum(String bankCardNum)throws Throwable{
		WebElement cardNumText = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/input"));
		cardNumText.clear();
		cardNumText.sendKeys(bankCardNum);
	}
	
	//选择账户类型
	public void selectAccountType(String accountType)throws Throwable{
		WebElement accountTypeSelect = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/form/div[1]/div[3]/div/div/select"));
		Select mySelect = new Select(accountTypeSelect);
		mySelect.selectByVisibleText(accountType);
	}
	
	//输入备注
	public void enterRemark(String remark)throws Throwable{
		WebElement remarkText = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/form/div[1]/div[4]/div/div/textarea"));
		remarkText.clear();
		remarkText.sendKeys(remark);
	}
	
	//点击新增账户弹窗的保存按钮
	public void clickAddDialogSaveButton()throws Throwable{
		WebElement saveBtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/form/div[2]/button[1]"));
		saveBtn.click();
	}
	
	//点击新增账户弹窗的取消按钮
	public void clickAddDialogCancelButton()throws Throwable{
		WebElement cancelBtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/form/div[2]/button[1]"));
		cancelBtn.click();
	}
	
	//点击提交按钮
	public void clickSubmitButton()throws Throwable{
		WebElement submitBtn = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[3]/div/div/div/div/span/button[1]"));
		submitBtn.click();
	}
	
	//点击提交确认框的确定按钮
	public void clickConfirmYesButton()throws Throwable{
		WebElement confirmBtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[5]/div/div/div[3]/button[1]"));
		confirmBtn.click();
	}
	
	//点击提交确认框的取消按钮
	public void clickConfirmNoButton()throws Throwable{
		WebElement cancelBtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[5]/div/div/div[3]/button[2]"));
		cancelBtn.click();
	}
}