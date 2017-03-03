package cls.ui.application.beforeloan;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import cls.ui.base.SpringContextHolder;
import cls.ui.dao.beforeloan.LoanCancelDao;
import cls.ui.dao.beforeloan.LoanModifyDao;
import cls.ui.model.selenium.IndexPage;
import cls.ui.model.selenium.loancancel.LoanCancelIndex;
import cls.ui.model.selenium.loancancel.RefundConfirmPage;
import cls.ui.model.selenium.loanmodify.BranchCompanyFinanceManagerPage;
import cls.ui.model.selenium.loanmodify.BranchCompanyManagerPage;
import cls.ui.model.selenium.loanmodify.BranchCompanyRefundConfirmPage;
import cls.ui.model.selenium.loanmodify.FinanceRefundConfirmPage;
import cls.ui.model.selenium.loanreview.BusinessEnteringPage;
import cls.ui.model.selenium.loanreview.HeadQuatersReviewCenterPage;
import cls.ui.model.selenium.loanreview.MiddleReviewPage;
import cls.ui.model.selenium.loanreview.PrimaryReviewPage;
import cls.ui.model.selenium.loanreview.StartLoanPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class LoanCancelStepdefs {
	
	private LoanCancelDao LoanCancelDao; 
	private IndexPage indexPage = PageFactory.initElements(IndexPage.getWebDriver(), IndexPage.class);
	private LoanCancelIndex loanCancelIndex = PageFactory.initElements(LoanCancelIndex.getWebDriver(), LoanCancelIndex.class);
	private BusinessEnteringPage businessEnteringPage = PageFactory.initElements(BusinessEnteringPage.getWebDriver(), BusinessEnteringPage.class);
	private PrimaryReviewPage primaryReviewPage = PageFactory.initElements(PrimaryReviewPage.getWebDriver(), PrimaryReviewPage.class);
	private MiddleReviewPage middleReviewPage = PageFactory.initElements(MiddleReviewPage.getWebDriver(), MiddleReviewPage.class);
	private BranchCompanyManagerPage branchCompanyManagerPage = PageFactory.initElements(BranchCompanyManagerPage.getWebDriver(), BranchCompanyManagerPage.class);
	private HeadQuatersReviewCenterPage headQuatersReviewCenterPage = PageFactory.initElements(HeadQuatersReviewCenterPage.getWebDriver(), HeadQuatersReviewCenterPage.class);
	private BranchCompanyFinanceManagerPage branchCompanyFinanceManagerPage = PageFactory.initElements(BranchCompanyFinanceManagerPage.getWebDriver(), BranchCompanyFinanceManagerPage.class);
	private RefundConfirmPage refundConfirmPage = PageFactory.initElements(RefundConfirmPage.getWebDriver(), RefundConfirmPage.class);
	private BranchCompanyRefundConfirmPage branchCompanyRefundConfirmPage = PageFactory.initElements(BranchCompanyRefundConfirmPage.getWebDriver(), BranchCompanyRefundConfirmPage.class);
	private FinanceRefundConfirmPage financeRefundConfirmPage = PageFactory.initElements(FinanceRefundConfirmPage.getWebDriver(), FinanceRefundConfirmPage.class);
	
	@Given("^Login to system for testing Loan Cancel$")
	public void init()throws Throwable{
		LoanCancelDao = (LoanCancelDao)SpringContextHolder.getBean(LoanCancelDao.class);
		//Login to system
		indexPage.init();
		Assert.assertTrue(indexPage.isLoginSuccess());
	}
	
	@Given("^Navigate to Start Loan Cancel Page$")
	public void Navigate_to_Start_Loan_Cancel_Page(final List<Map<String, String>> args)throws Throwable{
		String customerNameString = args.get(0).get("customerName"); 
		indexPage.clickManagementBeforeCreditPanel();
		indexPage.clickLoanCancelButton();
		loanCancelIndex.enterCustomerName(customerNameString);
		loanCancelIndex.clickSearchButton();
		loanCancelIndex.clickOperationButton();
	}
	
	@Given("^Enter advice in Start Loan Cancel Page$")
	public void enter_advice_in_Start_Loan_Cancel_Page(final List<Map<String, String>> args) throws Throwable {
		String adviceString = args.get(0).get("advice");
//		输入流程意见
		businessEnteringPage.enterAdvice(adviceString);
	}

	@Given("^Submit in Start Loan Cancel Page$")
	public void submit_in_Start_Loan_Cancel_Page() throws Throwable {
//		点击 提交
		businessEnteringPage.clickSubmitButton();
		businessEnteringPage.clickSureOptionButton();
	}
	
	@Given("^Select next node from My Task in Loan Cancel Process$")
	public void select_next_node_from_My_Task_in_Loan_Cancel_Process(final List<Map<String, String>> args) throws Throwable {
//		我的任务
		String customerNameString = args.get(0).get("customerName");
		String processNameString= args.get(0).get("processName");
		indexPage.refreshPage();
		indexPage.clickMyTaskPanel();
		indexPage.clickMyTaskButton();
		indexPage.enterCustomerName(customerNameString);
		indexPage.selectProcessName(processNameString);
		indexPage.clickSearchButton();
		indexPage.clickOperationButton();
	}
	
	@Then("^Enter advice in Loan Cancel Primary Review Page$")
	public void Enter_advice_in_Loan_Cancel_Primary_Review_Page(final List<Map<String, String>> args) throws Throwable {
		String adviceString = args.get(0).get("advice");
		primaryReviewPage.enterOpinionText(adviceString);
	}
	
	@And("^Submit in Loan Cancel Primary Review Page$")
	public void Submit_in_Loan_Cancel_Primary_Review_Page()throws Throwable{
		primaryReviewPage.clickSubmitButton();
		primaryReviewPage.clickFinalConfirmButton();
	}
	
	@Then("^Enter advice in Loan Cancel Middle Review Page$")
	public void Enter_advice_in_Loan_Cancel_Middle_Review_Page(final List<Map<String, String>> args) throws Throwable {
		String adviceString = args.get(0).get("advice");
		middleReviewPage.enterOpinionText(adviceString);
	}

	@And("^Submit in Loan Cancel Middle Review Page$")
	public void Submit_in_Loan_Cancel_Middle_Review_Page(final List<Map<String, String>> args)throws Throwable{
		String submitterString = args.get(0).get("submitter");
		middleReviewPage.clickSubmitButton();
		middleReviewPage.clickFinalConfirmButton(submitterString);
	} 
	
	@Then("^Enter advice in Loan Cancel Branch Company Manager Page$")
	public void Enter_advice_in_Loan_Cancel_Branch_Company_Manager_Page(final List<Map<String, String>> args)throws Throwable{
		String adviceString = args.get(0).get("advice");
		branchCompanyManagerPage.enterOpinionText(adviceString);
	}
	
	@And("^Submit in Loan Cancel Branch Company Manager Page$")
	public void Submit_in_Loan_Cancel_Branch_Company_Manager_Page()throws Throwable{
		branchCompanyManagerPage.clickSubmitButton();
		branchCompanyManagerPage.clickFinalConfirmButton();
	}
	
	@Then("^Enter advice in Loan Cancel Headquaters Review Center Page$")
	public void Enter_advice_in_Loan_Cancel_Headquaters_Review_Center_Page(final List<Map<String, String>> args)throws Throwable{
		String adviceString = args.get(0).get("advice");
		headQuatersReviewCenterPage.enterOpinionText(adviceString);
	}
	
	@And("^Submit in Loan Cancel Headquaters Review Center Page$")
	public void Submit_in_Loan_Cancel_Headquaters_Review_Center_Page()throws Throwable{
		headQuatersReviewCenterPage.clickSubmitButton();
		headQuatersReviewCenterPage.clickFinalConfirmButton();
	}
	
	@Then("^Enter advice in Loan Cancel Refund Confirm Page$")
	public void Enter_advice_in_Loan_Cancel_Refund_Confirm_Page(final List<Map<String, String>> args)throws Throwable{
		String adviceString = args.get(0).get("advice");
		refundConfirmPage.enterOpinionText(adviceString);
	}
	
	@And("^Submit in Loan Cancel Refund Confirm Page$")
	public void Submit_in_Loan_Cancel_Refund_Confirm_Page(final List<Map<String, String>> args)throws Throwable{
		String submitterString = args.get(0).get("submitter");
		refundConfirmPage.clickSubmitButton();
		refundConfirmPage.clickFinalConfirmButton();
		refundConfirmPage.selectSubmitter(submitterString);
	}
	
	@Then("^Enter advice in Loan Cancel Branch Company Refund Confirm Page$")
	public void Enter_advice_in_Loan_Cancel_Branch_Company_Refund_Confirm_Page(final List<Map<String, String>> args)throws Throwable{
		String adviceString = args.get(0).get("advice");
		branchCompanyRefundConfirmPage.enterOpinionText(adviceString);
	}
	
	@And("^Submit in Loan Cancel Branch Company Refund Confirm Page$")
	public void Submit_in_Loan_Cancel_Branch_Company_Refund_Confirm_Page(final List<Map<String, String>> args)throws Throwable{
		String submitterString = args.get(0).get("submitter");
		branchCompanyRefundConfirmPage.clickSubmitButton();
		branchCompanyRefundConfirmPage.clickFinalConfirmButton();
		branchCompanyRefundConfirmPage.selectSubmitter(submitterString);
	}
	
	@Then("^Enter advice in Loan Cancel Finance Refund Confirm Page$")
	public void Enter_advice_in_Loan_Cancel_Finance_Refund_Confirm_Page(final List<Map<String, String>> args)throws Throwable{
		String adviceString = args.get(0).get("advice");
		financeRefundConfirmPage.enterOpinionText(adviceString);
	}
	
	@And("^Submit in Loan Cancel Finance Refund Confirm Page$")
	public void Submit_in_Loan_Cancel_Finance_Refund_Confirm_Page(final List<Map<String, String>> args)throws Throwable{
		String submitterString = args.get(0).get("submitter");
		financeRefundConfirmPage.clickSubmitButton();
		financeRefundConfirmPage.clickFinalConfirmButton();
		financeRefundConfirmPage.selectSubmitter(submitterString);
	}
	
	
}
