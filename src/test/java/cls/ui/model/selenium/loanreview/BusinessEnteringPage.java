package cls.ui.model.selenium.loanreview;

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

public class BusinessEnteringPage extends BaseWebDriver{

//	证件有效期
	@FindBy(name="cardNoValidTime")
	private WebElement cardNoValidTime_textBox;
	
//	发证机关
	@FindBy(name="licenceIssuingAuthority")
	private WebElement licenceIssuingAuthority_textBox;
	
//	籍贯
	@FindBy(name="nativePlace")
	private WebElement nativePlace_textBox;
	
//	家庭电话
	@FindBy(name="homePhone")
	private WebElement homePhone_textBox;
	
//年收入
	@FindBy(name="yearlyIncome")
	private WebElement yearlyIncome_textBox;
	
//	工作单位
	@FindBy(name="companyName")
	private WebElement companyName_textBox;

//	单位电话
	@FindBy(name="companyPhone")
	private WebElement companyPhone_textBox;
	
//	入职时间
	@FindBy(name="employTime")
	private WebElement employTime_textBox;
	
//	公司详细地址
	@FindBy(name="companyAddressDetail")
	private WebElement companyAddressDetail_textBox;
	
//	现居住地时间
	@FindBy(name="curAddressTime")
	private WebElement curAddressTime_textBox;
	
//	居住地详细地址
	@FindBy(name="homeAddressDetail")
	private WebElement homeAddressDetail_textBox;
	
//	新增联系人按钮
	@FindBy(xpath="/html/body/div[2]/div[1]/div/div[2]/div[1]/div/div/div/form/div[4]/div[1]/div[2]/ul/li/a")
	private WebElement addNewContracts_btn;

//	新总总贴息金额
	@FindBy(name="xzzDiscountAmount")
	private WebElement xzzDiscountAmount_textBox;
	
//	紧急联系人姓名
	@FindBy(name="emergencyContact")
	private WebElement emergencyContact_textBox;
	
//	紧急联系人电话
	@FindBy(xpath="/html/body/div[3]/div/div/div[2]/div/form/div[2]/div[1]/div/input")
	private WebElement mobilePhone_textBox;
	
//	添加紧急联络人保存按钮
	@FindBy(id="btn-contacter-save")
	private WebElement contractsSave_btn;
	
//	是否同意按钮 是
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div/div/label[1]/input")
	private WebElement agree_btn;
	
//	是否同意按钮 否
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div/div/label[1]/input")
	private WebElement disAgree_btn;
	
//	意见说明
	@FindBy(id="opinionText")
	private WebElement opinionText_textBox;
	
//	预算单tab
	@FindBy(xpath="/html/body/div[2]/div[1]/div/ul/li[5]/a")
	private WebElement budget_panel;
	
//	已收金额
	@FindBy(id="collectedAmount")
	private WebElement collectedAmount_textBox;
	
//	提交按钮
	@FindBy(id="btn-opinion-save")
	private WebElement submit_btn;
	
//	确认提交按钮
	@FindBy(id="sureOption")
	private WebElement sureOption_btn;
	
	
//输入证件有效期
	public void enterCardNoValidTime(String cardNoValidTimeString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		cardNoValidTime_textBox.clear();
		cardNoValidTime_textBox.sendKeys(cardNoValidTimeString);
	}
	
//	输入发证机关
	public void enterLicenceIssuingAuthority(String licenceIssuingAuthorityString)throws Throwable{
		licenceIssuingAuthority_textBox.clear();
		licenceIssuingAuthority_textBox.sendKeys(licenceIssuingAuthorityString);
	}
	
//	输入籍贯
	public void enterNativePlace(String nativePlaceString)throws Throwable{
		nativePlace_textBox.clear();
		nativePlace_textBox.sendKeys(nativePlaceString);
	}

//	输入家庭电话
	public void enterHomePhone(String homePhoneString)throws Throwable{
		homePhone_textBox.clear();
		homePhone_textBox.sendKeys(homePhoneString);
	}
	
//	选择住房状况
	public void selectHousingStatus(String housingStatusString)throws Throwable{
		Thread.sleep(1000);
		WebElement housingStatus = driver.findElement(By.name("housingStatus"));
		Select mySelect= new Select(housingStatus);
		mySelect.selectByVisibleText(housingStatusString);
	}
	
//	选择最高学历
	public void selectEducation(String educationString)throws Throwable{
		Thread.sleep(1000);
		WebElement education = driver.findElement(By.name("education"));
		Select mySelect= new Select(education);
		mySelect.selectByVisibleText(educationString);
	}
	
//	选择职业
	public void selectProfessionCode(String professionCodeString)throws Throwable{
		Thread.sleep(1000);
		WebElement professionCode = driver.findElement(By.name("professionCode"));
		Select mySelect= new Select(professionCode);
		mySelect.selectByVisibleText(professionCodeString);
	}
	
	
//	选择职务	
	public void selectPost(String postString)throws Throwable{
		Thread.sleep(1000);
		WebElement post = driver.findElement(By.name("post"));
		Select mySelect= new Select(post);
		mySelect.selectByVisibleText(postString);
	}
	
//	选择所属行业
	public void selectIndustry(String industryString)throws Throwable{
		Thread.sleep(1000);
		WebElement industry = driver.findElement(By.name("industry"));
		Select mySelect= new Select(industry);
		mySelect.selectByVisibleText(industryString);
	}
	
//	选择单位经济性质
	public void selectWorkNatureCode(String workNatureCodeString)throws Throwable{
		Thread.sleep(1000);
		WebElement workNatureCode = driver.findElement(By.name("workNatureCode"));
		Select mySelect= new Select(workNatureCode);
		mySelect.selectByVisibleText(workNatureCodeString);
	}
	
//	选择个人月收入
	public void selectMonthlyIncome(String monthlyIncomeString)throws Throwable{
		Thread.sleep(1000);
		WebElement monthlyIncome = driver.findElement(By.name("monthlyIncome"));
		Select mySelect= new Select(monthlyIncome);
		mySelect.selectByVisibleText(monthlyIncomeString);
	}
	
//	年收入
	public void enterYearlyIncome(String yearlyIncomeString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		yearlyIncome_textBox.clear();
		yearlyIncome_textBox.sendKeys(yearlyIncomeString);
	}
	
//	选择公积金情况
	public void selectReservedFundsYear(String reservedFundsYearString)throws Throwable{
		Thread.sleep(1000);
		WebElement reservedFundsYear = driver.findElement(By.name("reservedFundsYear"));
		Select mySelect= new Select(reservedFundsYear);
		mySelect.selectByVisibleText(reservedFundsYearString);
	}
	
//	选择公积金
	public void selectReservedFunds(String reservedFundsString)throws Throwable{
		Thread.sleep(1000);
		WebElement reservedFunds = driver.findElement(By.name("reservedFunds"));
		Select mySelect= new Select(reservedFunds);
		mySelect.selectByVisibleText(reservedFundsString);
	}
	
	
//	选择社保情况
	public void selectSocialYear(String socialYearString)throws Throwable{
		Thread.sleep(1000);
		WebElement socialYear = driver.findElement(By.name("socialYear"));
		Select mySelect= new Select(socialYear);
		mySelect.selectByVisibleText(socialYearString);
	}
	
//	输入工作单位
	public void enterCompanyName(String companyNameString)throws Throwable{
		companyName_textBox.clear();
		companyName_textBox.sendKeys(companyNameString);
	}

//	输入单位电话
	public void enterCompanyPhone(String companyPhoneString)throws Throwable{
		companyPhone_textBox.clear();
		companyPhone_textBox.sendKeys(companyPhoneString);
	}
	
//	输入入职时间
	public void enterEmployTime(String employTimeString)throws Throwable{
		employTime_textBox.clear();
		employTime_textBox.sendKeys(employTimeString);
	}
	
//	选择单位地址（省）
	public void selectCompanyAddressPid(String companyAddressPidString)throws Throwable{
		Thread.sleep(1000);
		WebElement companyAddressPid = driver.findElement(By.name("companyAddressPid"));
		Select mySelect= new Select(companyAddressPid);
		mySelect.selectByVisibleText(companyAddressPidString);
	}
	
//	选择单位地址（市）
	public void selectCompanyAddressCid(String companyAddressCidString)throws Throwable{
		Thread.sleep(3000);
		WebElement companyAddressCid = driver.findElement(By.name("companyAddressCid"));
		Select mySelect= new Select(companyAddressCid);
		mySelect.selectByVisibleText(companyAddressCidString);
	}
	
//	选择单位地址（区）
	public void selectCompanyAddressRid(String companyAddressRidString)throws Throwable{
		Thread.sleep(3000);
		WebElement companyAddressRid = driver.findElement(By.name("companyAddressRid"));
		Select mySelect= new Select(companyAddressRid);
		mySelect.selectByVisibleText(companyAddressRidString);
	}
	
//	输入详细地址
	public void enterCompanyAddressDetail(String companyAddressDetailString)throws Throwable{
		companyAddressDetail_textBox.clear();
		companyAddressDetail_textBox.sendKeys(companyAddressDetailString);
	}
	
	
//	选择家庭地址（省）
	public void selectHomeAddressPid(String homeAddressPidString)throws Throwable{
		Thread.sleep(1000);
		WebElement homeAddressPid = driver.findElement(By.name("homeAddressPid"));
		Select mySelect= new Select(homeAddressPid);
		mySelect.selectByVisibleText(homeAddressPidString);
	}
	
//	选择家庭地址（市）
	public void selectHomeAddressCid(String homeAddressCidString)throws Throwable{
		Thread.sleep(3000);
		WebElement homeAddressCid = driver.findElement(By.name("homeAddressCid"));
		Select mySelect= new Select(homeAddressCid);
		mySelect.selectByVisibleText(homeAddressCidString);
	}
	
//	选择家庭地址（区）
	public void selectHomeAddressRid(String homeAddressRidString)throws Throwable{
		Thread.sleep(3000);
		WebElement homeAddressRid = driver.findElement(By.name("homeAddressRid"));
		Select mySelect= new Select(homeAddressRid);
		mySelect.selectByVisibleText(homeAddressRidString);
	}
	
//	输入现居住地入住时间
	public void enterCurAddressTime(String curAddressTimeString)throws Throwable{
		curAddressTime_textBox.clear();
		curAddressTime_textBox.sendKeys(curAddressTimeString);
	}
	
//	输入家庭详细地址
	public void enterHomeAddressDetail(String homeAddressDetailString)throws Throwable{
		homeAddressDetail_textBox.clear();
		homeAddressDetail_textBox.sendKeys(homeAddressDetailString);
	}
	
//	选择是否代购
	public void selectIsAgency(String isAgencyString)throws Throwable{
		Thread.sleep(1000);
		WebElement isAgency = driver.findElement(By.name("isAgency"));
		Select mySelect= new Select(isAgency);
		mySelect.selectByVisibleText(isAgencyString);
	}
	
//	点击新增联系人
	public void clickAddNewContractsbutton()throws Throwable{
		
		Thread.sleep(2000);
		addNewContracts_btn.click();
	}
	
//	输入紧急联系人姓名
	public void enterEmergencyContractsName(String emergencyContractsNameString)throws Throwable{
		Thread.sleep(1000);
		emergencyContact_textBox.clear();
		emergencyContact_textBox.sendKeys(emergencyContractsNameString);
	}
	
//	选择紧急联系人关系
	public void selectEmergencyRelationship(String emergencyRelationshipString)throws Throwable{
		Thread.sleep(1000);
		WebElement emergencyRelationship = driver.findElement(By.name("relationship"));
		Select mySelect= new Select(emergencyRelationship);
		mySelect.selectByVisibleText(emergencyRelationshipString);
	}
	
//	选择紧急联系人是否用车人
	public void selectIsCarUser(String isCarUserString)throws Throwable{
		Thread.sleep(2000);
		WebElement isCarUser = driver.findElement(By.name("isCarUser"));
		Select mySelect= new Select(isCarUser);
		mySelect.selectByVisibleText(isCarUserString);
	}
	
//	输入紧急联系人手机号码
	public void enterEmergencyMobilePhone(String emergencyMobilePhoneString)throws Throwable{
		Thread.sleep(2000);
		mobilePhone_textBox.clear();
		mobilePhone_textBox.sendKeys(emergencyMobilePhoneString);
	}
	
//	保存紧急联络人
	public void clickContractsSaveBtn()throws Throwable{
		Thread.sleep(1000);
		contractsSave_btn.click();
	}
	
//	选择是否同意
	public void selectAgreeOption(String agreeString)throws Throwable{
		if(agreeString.equals("同意")){
			agree_btn.click();
		}
		else {
			disAgree_btn.click();
		}
	}
	
//	填写流程意见
	public void enterAdvice(String adviceString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
		opinionText_textBox.clear();
		opinionText_textBox.sendKeys(adviceString);
	}
	
//	切换到预算单页面
	public void clickBudgetPanel()throws Throwable{
		Thread.sleep(4000);
		budget_panel.click();
	}
	
//	选择是否公牌
	public void selectIsPublicLicense(String isPublicLicenseString)throws Throwable{
		Thread.sleep(2000);
		WebElement isPublicLicense = driver.findElement(By.name("isPublicLicense"));
		Select mySelect= new Select(isPublicLicense);
		mySelect.selectByVisibleText(isPublicLicenseString);
	}
	
//	选择打款方式
	public void selectPaymentMethod(String paymentMethodString)throws Throwable{
		Thread.sleep(2000);
		WebElement paymentMethod = driver.findElement(By.name("paymentMethod"));
		Select mySelect= new Select(paymentMethod);
		mySelect.selectByVisibleText(paymentMethodString);
	}
	
//	选择提车方式
	public void selectDeliveryMethod(String deliveryMethodString)throws Throwable{
		Thread.sleep(2000);
		WebElement deliveryMethod = driver.findElement(By.name("deliveryMethod"));
		Select mySelect= new Select(deliveryMethod);
		mySelect.selectByVisibleText(deliveryMethodString);
	}
	
//	输入已收金额
	public void enterCollectedAmount(String collectedAmountString)throws Throwable{
		collectedAmount_textBox.clear();
		collectedAmount_textBox.sendKeys(collectedAmountString);
	}
	
//	输入新总总贴息金额
	public void enterXzzDiscountAmount(String xzzDiscountAmountString)throws Throwable{
		Thread.sleep(2000);
		xzzDiscountAmount_textBox.clear();
		xzzDiscountAmount_textBox.sendKeys(xzzDiscountAmountString);
	}
	
	
//	点击提交按钮
	public void clickSubmitButton()throws Throwable{
		Thread.sleep(2000);
		submit_btn.click();
	}
	
//	点击确认提交按钮
	public void clickSureOptionButton()throws Throwable{
		Thread.sleep(2000);
		sureOption_btn.click();
		Thread.sleep(2000);
	}
	
}
