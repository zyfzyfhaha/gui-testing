package cls.ui.application.beforeloan;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cls.ui.base.SpringContextHolder;
import cls.ui.dao.beforeloan.LoanModifyDao;
import cls.ui.model.selenium.IndexPage;
import cls.ui.model.selenium.loanmodify.BranchCompanyFinanceManagerPage;
import cls.ui.model.selenium.loanmodify.BranchCompanyManagerPage;
import cls.ui.model.selenium.loanmodify.BranchCompanyRefundConfirmPage;
import cls.ui.model.selenium.loanmodify.FinanceRefundConfirmPage;
import cls.ui.model.selenium.loanmodify.LoanModifyIndex;
import cls.ui.model.selenium.loanreview.BranchCompanyPayPage;
import cls.ui.model.selenium.loanreview.BusinessEnteringPage;
import cls.ui.model.selenium.loanreview.CapitalAllocationPage;
import cls.ui.model.selenium.loanreview.HeadQuatersReviewCenterPage;
import cls.ui.model.selenium.loanreview.MiddleReviewPage;
import cls.ui.model.selenium.loanreview.PayRequestPage;
import cls.ui.model.selenium.loanreview.PayReviewPage;
import cls.ui.model.selenium.loanreview.PrimaryReviewPage;
import cls.ui.model.selenium.loanreview.StartLoanPage;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class LoanModifyStepdefs {
	
	private LoanModifyDao loanModifyDao;
	private IndexPage indexPage = PageFactory.initElements(IndexPage.getWebDriver(), IndexPage.class);
	private LoanModifyIndex loanModifyIndex = PageFactory.initElements(LoanModifyIndex.getWebDriver(), LoanModifyIndex.class);
	private StartLoanPage startLoanPage = PageFactory.initElements(StartLoanPage.getWebDriver(), StartLoanPage.class);
	private BusinessEnteringPage businessEnteringPage = PageFactory.initElements(BusinessEnteringPage.getWebDriver(), BusinessEnteringPage.class);
	private PrimaryReviewPage primaryReviewPage = PageFactory.initElements(PrimaryReviewPage.getWebDriver(), PrimaryReviewPage.class);
	private MiddleReviewPage middleReviewPage = PageFactory.initElements(MiddleReviewPage.getWebDriver(), MiddleReviewPage.class);
	private BranchCompanyManagerPage branchCompanyManagerPage = PageFactory.initElements(BranchCompanyManagerPage.getWebDriver(), BranchCompanyManagerPage.class);
	private HeadQuatersReviewCenterPage headQuatersReviewCenterPage = PageFactory.initElements(HeadQuatersReviewCenterPage.getWebDriver(), HeadQuatersReviewCenterPage.class);
	private BranchCompanyFinanceManagerPage branchCompanyFinanceManagerPage = PageFactory.initElements(BranchCompanyFinanceManagerPage.getWebDriver(), BranchCompanyFinanceManagerPage.class);
	private BranchCompanyRefundConfirmPage branchCompanyRefundConfirmPage = PageFactory.initElements(BranchCompanyRefundConfirmPage.getWebDriver(), BranchCompanyRefundConfirmPage.class);
	private FinanceRefundConfirmPage financeRefundConfirmPage = PageFactory.initElements(FinanceRefundConfirmPage.getWebDriver(), FinanceRefundConfirmPage.class);
	private PayRequestPage payRequestPage = PageFactory.initElements(PayRequestPage.getWebDriver(), PayRequestPage.class);
	private PayReviewPage payReviewPage = PageFactory.initElements(PayReviewPage.getWebDriver(), PayReviewPage.class);
	private CapitalAllocationPage capitalAllocationPage = PageFactory.initElements(CapitalAllocationPage.getWebDriver(), CapitalAllocationPage.class);
	private BranchCompanyPayPage branchCompanyPayPage = PageFactory.initElements(BranchCompanyPayPage.getWebDriver(), BranchCompanyPayPage.class);
	
	@Given("^Login to system for testing Loan Modify$")
	public void init(final List<Map<String, String>> args)throws Throwable{
		loanModifyDao = (LoanModifyDao)SpringContextHolder.getBean(LoanModifyDao.class);

//		Login to system
		indexPage.init();
		Assert.assertTrue(indexPage.isLoginSuccess());

//		delete diry data
		String cardNumberString = args.get(0).get("idNumber");
		List<String> applyIds = loanModifyDao.getApplyId(cardNumberString);
		int count = applyIds.size();
		if(count != 0){
			loanModifyDao.deleteSqlWithOneParamter("beforeloanmanagement", "LoanModify", applyIds);
		}
	}
	
	@Given("^Navigate to Start Loan Modify Page$")
	public void navigate_to_Start_Loan_Modify_Page(final List<Map<String, String>> args) throws Throwable {
		String customerNameString = args.get(0).get("customerName");
//	点击进入发起贷款修改
		indexPage.clickManagementBeforeCreditPanel();
		indexPage.clickLoanModifyButton();
		loanModifyIndex.selectSpecificCustomer(customerNameString);
		loanModifyIndex.clickOperationButton();
	}

	@Given("^Modify the loan details in Start Loan Modify Page$")
	public void modify_the_loan_details_in_Start_Loan_Modify_Page(final List<Map<String, String>> args) throws Throwable {
		String loanPriceString = args.get(0).get("loanPrice");
		String addressString = args.get(0).get("address");
		//		修改详细地址		
		startLoanPage.enterAddress(addressString);
		
		//		修改贷款金额
		startLoanPage.enterLoanPrice(loanPriceString);
	}

	@Given("^Submit in Start Loan Modify Page$")
	public void submit_in_Start_Loan_Modify_Page(final List<Map<String, String>> args) throws Throwable {
		String submitterString = args.get(0).get("submitter");
		startLoanPage.clickSubmitButton();
		startLoanPage.clickSureOption();
		startLoanPage.selectSubmitter(submitterString);
		startLoanPage.clickfinalSureOptionButton();
	}
	
	@Given("^Select next node from My Task in Loan Modify Process$")
	public void select_next_node_from_my_task(final List<Map<String, String>> args)throws Throwable{
		indexPage.clickMyTaskPanel();
		indexPage.clickMyTaskButton();
		
		String customerNameString = args.get(0).get("customerName");
		String processNameString = args.get(0).get("processName");
		indexPage.enterCustomerName(customerNameString);
		indexPage.selectProcessName(processNameString);
		indexPage.clickSearchButton();
		indexPage.clickOperationButton();
	}
	
	@Then("^Modify the loan details in Loan Modify Business Input Page$")
	public void Modify_the_loan_details_in_Business_Input_Page(final List<Map<String, String>> args)throws Throwable{
		String yearlyIncomeString = args.get(0).get("yearlyIncome");
		String adviceString = args.get(0).get("advice");
		businessEnteringPage.enterYearlyIncome(yearlyIncomeString);
		businessEnteringPage.enterAdvice(adviceString);
	}
	
    @And("^Submit in Loan Modify Business Input Page$")
    public void submit_in_business_input_page()throws Throwable{
    	businessEnteringPage.clickSubmitButton();
    	businessEnteringPage.clickSureOptionButton();
    }
    
    @Then("^Modify advice in Loan Modify Primary Review Page$")
    public void Modify_advice_in_Loan_Modify_Primary_Review_Page(final List<Map<String, String>> args)throws Throwable{
    	String adviceString = args.get(0).get("advice");
//    	写说明建议
    	primaryReviewPage.enterOpinionText(adviceString);
    }
    
    @And("^Submit in Loan Modify Primary Review Page$")
    public void Submit_in_Loan_Modify_Primary_Review_Page()throws Throwable{
//    	提交
    	primaryReviewPage.clickSubmitButton();
    	primaryReviewPage.clickFinalConfirmButton();
    }
    
    @Then("^Modify advice in Loan Modify Middle Review Page$")
    public void Modify_advice_in_Loan_Modify_Middle_Review_Page(final List<Map<String, String>> args)throws Throwable{
    	String adviceString = args.get(0).get("advice");
//    	写说明建议
    	middleReviewPage.enterOpinionText(adviceString);
    }
    
    @And("^Submit in Loan Modify Middle Review Page$")
    public void Submit_in_Loan_Modify_Middle_Review_Page(final List<Map<String, String>> args)throws Throwable{
    	String submitterString = args.get(0).get("submitter");
//    	提交
    	middleReviewPage.clickSubmitButton();
    	middleReviewPage.clickFinalConfirmButton(submitterString);
    }
    
    @Then("^Modify advice in Loan Modify Branch Company Manager Page$")
    public void Modify_advice_in_Loan_Modify_Branch_Company_Manager_Page(final List<Map<String, String>> args)throws Throwable{
    	String adviceString = args.get(0).get("advice");
    	branchCompanyManagerPage.enterOpinionText(adviceString);
    }
    
    @Then("Submit in Loan Modify Branch Company Manager Page")
    public void Submit_in_Loan_Modify_Branch_Company_Manager_Page()throws Throwable{
    	branchCompanyManagerPage.clickSubmitButton();
    	branchCompanyManagerPage.clickFinalConfirmButton();
    }
    
    @Then("^Modify advice in Loan Modify Headquaters Review Center Page$")
    public void  Modify_advice_in_Loan_Modify_Headquaters_Review_Center_Page(final List<Map<String, String>> args)throws Throwable{
    	String adviceString = args.get(0).get("advice");
    	headQuatersReviewCenterPage.enterOpinionText(adviceString);
    }
	
    @And("^Submit in Loan Modify Headquaters Review Center Page$")
    public void Submit_in_Loan_Modify_Headquaters_Review_Center_Page()throws Throwable{
    	headQuatersReviewCenterPage.clickSubmitButton();
    	headQuatersReviewCenterPage.clickFinalConfirmButton();
    }
    
    @Then("Modify in Loan Modify Branch Company Finance Manager Page")
    public void Modify_advice_in_Loan_Modify_Branch_Company_Finance_Manager_Page(final List<Map<String, String>> args)throws Throwable{
    	String payMethodString = args.get(0).get("payMethod");
    	String adviceString = args.get(0).get("advice");
    	branchCompanyFinanceManagerPage.selectPayAll(payMethodString);
    	branchCompanyFinanceManagerPage.enterOpinionText(adviceString);
    }
    
    @And("Submit in Loan Modify Branch Company Finance Manager Page")
    public void Submit_in_Loan_Modify_Branch_Company_Finance_Manager_Page(final List<Map<String, String>> args)throws Throwable{
    	String submitterString = args.get(0).get("submitter");
//    	提交
    	branchCompanyFinanceManagerPage.clickSubmitButton();
    	branchCompanyFinanceManagerPage.clickFinalConfirmButton();
    	branchCompanyFinanceManagerPage.selectSubmitter(submitterString);
    }
    
    @Then("^Modify advice in Loan Modify Branch Company Refund Confirm Page$")
    public void Modify_advice_in_Loan_Modify_Branch_Company_Refund_Confirm_Page(final List<Map<String, String>> args)throws Throwable{
    	String adviceString = args.get(0).get("advice");
    	branchCompanyRefundConfirmPage.enterOpinionText(adviceString);
    }
    @And("^Submit in Loan Modify Branch Company Refund Confirm Page$")
    public void Submit_in_Loan_Modify_Branch_Company_Refund_Confirm_Page(final List<Map<String, String>> args)throws Throwable{
    	String submitterString = args.get(0).get("submitter");
    	branchCompanyRefundConfirmPage.clickSubmitButton();
    	branchCompanyRefundConfirmPage.clickFinalConfirmButton();
    	branchCompanyRefundConfirmPage.selectSubmitter(submitterString);
    }
    
    @Then("^Modify advice in Loan Modify Finance Refund Confirm Page$")
    public void Modify_advice_in_Loan_Modify_Finance_Refund_Confirm_Page(final List<Map<String, String>> args)throws Throwable{
    	String adviceString = args.get(0).get("advice");
    	financeRefundConfirmPage.enterOpinionText(adviceString);
    }
    
    @And("^Submit in Loan Modify Finance Refund Confirm Page$")
    public void Submit_in_Loan_Modify_Finance_Refund_Confirm_Page()throws Throwable{
    	financeRefundConfirmPage.clickSubmitButton();
    	financeRefundConfirmPage.clickFinalConfirmButton();
    }
    
    @Then("^Modify advice in Loan Modify Pay Request Page$")
    public void Modify_advice_in_Loan_Modify_Pay_Request_Page(final List<Map<String, String>> args)throws Throwable{
    	String adviceString = args.get(0).get("advice");
    	payRequestPage.enterOpinionText(adviceString);
    }
  
    @And("^Submit in Loan Modify Pay Request Page$")
    public void Submit_in_Loan_Modify_Pay_Request_Page(final List<Map<String, String>> args)throws Throwable{
	  String submitterString = args.get(0).get("submitter");
	  payRequestPage.clickSubmitButton();
	  payRequestPage.clickSureOptionButton();
	  payRequestPage.selectSubmitter(submitterString);
  }
    
    @Then("^Modify advice in Loan Modify Pay Review Page$")
    public void Modify_advice_in_Loan_Modify_Pay_Review_Page(final List<Map<String, String>> args)throws Throwable{
//    	填写流程意见
		String adviceString = args.get(0).get("advice");
    	payReviewPage.enterOpinionText(adviceString);
    }
  
    @And("^Submit in Loan Modify Pay Review Page$")
    public void Submit_in_Loan_Modify_Pay_Review_Page(final List<Map<String, String>> args)throws Throwable{
	  String submitterString = args.get(0).get("submitter");
	  payReviewPage.clickSubmitButton();
	  payReviewPage.clickSureOptionButton();
	  payReviewPage.selectSubmitter(submitterString);
  }
    
    @Then("^Modify advice in Loan Modify Capital Allocation Page$")
    public void Modify_advice_in_Loan_Modify_Capital_Allocation_Page(final List<Map<String, String>> args)throws Throwable{
    	String adviceString = args.get(0).get("advice");
    	payReviewPage.enterOpinionText(adviceString);
    }
  
    @And("^Submit in Loan Modify Capital Allocation Page$")
    public void Submit_in_Loan_Modify_Capital_Allocation_Page(final List<Map<String, String>> args)throws Throwable{
	  String submitterString = args.get(0).get("submitter");
	  payReviewPage.clickSubmitButton();
	  payReviewPage.clickSureOptionButton();
	  payReviewPage.selectSubmitter(submitterString);
  }
    
    @Then("^Modify advice in Loan Modify Branch Company Pay Page$")
    public void Modify_advice_in_Loan_Modify_Branch_Company_Pay_Page(final List<Map<String, String>> args)throws Throwable{
    	String explanationString = args.get(0).get("explanation");
    	String adviceString = args.get(0).get("advice");
    	
    	branchCompanyRefundConfirmPage.enterOpinionText(adviceString);
    	branchCompanyRefundConfirmPage.enterPayExplanation(explanationString);
    }
  
    @And("^Submit in Loan Modify Branch Company Pay Page$")
    public void Submit_in_Loan_Modify_Branch_Company_Pay_Page(final List<Map<String, String>> args)throws Throwable{
	  String submitterString = args.get(0).get("submitter");
	  branchCompanyRefundConfirmPage.clickSubmitButton();
	  branchCompanyRefundConfirmPage.clickFinalConfirmButton();
	  branchCompanyRefundConfirmPage.selectSubmitter(submitterString);
	  branchCompanyRefundConfirmPage.quit();
  }
    
    
    
}
