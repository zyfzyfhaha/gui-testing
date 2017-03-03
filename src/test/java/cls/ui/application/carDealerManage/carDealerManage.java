package cls.ui.application.carDealerManage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import cls.ui.base.SpringContextHolder;
import cls.ui.dao.cardealermanage.CarDealerManageDao;
import cls.ui.model.selenium.IndexPage;
import cls.ui.model.selenium.carDealerManage.BasicInfoPage;
import cls.ui.model.selenium.carDealerManage.CarDealerListPage;
import cls.ui.model.selenium.carDealerManage.FeeManagePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
/**
 * 
 * @author lxx
 */

public class carDealerManage {
	
	private IndexPage indexPage = PageFactory.initElements(
			IndexPage.getWebDriver(), IndexPage.class);
	
	private CarDealerListPage carDealerListPage = PageFactory.initElements(
			CarDealerListPage.getWebDriver(), CarDealerListPage.class);
	
	private BasicInfoPage basicInfoPage = PageFactory.initElements(
			BasicInfoPage.getWebDriver(), BasicInfoPage.class);
	private FeeManagePage feeManagePage = PageFactory.initElements(FeeManagePage.getWebDriver(), FeeManagePage.class);
	private CarDealerManageDao carDealerManageDao;
	
	@Given("^login to system$")
	public void init(final List<Map<String, String>> args) throws Throwable {
		carDealerManageDao = (CarDealerManageDao)SpringContextHolder.getBean(CarDealerManageDao.class);
		indexPage.init();
		Assert.assertTrue(indexPage.isLoginSuccess());
		String dealerName = args.get(0).get("dealerName");
		List<String> dealerNameList=Arrays.asList(dealerName);
		carDealerManageDao.deleteSqlWithOneParamter("CarDealerManage", "CarDealerManage", dealerNameList);
	}
	
	@Given("Navigate to CarDealerList page")
	public void navigateToCarDealerListPage() throws Throwable{
		indexPage.clickCarDealerManagePanel();
		indexPage.clickCarDealerManageButton();
	}
	
	@And("Navigate to AddCarDealer page")
	public void navigateToAddCarDealerPage() throws Throwable{
		carDealerListPage.navigateToAddCarDealerPage();
		Assert.assertTrue(basicInfoPage.isLoadSuccess());
	}
	
	@And("Enter carDealer information")
	public void enterCarDealerInfo(
			final List<Map<String, String>> args) throws Throwable{
//		//根据时间给名称加上编号，确保车行名称唯一
//		Date date=new Date();
//		DateFormat format=new SimpleDateFormat("MMdd-HHmm");
//		String time=format.format(date);
		
		// 输入车行名称
		String dealerNameString = args.get(0).get("dealerName");
		basicInfoPage.enterDealerName(dealerNameString);
//		basicInfoPage.enterDealerName(dealerNameString+time);
		
//		basicInfoPage.clickGetInfo();
		
		//选择车商类型
		String carDealerType = args.get(0).get("carDealerType");
		basicInfoPage.selectCarDealerType(carDealerType);
		
		//输入联系人姓名
		String contactName = args.get(0).get("contactName");
		basicInfoPage.enterContactName(contactName);
		
		//输入联系人手机号
		String contactPhone = args.get(0).get("contactPhone");
		basicInfoPage.enterContactPhone(contactPhone);
		
		//选择是否贴息
		String isDiscount = args.get(0).get("isDiscount");
		basicInfoPage.selectDiscount(isDiscount);
		
		//选择省份
		String province = args.get(0).get("province");
		basicInfoPage.selectProvince(province);
		
		//选择城市
		String city = args.get(0).get("city");
		basicInfoPage.selectCity(city);
		
		//选择区域
		String area = args.get(0).get("area");
		basicInfoPage.selectArea(area);
		
		//输入详细地址
		String detailAddress = args.get(0).get("detailAddress");
		basicInfoPage.enterDetailAddress(detailAddress);
		
		//输入在职员工数
		String employeeNum = args.get(0).get("employeeNum");
		basicInfoPage.enterEmployeeNum(employeeNum);
		
		//输入营业场所面积
		String placeProportion = args.get(0).get("placeProportion");
		basicInfoPage.enterPlaceProportion(placeProportion);
		
		//输入月销售量
		String salesVolume = args.get(0).get("salesVolume");
		basicInfoPage.enterSalesVolume(salesVolume);
		
		basicInfoPage.uploadBusinessLicense();
		
		//点击保存
		basicInfoPage.clickSaveButton();
		Thread.sleep(2000);
	}
	
