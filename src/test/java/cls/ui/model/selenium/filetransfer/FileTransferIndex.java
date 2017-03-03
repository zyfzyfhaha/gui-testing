package cls.ui.model.selenium.filetransfer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cls.ui.base.BaseWebDriver;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class FileTransferIndex extends BaseWebDriver{
	
//	客户名称
	@FindBy(name="customerName")
	private WebElement customerName_textBox;
	
//	搜索按钮
	@FindBy(id="btn-search")
	private WebElement search_btn;
	
//	操作按钮
	@FindBy(xpath="/html/body/div/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/table/tbody/tr/td[8]/div/button")
	private WebElement operation_btn;
	
//	发起文档传递按钮
	@FindBy(xpath="/html/body/div/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/table/tbody/tr/td[8]/div/ul/li[1]/a")
	private WebElement startFlieTransfer_btn;
	
// 输入客户名称
	public void enterCustomerName(String customerNameString)throws Throwable{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_22");
		customerName_textBox.clear();
		customerName_textBox.sendKeys(customerNameString);
	}
	
//	点击搜索按钮
	public void clickSearchButton()throws Throwable{
		search_btn.click();
	}
	
//	点击操作按钮
	public void clickOperationButton()throws Throwable{
		Thread.sleep(2000);
		operation_btn.click();
	}
	
// 点击发起文档传递按钮
	public void clickstartFlieTransferButton()throws Throwable{
		Thread.sleep(2000);
		startFlieTransfer_btn.click();
	}
	
	//点击已传递tab
	public void clickAlreadyFileTransferTab() throws Throwable {
		WebElement alreadyTab = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/ul/li[2]/a"));
		alreadyTab.click();
		Thread.sleep(1000);
	}
	
	//检查当前节点是否一致
	public boolean equalsCurrentNode(String currentNode) {
		WebElement currentNodeText = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[7]"));
		boolean ret = currentNodeText.getText().equals(currentNode);
		return ret;
	}
}
