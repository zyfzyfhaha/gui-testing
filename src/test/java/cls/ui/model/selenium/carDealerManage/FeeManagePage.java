package cls.ui.model.selenium.carDealerManage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cls.ui.base.BaseWebDriver;

public class FeeManagePage extends BaseWebDriver{
	//点击费用管理
	public void clickFeeManageButton()throws Throwable{
		WebElement feeManageBtn = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/ul/li[2]/a"));
		feeManageBtn.click();
	}
	
	//点击添加费用
	public void clickAddFee()throws Throwable{
		WebElement addFeeBtn = driver.findElement(By.id("addFee-btn"));
		addFeeBtn.click();
		Thread.sleep(1000);
	}
	
	//输入费用方案名称
	public void enterFeeName(String feeName)throws Throwable{
		List<WebElement> feeNameLst = driver.findElements(By.name("feeName"));
		WebElement feeNameText = feeNameLst.get(1);
		feeNameText.clear();
		feeNameText.sendKeys(feeName);
	}
	
	//选择期限
	public void selectTerm(String term)throws Throwable{
		WebElement termSelect = driver.findElement(By.name("nper"));
		Select mySelect = new Select(termSelect);
		mySelect.selectByVisibleText(term);
	}
	
	//输入手续费率
	public void enterPoundage(String poundage)throws Throwable{
		WebElement poundageText = driver.findElement(By.name("handingFee"));
		poundageText.clear();
		poundageText.sendKeys(poundage);
	}
	
	//输入最低收益
	public void enterMinEarnings(String minEarnings)throws Throwable{
		WebElement minEarningsText = driver.findElement(By.name("minEarnings"));
		minEarningsText.clear();
		minEarningsText.sendKeys(minEarnings);
	}
	
	//选择营销费收取方式
	public void selectRebateType(String rebateType)throws Throwable{
		WebElement rebateTypeSelect = driver.findElement(By.id("rebateType"));
		Select mySelect = new Select(rebateTypeSelect);
		mySelect.selectByVisibleText(rebateType);
	}
	
	//输入营销费/营销费上限
	public void enterRebate(String rebate)throws Throwable{
		WebElement rebateText = driver.findElement(By.name("rebate"));
		rebateText.clear();
		rebateText.sendKeys(rebate);
	}
	
	//输入返销售团队
	public void enterRebateTeam(String rebateTeam)throws Throwable{
		WebElement rebateTeamText = driver.findElement(By.name("rebateTeam"));
		rebateTeamText.clear();
		rebateTeamText.sendKeys(rebateTeam);
	}
	
	//输入按揭手续费
	public void enterGuarantyRiskAmount(String guarantyRiskAmount)throws Throwable{
		WebElement guarantyRiskAmountText = driver.findElement(By.id("guarantyRiskAmount"));
		guarantyRiskAmountText.clear();
		guarantyRiskAmountText.sendKeys(guarantyRiskAmount);
	}
	
	//输入按揭服务费
	public void enterServeFee(String serveFee)throws Throwable{
		WebElement serveFeeText = driver.findElement(By.id("serveFee"));
		serveFeeText.clear();
		serveFeeText.sendKeys(serveFee);
	}
	
	//输入上牌费
	public void enterRegistrationCharge(String registrationCharge)throws Throwable{
		WebElement registrationChargeText = driver.findElement(By.id("registrationCharge"));
		registrationChargeText.clear();
		registrationChargeText.sendKeys(registrationCharge);
	}
	
	//输入上门调查费
	public void enterOnSiteSurveyFee(String onSiteSurveyFee)throws Throwable{
		WebElement onSiteSurveyFeeText = driver.findElement(By.id("onSiteSurveyFee"));
		onSiteSurveyFeeText.clear();
		onSiteSurveyFeeText.sendKeys(onSiteSurveyFee);
	}
	
	//输入评估费
	public void enterValuationFee(String valuationFee)throws Throwable{
		WebElement valuationFeeText = driver.findElement(By.id("valuationFee"));
		valuationFeeText.clear();
		valuationFeeText.sendKeys(valuationFee);
	}
	//输入银行利差
	public void enterBankInterestMargin(String bankInterestMargin)throws Throwable{
		WebElement bankInterestMarginText = driver.findElement(By.id("bankInterestMargin"));
		bankInterestMarginText.clear();
		bankInterestMarginText.sendKeys(bankInterestMargin);
	}
	//选择GPS(台)
	public void selectGPSNum(String GPSNum)throws Throwable{
		WebElement GPSNumSelect = driver.findElement(By.id("gpsNumber"));
		Select mySelect = new Select(GPSNumSelect);
		mySelect.selectByVisibleText(GPSNum);
	}
	
	//选择GPS类型
	public void selectGPSType(String GPSType)throws Throwable{
		WebElement GPSTypeSelect = driver.findElement(By.id("gpsType"));
		Select mySelect = new Select(GPSTypeSelect);
		mySelect.selectByVisibleText(GPSType);
	}
	
	//输入GPS厂家
	public void enterGPSFactory(String GPSFactory)throws Throwable{
		WebElement GPSFactoryText = driver.findElement(By.id("gpsFactory"));
		GPSFactoryText.clear();
		GPSFactoryText.sendKeys(GPSFactory);
	}
	
	//输入GPS安装费
	public void enterGPSInstallFee(String GPSInstallFee)throws Throwable{
		WebElement GPSFactoryText = driver.findElement(By.id("gpsInstallationFee"));
		GPSFactoryText.clear();
		GPSFactoryText.sendKeys(GPSInstallFee);
	}
	
	//输入责信险
	public void enterLiabilityAmount(String liabilityAmount)throws Throwable{
		WebElement liabilityAmountText = driver.findElement(By.id("liabilityAmount"));
		liabilityAmountText.clear();
		liabilityAmountText.sendKeys(liabilityAmount);
	}
	
