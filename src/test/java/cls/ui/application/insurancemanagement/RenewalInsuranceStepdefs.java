package cls.ui.application.insurancemanagement;

import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cls.ui.base.SpringContextHolder;
import cls.ui.dao.insurancemanagement.FirstMaintenanceDao;
import cls.ui.dao.insurancemanagement.RenewalInsuranceDao;
import cls.ui.model.selenium.IndexPage;
import cls.ui.model.selenium.firstmaintenance.BusinessEntering;
import cls.ui.model.selenium.firstmaintenance.FirstMaintenanceBusinessEntering;
import cls.ui.model.selenium.firstmaintenance.FirstMaintenanceIndex;
import cls.ui.model.selenium.renewalinsurance.InsuranceDetailsPage;
import cls.ui.model.selenium.renewalinsurance.RenewalBusinessEnteringPage;
import cls.ui.model.selenium.renewalinsurance.RenewalInsuranceManagementPage;

/**
 * 
 * @author zyf
 * @Email zhuyunfeng@zafh.com.cn
 */

public class RenewalInsuranceStepdefs {

	private RenewalInsuranceDao renewalInsuranceDao;
	private IndexPage indexPage = PageFactory.initElements(
			IndexPage.getWebDriver(), IndexPage.class);
	private RenewalBusinessEnteringPage renewalBusinessEnteringPage = PageFactory.initElements(
			RenewalBusinessEnteringPage.getWebDriver(), RenewalBusinessEnteringPage.class);
	private RenewalInsuranceManagementPage renewalInsuranceManagementPage = PageFactory
			.initElements(RenewalInsuranceManagementPage.getWebDriver(),
					RenewalInsuranceManagementPage.class);
	private InsuranceDetailsPage insuranceDetailsPage = PageFactory
			.initElements(InsuranceDetailsPage.getWebDriver(),
					InsuranceDetailsPage.class);

	@Given("^Login to system for testing Renewal Insurance$")
	public void inti(final List<Map<String, String>> args) throws Throwable {
		renewalInsuranceDao = (RenewalInsuranceDao) SpringContextHolder
				.getBean(RenewalInsuranceDao.class);
		indexPage.init();
		Assert.assertTrue(indexPage.isLoginSuccess());

		// delte dirty data
		String cardNumberString = args.get(0).get("idNumber");
		List<String> projectIds = renewalInsuranceDao
				.getProjectIdFromDb(cardNumberString);

		// delete file transfer
		renewalInsuranceDao.deleteSqlWithOneParamter("insurancemanagement",
				"RenewalInsurance", projectIds);
	}

	@Given("^Navigate to Enter Maintenance Page in Renewal Insurance process$")
	public void Navigate_to_Enter_Maintenance_Page_in_renewal_insurance_process(
			final List<Map<String, String>> args) throws Throwable {
		// 进入续保登记页面
		indexPage.clickRenewalInsurancemanagement();

		// 搜索客户名称,进入信息录入页面
		String customerNameString = args.get(0).get("customerName");
		renewalInsuranceManagementPage.enterCustomerName(customerNameString);
		renewalInsuranceManagementPage.clickSearchButton();
		renewalInsuranceManagementPage.enterInsruanceManagementPage();
		insuranceDetailsPage.clickEnterBusinessButton();
	}

	@Then("^Enter insurance detail in Enter Maintenance Page in Renewal Insurance process$")
	public void Enter_insurance_detail_in_Enter_Maintenance_Page_in_Renewal_Insurance_process(
			final List<Map<String, String>> args) throws Throwable {

		String InsuranceNoString = args.get(0).get("InsuranceNo");
		String insuranceCompanyString = args.get(0).get("insuranceCompany");
		String insuranceTypeString = args.get(0).get("insuranceType");
		String insuranceNameString = args.get(0).get("insuranceName");
		String FeeString = args.get(0).get("Fee");
		String MoneyString = args.get(0).get("Money");
		String insuranceStartDateString = args.get(0).get("startDate");
		String insuranceEndDateString = args.get(0).get("endDate");
		String insuranceStatusString = args.get(0).get("insuranceStatus");

		// 保险信息录入
		renewalBusinessEnteringPage.enterInsuranceNo(InsuranceNoString);
		renewalBusinessEnteringPage.selectInsuranceCompany(insuranceCompanyString);
		renewalBusinessEnteringPage.selectInsuranceType(insuranceTypeString);
		renewalBusinessEnteringPage.selectSpecificInsurance(insuranceNameString);
		renewalBusinessEnteringPage.enterFee(FeeString);
		renewalBusinessEnteringPage.enterMoney(MoneyString);
		renewalBusinessEnteringPage.enterInsuranceStartTime(insuranceStartDateString);
		renewalBusinessEnteringPage.enterInsuranceEndTime(insuranceEndDateString);
		renewalBusinessEnteringPage.selectInsuranceStatus(insuranceStatusString);
	}

	@And("^Save the insurance detail in Renewal Insurance process$")
	public void Save_in_Enter_Maintenance_Page() throws Throwable {
		// 保存
		renewalBusinessEnteringPage.clickSaveButton();
	}
	
	
	@Then("^Check if the insurance details correct in previous page in Renewal Insurance process$")
	public void Check_if_the_insurance_details_correct_in_previous_page_in_Renewal_Insurance_process(final List<Map<String, String>> args)throws Throwable{
		String customerNameString = args.get(0).get("customerName");
		String insuranceNoString = args.get(0).get("InsuranceNo");
		String insuranceCompanyString = args.get(0).get("insuranceCompany");
		String insuranceTypeString = args.get(0).get("insuranceType");
		String insuranceFeeString = args.get(0).get("Fee");
		String insuranceStartDateString = args.get(0).get("startDate");
		String insuranceEndDateString = args.get(0).get("endDate"); 
		String insuranceStatusString = args.get(0).get("insuranceStatus"); 
		String registrantString = args.get(0).get("registrant"); 
		String verificationStatusString = args.get(0).get("verificationStatus"); 
		String isFirstMaintenanceString = args.get(0).get("isFirstMaintenance"); 
		
//		刷新页面，重新搜索续保信息
		indexPage.refreshPage();
		indexPage.clickRenewalInsurancemanagement();
		renewalInsuranceManagementPage.enterCustomerName(customerNameString);
		renewalInsuranceManagementPage.clickSearchButton();
		renewalInsuranceManagementPage.enterInsruanceManagementPage();
		
//		对比数据
		insuranceDetailsPage.compareInsuranceNo(insuranceNoString);
		insuranceDetailsPage.compareInsuranceCompany(insuranceCompanyString);
		insuranceDetailsPage.compareInsuranceType(insuranceTypeString);
		insuranceDetailsPage.compareInsuranceStartDate(insuranceStartDateString);
		insuranceDetailsPage.compareInsuranceEndDate(insuranceEndDateString);
		insuranceDetailsPage.compareInsuranceFee(insuranceFeeString);
		insuranceDetailsPage.compareInsuranceStatus(insuranceStatusString);
		insuranceDetailsPage.compareRegistrant(registrantString);
		insuranceDetailsPage.compareVarificationStatus(verificationStatusString);
		insuranceDetailsPage.compareIsFirstMaintenance(isFirstMaintenanceString);
		insuranceDetailsPage.quit();
	}
	

}