	@And("Add carDealer bank information")
	public void addCarDealerBankInfo(
			final List<Map<String, String>> args) throws Throwable{
		//点击新增账户
		basicInfoPage.clickAddAccountButton();
		
		//输入户名
		String accountName = args.get(0).get("accountName");
		basicInfoPage.enterAccountName(accountName);
		
		//选择银行名称
		String bankName = args.get(0).get("bankName");
		basicInfoPage.selectBankName(bankName);
		
		//输入支行名称
		String subBankName = args.get(0).get("subBankName");
		basicInfoPage.enterSubBankName(subBankName);
		
		//输入卡号
		String bankCardNum = args.get(0).get("bankCardNum");
		basicInfoPage.enterBankCardNum(bankCardNum);
		
		//选择账户类型
		String accountType = args.get(0).get("accountType");
		basicInfoPage.selectAccountType(accountType);
		
		//输入备注
		String remark = args.get(0).get("remark");
		basicInfoPage.enterRemark(remark);
		
		//点击保存
		basicInfoPage.clickAddDialogSaveButton();
		Thread.sleep(2000);
	}
	
	@And("Change to feeManage tab")
	public void changeToFeeManage() throws Throwable{
		//点击费用管理切换至费用管理tab
		feeManagePage.clickFeeManageButton();
		Thread.sleep(2000);
	}
	
	@And("Add Fee Solution")
	public void addFeeSolution(
			final List<Map<String, String>> args) throws Throwable{
		//点击添加费用
		feeManagePage.clickAddFee();
		
		//输入费用方案名称
		String feeName = args.get(0).get("feeName");
		feeManagePage.enterFeeName(feeName);
		
		//选择期限
		String term = args.get(0).get("term");
		feeManagePage.selectTerm(term);
		
		//输入手续费率
		String poundage = args.get(0).get("poundage");
		feeManagePage.enterPoundage(poundage);
		
		//输入最低收益
		String minEarnings = args.get(0).get("minEarnings");
		feeManagePage.enterMinEarnings(minEarnings);
		
		//选择营销费收取方式
		String rebateType = args.get(0).get("rebateType");
		feeManagePage.selectRebateType(rebateType);
		
		//输入营销费/营销费上限
		String rebate = args.get(0).get("rebate");
		feeManagePage.enterRebate(rebate);
		
		//输入返销售团队
		String rebateTeam = args.get(0).get("rebateTeam");
		feeManagePage.enterRebateTeam(rebateTeam);
		
		//选择GPS(台)
		String GPSNum = args.get(0).get("GPSNum");
		feeManagePage.selectGPSNum(GPSNum);
		
		//选择第一年保费
		String premiumType = args.get(0).get("premiumType");
		feeManagePage.selectPremiumType(premiumType);
		
		//选择是否续保
		String isRenewal = args.get(0).get("isRenewal");
		feeManagePage.selectIsRenewal(isRenewal);
		
		//输入履约保证金enterPBDeposit
		String pbDeposit = args.get(0).get("pbDeposit");
		feeManagePage.enterPBDeposit(pbDeposit);
		
		//选择预计车辆购置税
		String predictedPurchasetax = args.get(0).get("predictedPurchasetax");
		feeManagePage.selectPredictedPurchasetax(predictedPurchasetax);
		
		feeManagePage.clickSaveButton();
	}
	
	@Then("^Click submit button$")
	public void clickSubmitButton(
			final List<Map<String,String>> args) throws Throwable{
		//点击提交按钮
		feeManagePage.clickSubmitButton();
		Thread.sleep(1000);
		feeManagePage.clickConfirmYesButton();
		Thread.sleep(2000);
		
		String submitterName = args.get(0).get("submitterName");
		feeManagePage.selectNextUserName(submitterName);
		
		feeManagePage.clickSubmitYesButton();
	}
	
	@Then("Click confirm YES button")
	public void clickConfirmYesButton()throws Throwable{
		//点击Yes按钮
		basicInfoPage.clickConfirmYesButton();
	}	
	
	@Given("Confirm carDealer")
	public void confirmResult(
			final List<Map<String, String>> args) throws Throwable{
		carDealerListPage.initPapge();
		//清楚查询条件
		carDealerListPage.clickClearButton();
		
		//输入车商名称
		String dealerName = args.get(0).get("dealerName");
		carDealerListPage.enterDealerName(dealerName);
		
		carDealerListPage.clickSearchButton();

		Thread.sleep(1000);
		Assert.assertTrue(carDealerListPage.isExistResult());
		
//		//点击查看操作-查看
//		carDealerListPage.clickViewButton();
		
	}
	
	@Then("^Check if carDealer add successfully$")
	public void CheckResult(final List<Map<String, String>> args)throws Throwable{
		indexPage.refreshPage();
		indexPage.clickCarDealerManagePanel();
		indexPage.clickCarDealerManageButton();
		carDealerListPage.initPapge();
		//输入车商名称
		String dealerName = args.get(0).get("dealerName");
		carDealerListPage.enterDealerName(dealerName);
		carDealerListPage.clickSearchButton();
		Thread.sleep(2000);
		Assert.assertTrue(carDealerListPage.isExistResult());
		Assert.assertTrue(carDealerListPage.isReviewSuccess());
		indexPage.quit();
	}
}
