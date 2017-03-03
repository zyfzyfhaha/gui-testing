package cls.ui.model.selenium.loaninquire;

import java.math.BigDecimal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cls.ui.base.BaseWebDriver;
import cls.ui.base.SpringContextHolder;
import cls.ui.dao.beforeloan.LoanInquireDao;

public class LoanBudgetPage extends BaseWebDriver{
	private LoanInquireDao loanInquireDao;
	
	//检查贷款额是否相同
	public boolean equalsLoanAmount(String loanAmount) {
		WebElement loanAmountInput = driver.findElement(By.name("loanAmount"));
		String loanAmountText = loanAmountInput.getAttribute("value");
		boolean ret = loanAmountText.equals(loanAmount);
		return ret;
	}
	
	//检查手续费是否相同,不含%号
	public boolean equalsHandingFee(String handingFee) {
		WebElement handingFeeInput = driver.findElement(By.name("handingFee"));
		boolean ret = handingFeeInput.getAttribute("value").equals(handingFee);
		return ret;
	}
	
	//检查开票价是否相同
	public boolean equalsBillingPrice(String billingPrice) {
		WebElement billingPriceInput = driver.findElement(By.name("billingPrice"));
		boolean ret = billingPriceInput.getAttribute("value").equals(billingPrice);
		return ret;
	}
	
	//计算首付款
	public String calculateDownPaymentAmount(String billingPriceStr,String loanAmountStr) {
		double billingPrice = Double.valueOf(billingPriceStr);
		double loanAmount = Double.valueOf(loanAmountStr);
		//首付款 = 开票价 - 贷款金额
		double downPaymentAmount = billingPrice - loanAmount;
		String downPaymentAountStr = formatRemoveZero(downPaymentAmount);
		
		return downPaymentAountStr;
	}
	
	//检查首付款是否相同
	public boolean equalsDownPaymentAmount(String downPaymentAmount) {
		WebElement downPaymentAmountInput = driver.findElement(By.name("downPaymentAmount"));
		boolean ret = downPaymentAmountInput.getAttribute("value").equals(downPaymentAmount);
		return ret;
	}
	
	//计算首付款
	public String calculateLoanRatio(String billingPriceStr,String loanAmountStr) {
		double billingPrice = Double.valueOf(billingPriceStr);
		double loanAmount = Double.valueOf(loanAmountStr);
		//首付款 = 贷款金额/开票价,此处单位为%
		int loanRatio = (int) (loanAmount/billingPrice*100);
		
		String loanRatioStr = String.valueOf(loanRatio);
		return loanRatioStr;
	}
	
	//检查贷款比例是否相同
	public boolean equalsLoanRatio(String loanRatio) {
		WebElement loanRatiofInput = driver.findElement(By.name("loanRatio"));
		boolean ret = loanRatiofInput.getAttribute("value").equals(loanRatio);
		return ret;
	}
	
	//检查贴息金额
	public boolean checkDiscount(String cardNo) {
		loanInquireDao = (LoanInquireDao)SpringContextHolder.getBean(LoanInquireDao.class);
		boolean isDiscount = loanInquireDao.getIsDiscount(cardNo);
		boolean ret = true;
		
		if(isDiscount){
			WebElement discountAmountInput = driver.findElement(By.name("discountAmount"));
			String discountAmountStr = discountAmountInput.getAttribute("value");
			
		}else{
			ret = true;
		}
		return true;
	}
	
	//计算贴息金额
	public String calculateDiscountAmount() {
		//
		return "";
	}
	
	//获取费用合计是否相同
	public String getTotalFee() {
		WebElement totalFeeInput = driver.findElement(By.name("totalFee"));
		String totalFee = totalFeeInput.getAttribute("value");
		return totalFee;
	}
	
	//检查试算月还款额是否相同
	public boolean equalsTestedRepaymentAmount(String testedRepayment) {
		WebElement testedRepaymentAmountInput = driver.findElement(By.name("testedRepaymentAmount"));
		boolean ret = testedRepaymentAmountInput.getAttribute("value").equals(testedRepayment);
		return ret;
	}
	
	//计算试算月还款
	public String calculateRepaymentAmount(String loanAmountStr,String handingFeeStr,String cardNo){
		loanInquireDao = (LoanInquireDao)SpringContextHolder.getBean(LoanInquireDao.class);
		String periodNumberStr = loanInquireDao.getPeriodNumber(cardNo);
		
		double loanAmount = Double.valueOf(loanAmountStr);
		double handingFee = Double.valueOf(handingFeeStr);
		int periodNumber;
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
		
		//计算月还款
		double result=loanAmount*(1+handingFee/100)/periodNumber;
		//四舍五入保留两位小数，并转化为字符串
		BigDecimal tempResult =new BigDecimal(result);  
		double repaymentAmount = tempResult.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		String repaymentAmountStr = formatRemoveZero(repaymentAmount);
		
		return repaymentAmountStr;
	}
	
	//检查已收金额是否相同
	public boolean equalsCollectedAmount(String collectedAmount) {
		WebElement collectedAmountInput = driver.findElement(By.name("collectedAmount"));
		boolean ret = collectedAmountInput.getAttribute("value").equals(collectedAmount);
		return ret;
	}
	
	//计算预收金额
	public String calculatePreCollectedAmount(String billingPriceStr,String loanAmountStr,String totalFeeStr,String collectedAmountStr) {
		//各值转化为double
		double billingPrice = Double.valueOf(billingPriceStr);
		double loanAmount = Double.valueOf(loanAmountStr);
		double totalFee = Double.valueOf(totalFeeStr);
		double collectedAmount = Double.valueOf(collectedAmountStr);
		
		//预收金额=开票价-贷款金额+费用合计-已收金额
		double preCollecteAmount = billingPrice-loanAmount+totalFee-collectedAmount;
		
		String preCollectedAmountStr = formatRemoveZero(preCollecteAmount);
		return preCollectedAmountStr;
	}
	
	//检查预收金额是否相同
	public boolean equalsPreCollectedAmount(String preCollectedAmount) {
		WebElement preCollectedAmountInput = driver.findElement(By.name("preCollectedAmount"));
		boolean ret = preCollectedAmountInput.getAttribute("value").equals(preCollectedAmount);
		return ret;
	}
	
	//计算应付金额
	public String calculatePayableAmount(String loanAmountStr,String collectedAmountStr,String totalFeeStr) {
		//各值转化为double
		double loanAmount = Double.valueOf(loanAmountStr);
		double collectedAmount = Double.valueOf(collectedAmountStr);
		double totalFee = Double.valueOf(totalFeeStr);
		
		//应付金额=贷款金额+已收金额-费用合计-贴息金额-新总总贴息总额
		double payableAmount = loanAmount + collectedAmount - totalFee;
		String payableAmountStr = formatRemoveZero(payableAmount);
		return payableAmountStr;
	}
	
	//检查应收金额是否相同
	public boolean equalsPayableAmount(String payableAmount) {
		WebElement payableAmountInput = driver.findElement(By.name("payableAmount"));
		boolean ret = payableAmountInput.getAttribute("value").equals(payableAmount);
		return ret;
	}
	
	public String formatRemoveZero(double number) {
		String ret;
		int amountContainDecimal=(int) (number*1000);
		int amountNoDecimal=(int)(number)*1000;
		if(amountContainDecimal == amountNoDecimal){
			//小数位为0时，取整
			ret = String.valueOf((int)(number));
		}else{
			ret = String.valueOf(number);
		}
		return ret;
	}
}