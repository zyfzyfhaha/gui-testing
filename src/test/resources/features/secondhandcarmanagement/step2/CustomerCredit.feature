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
Feature: Customer Credit
  I want to use this template for my feature file

  Background: Login to system
    Given Login to system for testing CustomerCreidt
      | cardNum |
      | 330100198502080003       |

  Scenario: AC1: Normal process with one relavant - spinsterhood
    #Launch Creidt
    Given Navigate to Manage Customer Credit page
    And Navigate to LaunchCredit page
    And Enter customer details in LaunchCredit page
      | customerName | customerIdentify	| idNumber           | maritalStatus	| bank            | phoneNumber | guaranteeName | guaranteeCardType	| guaranteeIdNum     | guaranteePhoneNum | relationship | guaranteeRelationship |
      | uiTest011    | 身份证           	| 330100198502080003 | 未婚          	| Automation Bank | 13588840001 | uiTest012     | 身份证           	| 330100196006020010 | 13588840002 		 | 父亲        	| 担保人                	|
    When Click the submit button
    Then Click the confirm YES button
    And Select a submitter
      | submmiter |
      | 朱云峰       |
    And Click the Final Confirm button
    #Normal Process
    Given Click My Task panel
    And Click My Task button
    And Find my client
      | customerName | processName	|
      | uiTest011    | 征信流程    	|
    And Click the operation button
    #Enter Creidt
    And Enter details in EnterCredit page
      | customerResearchType | customerResearchResult	| customerRemark	| relavantResearchType	| relavantResearchResult	| relavantRemark |
      | 电话              	 | 通过                 		| 客户测试备注   	| 电话                 	| 通过                  		| 担保人测试备注  |
    When Click the submit button
    Then Click the confirm YES button
    #Normal Process
    Given Click My Task panel
    And Click My Task button
    And Find my client
      | customerName | processName |
      | uiTest011    | 征信流程        |
    And Click the operation button
    #Accept Creidt
    When Click the submit button
    Then Click the confirm YES button
    Then Check if customer credit successfully
      | customerName | idNumber           | creditResult |
      | uiTest011    | 330100198502080003 | 征信通过         |
