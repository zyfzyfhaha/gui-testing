package cls.ui.application.beforeloan;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import cls.ui.dao.beforeloan.LoanInquireDao;
import cls.ui.model.selenium.IndexPage;
import cls.ui.model.selenium.loaninquire.ContractInfoPage;
import cls.ui.model.selenium.loaninquire.InfoInLoanPage;
import cls.ui.model.selenium.loaninquire.LoanBudgetPage;
import cls.ui.model.selenium.loaninquire.LoanDetailPage;
import cls.ui.model.selenium.loaninquire.LoanInquireIndex;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

public class LoanInquireStepdefs{
	
	private IndexPage indexPage = PageFactory.initElements(IndexPage.getWebDriver(), IndexPage.class);
	private LoanInquireIndex loanInquireIndex = PageFactory.initElements(LoanInquireIndex.getWebDriver(), LoanInquireIndex.class);
	private LoanDetailPage loanDetailPage = PageFactory.initElements(LoanDetailPage.getWebDriver(), LoanDetailPage.class);
	private LoanBudgetPage loanBudgetPage = PageFactory.initElements(LoanBudgetPage.getWebDriver(), LoanBudgetPage.class);
	private ContractInfoPage contractInfoPage = PageFactory.initElements(ContractInfoPage.getWebDriver(), ContractInfoPage.class);
	private InfoInLoanPage infoInLoanPage = PageFactory.initElements(InfoInLoanPage.getWebDriver(), InfoInLoanPage.class);
	
	@Given("Login to system for testing Loan Inquire")
	public void init()throws Throwable{
		// Login to system
		indexPage.init();
		Assert.assertTrue(indexPage.isLoginSuccess());
	}
	
	@Given("Navigate to LoanInquireIndex page")
	public void navigateToLoanInquireIndexPage() throws Throwable{
		indexPage.clickManagementBeforeCreditPanel();
		Thread.sleep(1000);
		indexPage.clickLoanInquireButton();
		Thread.sleep(2000);
	}
	
	@And("Navigate to LoanDetail page")
	public void navigateToLoanDetailPage(final List<Map<String, String>> args) throws Throwable {
		loanInquireIndex.init();
		String customerName = args.get(0).get("customerName");
		loanInquireIndex.enterCustomerName(customerName);
		loanInquireIndex.clickSearchButton();
		loanInquireIndex.clickOperationButton();
		loanDetailPage.init();
	}
	
	@Then("Check loan info overview")
	public void checkLoanInfoOverview(
			final List<Map<String, String>> args) throws Throwable{
		//检查开票价是否一致
		String billingPrice = args.get(0).get("billingPrice");
		Assert.assertTrue(loanDetailPage.equalsBillingPrice(billingPrice));
		
		//检查贷款额是否相同
		String loanAmount = args.get(0).get("loanAmount");
		Assert.assertTrue(loanDetailPage.equalsLoanAmount(loanAmount));
		
		//检查分期手续费是否相同
		String handingFee = args.get(0).get("handingFee");
		Assert.assertTrue(loanDetailPage.equalsHandingFee(handingFee));
		
		//检查月还款是否相同
		String product = args.get(0).get("product");
		String cardNo = args.get(0).get("cardNo");
		String repaymentAmount = loanDetailPage.calculateRepaymentAmount(loanAmount, handingFee, product,cardNo);
		Assert.assertTrue(loanDetailPage.equalsRepaymentAmount(repaymentAmount));
	}
	
	@When("Click budget Tab")
	public void clickBudgetTab(){
		loanDetailPage.clickBudgetTab();
	}
	
