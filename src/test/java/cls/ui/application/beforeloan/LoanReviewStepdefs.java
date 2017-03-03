package cls.ui.application.beforeloan;

import gherkin.lexer.Pa;

import java.util.List;
import java.util.Map;











import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.http.util.Args;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import com.mysql.jdbc.Driver;
import com.steadystate.css.util.ThrowCssExceptionErrorHandler;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cls.ui.base.SpringContextHolder;
import cls.ui.dao.beforeloan.LoanReviewDao;
import cls.ui.dao.filetransfermanagement.FileTransferDao;
import cls.ui.model.selenium.IndexPage;
import cls.ui.model.selenium.filetransfer.FileTransferIndex;
import cls.ui.model.selenium.filetransfer.StartFileTransferpage;
import cls.ui.model.selenium.loanreview.BranchCompanyPayPage;
import cls.ui.model.selenium.loanreview.BusinessEnteringPage;
import cls.ui.model.selenium.loanreview.CapitalAllocationPage;
import cls.ui.model.selenium.loanreview.HeadQuatersReviewCenterPage;
import cls.ui.model.selenium.loanreview.LoanReviewIndex;
import cls.ui.model.selenium.loanreview.MiddleReviewPage;
import cls.ui.model.selenium.loanreview.OrderAllocationPage;
import cls.ui.model.selenium.loanreview.OrderInvestigationVicePage;
import cls.ui.model.selenium.loanreview.OrderInvestigationPage;
import cls.ui.model.selenium.loanreview.PayRequestPage;
import cls.ui.model.selenium.loanreview.PayReviewPage;
import cls.ui.model.selenium.loanreview.PrimaryReviewPage;
import cls.ui.model.selenium.loanreview.StartLoanPage;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class LoanReviewStepdefs {
	
	private LoanReviewDao loanReviewDao;
	private FileTransferDao fileTransferDao;
	private IndexPage indexPage = PageFactory.initElements(IndexPage.getWebDriver(), IndexPage.class);
	private LoanReviewIndex loanReviewIndex = PageFactory.initElements(LoanReviewIndex.getWebDriver(), LoanReviewIndex.class);
	private StartLoanPage startLoanPage = PageFactory.initElements(StartLoanPage.getWebDriver(), StartLoanPage.class);
	private OrderAllocationPage orderAllocationPage = PageFactory.initElements(OrderAllocationPage.getWebDriver(), OrderAllocationPage.class);
	private OrderInvestigationPage orderInvestigationPage = PageFactory.initElements(OrderInvestigationPage.getWebDriver(), OrderInvestigationPage.class);
	private OrderInvestigationVicePage orderInvesitgationVicePage = PageFactory.initElements(OrderInvestigationVicePage.getWebDriver(),OrderInvestigationVicePage.class);
	private BusinessEnteringPage businessEnteringPage = PageFactory.initElements(BusinessEnteringPage.getWebDriver(), BusinessEnteringPage.class);
	private FileTransferIndex fileTransferIndex = PageFactory.initElements(FileTransferIndex.getWebDriver(), FileTransferIndex.class);
	private StartFileTransferpage startFileTransferpage = PageFactory.initElements(StartFileTransferpage.getWebDriver(), StartFileTransferpage.class);
	private PrimaryReviewPage primaryReviewPage = PageFactory.initElements(PrimaryReviewPage.getWebDriver(), PrimaryReviewPage.class);
	private MiddleReviewPage middleReviewPage = PageFactory.initElements(MiddleReviewPage.getWebDriver(), MiddleReviewPage.class);
	private HeadQuatersReviewCenterPage headQuatersReviewCenterPage = PageFactory.initElements(HeadQuatersReviewCenterPage.getWebDriver(), HeadQuatersReviewCenterPage.class);
	private PayRequestPage payRequestPage = PageFactory.initElements(PayRequestPage.getWebDriver(), PayRequestPage.class);
	private PayReviewPage payReviewPage = PageFactory.initElements(PayReviewPage.getWebDriver(), PayReviewPage.class);
	private CapitalAllocationPage capitalAllocationPage = PageFactory.initElements(CapitalAllocationPage.getWebDriver(), CapitalAllocationPage.class);
	private BranchCompanyPayPage branchCompanyPayPage = PageFactory.initElements(BranchCompanyPayPage.getWebDriver(), BranchCompanyPayPage.class);
	
	
	
	@Given("Login to system for testing Loan Review")
	public void init(final List<Map<String, String>> args)throws Throwable{
		loanReviewDao = (LoanReviewDao)SpringContextHolder.getBean(LoanReviewDao.class);
		fileTransferDao = (FileTransferDao)SpringContextHolder.getBean(FileTransferDao.class);
		// Login to system
		indexPage.init();
		Assert.assertTrue(indexPage.isLoginSuccess());
		
//		delete diry data
		String cardNumberString = args.get(0).get("idNumber");
		List<String> applyIds= loanReviewDao.getApplyIds(cardNumberString);
		List<String> projectIds = fileTransferDao.getProjectIdFromDb(cardNumberString);
//		delete loan review
		loanReviewDao.deleteSqlWithOneParamter("beforeloanmanagement", "LoanReview", applyIds);
		
//		delete file transfer
		fileTransferDao.deleteSqlWithOneParamter("filetransfermanagement", "FileTransfer", projectIds);
	}
	
	
	@Given("^Navigate to Loan Review page$")
	public void navigate_to_Loan_Review_page() throws Throwable {
	 indexPage.clickManagementBeforeCreditPanel();
	 indexPage.clickLoanReviewButton();
		
	}

	@And("^Navigate to Start Loan page$")
	public void navigate_to_Start_Loan_page(final List<Map<String, String>> args) throws Throwable {
		String customerNameString = args.get(0).get("customerName");
		loanReviewIndex.enterCustomerName(customerNameString);
		loanReviewIndex.clickSearchButton();
		loanReviewIndex.clickOperationButton();
	}

	@And("^Enter customer details in StartLoan page$")
	public void enter_customer_details_in_StartLoan_page(final List<Map<String, String>> args) throws Throwable {
		
		String isDiscountString = args.get(0).get("isDiscount");
		String businessTypeString = args.get(0).get("businessType");
		String productString = args.get(0).get("product");
		String carTypeString = args.get(0).get("carType");
		String separationString = args.get(0).get("separation");
		String detailBrandString = args.get(0).get("detailBrand");
		String carSeriesString =args.get(0).get("carSeries");
		String carModelString = args.get(0).get("carModel");
		String isImportString = args.get(0).get("isImport");
		String carDealerString = args.get(0).get("carDealer");
		String carFeeString = args.get(0).get("carFee");
		String billingPriceString = args.get(0).get("billingPrice");
		String LoanPriceString = args.get(0).get("loanPrice");
		String handingFeeString = args.get(0).get("handingFee");
		String provinceString = args.get(0).get("province");
		String cityString = args.get(0).get("city");
		String areaString = args.get(0).get("area");
		String addressString = args.get(0).get("address");
		
		
//		选择业务品种
		startLoanPage.selectBusinessType(businessTypeString);
//		选择金融产品
		startLoanPage.selectProduct(productString);
//		选择汽车类型
		startLoanPage.selectCarType(carTypeString);
//		选择是否两港分离
		startLoanPage.selectSeparation(separationString);
		
//		选择是否贴息
		startLoanPage.selectIsDiscount(isDiscountString);
//		选择品牌
		startLoanPage.clickBrand();
		startLoanPage.selectDetailBrand(detailBrandString);
		
//		选择车系
		startLoanPage.selectCarSeries(carSeriesString);
		startLoanPage.selectCarmodel(carModelString);
		
//		选择具体车型
		startLoanPage.selectCarmodel(carModelString);
		
//		选择是否进口车
		startLoanPage.selectIsImported(isImportString);
		
//		选择推荐商
		startLoanPage.selectCarDealer(carDealerString);
		
//		选择车商费用
		startLoanPage.selectCarFee(carFeeString);
		
//		填写开票价
		startLoanPage.enterBillingPrice(billingPriceString);
		
//		填写贷款金额
		startLoanPage.enterLoanPrice(LoanPriceString);
		
//		填写手续费
		startLoanPage.enterHandingFee(handingFeeString);
		
//		选择上门地址（省）
		startLoanPage.selectProvince(provinceString);
		
//		选择市
		startLoanPage.selectCity(cityString);
		
//		选择区
		startLoanPage.selectArea(areaString);
		
//		填写详细地址
		startLoanPage.enterAddress(addressString);
		
//		点击获取位置
		startLoanPage.getAddress();
		
//		选取坐标
		startLoanPage.selectPosition();
	}
	
	@And("^Enter second hand car customer details in StartLoan page$")
	public void enter_second_customer_details_in_StartLoan_page(final List<Map<String, String>> args) throws Throwable {
		
		String isDiscountString = args.get(0).get("isDiscount");
		String businessTypeString = args.get(0).get("businessType");
		String productString = args.get(0).get("product");
		String carTypeString = args.get(0).get("carType");
		String detailBrandString = args.get(0).get("detailBrand");
		String carSeriesString =args.get(0).get("carSeries");
		String carModelString = args.get(0).get("carModel");
		String isImportString = args.get(0).get("isImport");
		String carDealerString = args.get(0).get("carDealer");
		String carFeeString = args.get(0).get("carFee");
		String billingPriceString = args.get(0).get("billingPrice");
		String LoanPriceString = args.get(0).get("loanPrice");
		String handingFeeString = args.get(0).get("handingFee");
		String provinceString = args.get(0).get("province");
		String cityString = args.get(0).get("city");
		String areaString = args.get(0).get("area");
		String addressString = args.get(0).get("address");
		
		
//		选择业务品种
		startLoanPage.selectBusinessType(businessTypeString);
//		选择金融产品
		startLoanPage.selectProduct(productString);
//		选择汽车类型
		startLoanPage.selectCarType(carTypeString);
		//选择二手车信息
		startLoanPage.selectSecondHandCarInfo();

//		选择是否贴息
//		startLoanPage.selectIsDiscount(isDiscountString);
//		选择品牌
//		startLoanPage.clickBrand();
//		startLoanPage.selectDetailBrand(detailBrandString);
		
////		选择车系
//		startLoanPage.selectCarSeries(carSeriesString);
//		startLoanPage.selectCarmodel(carModelString);
//		
////		选择具体车型
//		startLoanPage.selectCarmodel(carModelString);
		
//		选择是否进口车
		startLoanPage.selectIsImported(isImportString);
		
//		选择推荐商
		startLoanPage.selectCarDealer(carDealerString);
		
//		选择车商费用
		startLoanPage.selectCarFee(carFeeString);
		
//		填写开票价
		startLoanPage.enterBillingPrice(billingPriceString);
		
//		填写贷款金额
		startLoanPage.enterLoanPrice(LoanPriceString);
		
//		填写手续费
		startLoanPage.enterHandingFee(handingFeeString);
		
//		选择上门地址（省）
		startLoanPage.selectProvince(provinceString);
		
//		选择市
		startLoanPage.selectCity(cityString);
		
//		选择区
		startLoanPage.selectArea(areaString);
		
//		填写详细地址
		startLoanPage.enterAddress(addressString);
		
//		点击获取位置
		startLoanPage.getAddress();
		
//		选取坐标
		startLoanPage.selectPosition();
	}
	@When("^Click the submit button in StartLoan Page$")
	public void click_the_submit_button()throws Throwable{
//		点击提交按钮
		startLoanPage.clickSubmitButton();
	}
		
	@Then("^Click the confirm YES button in StartLoan Page$")
	public void click_the_confirm_yes_button()throws Throwable{
//		点击提交确认按钮
		startLoanPage.clickSureOption();
	}
	
	@And("^Select a submitter in StartLoan Page$")
	public void select_submmitter(final List<Map<String, String>> args)throws Throwable{
		String submitterString = args.get(0).get("submmiter");

//		选择提交人
		startLoanPage.selectSubmitter(submitterString);
	}
	
	@And("^Click the Final Confirm button in StartLoan Page$")
	public void click_the_final_confirm()throws Throwable{
//		点击确认提交人按钮
		startLoanPage.clickfinalSureOptionButton();
	}
	
	@Given("^Click My Task panel in loan review process when the node submit successfully$")
	public void click_my_task_panel()throws Throwable{
		indexPage.clickMyTaskPanel();
	}

	@Given("^Click My Task button in loan review process when the node submit successfully$")
	public void click_My_Task_button_after_submit_startLoan_page_successfully() throws Throwable {
		indexPage.clickMyTaskButton();
	}
	
	@Given("^Find my client in loan review process when the node submit successfully$")
	public void find_my_client_after_submit_startLoan_page_successfully(final List<Map<String, String>> args) throws Throwable {
	String customerNameString = args.get(0).get("customerName");
	String processNameString = args.get(0).get("processName");
	indexPage.enterCustomerName(customerNameString);
	indexPage.selectProcessName(processNameString);
	indexPage.clickSearchButton();
	}
	
	@Given("^Click the Operation button in loan review process when the node submit successfully$")
	public void click_order_allocation()throws Throwable{
		indexPage.clickOperationButton();
	}
	
	@When("^Enter details in Order Allocation page$")
	public void enter_details_in_Order_Allocation_page(final List<Map<String, String>> args) throws Throwable {
		
		String mainSignNameString = args.get(0).get("mainSigner");
		String mainSignerWeightString =args.get(0).get("mainSignerWeight");
		String viceSignNameString = args.get(0).get("viceSigner");
		String viceSignerWeightString =args.get(0).get("viceSignerWeight");
		String agreeOptionString = args.get(0).get("agreeOption");
		String adviceString = args.get(0).get("advice");
		
//		点击主签单员选择按钮
		orderAllocationPage.clickMainSignSelectButton();
		
//		选择主签单员
		orderAllocationPage.selectMainSign(mainSignNameString);
		
//		填写主签单员权重
		orderAllocationPage.enterMainSignerWeight(mainSignerWeightString);

//		点击次签单员 选择按钮
		orderAllocationPage.clickViceSignSelectButton();
		
//		选择次签单员
		orderAllocationPage.selectViceSign(viceSignNameString);
		
//		填写副签单员权重
		orderAllocationPage.enterViceSignerWeight(viceSignerWeightString);
		
//		选择同意
		orderAllocationPage.selectAgreeOption(agreeOptionString);
		
//		填写流程意见
		orderAllocationPage.enterAdvice(adviceString);
	}

	@Then("^Click the submit button in Order Allocation page$")
	public void click_submit_button_in_order_allocation_page()throws Throwable{
		orderAllocationPage.clickSubmitButton();
	}
	
	@Then("^Click sureOption button in Order Allocation page$")
	public void click_sureOption_button_in_order_allocation_page()throws Throwable{
		orderAllocationPage.clickSureOptionbutton();
	}
	
	@When("^Enter details in Order Investigation page$")
	public void enter_details_in_order_investigation_page(final List<Map<String, String>> args)throws Throwable{
		
		String agreeOptionString = args.get(0).get("agreeOption");
		String adviceString = args.get(0).get("advice");
		
//		选择同意
		orderInvestigationPage.selectAgreeOption(agreeOptionString);

//		填写意见
		orderInvestigationPage.enterAdvice(adviceString);
		
//		切换到影像管理
		orderInvestigationPage.navigateToImageManagement();
		
//		点击客户身份信息
		orderInvestigationPage.clickClientIdentifyInformation();
		
//		点击上传文件tab
		orderInvestigationPage.clickUploadFile();
		
//		点击上传图片
		orderInvestigationPage.clickUpImage();
		
//		点击开始上传
		orderInvestigationPage.clickUpload();
	}
	
	@Then("^Click the submit button in Order Investigation page$")
	public void click_the_submit_button_in_order_investigation_page()throws Throwable{
//		点击提交按钮
		orderInvestigationPage.clickSubmitButton();
	}
	
	@Then("^Click the confirm YES button in Order Investigation Page$")
	public void click_the_confirm_yes_button_in_order_investigation_page()throws Throwable{
//		点击确认提交按钮
		orderInvestigationPage.clickSureOptionButton();
		indexPage.logout();
	}
	
	@Given("^Login to system with specific account$")
	public void login_to_system_with_specific_account(final List<Map<String, String>> args)throws Throwable{
		String userNameString = args.get(0).get("userName");
		String passwordString = args.get(0).get("password");
		indexPage.init();
		indexPage.isLoginSuccessWithSpecificAccount(userNameString, passwordString);
	}
	
//	文档传递
    @And("^Navigate to File Transfer Page in loan review process when the node submit successfully$")
    public void Navigate_to_File_Transfer_Page_in_loan_review_process_when_the_node_submit_successfully()throws Throwable{
    	indexPage.clickFileTransferManagementPanel();
		indexPage.clickFileTransferButton();
    }
    @And("^Navigate to Start File Transfer Page in loan review process when the node submit successfully$")
    public void Navigate_to_Start_File_Transfer_Page_in_loan_review_process_when_the_node_submit_successfully(final List<Map<String, String>> args)throws Throwable{
    	String customerNameString = args.get(0).get("customerName");

		//		进入文档传递编辑
		fileTransferIndex.enterCustomerName(customerNameString);
		fileTransferIndex.clickSearchButton();
		fileTransferIndex.clickOperationButton();
		fileTransferIndex.clickstartFlieTransferButton();
    	
    }
    @When("^Add a file record in loan review process when the node submit successfully$") 
    public void Add_a_file_record_in_loan_review_process_when_the_node_submit_successfully()throws Throwable{
    	startFileTransferpage.clickAddRecordButton();
    }
    
    @And("^Submit the file record$")
    public void submit_the_file_record()throws Throwable{
//    	确认文档提交传递
    	startFileTransferpage.clickSubmitButton();
    	startFileTransferpage.clickSureOptionButton();
    }
    
	@When("^Enter details in Order Investigation vice page$")
	public void enter_details_in_order_investigation_vice_page(final List<Map<String, String>> args)throws Throwable{
		String agreeOptionString = args.get(0).get("agreeOption");
		String adviceString = args.get(0).get("advice");
//		选择同意
		orderInvesitgationVicePage.selectAgreeOption(agreeOptionString);
		
//		填写流程意见
		orderInvesitgationVicePage.enterAdvice(adviceString);
	}
	
	  @Then("^Click the submit button in Order Investigation Vice page$")
	  public void click_the_submit_button_in_order_investigation_vice_page()throws Throwable{
		  orderInvesitgationVicePage.clickSubmitButton();
	  }
	  
	  @Then("^Click the confirm YES button in Order Investigation Vice Page$")
	  public void click_the_confirm_yes_button_in_order_investigation_vice_page()throws Throwable{
		  orderInvesitgationVicePage.clickSureOptionButton();
	  }
	  
	  @Then("^Select a submitter in Order Investigation Vice Page$")
	  public void select_a_submitter_in_order_investigation_vice_page(final List<Map<String, String>> args)throws Throwable{
		  String submitterString = args.get(0).get("submitter");
		  orderInvesitgationVicePage.selectSubmitter(submitterString);
	  }
	  
	  @Then("^Click the final confirm button in Order Investigation Vice Page$")
	  public void click_the_final_confirm_button_in_order_investigation_vice_page()throws Throwable{
		  orderInvesitgationVicePage.clickFinalConfirmButton();
		  indexPage.logout();
	  }
	  
	  @When("^Enter basic details in Business Entering page$")
	  public void enter_details_in_business_entering_page(final List<Map<String, String>> args)throws Throwable{
		  String cardNoValidTimeString = args.get(0).get("cardNoValidTime");
		  String licenceIssuingAuthorityString = args.get(0).get("licenceIssuingAuthority");
		  String nativePlaceString = args.get(0).get("nativePlace");
		  String homePhoneString = args.get(0).get("homePhone");
		  String housingStatusString = args.get(0).get("housingStatus");
		  String educationString = args.get(0).get("education");
		  String professionCodeString = args.get(0).get("professionCode");
		  String postString = args.get(0).get("post");
		  String industryString = args.get(0).get("industry");
		  String workNatureCodeString = args.get(0).get("workNatureCode");
		  String monthlyIncomeString = args.get(0).get("monthlyIncome");
		  String yearlyIncomeString = args.get(0).get("yearlyIncome");
		  String reservedFundsYearString = args.get(0).get("reservedFundsYear");
		  String reservedFundsString = args.get(0).get("reservedFunds");
		  String socialYearString = args.get(0).get("socialYear");
		  String companyNameString = args.get(0).get("companyName");
		  String companyPhoneString = args.get(0).get("companyPhone");
		  String employTimeString = args.get(0).get("employTime");
		  String companyProvinceString = args.get(0).get("companyProvince");
		  String companyCityString = args.get(0).get("companyCity");
		  String companyAreaString = args.get(0).get("companyArea");
		  String companyAddressDetailString = args.get(0).get("companyAddressDetail");
		  String homeProvinceString = args.get(0).get("homeProvince");
		  String homeCityString = args.get(0).get("homeCity");
		  String homeAreaString = args.get(0).get("homeArea");
		  String curAddressTimeString = args.get(0).get("curAddressTime");
		  String homeAddressDetailString = args.get(0).get("homeAddressDetail");
		  String isAgencyString = args.get(0).get("isAgency");
		  String agreeOptionString = args.get(0).get("agreeOption");
		  String adviceString = args.get(0).get("advice");
		  
		  
//		  输入证件有效期
		  businessEnteringPage.enterCardNoValidTime(cardNoValidTimeString);
		  
//		  输入发证机关
		  businessEnteringPage.enterLicenceIssuingAuthority(licenceIssuingAuthorityString);
		  
//		  输入籍贯
		  businessEnteringPage.enterNativePlace(nativePlaceString);
		  
//		  输入手机号码
		  businessEnteringPage.enterHomePhone(homePhoneString);
		  
//		  选择住房状况
		  businessEnteringPage.selectHousingStatus(housingStatusString);
		  
//		  选择最高学历
		  businessEnteringPage.selectEducation(educationString);
		  
//		  选择职业
		  businessEnteringPage.selectProfessionCode(professionCodeString);
		  
//		  选择职务
		  businessEnteringPage.selectPost(postString);
		  
//		  选择所属行业
		  businessEnteringPage.selectIndustry(industryString);
		  
//		  选择单位经济性质
		  businessEnteringPage.selectWorkNatureCode(workNatureCodeString);
		  
//		  选择个人月收入
		  businessEnteringPage.selectMonthlyIncome(monthlyIncomeString);
		  
//		  输入年收入
		  businessEnteringPage.enterYearlyIncome(yearlyIncomeString);
		  
//		  选择公积金情况
		  businessEnteringPage.selectReservedFundsYear(reservedFundsYearString);
		  
//		  选择公积金
		  businessEnteringPage.selectReservedFunds(reservedFundsString);
		  
//		  选择社保情况
		  businessEnteringPage.selectSocialYear(socialYearString);
		  
//		  输入工作单位
		  businessEnteringPage.enterCompanyName(companyNameString);
		  
//		  输入单位电话
		  businessEnteringPage.enterCompanyPhone(companyPhoneString);
		  
//		  输入入职时间
		  businessEnteringPage.enterEmployTime(employTimeString);
		  
//		  选择单位地址 省
		  businessEnteringPage.selectCompanyAddressPid(companyProvinceString);
		  
//		  选择单位地址 市
		  businessEnteringPage.selectCompanyAddressCid(companyCityString);
		  
//		  选择单位地址 区
		  businessEnteringPage.selectCompanyAddressRid(companyAreaString);
		  
//		  输入公司详细地址
		  businessEnteringPage.enterCompanyAddressDetail(companyAddressDetailString);
		  
//		  选择家庭地址 省
		  businessEnteringPage.selectHomeAddressPid(homeProvinceString);
		  
//		  选择家庭地址 市
		  businessEnteringPage.selectHomeAddressCid(homeCityString);

//		 选择家庭地址 区 
		  businessEnteringPage.selectHomeAddressRid(homeAreaString);
		  
//		  输入现居住地入住时间
		  businessEnteringPage.enterCurAddressTime(curAddressTimeString);

//		  详细地址
		  businessEnteringPage.enterHomeAddressDetail(homeAddressDetailString);
		  
////		  选择是否代购
//		  businessEnteringPage.selectIsAgency(isAgencyString);
		  
//		  选择是否同意
		  businessEnteringPage.selectAgreeOption(agreeOptionString);
		  
//		  填写流程意见
		  businessEnteringPage.enterAdvice(adviceString);
	  }
  
	  @And("^Add emergency contracts in Business Entering page$")
	  public void add_emergency_contracts_in_business_entering_page(final List<Map<String, String>> args)throws Throwable{
//		  紧急联系人1
		  String emergencyName1String = args.get(0).get("emergencyName");   
		  String emergencyRelationship1String = args.get(0).get("emergencyRelationship");
		  String emergencyPhone1String = args.get(0).get("emergencyPhone");
		  String emergencyIsCarUser1String = args.get(0).get("emergencyIsCarUser");
		 
//		  紧急联系人2
		  String emergencyName2String = args.get(1).get("emergencyName");   
		  String emergencyRelationship2String = args.get(1).get("emergencyRelationship");
		  String emergencyPhone2String = args.get(1).get("emergencyPhone");
		  String emergencyIsCarUser2String = args.get(1).get("emergencyIsCarUser");
		  
//		  点击新增联系人
		  businessEnteringPage.clickAddNewContractsbutton();
		  
//		  输入紧急联系人姓名1
		  businessEnteringPage.enterEmergencyContractsName(emergencyName1String);
		  
//		  选择紧急联系人关系1
		  businessEnteringPage.selectEmergencyRelationship(emergencyRelationship1String);
		  
//		  输入紧急联系人手机号码1
		  businessEnteringPage.enterEmergencyMobilePhone(emergencyPhone1String);
		  
//		  选择紧急联系人是否为实际用车人1
		  businessEnteringPage.selectIsCarUser(emergencyIsCarUser1String);
		
//		  点击保存紧急联络人按钮
		  businessEnteringPage.clickContractsSaveBtn();
		  
//		  点击新增联系人
		  businessEnteringPage.clickAddNewContractsbutton();
		  
//		  输入紧急联系人姓名2
		  businessEnteringPage.enterEmergencyContractsName(emergencyName2String);
		  
//		  选择紧急联系人关系2
		  businessEnteringPage.selectEmergencyRelationship(emergencyRelationship2String);
		  
//		  输入紧急联系人手机号码2
		  businessEnteringPage.enterEmergencyMobilePhone(emergencyPhone2String);
		  
//		  选择紧急联系人是否为实际用车人2
		  businessEnteringPage.selectIsCarUser(emergencyIsCarUser2String);
		  
//		  点击保存紧急联络人按钮
		  businessEnteringPage.clickContractsSaveBtn();
		  
	  }
	  
	  @And("^Enter budget details in Business Entering page$")
	  public void enter_budget_details_in_business_entering_page(final List<Map<String, String>> args)throws Throwable{
		  
		  String isPublicLicenseString = args.get(0).get("isPublicLicense");
		  String paymentMethodString = args.get(0).get("paymentMethod");
		  String deliveryMethodString = args.get(0).get("deliveryMethod");
		  String collectedAmountString = args.get(0).get("collectedAmount");
		  String xzzDiscountAmountString =args.get(0).get("xzzDiscountAmount");
		  
//		  进入预算单页面
		  businessEnteringPage.clickBudgetPanel();
		  
//		  选择是否公牌
		  businessEnteringPage.selectIsPublicLicense(isPublicLicenseString);
		  
//		  选择打款方式
		  businessEnteringPage.selectPaymentMethod(paymentMethodString);
		  
//		  选择提车方式
		  businessEnteringPage.selectDeliveryMethod(deliveryMethodString);
		  
//		  输入已收金额
		  businessEnteringPage.enterCollectedAmount(collectedAmountString);
		  
//		  输入新总总贴息金额
//		  businessEnteringPage.enterXzzDiscountAmount(xzzDiscountAmountString);
	  }
	  
	  @Then("^Click the submit button in Business Entering page$")
	  public void click_the_submit_button_in_Business_Entering_page() throws Throwable {
		  businessEnteringPage.clickSubmitButton();
		}

	  @And("^Click the final confirm button in Business Entering page$")
	  public void click_the_final_confirm_button_in_business_entering_page()throws Throwable{
		  businessEnteringPage.clickSureOptionButton();
	  }
	  
//	  初级审核
	  @Then("Enter advice in Primary Review Page")
	  public void enter_advice_in_primary_review_page(final List<Map<String, String>> args)throws Throwable{
		  String adviceString = args.get(0).get("advice");
		  primaryReviewPage.enterOpinionText(adviceString);
	  }
	  
	  @And("^Check the image in Primary Review Page$")
	  public void check_the_image_in_primary_review_page()throws Throwable{
//		 查看图片
		  primaryReviewPage.clickImageManagementTab();
		  primaryReviewPage.clickClientIdentifyInformation();
		  primaryReviewPage.clickPicture();
		  primaryReviewPage.closePicture();
	  }
	  
	  @And("Submit in Primary Review Page")
	  public void submit_in_primary_review_page()throws Throwable{
		  primaryReviewPage.clickSubmitButton();
		  primaryReviewPage.clickFinalConfirmButton();
	  }
	  
	  
//	  中级审核
	  @Then("Enter advice in Middle Review Page")
	  public void enter_advice_in_Middle_review_page(final List<Map<String, String>> args)throws Throwable{
		  String adviceString = args.get(0).get("advice");
		  middleReviewPage.enterOpinionText(adviceString);
	  }
	  
	  @And("^Check the image in Middle Review Page$")
	  public void check_the_image_in_Middle_review_page()throws Throwable{
//		 查看图片
		  middleReviewPage.clickImageManagementTab();
		  middleReviewPage.clickClientIdentifyInformation();
		  middleReviewPage.clickPicture();
		  middleReviewPage.closePicture();
	  }
	  
	  @And("Submit in Middle Review Page")
	  public void submit_in_Middle_review_page(final List<Map<String, String>> args)throws Throwable{
		  String submitterString = args.get(0).get("submitter");
		  middleReviewPage.clickSubmitButton();
	  	  middleReviewPage.clickFinalConfirmButton(submitterString);
	  }
	  
	  
	  @Then("^Select process advice in Headquaters Review Center Page$")
	  public void Select_process_advice_in_Headquaters_Review_Center_Page(final List<Map<String, String>> args)throws Throwable{
		  String isVisitHomeString = args.get(0).get("isVisitHome");
		  String isAgencyString = args.get(0).get("isAgency");
		  String isCompanyGpsString = args.get(0).get("isCompanyGps");
		  String isBankGpsString = args.get(0).get("isBankGps");
		  
		  headQuatersReviewCenterPage.selectIsVisitHome(isVisitHomeString);
		  headQuatersReviewCenterPage.selectIsAgency(isAgencyString);
		  headQuatersReviewCenterPage.selectIsCompanyGps(isCompanyGpsString);
		  headQuatersReviewCenterPage.selectIsBankGps(isBankGpsString);
		 
	  }
	  
	  @Then("^Enter advice in Headquaters Review Center Page$")
	    public void Enter_advice_in_Headquaters_Review_Center(final List<Map<String, String>> args)throws Throwable{
		  String adviceString =args.get(0).get("advice");
		  headQuatersReviewCenterPage.enterOpinionText(adviceString);
	  }
	  
	  
	  @And("^Check the image in Headquaters Review Center Page$")
	    public void Check_the_image_in_Headquaters_Review_Center()throws Throwable{
//			 查看图片
		  headQuatersReviewCenterPage.clickImageManagementTab();
		  headQuatersReviewCenterPage.clickClientIdentifyInformation();
		  headQuatersReviewCenterPage.clickPicture();
		  headQuatersReviewCenterPage.closePicture();
	  }
	  
	  @And("^Check Property distribute in Headquaters Review Center Page$")
	  public void Check_Property_distribute_in_Headquaters_Review_Center_Page()throws Throwable{
		  headQuatersReviewCenterPage.sendContract();
	  }
	  
	  @And("^Submit in Headquaters Review Center Page$")
	    public void Submit_in_Headquaters_Review_Center()throws Throwable{
		  headQuatersReviewCenterPage.clickSubmitButton();
		  headQuatersReviewCenterPage.clickFinalConfirmButton();
	  }
	  
	  @Then("Select agency account in Pay Request Page")
	  public void Select_agency_account_in_Pay_Request_Page(final List<Map<String, String>> args)throws Throwable{
		  String payNameString = args.get(0).get("payName");
		  payRequestPage.clickaccountSelect2Button();
		  payRequestPage.selectPay(payNameString);
//		  payRequestPage.clickPayConfirmButton();
	  }
	  
	  @And("^Enter Advice in Pay Request Page$")
	  public void Enter_Advice_in_Pay_Request_Page(final List<Map<String, String>> args)throws Throwable{
		  String adviceString = args.get(0).get("advice");
		  payRequestPage.enterOpinionText(adviceString);
	  }
	  
	  @And("^Submit in Pay Request Page$")
	  public void submit_in_pay_request_page(final List<Map<String, String>> args)throws Throwable{
		  String submitterString = args.get(0).get("submitter");
		  payRequestPage.clickSubmitButton();
		  payRequestPage.clickSureOptionButton();
		  payRequestPage.selectSubmitter(submitterString);
	  }
	  
	  @Then("^Select finance account and Enter advice in Pay Review Page$")
	  public void enter_advice_in_pay_revire_page(final List<Map<String, String>> args)throws Throwable{
//		 选择资金账户
		  payReviewPage.selectFinanceAccount();
//		  填写意见
		  String adviceString = args.get(0).get("advice");
		  payReviewPage.enterOpinionText(adviceString);
	  }
	  
	  @And("^Submit in Pay Review Page$")
	  public void submit_in_pay_review_page(final List<Map<String, String>> args)throws Throwable{
		  String submitterString = args.get(0).get("submitter");
		  payReviewPage.clickSubmitButton();
		  payReviewPage.clickSureOptionButton();
		  payReviewPage.selectSubmitter(submitterString);
	  }
	  
	  @Then("^Enter advice in Capital Allocation Page$")
	  public void Enter_advice_in_Capital_Allocation_Page(final List<Map<String, String>> args)throws Throwable{
		  String adviceString = args.get(0).get("advice");
		  capitalAllocationPage.enterOpinionText(adviceString);
	  }
	  
	  
	  @And("^Submit in Capital Allocation Page$")
	  public void Submit_in_Capital_Allocation_Page(final List<Map<String, String>> args)throws Throwable{
		  String submitterString = args.get(0).get("submitter");
		  capitalAllocationPage.clickSubmitButton();
		  capitalAllocationPage.clickSureOptionButton();
		  capitalAllocationPage.selectSubmitter(submitterString);
	  }
	  
	  @Then("^Enter description in Branch Company Pay Page$")
	  public void Enter_description_in_Branch_Company_Pay_Page(final List<Map<String, String>> args)throws Throwable{
		  String remarkString = args.get(0).get("remark");
		  branchCompanyPayPage.enterDealerPaymentRemark(remarkString);
	  }
	  
	  @Then("^Enter advice in Branch Company Pay Page$")
	  public void Enter_advice_in_Branch_Company_Pay_Page(final List<Map<String, String>> args)throws Throwable{
		  String adviceString = args.get(0).get("advice");
		  branchCompanyPayPage.enterOpinionText(adviceString);
	  }
	  
	  
	  @And("^Submit in Branch Company Pay Page$")
	  public void Submit_in_Branch_Company_Pay_Page(final List<Map<String, String>> args)throws Throwable{
		  String submitterString = args.get(0).get("submitter");
		  branchCompanyPayPage.clickSubmitButton();
		  branchCompanyPayPage.clickSureOptionButton();
		  
//		  Feature finished, quit the browser
		  branchCompanyPayPage.quit();
		  
	  }
}
