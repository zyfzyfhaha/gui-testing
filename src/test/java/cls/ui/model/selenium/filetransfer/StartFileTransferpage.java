package cls.ui.model.selenium.filetransfer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class StartFileTransferpage extends BaseWebDriver{
	
//	添加档案袋
	@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div")
	private WebElement addRecord_Btn;
	
//	提交按钮
	@FindBy(id="sub")
	private WebElement submit_btn;

//	确认提交按钮
	@FindBy(id="sureOption")
	private WebElement sureOption_btn;
	
//	点击添加档案袋	
	public void clickAddRecordButton()throws Throwable{
		Thread.sleep(2000);
		addRecord_Btn.click();
	}
	
//	点击提交按钮
	public void clickSubmitButton()throws Throwable{
		Thread.sleep(2000);
		submit_btn.click();
	}
	
//	点击确认提交按钮
	public void clickSureOptionButton()throws Throwable{
		Thread.sleep(2000);
		sureOption_btn.click();
	}

}