	//选择第一年保费
	public void selectPremiumType(String premiumType)throws Throwable{
		WebElement premiumTypeSelect = driver.findElement(By.id("premiumType"));
		Select mySelect = new Select(premiumTypeSelect);
		mySelect.selectByVisibleText(premiumType);
	}
	
	//输入金额(第一年保费)
	public void enterInsuranceAmount(String insuranceAmount)throws Throwable{
		WebElement insuranceAmountText = driver.findElement(By.id("insuranceAmount"));
		insuranceAmountText.clear();
		insuranceAmountText.sendKeys(insuranceAmount);
	}
	
	//选择是否续保
	public void selectIsRenewal(String isRenewal)throws Throwable{
		WebElement isRenewalSelect = driver.findElement(By.id("isRenewal"));
		Select mySelect = new Select(isRenewalSelect);
		mySelect.selectByVisibleText(isRenewal);
	}
	
	//输入履约保证金
	public void enterPBDeposit(String pbDeposit)throws Throwable{
		WebElement pbDepositText = driver.findElement(By.id("pbDeposit"));
		pbDepositText.clear();
		pbDepositText.sendKeys(pbDeposit);
	}
	
	//输入上牌抵押押金
	public void enterAccountDeposit(String accountDeposit)throws Throwable{
		WebElement accountDepositText = driver.findElement(By.id("accountDeposit"));
		accountDepositText.clear();
		accountDepositText.sendKeys(accountDeposit);
	}
	
	//选择工本费
	public void selectCostType(String costType)throws Throwable{
		WebElement costTypeSelect = driver.findElement(By.id("costType"));
		Select mySelect = new Select(costTypeSelect);
		mySelect.selectByVisibleText(costType);
	}
	
	//输入金额(工本费)
	public void enterCostAmount(String costAmount)throws Throwable{
		WebElement costAmountText = driver.findElement(By.id("costAmount"));
		costAmountText.clear();
		costAmountText.sendKeys(costAmount);
	}
	
	//选择预计车辆购置税
	public void selectPredictedPurchasetax(String predictedPurchasetax)throws Throwable{
		WebElement predictedPurchasetaxSelect = driver.findElement(By.id("predictedPurchasetax"));
		Select mySelect = new Select(predictedPurchasetaxSelect);
		mySelect.selectByVisibleText(predictedPurchasetax);
	}
	
	//输入金额(车辆购置税)
	public void enterVehiclePurchaseTaxFee(String vehiclePurchaseTaxFee)throws Throwable{
		WebElement vehiclePurchaseTaxFeeText = driver.findElement(By.id("vehiclePurchaseTaxFee"));
		vehiclePurchaseTaxFeeText.clear();
		vehiclePurchaseTaxFeeText.sendKeys(vehiclePurchaseTaxFee);
	}
	
	//输入车行服务费
	public void enterDealerServerCharge(String dealerServerCharge)throws Throwable{
		WebElement dealerServerChargeText = driver.findElement(By.id("dealerServerCharge"));
		dealerServerChargeText.clear();
		dealerServerChargeText.sendKeys(dealerServerCharge);
	}
	
	//输入外包调查费
	public void enterOutsourcingServiceCharge(String outsourcingServiceCharge)throws Throwable{
		WebElement outsourcingServiceChargeText = driver.findElement(By.id("outsourcingServiceCharge"));
		outsourcingServiceChargeText.clear();
		outsourcingServiceChargeText.sendKeys(outsourcingServiceCharge);
	}
	
	//输入备注
	public void enterRemark(String remark)throws Throwable{
		WebElement remarkText = driver.findElement(By.name("remark"));
		remarkText.clear();
	}
	
	//点击保存
	public void clickSaveButton()throws Throwable{
		WebElement saveBtn = driver.findElement(By.id("save-fee"));
		saveBtn.click();
		Thread.sleep(1000);
	}
	
	//点击取消
	public void clickCancelButton()throws Throwable{
		WebElement cancelBtn = driver.findElement(By.id("resetFeeForm"));
		cancelBtn.click();
	}
	
	//点击提交
	public void clickSubmitButton()throws Throwable{
		WebElement submitBtn = driver.findElement(By.id("btn-flowSubmit"));
		submitBtn.click();
	}
	
	//点击提交确认框的确定按钮
	public void clickConfirmYesButton()throws Throwable{
		WebElement confirmBtn = driver.findElement(By.id("sureOption"));
		confirmBtn.click();
	}
	
	//点击提交确认框的取消按钮
	public void clickConfirmNoButton()throws Throwable{
		WebElement cancelBtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[5]/div/div/div[3]/button[2]"));
		cancelBtn.click();
	}
	
	//选择流转人员
	public void selectNextUserName(String submitterName)throws Throwable{
		List<WebElement> userIdLst = driver.findElements(By.name("userId"));
		
		int lstSize = userIdLst.size();
		int userId = 0;
		
		for(int i=1;i<=lstSize;i++){
			String tempName = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr["+i+"]/td[4]")).getText();
			if(tempName.equals(submitterName)){
				userId = i-1;
				break;
			}
		}
		
		WebElement selectUserId = userIdLst.get(userId);
		selectUserId.click();
	}
	
	//点击任务提交的确定按钮
	public void clickSubmitYesButton()throws Throwable{
		WebElement confirmBtn = driver.findElement(By.id("select-sign-btn"));
		confirmBtn.click();
	}
	
	//点击任务提交的取消按钮
	public void clickSubmitNoButton()throws Throwable{
		WebElement cancelBtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/div[3]/button[2]"));
		cancelBtn.click();
	}
}