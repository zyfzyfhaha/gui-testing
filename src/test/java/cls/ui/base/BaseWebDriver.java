package cls.ui.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.runtime.io.FlatteningIterator;
import cls.ui.client.IClientService;


public class BaseWebDriver {

	protected static final Logger logger = Logger
			.getLogger(BaseWebDriver.class);
	protected static WebDriver driver;
	private static boolean isLogined = false;
	public static boolean isUARegion = false;
	private static Config config = new Config();
	private String baseURL;
	protected IClientService client;
	private Actions actionDriver;

	public static WebDriver getWebDriver() {
		
//		firefox 插件管理 
//		File file = new File("D:\\Test\\Firefox\\profile\\extensions\\firebug@software.joehewitt.com.xpi");
//		   FirefoxProfile firefoxProfile = new FirefoxProfile();
//		   try {
//			firefoxProfile.addExtension(file);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		   firefoxProfile.setPreference("extensions.firebug.currentVersion", "2.0.17"); 
		
		String browserType = config.getProperty("browserType");
		if(driver == null){
			if(browserType.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.firefox.bin", config.getProperty("firefoxPath"));
				driver = new FirefoxDriver();
			}else {
				//chrome
				System.setProperty("webdriver.chrome.driver", config.getProperty("chromePath"));
				driver = new ChromeDriver();
			}
		}
		
		return driver;
	}

