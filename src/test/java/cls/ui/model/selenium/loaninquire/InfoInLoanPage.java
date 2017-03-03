package cls.ui.model.selenium.loaninquire;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cls.ui.base.BaseWebDriver;

public class InfoInLoanPage extends BaseWebDriver{
	//检查贷款金额
	public boolean equalsLoanAmount(String loanAmount) {
		WebElement loanAmountInput = driver.findElement(By.name("loanAmount"));
		boolean ret = loanAmountInput.getAttribute("value").equals(loanAmount);
		return ret;
	}
}