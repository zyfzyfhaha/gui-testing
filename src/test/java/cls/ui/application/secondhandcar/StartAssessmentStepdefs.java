package cls.ui.application.secondhandcar;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import cls.ui.base.SpringContextHolder;
import cls.ui.dao.secondhandcarmanagement.SecondHandCarAssessment;
import cls.ui.model.selenium.IndexPage;
import cls.ui.model.selenium.secondhandcarmanagement.AssessmentIndex;
import cls.ui.model.selenium.secondhandcarmanagement.PreliminaryAssessmentPage;
import cls.ui.model.selenium.secondhandcarmanagement.StartAssessmentPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

public class StartAssessmentStepdefs{
	
	private IndexPage indexPage = PageFactory.initElements(IndexPage.getWebDriver(), IndexPage.class);
	private AssessmentIndex assessmentIndex = PageFactory.initElements(AssessmentIndex.getWebDriver(), AssessmentIndex.class);
	private StartAssessmentPage startAssessmentPage = PageFactory.initElements(StartAssessmentPage.getWebDriver(), StartAssessmentPage.class);
	private PreliminaryAssessmentPage preAssessmentPage = PageFactory.initElements(PreliminaryAssessmentPage.getWebDriver(), PreliminaryAssessmentPage.class);
	private SecondHandCarAssessment secondHandCarAssessment;
	
	@Given("Login to system for testing Start Assessment")
	public void init()throws Throwable{
		// Login to system
		indexPage.init();
		Assert.assertTrue(indexPage.isLoginSuccess());
		secondHandCarAssessment = (SecondHandCarAssessment)SpringContextHolder.getBean(SecondHandCarAssessment.class);
		secondHandCarAssessment.deleteSql("secondhandcarmanagement", "SecondHandCarAssessment");
	}
	
	@Given("Navigate to AssessmentIndex page")
	public void navigateToAssessmentIndexPage() throws Throwable{
		indexPage.clickSecondHandCarManagementPanel();
		indexPage.clickSecondHandCarAssessmentButton();
	}
	
	@And("Navigate to StartAssessment page")
	public void navigateToStartAssessmentPage() throws Throwable{
		assessmentIndex.init();
		assessmentIndex.clickAssessmentButton();
		startAssessmentPage.init();
	}
	
	@Then("Enter assessment info")
	public void enterAssessmentInfo(final List<Map<String, String>> args) throws Throwable {
		//保存二手车评估单号
		startAssessmentPage.setAssessmentCode();
		
		//选择车辆品牌
		String letter = args.get(0).get("letter");
		String brand = args.get(0).get("brand");
		startAssessmentPage.selectBrand(letter,brand);
		
		//选择车系
		String carSeries = args.get(0).get("carSeries");
		startAssessmentPage.selectCarSeries(carSeries);
		
		//选择车型
		String carModel = args.get(0).get("carModel");
		startAssessmentPage.selectCarModel(carModel);
		
		//输入上牌时间
		String licenseDate = args.get(0).get("licenseDate");
		startAssessmentPage.enterLicenseDate(licenseDate);
		
		//输入里程数
		String kilometres = args.get(0).get("kilometres");
		startAssessmentPage.entreKilometres(kilometres);
		
		//输入车身颜色
		String carColour = args.get(0).get("carColour");
		startAssessmentPage.enterCarColour(carColour);
		
		//输入车架号码
		String carIdentifyNum = args.get(0).get("carIdentifyNum");
		startAssessmentPage.enterCarIdentifyNum(carIdentifyNum);
		
		//输入商业险到期日
		String commercialInsuranceDate = args.get(0).get("commercialInsuranceDate");
		startAssessmentPage.enterCommercialInsuranceDate(commercialInsuranceDate);
		
		//输入交强险到期日
		String compulsoryInsuranceDate = args.get(0).get("compulsoryInsuranceDate");
		startAssessmentPage.enterCompulsoryInsuranceDate(compulsoryInsuranceDate);
		
		//输入现行新车价
		String newCarPrice = args.get(0).get("newCarPrice");
		startAssessmentPage.enterNewCarPrice(newCarPrice);
		
		//输入二手车销售价
		String secondHandCarPrice = args.get(0).get("secondHandCarPrice");
		startAssessmentPage.enterSecondHandCarPrice(secondHandCarPrice);
		
		//输入备注
		String comment = args.get(0).get("comment");
		startAssessmentPage.enterComment(comment);
	}
	
