package cls.ui.model.selenium.firstmaintenance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class FirstMaintenanceIndex extends BaseWebDriver{
	
//保险客户名称
	@FindBy(name="customerName")
	private WebElement customerName_textBox;
	
//搜索按钮
	@FindBy(id="btn-search")
	private WebElement search_btn;

//操作按钮
	@FindBy(xpath="//*[@id='table1']/tbody/tr/td[10]/div/button")
	private WebElement operation_btn;
	
//首保信息录入
	@FindBy(xpath="//*[@id='table1']/tbody/tr/td[10]/div/ul/li[1]/a")
	private WebElement firstMaintenanceEntering_btn;

//输入客户名称

public void enterCustomerName(String customerNameString)throws Throwable{
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("iframe_38");
	customerName_textBox.clear();
	customerName_textBox.sendKeys(customerNameString);
	}
	
//点击搜索
public void clickSearchButton()throws Throwable{
	search_btn.click();
}

//进入首保信息录入按钮
public void clickOperationButton()throws Throwable{
	Thread.sleep(2000);
	operation_btn.click();
	firstMaintenanceEntering_btn.click();
}


}
