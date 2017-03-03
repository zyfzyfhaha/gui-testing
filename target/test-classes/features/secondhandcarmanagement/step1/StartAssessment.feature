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
Feature: Start Assessment
  I want to use this template for my feature file

  Background: Login to system
    Given Login to system for testing Start Assessment

  Scenario: AC1: Normal process with one relavant - spinsterhood
    #Normal Process
    Given Navigate to AssessmentIndex page
    And Navigate to StartAssessment page
    #Start Assessment
    Then Enter assessment info
    	| letter | brand | carSeries | carModel 				| licenseDate | kilometres | carColour | carIdentifyNum	  | commercialInsuranceDate | compulsoryInsuranceDate | newCarPrice | secondHandCarPrice | comment				 |
    	| B 	 | 宝马	 | 宝马1系	 | 2015款 118i 都市设计套装	| 2015-06-01  | 230		   | 红色	   | 12345678987654321| 2017-12-12			  | 2017-11-13			    | 256000 	  | 179000			   | 二手车评估-自动化测试备注 |
    Then Click assessment submit button
    #Normal Process
    Given Click My Task panel
    And Click My Task button
    And Find my client by code
    And Click the operation button
    When Enter Preliminary Assessment Info
        | firstEstimateSourceKey | firstEstimatePrice | firstEstimateDesc 	 |
    	| 公司自营	 			 | 170000			  | 二手车初评-自动化测试 |
    Then Click Submit button
    And Select Next Operator
        | operator 	|
    	| 朱云峰 	|
    #Normal Process
    Given Click My Task panel
    And Click My Task button
    And Find my client by code
    And Click the operation button
    Then Enter Review info
    	| secondEstimateUserId 	| secondEstimatePrice 	| secondEstimateDesc 	|
    	| 集团评估师			 	| 172000			 	| 二手车复评-自动化测试 	|
    Then Check if secondhand car assessment successfully
		| result 	|
		| 复评完成	|