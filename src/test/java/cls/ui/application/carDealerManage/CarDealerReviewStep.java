package cls.ui.application.carDealerManage;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import cls.ui.model.selenium.carDealerManage.ReviewCarDealerPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author lxx
 */

public class CarDealerReviewStep {
	private ReviewCarDealerPage reviewCarDealerPage = PageFactory.initElements(ReviewCarDealerPage.getWebDriver(), ReviewCarDealerPage.class);
	
	@When("^carDealer Click the submit button$")
	public void clickSubmitButton() throws Throwable{
		//点击提交按钮
		reviewCarDealerPage.clickSubmitButton();
		//点击确定
		reviewCarDealerPage.clickConfirmYesButton();
	}
	
	@Then("^carDealer Select Next User$")
	public void SelectNextUser(
			final List<Map<String,String>> args) throws Throwable{
		//选择流转人员
		String submitterName = args.get(0).get("submitterName");
		reviewCarDealerPage.selectNextUserName(submitterName);
		//点击确定
		reviewCarDealerPage.clickSubmitYesButton();
	}
	
	@Then("^carDealer Select Next User Div$")
	public void SelectNextUserDiv(
			final List<Map<String,String>> args) throws Throwable{
		//选择流转人员
		String submitterName = args.get(0).get("submitterName");
		reviewCarDealerPage.selectNextUserNameDiv(submitterName);
		//点击确定
		reviewCarDealerPage.clickSubmitYesButton();
	}
}
