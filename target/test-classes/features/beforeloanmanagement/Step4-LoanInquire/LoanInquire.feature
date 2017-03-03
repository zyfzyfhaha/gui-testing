#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#AC1: Normal process with one relavant - spinsterhood
@test
Feature: Loan Inquire
  I want to use this template for my feature file

  Background: Login to system
    Given Login to system for testing Loan Inquire

  Scenario: AC1: Normal process with one relavant - spinsterhood
  #Open Detail Page
    Given Navigate to LoanInquireIndex page
    And Navigate to LoanDetail page
      | customerName |
      | uiTest001    |
    #loan info overview
    Then Check loan info overview
    	| billingPrice | loanAmount | handingFee | bank			   | product		|cardNo			 	|
    	| 300000 	   | 270000	    | 15		 | Automation Bank | 自动化测试专用	|330106198001010013 |
    #budget
    When Click budget Tab
    Then Check loanBudget info
    	| loanAmount | handingFee | billingPrice | collectedAmount |cardNo			 	|
    	| 270000 	 | 15	      | 300000		 | 1000			   |330106198001010013 	|
    #contractInfo
    When Click contractInfo Tab
    Then Check contract info
    	| loanAmount | handingFee |cardNo			 	| product		| contractPeriodpaymentInterest |
    	| 270000 	 | 15	      |330106198001010013 	| 自动化测试专用	| 918.73			 		    |
    #InfoInLoan
    When Click InfoInLoan Tab
    Then Check info in loan
      | loanAmount |
      | 270000     |