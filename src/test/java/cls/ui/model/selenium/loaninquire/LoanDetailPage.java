package cls.ui.model.selenium.loaninquire;

import java.math.BigDecimal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import cls.ui.base.BaseWebDriver;
import cls.ui.base.SpringContextHolder;
import cls.ui.dao.beforeloan.LoanInquireDao;

public class LoanDetailPage extends BaseWebDriver{
	private LoanInquireDao loanInquireDao;
	private LoanBudgetPage loanBudgetPage = PageFactory.initElements(LoanBudgetPage.getWebDriver(), LoanBudgetPage.class);
	//初始化
	public void init() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_undefined");
	}
	
	//检查开票价是否相同
	public boolean equalsBillingPrice(String billingPrice) {
		WebElement billingPriceText = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/p"));
		boolean ret = billingPriceText.getText().equals(billingPrice);
		return ret;
	}
	
	//检查贷款额是否相同
	public boolean equalsLoanAmount(String loanAmount) {
		WebElement loanAmountText = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[1]/div[2]/div[2]/div/div[3]/div[1]/div/p"));
		boolean ret = loanAmountText.getText().equals(loanAmount);
		return ret;
	}
	
	//检查分期手续费是否相同
	public boolean equalsHandingFee(String handingFee) {
		WebElement handingFeeText = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[1]/div[2]/div[2]/div/div[3]/div[2]/div/p/span"));
		boolean ret = handingFeeText.getText().equals(handingFee);
		return ret;
	}
	
	//检查月还款是否相同
	public Boolean equalsRepaymentAmount(String repaymentAmount) {
		WebElement repaymentAmountText = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[1]/div[2]/div[2]/div/div[3]/div[3]/div/p"));
		Boolean ret = repaymentAmountText.getText().equals(repaymentAmount);
		return ret;
	}
	
	//计算月还款
	public String calculateRepaymentAmount(String loanAmountStr,String handingFeeStr,String product,String cardNo){
		loanInquireDao = (LoanInquireDao)SpringContextHolder.getBean(LoanInquireDao.class);
		String periodNumberStr = loanInquireDao.getPeriodNumber(cardNo);
		String productId = loanInquireDao.getProductId(cardNo);
		String benchmarkRateStr = loanInquireDao.getBenchmarkRate(productId);
		
		double loanAmount = Double.valueOf(loanAmountStr);//贷款金额
		double handingFee = Double.valueOf(handingFeeStr);//手续费
		double benchmarkRate = Double.valueOf(benchmarkRateStr);//基准费率（%）
		int periodNumber;//期数
		int num = Integer.valueOf(periodNumberStr);
		switch (num) {
		case 1:
			periodNumber = 12;
			break;
		case 2:
			periodNumber = 24;
			break;
		case 3:
			periodNumber = 18;
			break;
		case 4: 
			periodNumber = 36;
			break;
		default:
			periodNumber = 36;
			break;
		}
		
		//计算担保服务费(贷款金额*（1+公司费率）/（1+基准费率）-贷款金额)此处加0.5是为了四舍五入取整
		int serviceFee = (int) (loanAmount*(1+handingFee/100)/(1+benchmarkRate/100)-loanAmount+0.5);
		
		//计算银行分期金额(担保服务费+贷款金额)
		double installmentAmount = serviceFee+loanAmount;
		
		//计算银行分期手续费(银行分期金额*基准费率)保留两位小数
		double tempInstallmentHandingFee = installmentAmount*benchmarkRate/100;
		BigDecimal tempHandingFee =new BigDecimal(tempInstallmentHandingFee);  
		double installmentHandingFee = tempHandingFee.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		//计算月还款
		double result=(installmentAmount+installmentHandingFee)/periodNumber;
		//四舍五入保留两位小数，并转化为字符串
		BigDecimal tempResult =new BigDecimal(result);  
		double repaymentAmount = tempResult.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		String repaymentAmountStr = loanBudgetPage.formatRemoveZero(repaymentAmount);
		
		return repaymentAmountStr;
	}
	
	//点击贷款信息总览
	public void clickLoanDetailInfo() {
		WebElement loanDetailInfoTab = driver.findElement(By.id("tab1"));
		loanDetailInfoTab.click();
	}
	
	//点击客户资料tab
	public void clickCustomerInfoTab() {
		WebElement customerInfoTab = driver.findElement(By.id("tab2"));
		customerInfoTab.click();
	}
	
	//点击预算单tab
	public void clickBudgetTab() {
		WebElement budgetTab = driver.findElement(By.id("tab3"));
		budgetTab.click();
	}
	
	//点击汽车信息tab
	public void clickCarInfoTab() {
		WebElement carInfoTab = driver.findElement(By.id("tab4"));
		carInfoTab.click();
	}
	
	//点击影像管理tab
	public void clickImageInfoTab() {
		WebElement imageInfoTab = driver.findElement(By.id("tab5"));
		imageInfoTab.click();
	}
	
	//点击保险信息tab
	public void clickInsuranceInfoTab() {
		WebElement insuranceInfoTab = driver.findElement(By.id("tab6"));
		insuranceInfoTab.click();
	}
	
	//点击合同信息tab
	public void clickContractInfoTab() {
		WebElement contractInfoTab = driver.findElement(By.id("tab7"));
		contractInfoTab.click();
	}
	
	//点击反担保信息tab
	public void clickGuaranteeInfoTab() {
		WebElement guaranteeInfoTab = driver.findElement(By.id("tab8"));
		guaranteeInfoTab.click();
	}
	
	//点击贷中信息tab
	public void clickLoanManageTab() {
		WebElement loanManageTab = driver.findElement(By.id("tab9"));
		loanManageTab.click();
	}
	
	//点击征信信息tab
	public void clickCreditInfoTab() {
		WebElement creditInfoTab = driver.findElement(By.id("tab10"));
		creditInfoTab.click();
	}
	
	//点击GPS信息tab
	public void clickGPSInfoTab() {
		WebElement GPSInfoTab = driver.findElement(By.id("tab1"));
		GPSInfoTab.click();
	}
	
	//点击过程信息tab
	public void clickOpinionInfoTab() {
		WebElement opinionInfoTab = driver.findElement(By.id("tab12"));
		opinionInfoTab.click();
	}
}