	@Then("Check loanBudget info")
	public void checkLoanBudget(
			final List<Map<String, String>> args) throws Throwable{
		//检查贷款额是否相同
		String loanAmount = args.get(0).get("loanAmount");
		Assert.assertTrue(loanBudgetPage.equalsLoanAmount(loanAmount));
		
		//检查手续费是否相同,不含%号
		String handingFee = args.get(0).get("handingFee");
		Assert.assertTrue(loanBudgetPage.equalsHandingFee(handingFee));
		
		//检查开票价是否相同
		String billingPrice = args.get(0).get("billingPrice");
		Assert.assertTrue(loanBudgetPage.equalsBillingPrice(billingPrice));
		
		//检查首付款是否相同
		String downPaymentAmount = loanBudgetPage.calculateDownPaymentAmount(billingPrice, loanAmount);
		Assert.assertTrue(loanBudgetPage.equalsDownPaymentAmount(downPaymentAmount));
		
		//检查贷款比例是否相同
		String loanRatio = loanBudgetPage.calculateLoanRatio(billingPrice, loanAmount);
		Assert.assertTrue(loanBudgetPage.equalsLoanRatio(loanRatio));
		
		//检查贴息
		
		
		//合作银行、金融产品
		String cardNo = args.get(0).get("cardNo");
		
		//检查试算月还款额是否相同
		String testedRepayment = loanBudgetPage.calculateRepaymentAmount(loanAmount, handingFee, cardNo);
		Assert.assertTrue(loanBudgetPage.equalsTestedRepaymentAmount(testedRepayment));
		
		//检查已收金额是否相同
		String collectedAmount = args.get(0).get("collectedAmount");
		Assert.assertTrue(loanBudgetPage.equalsCollectedAmount(collectedAmount));
		
		//获取费用合计值以便计算预收金额和应付金额（由于case均使用默认值，费用合计没什么好统计的）
		String totalFee = loanBudgetPage.getTotalFee();
		
		//检查预收金额是否相同
		String preCollectedAmount = loanBudgetPage.calculatePreCollectedAmount(billingPrice, loanAmount, totalFee, collectedAmount);
		Assert.assertTrue(loanBudgetPage.equalsPreCollectedAmount(preCollectedAmount));
		
		//检查应收金额是否相同
		String payableAmount = loanBudgetPage.calculatePayableAmount(loanAmount, collectedAmount, totalFee);
		Assert.assertTrue(loanBudgetPage.equalsPayableAmount(payableAmount));
	}
	
	@When("Click contractInfo Tab")
	public void clickContractInfoTab(){
		loanDetailPage.clickContractInfoTab();
	}
	
	@Then("Check contract info")
	public void checkContractInfo(
			final List<Map<String, String>> args) throws Throwable{	
		String loanAmount = args.get(0).get("loanAmount");
		String handingFee = args.get(0).get("handingFee");
		String cardNo = args.get(0).get("cardNo");
		String product = args.get(0).get("product");
		//检查分期手续费是否相同
		String bankInstallmentFee = contractInfoPage.calculateBankInstallmentFee(loanAmount, handingFee, cardNo);
		Assert.assertTrue(contractInfoPage.equalsBankInstallmentFee(bankInstallmentFee));
		
		//检查用卡须知-首期偿还总额
		String repaymentAmount = loanDetailPage.calculateRepaymentAmount(loanAmount, handingFee, product, cardNo);
		Assert.assertTrue(contractInfoPage.equalsNoticeDownpaymentAmount(repaymentAmount));
		
		//检查用卡须知-每期偿还总额是否相同
		Assert.assertTrue(contractInfoPage.equalsNoticePeriodpaymentAmount(repaymentAmount));
		
		//检查用卡须知-末期偿还总额是否相同
		Assert.assertTrue(contractInfoPage.equalsNoticeFinalpaymentAmount(repaymentAmount));
		
		//检查还款合同-每期利息是否相同
		String contractPeriodpaymentInterest = contractInfoPage.calculateContractPeriodpaymentInterest(loanAmount, handingFee, cardNo);
		Assert.assertTrue(contractInfoPage.equalsContractPeriodpaymentInterest(contractPeriodpaymentInterest));
		
		//检查还款合同-首期偿还总额是否相同
		Assert.assertTrue(contractInfoPage.equalsContractDownpaymentAmount(repaymentAmount));
		
		//检查还款合同-每期偿还总额是否相同
		Assert.assertTrue(contractInfoPage.equalsContractPeriodpaymentAmount(repaymentAmount));
		
		//检查还款合同-末期偿还总额是否相同
		Assert.assertTrue(contractInfoPage.equalsContractFinalpaymentAmount(repaymentAmount));
	}
	
	@When("Click InfoInLoan Tab")
	public void clickInfoInLoanTab(){
		loanDetailPage.clickLoanManageTab();
	}
	
	@Then("Check info in loan")
	public void checkInfoInLoan(
			final List<Map<String, String>> args) throws Throwable{
		//检查贷款总额是否相同
		String loanAmount = args.get(0).get("loanAmount");
		Assert.assertTrue(infoInLoanPage.equalsLoanAmount(loanAmount));
		indexPage.quit();
		
	}
}