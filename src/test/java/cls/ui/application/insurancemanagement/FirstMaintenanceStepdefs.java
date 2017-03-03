package cls.ui.application.insurancemanagement;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cls.ui.base.SpringContextHolder;
import cls.ui.dao.insurancemanagement.FirstMaintenanceDao;
import cls.ui.model.selenium.IndexPage;
import cls.ui.model.selenium.firstmaintenance.BusinessEntering;
import cls.ui.model.selenium.firstmaintenance.FirstMaintenanceBusinessEntering;
import cls.ui.model.selenium.firstmaintenance.FirstMaintenanceIndex;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class FirstMaintenanceStepdefs {
	private FirstMaintenanceDao firstMaintenanceDao;
	private IndexPage indexPage = PageFactory.initElements(IndexPage.getWebDriver(), IndexPage.class);
	private FirstMaintenanceIndex firstMaintenanceIndex = PageFactory.initElements(FirstMaintenanceIndex.getWebDriver(), FirstMaintenanceIndex.class);
	private FirstMaintenanceBusinessEntering firstMaintenanceBusinessEntering = PageFactory.initElements(FirstMaintenanceBusinessEntering.getWebDriver(), FirstMaintenanceBusinessEntering.class);
	private BusinessEntering businessEntering = PageFactory.initElements(BusinessEntering.getWebDriver(), BusinessEntering.class);
	
	@Given("^Login to system for testing First Maintenance$")
	public void inti(final List<Map<String, String>> args)throws Throwable{
		firstMaintenanceDao = (FirstMaintenanceDao) SpringContextHolder.getBean(FirstMaintenanceDao.class);
		indexPage.init();
		Assert.assertTrue(indexPage.isLoginSuccess());
		
//		delte dirty data
		String cardNumberString = args.get(0).get("idNumber");
		List<String> projectIds = firstMaintenanceDao.getProjectIdFromDb(cardNumberString);
		
//		delete first maintenance data
		firstMaintenanceDao.deleteSqlWithOneParamter("insurancemanagement", "FirstMaintenance", projectIds);
	}
	
	@Given("^Navigate to Enter Maintenance Page$")
	public void Navigate_to_Enter_Maintenance_Page(final List<Map<String, String>> args)throws Throwable{
//		进入首保登记页面
		indexPage.clickFirstMaintenance();
		
//		搜索客户名称,进入信息录入页面
		String customerNameString = args.get(0).get("customerName");
		firstMaintenanceIndex.enterCustomerName(customerNameString);
		firstMaintenanceIndex.clickSearchButton();
		firstMaintenanceIndex.clickOperationButton();
		firstMaintenanceBusinessEntering.clickBusinessEnteringButton();
	}
	
	@Then("^Enter insurance detail in Enter Maintenance Page$")
	public void Enter_insurance_detail_in_Enter_Maintenance_Page(final List<Map<String, String>> args)throws Throwable{
		String InsuranceNoString = args.get(0).get("InsuranceNo");
		String insuranceCompanyString = args.get(0).get("insuranceCompany");
		String insuranceTypeString = args.get(0).get("insuranceType");
		String insuranceNameString = args.get(0).get("insuranceName");
		String FeeString = args.get(0).get("Fee");
		String MoneyString = args.get(0).get("Money");
		String insuranceStartDateString = args.get(0).get("startDate");
		String insuranceEndDateString = args.get(0).get("endDate"); 
		
//		保险信息录入
		businessEntering.enterInsuranceNo(InsuranceNoString);
		businessEntering.selectInsuranceCompany(insuranceCompanyString);
		businessEntering.selectInsuranceType(insuranceTypeString);
		businessEntering.selectSpecificInsurance(insuranceNameString);
		businessEntering.enterFee(FeeString);
		businessEntering.enterMoney(MoneyString);
		businessEntering.enterInsuranceStartTime(insuranceStartDateString);
		businessEntering.enterInsuranceEndTime(insuranceEndDateString);
	}
	
	@And("^Save in Enter Maintenance Page$")
	public void Save_in_Enter_Maintenance_Page()throws Throwable{
//		保存
		businessEntering.clickSaveButton();
	}
	
	@Then("^Check if the insurance details correct in previous page in First Maintenance process$")
	public void Check_if_the_insurance_details_correct_in_previous_page_in_first_maintenance_process(final List<Map<String, String>> args)throws Throwable{
		String customerNameString = args.get(0).get("customerName");
		String insuranceNoString = args.get(0).get("InsuranceNo");
		String insuranceCompanyString = args.get(0).get("insuranceCompany");
		String insuranceTypeString = args.get(0).get("insuranceType");
		String insuranceFeeString = args.get(0).get("Fee");
		String insuranceStartDateString = args.get(0).get("startDate");
		String insuranceEndDateString = args.get(0).get("endDate"); 
		String insuranceStatusString = args.get(0).get("insuranceStatus"); 
		String registrantString = args.get(0).get("registrant"); 
		
//		刷新页面，重新搜索首保信息
		indexPage.refreshPage();
		indexPage.clickFirstMaintenance();
		firstMaintenanceIndex.enterCustomerName(customerNameString);
		firstMaintenanceIndex.clickSearchButton();
		firstMaintenanceIndex.clickOperationButton();
		
//		对比首保信息是否录入正确
		firstMaintenanceBusinessEntering.compareInsuranceNo(insuranceNoString);
		firstMaintenanceBusinessEntering.compareInsuranceCompany(insuranceCompanyString);
		firstMaintenanceBusinessEntering.compareInsuranceType(insuranceTypeString);
		firstMaintenanceBusinessEntering.compareInsuranceStartDate(insuranceStartDateString);
		firstMaintenanceBusinessEntering.compareInsuranceEndDate(insuranceEndDateString);
		firstMaintenanceBusinessEntering.compareInsuranceFee(insuranceFeeString);
		firstMaintenanceBusinessEntering.compareInsuranceStatus(insuranceStatusString);
		firstMaintenanceBusinessEntering.compareRegistrant(registrantString);
		firstMaintenanceBusinessEntering.quit();
		
	}

}