	@And("Click assessment submit button")
	public void clickSubmitBtn() throws Throwable{
		startAssessmentPage.clickSubmitButton();
		startAssessmentPage.clickConfirmButtom();
	}
	
	@And("Find my client by code")
	public void navigateToMyTaskPage() throws Throwable{
		indexPage.enterLoanNum(startAssessmentPage.assessmentCode);
		indexPage.clickSearchButton();
		Thread.sleep(2000);
	}
	
	@When("Enter Preliminary Assessment Info")
	public void enterPreAssementInfo(final List<Map<String, String>> args) throws Throwable {
		Thread.sleep(2000);
		preAssessmentPage.init();
		//选择评估结果来源
		String firstEstimateSourceKey = args.get(0).get("firstEstimateSourceKey");
		preAssessmentPage.selectFirstEstimateSource(firstEstimateSourceKey);
		
		//输入初评价格
		String firstEstimatePrice = args.get(0).get("firstEstimatePrice");
		preAssessmentPage.enterFirstEstimatePrice(firstEstimatePrice);
		
		//输入初评描述
		String firstEstimateDesc = args.get(0).get("firstEstimateDesc");
		preAssessmentPage.enterFirstEstimateDesc(firstEstimateDesc);
	}
	
	@Then("^Click Submit button$")
	public void clickSubmitButton() throws Throwable{
		preAssessmentPage.clickSubmitButton();
		preAssessmentPage.clickConfirmButtom();
	}
	
	@And("^Select Next Operator$")
	public void selectNextOperator(final List<Map<String, String>> args) throws Throwable {
		//选择评估结果来源
		String operator = args.get(0).get("operator");
		preAssessmentPage.selectNextOperator(operator);
		preAssessmentPage.clickConfirmOperatorButton();
	}
	
	@Then("Enter Review info")
	public void enterReviewInfo(final List<Map<String, String>> args) throws Throwable {
		Thread.sleep(2000);
		preAssessmentPage.init();
		//选择复评师
		String secondEstimateUserId = args.get(0).get("secondEstimateUserId");
		preAssessmentPage.selectSecondEstimateUserId(secondEstimateUserId);
		
		//输入复评价格
		String secondEstimatePrice = args.get(0).get("secondEstimatePrice");
		preAssessmentPage.enterSecondEstimatePrice(secondEstimatePrice);
		
		//输入复评描述
		String secondEstimateDesc = args.get(0).get("secondEstimateDesc");
		preAssessmentPage.enterSecondEstimateDesc(secondEstimateDesc);
		
		//点击完成评估
		preAssessmentPage.clickCompleteButton();
		preAssessmentPage.clickConfirmButtom();
	}
	
	@And("Check if secondhand car assessment successfully")
	public void checkIfSuccessfully(final List<Map<String, String>> args) throws Throwable {
		indexPage.refreshPage();
		//打开二手车评估页面
		indexPage.clickSecondHandCarManagementPanel();
		indexPage.clickSecondHandCarAssessmentButton();
		
		//查找评估的二手车
		assessmentIndex.init();
		assessmentIndex.enterEstimateNum(startAssessmentPage.assessmentCode);
		assessmentIndex.clickSearchButton();
		
		//检查评估结果
		String result = args.get(0).get("result");
		Assert.assertTrue(assessmentIndex.isResultPassed(result));
		
		indexPage.quit();
	}
	
	
	
	
	
	
	
}