	public void init() {
		driver.manage().window().maximize();
		Navigation navigation = driver.navigate();
		baseURL = config.getProperty("baseUrl");
		navigation.to(baseURL);
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void navigateToSpecificUrl(String url) {
		Navigation navigation = driver.navigate();
		navigation.to(url);
	}


	public void quit() throws Throwable{
		Thread.sleep(2000);
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	private void login() {
		WebElement inputName = driver.findElement(By
				.xpath("//div/input[@name='userName']"));
		inputName.clear();
		inputName.sendKeys(config.getProperty("userName"));
		WebElement inputPassword = driver.findElement(By
				.xpath("//div/input[@name='password']"));
		inputPassword.clear();
		inputPassword.sendKeys(config.getProperty("password"));
		WebElement loginBTN = driver.findElement(By
				.id("loginBtn"));
		loginBTN.click();
	}
	
	
	private void loginWithSpecificAccount(String userNameString, String passwordString) {
		WebElement inputName = driver.findElement(By
				.xpath("//div/input[@name='userName']"));
		inputName.clear();
		inputName.sendKeys(userNameString);
		WebElement inputPassword = driver.findElement(By
				.xpath("//div/input[@name='password']"));
		inputPassword.clear();
		inputPassword.sendKeys(passwordString);
		WebElement loginBTN = driver.findElement(By
				.id("loginBtn"));
		loginBTN.click();
	}
	

	public Boolean isLoginSuccess() {
		login();
		new WebDriverWait(driver, 5 ).until(
			     ExpectedConditions.presenceOfElementLocated(By.id("userName")));
		Boolean flag = false;
		WebElement userName = driver.findElement(By.id("userName"));
		if(userName != null){
			flag = true;
		}
		return flag;
	}
	
	
	public Boolean isLoginSuccessWithSpecificAccount(String userNameString, String passwordString) {
		loginWithSpecificAccount(userNameString, passwordString);
		new WebDriverWait(driver, 5 ).until(
			     ExpectedConditions.presenceOfElementLocated(By.id("userName")));
		Boolean flag = false;
		WebElement userName = driver.findElement(By.id("userName"));
		if(userName != null){
			flag = true;
		}
		return flag;
	}

	public boolean isElementExist(By Locator) {
		try {
			driver.findElement(Locator);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public boolean waitingElement(By Locator) {
		Date startDate = new Date();
		long timeOut = 60000;
		long cost = 0;
		while (cost < timeOut) {
			if (isElementExist(Locator)) {
				return true;
			}
			Date endDate = new Date();
			cost = endDate.getTime() - startDate.getTime();
		}
		return false;
	}

	public boolean waitingElementDisappear(By Locator) {
		Date startDate = new Date();
		long timeOut = 60000;
		long cost = 0;
		while (cost < timeOut) {
			if (!isElementExist(Locator)) {
				return true;
			}
			Date endDate = new Date();
			cost = endDate.getTime() - startDate.getTime();
		}
		return false;
	}




	public void setInputValue(WebElement inputBox, String value) {
		if (value.equals("@Null") || value.equals("@Empty")) {
			value = "";
		}
		WebElement parentElement = inputBox.findElement(By.xpath(".."));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"arguments[0].focus(); arguments[0].blur(); return true",
				inputBox);
		inputBox.clear();

		try {
			inputBox.sendKeys(value);
		} catch (StaleElementReferenceException e) {
			inputBox = parentElement.findElement(By.tagName("input"));
			inputBox.sendKeys(value);
		}
//		js.executeScript(
//				"arguments[0].focus(); arguments[0].blur(); return true",
//				inputBox);
		// js.executeScript("alert(jQuery.active)");
	}

	public List<String> getDropDownValueList() {
		List<String> listValue = new ArrayList<String>();
		if (isElementExist(By
				.xpath("//div[starts-with(@class,'cdtListView')]//a"))) {
			List<WebElement> items = driver
					.findElements(By
							.xpath("//div[starts-with(@class,'cdtListView')]/div/div/a"));
			for (WebElement item : items) {
				listValue.add(item.getText());
			}
		}
		return listValue;
	}

	public List<String> getDropDownValueList(WebElement dropdownlist) {
		waitElementEnable(dropdownlist);
		dropdownlist.click();
		if (!isElementExist(By.xpath("//div[@class='cdtListView']//a"))) {
			dropdownlist.click();
		}
		return getDropDownValueList();
	}

	public boolean waitPageLoadComplete() {
		Date startDate = new Date();
		long timeOut = 60000;
		long cost = 0;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		while (cost < timeOut) {
			long count = (long) js.executeScript("return jQuery.active;");
			if (count == 0) {
				return true;
			}
			Date endDate = new Date();
			cost = endDate.getTime() - startDate.getTime();
		}
		return false;
	}

	public boolean waitElementEnable(WebElement element) {
		Date startDate = new Date();
		long timeOut = 30000;
		long cost = 0;
		while (cost < timeOut) {
			if (element.isEnabled()) {
				return true;
			}
			Date endDate = new Date();
			cost = endDate.getTime() - startDate.getTime();
		}
		return false;
	}

	public int waitAfterSearch() {
		if (isElementExist(By.xpath("//div[@id='CommonMessageBox']"))) {
			return -1;
		}
		Date startDate = new Date();
		long timeOut = 60000;
		long cost = 0;
		while (cost < timeOut) {
			if (isElementExist(By
					.xpath("//div[@class='dataGridWidget']/div[3]//tr[starts-with(@class,'dataGridEvenRow')]"))) {
				return 0;
			}
			if (isElementExist(By.xpath("//div[@class='noDataFound']"))) {
				return 1;
			}
			Date endDate = new Date();
			cost = endDate.getTime() - startDate.getTime();
		}
		return -1;
	}

	public void waitLoadingEnd() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			logger.error(e, e);
		}
		waitingElementDisappear(By.xpath("//div[@class='loadingIndicator']"));
	}

	public String getErrorMsg() {
		if (!waitingElement(By.xpath("//div[@class='noDataFound']"))) {
			throw new NoSuchElementException("Element not found");
		}
		return driver.findElement(By.xpath("//div[@class='noDataFound']"))
				.getText();
	}


	public void switchToFrame(String frameName) {
		List<WebElement> frames = driver.findElements(By.tagName("IFRAME"));
		for (WebElement ele : frames) {
			if (ele.getAttribute("src").contains(frameName)) {
				driver.switchTo().frame(ele);
				return;
			}
		}
		return;
	}

	public WebElement findElementByWrapperAndTagName(String wrapperId,
			String tagName) {

		WebElement wrapper = driver.findElement(By.id(wrapperId));
		if (wrapper != null) {
			return wrapper.findElement(By.tagName(tagName));
		}

		return null;
	}

	public WebElement findElementById(String id) {
		return driver.findElement(By.id(id));
	}

	public WebElement findElementByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public List<WebElement> findElementListByXpath(String xpath) {
		List<WebElement> elementList = driver.findElements(By.xpath(xpath));
		return elementList;
	}

	public Map<String, Integer> get_col_map() {
		Map<String, Integer> colMap = new LinkedHashMap<String, Integer>();

		// Get the column no
		List<WebElement> headerCol = driver.findElements(By
				.cssSelector(".dataGridHeader span"));

		for (Integer index = 0; index < headerCol.size(); index++) {

			String colValue = headerCol.get(index).getText().trim()
					.toUpperCase();
			colMap.put(colValue, index);
		}

		return colMap;
	}

	public String getUploadFilePath(){
		String browserType = config.getProperty("browserType");
		String path;
		if(browserType.equalsIgnoreCase("firefox")){
			path = config.getProperty("uploadFileExePathforFirefox");
		}else{
			path = config.getProperty("uploadFileExePathForChrome");
		}
		return path;
	}
	
}
