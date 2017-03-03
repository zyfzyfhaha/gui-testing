package com.tuoche.cheguo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;


import cucumber.api.java.en.Given;

public class OpenUrl {

	
	@Given("^Open URL test$")
	public void open_URL_test() throws Throwable {
		// Login to system
		System.out.println("OpenUrl.open_URL_test()");
	}
	
	@Given("^Navigate to Baidu$")
	public void navigate_to_Baidu() throws Throwable {
		System.out.println("OpenUrl.open_URL_test()");
	}
	
	
//	@Given("^testBackground$")
//	public void open_URL_test() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//		System.out.println("OpenUrl.open_URL_test()");
//	}
//
//	@Given("^testScenario$")
//	public void navigate_to_Baidu() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//		System.out.println("OpenUrl.navigate_to_Baidu()");
//	}
//	
	
	
}
