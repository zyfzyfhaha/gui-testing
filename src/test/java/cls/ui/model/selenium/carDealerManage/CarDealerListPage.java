package cls.ui.model.selenium.carDealerManage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cls.ui.base.BaseWebDriver;

public class CarDealerListPage extends BaseWebDriver{
	
	//新增车行按钮
	@FindBy(xpath="/html/body/div[1]/div/div/div[1]/div/form/div[3]/div/button[3]")
	private WebElement addCarDealerBtn;
	
	//焦点切换至车商管理tab
	public void initPapge()throws Throwable {
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_27");
	}
	//点击新增车行按钮
	public void clickAddCarDealerBottun(){
		addCarDealerBtn.click();
	}
	
	//进入新增车行页面
	public void navigateToAddCarDealerPage()throws Throwable{
		driver.switchTo().frame("iframe_27");
		new WebDriverWait(driver, 5 ).until(
			     ExpectedConditions.presenceOfElementLocated(By.id("addCarDealer")));
		addCarDealerBtn.click();
	}
	
	//输入车行名称
	public void enterDealerName(String dealerName) {
		WebElement dealerNameText = driver.findElement(By.name("dealerName"));
		dealerNameText.clear();
		dealerNameText.sendKeys(dealerName);
	}
	
	//输入客户经理
	public void enterManageName(String manageName){
		WebElement manageNameText = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/form/div[1]/div[2]/div/input"));
		manageNameText.clear();
		manageNameText.sendKeys(manageName);
	}
	
	//选择所属分公司
	public void selectCompanyId(String companyId) {
		WebElement companyIdSelect = driver.findElement(By.id("companyId"));
		Select mySelect = new Select(companyIdSelect);
		mySelect.selectByVisibleText(companyId);
	}
	
	//选择业务组
	public void selectGroupId(String groupId) throws Throwable{
		Thread.sleep(1000);
		WebElement groupIdSelect = driver.findElement(By.id("groupId"));
		Select mySelect = new Select(groupIdSelect);
		mySelect.selectByVisibleText(groupId);
	}
	
	//选择审核状态
	public void selectApproveStatus(String approveStatus) {
		WebElement approveStatusSelect =driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/form/div[2]/div[2]/div/select"));
		Select mySelect = new Select(approveStatusSelect);
		mySelect.selectByVisibleText(approveStatus);
	}
	
	//点击查询
	public void clickSearchButton() {
		WebElement searchBtn = driver.findElement(By.id("btn-search"));
		searchBtn.click();
	}
	
	//点击清楚查询条件
	public void clickClearButton() {
		WebElement clearchBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/form/div[3]/div/button[2]"));
		clearchBtn.click();
	}
	
	//点击操作-查看
	public void clickViewButton(){
		List<WebElement> operationBtnList = driver.findElements(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[7]/div/button"));
		if(operationBtnList.size()>0){
			//列表存在查询结果
			WebElement operationBtn = operationBtnList.get(0);
			operationBtn.click();
			List<WebElement> operateList = driver.findElements(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[7]/div/ul/li"));
			if(operateList.size()>1){
				//该数据有发起评审、修改、停用和查看四个操作
				operateList.get(3).click();
			}else{
				//该数据仅有查查看按钮
				operateList.get(0).click();
			}
		}
	}
	
	//检查是否存在查询结果
	public Boolean isExistResult() {
		List<WebElement> operationBtnList = driver.findElements(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[7]/div/button"));
		if(operationBtnList.size() > 0){
			return true;
		}else {
			return false;
		}
	}
	
	//检查该数据是否审核通过
	public Boolean isReviewSuccess() {
		String result = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[5]")).getText();
		if(result.equalsIgnoreCase("审批通过")){
			return true;
		}else {
			return false;
		}
	}
}