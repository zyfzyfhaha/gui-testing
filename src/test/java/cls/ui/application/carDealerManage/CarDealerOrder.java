package cls.ui.application.carDealerManage;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import cls.ui.model.selenium.IndexPage;
import cls.ui.model.selenium.carDealerManage.CarDealerOrderListPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CarDealerOrder{
	private CarDealerOrderListPage carDealerOrderListPage = PageFactory.initElements(
			CarDealerOrderListPage.getWebDriver(), CarDealerOrderListPage.class);
	private IndexPage indexPage = PageFactory.initElements(IndexPage.getWebDriver(), IndexPage.class);
	
	@Given("^Login to system for testing CarDealer Order$")
	public void init() throws Throwable {
		indexPage.init();
		Assert.assertTrue(indexPage.isLoginSuccess());
	}
	
	@Given("^Navigate to CarDealerOrderList page$")
	public void NavigateToCarDealerOrderListPage() throws Throwable{
		indexPage.clickCarDealerManagePanel();
		indexPage.clickCarDealerOrderButton();
	}
	
	@And("^Switch Driver To CarDealerOrder Page$")
	public void switchDriverToCarDealerOrderPage() throws Throwable{
		carDealerOrderListPage.switchDriverToCarDealerOrder();
	}
	
	@Then("^Find my order$")
	public void findMyOrder(List<Map<String, String>> args)throws Throwable{
		//输入客户名称 点击查询
		String customerName = args.get(0).get("customerName");
		carDealerOrderListPage.enterCustomerName(customerName);
		carDealerOrderListPage.clickSearchButton();
	}
	
	@And("^Click the Launch Credit button$")
	public void clickLaunchCreditButton() throws Throwable{
		carDealerOrderListPage.clickLaunchCredit();
	}
	
	@And("^Click the Back Order button$")
	public void clickBackOrderButton() throws Throwable{
		carDealerOrderListPage.clickBackOrder();
	}
	
	@And("^Click the Accept Order button$")
	public void clickAcceptOrderButton() throws Throwable{
		carDealerOrderListPage.clickAcceptButton();
	}
	
	@When("^Click Accepted Order tab$")
	public void clickAcceptedTab(){
		carDealerOrderListPage.clickAcceptedTab();
	}
	
	@When("^Click Unaccepted Order tab$")
	public void clickUnacceptedTab(){
		carDealerOrderListPage.clickUnacceptedTab();
	}
	
	@And("^Check if back success$")
	public void checkIfSuccess(List<Map<String, String>> args)throws Throwable{
		//输入客户名称 点击查询
		String customerName = args.get(0).get("customerName");
		carDealerOrderListPage.enterCustomerName(customerName);
		carDealerOrderListPage.clickSearchButton();
		Assert.assertFalse(carDealerOrderListPage.isExistResult());
		indexPage.quit();
	}
}