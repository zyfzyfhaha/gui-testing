package cls.ui.model.selenium.loaninquire;

import java.math.BigDecimal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import cls.ui.base.BaseWebDriver;
import cls.ui.base.SpringContextHolder;
import cls.ui.dao.beforeloan.LoanInquireDao;

public class ContractInfoPage extends BaseWebDriver{
	private LoanInquireDao loanInquireDao;
	private LoanBudgetPage loanBudgetPage = PageFactory.initElements(LoanBudgetPage.getWebDriver(), LoanBudgetPage.class);
	
	//检查分期手续费是否相同
	public boolean equalsBankInstallmentFee(String bankInstallmentFee) {
		WebElement bankInstallmentFeeInput = driver.findElement(By.name("bankInstallmentFee"));
		boolean ret = bankInstallmentFeeInput.getAttribute("value").equals(bankInstallmentFee);
		return ret;
	}
	
	//计算分期手续费
	public String calculateBankInstallmentFee(String loanAmountStr,String handingFeeStr,String cardNo) {
		loanInquireDao = (LoanInquireDao)SpringContextHolder.getBean(LoanInquireDao.class);
		String productId = loanInquireDao.getProductId(cardNo);
		String benchmarkRateStr = loanInquireDao.getBenchmarkRate(productId);
		
		double loanAmount = Double.valueOf(loanAmountStr);//贷款金额
		double handingFee = Double.valueOf(handingFeeStr);//手续费
		double benchmarkRate = Double.valueOf(benchmarkRateStr);//基准费率（%）
		
		//计算担保服务费(贷款金额*（1+公司费率）/（1+基准费率）-贷款金额)此处加0.5是为了四舍五入取整
		int serviceFee = (int) (loanAmount*(1+handingFee/100)/(1+benchmarkRate/100)-loanAmount+0.5);
		
		//计算银行分期金额(担保服务费+贷款金额)
		double installmentAmount = serviceFee+loanAmount;
		
		//计算银行分期手续费(银行分期金额*基准费率)保留两位小数
		double tempInstallmentHandingFee = installmentAmount*benchmarkRate/100;
		BigDecimal tempHandingFee =new BigDecimal(tempInstallmentHandingFee);  
		double installmentHandingFee = tempHandingFee.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		String installmentHandingFeeStr = loanBudgetPage.formatRemoveZero(installmentHandingFee);
		
		return installmentHandingFeeStr;
	}
	
	//检查用卡须知-首期偿还总额是否相同
	public boolean equalsNoticeDownpaymentAmount(String noticeDownpaymentAmount) {
		WebElement noticeDownpaymentAmountInput = driver.findElement(By.name("noticeDownpaymentAmount"));
		boolean ret = noticeDownpaymentAmountInput.getAttribute("value").equals(noticeDownpaymentAmount);
		return ret;
	}
	
	//检查用卡须知-每期偿还总额是否相同
	public boolean equalsNoticePeriodpaymentAmount(String noticePeriodpaymentAmount) {
		WebElement noticePeriodpaymentAmountInput = driver.findElement(By.name("noticePeriodpaymentAmount"));
		boolean ret = noticePeriodpaymentAmountInput.getAttribute("value").equals(noticePeriodpaymentAmount);
		return ret;
	}
	
	//检查用卡须知-末期偿还总额是否相同
	public boolean equalsNoticeFinalpaymentAmount(String noticeFinalpaymentAmount) {
		WebElement noticeFinalpaymentAmountInput = driver.findElement(By.name("noticeFinalpaymentAmount"));
		boolean ret = noticeFinalpaymentAmountInput.getAttribute("value").equals(noticeFinalpaymentAmount);
		return ret;
	}
	
	//检查还款合同-每期利息是否相同
	public boolean equalsContractPeriodpaymentInterest(String contractPeriodpaymentInterest) {
		WebElement contractPeriodpaymentInterestInput = driver.findElement(By.name("contractPeriodpaymentInterest"));
		boolean ret = contractPeriodpaymentInterestInput.getAttribute("value").equals(contractPeriodpaymentInterest);
		return ret;
	}
	
	//计算还款合同-每期利息
	public String calculateContractPeriodpaymentInterest(String loanAmountStr,String handingFeeStr,String cardNo) {
		//计算银行分期手续费(银行分期金额*基准费率)保留两位小数
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
		
		//每期利息(银行分期金额*基准费率/期数)保留两位小数
		double tempPeriodpaymentInterest = installmentAmount*benchmarkRate/100/periodNumber;
		BigDecimal tempInterest =new BigDecimal(tempPeriodpaymentInterest);  
		double periodpaymentInterest = tempInterest.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		String periodpaymentInterestStr = loanBudgetPage.formatRemoveZero(periodpaymentInterest);
		
		return periodpaymentInterestStr;
	}
	
	//检查还款合同-首期偿还总额是否相同
	public boolean equalsContractDownpaymentAmount(String contractDownpaymentAmount) {
		WebElement contractDownpaymentAmountInput = driver.findElement(By.name("contractDownpaymentAmount"));
		boolean ret = contractDownpaymentAmountInput.getAttribute("value").equals(contractDownpaymentAmount);
		return ret;
	}
	
	//检查还款合同-每期偿还总额是否相同
	public boolean equalsContractPeriodpaymentAmount(String contractPeriodpaymentAmount) {
		WebElement contractPeriodpaymentAmountInput = driver.findElement(By.name("contractPeriodpaymentAmount"));
		boolean ret = contractPeriodpaymentAmountInput.getAttribute("value").equals(contractPeriodpaymentAmount);
		return ret;
	}

	//检查还款合同-末期偿还总额是否相同
	public boolean equalsContractFinalpaymentAmount(String contractFinalpaymentAmount) {
		WebElement contractFinalpaymentAmountInput = driver.findElement(By.name("contractFinalpaymentAmount"));
		boolean ret = contractFinalpaymentAmountInput.getAttribute("value").equals(contractFinalpaymentAmount);
		return ret;
	}
}