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
#AC1: Normal process for Loan Cancel
@test
Feature: Loan Cancel
  I want to use this template for my feature file

  Background: Login to system
    Given Login to system for testing Loan Cancel

  Scenario: AC1: Normal process for Loan Cancel
    #Start Loan Cancel
    Given Navigate to Start Loan Cancel Page
      | customerName |
      | uiTest001    |
    And Enter advice in Start Loan Cancel Page
      | advice           |
      | 贷款作废流程-业务录入-测试同意 |
    And Submit in Start Loan Cancel Page
    #Normal Process
    Given Select next node from My Task in Loan Cancel Process
      | customerName | processName |
      | uiTest001    | 贷款作废流程      |
    #Primary Review
    Then Enter advice in Loan Cancel Primary Review Page
      | advice           |
      | 贷款作废流程-初级审核-测试同意 |
    And Submit in Loan Cancel Primary Review Page
    #Normal Process
    Given Select next node from My Task in Loan Cancel Process
      | customerName | processName |
      | uiTest001    | 贷款作废流程      |
    #Middle Review
    Then Enter advice in Loan Cancel Middle Review Page
      | advice           |
      | 贷款作废流程-初级审核-测试同意 |
    And Submit in Loan Cancel Middle Review Page
      | submitter |
      | 朱云峰       |
    #Normal Process
    Given Select next node from My Task in Loan Cancel Process
      | customerName | processName |
      | uiTest001    | 贷款作废流程      |
    #Branch Company Manager
    Then Enter advice in Loan Cancel Branch Company Manager Page
      | advice            |
      | 贷款作废流程-分公司经理-测试同意 |
    And Submit in Loan Cancel Branch Company Manager Page
    #Normal Process
    Given Select next node from My Task in Loan Cancel Process
      | customerName | processName |
      | uiTest001    | 贷款作废流程      |
    #Headquaters Review Center
    Then Enter advice in Loan Cancel Headquaters Review Center Page
      | advice             |
      | 贷款作废流程-总部审批中心-测试同意 |
    And Submit in Loan Cancel Headquaters Review Center Page
    #Normal Process
    Given Select next node from My Task in Loan Cancel Process
      | customerName | processName |
      | uiTest001    | 贷款作废流程      |
    #Refund Confirm
    Then Enter advice in Loan Cancel Refund Confirm Page
      | advice           |
      | 贷款作废流程-退款核对-测试同意 |
    And Submit in Loan Cancel Refund Confirm Page
      | submitter |
      | 朱云峰       |
    #Normal Process
    Given Select next node from My Task in Loan Cancel Process
      | customerName | processName |
      | uiTest001    | 贷款作废流程      |
    #Branch Company Refund Confirm
    Then Enter advice in Loan Cancel Branch Company Refund Confirm Page
      | advice              |
      | 贷款作废流程-分公司退款确认-测试同意 |
    And Submit in Loan Cancel Branch Company Refund Confirm Page
      | submitter |
      | 朱云峰       |
    #Normal Process
    Given Select next node from My Task in Loan Cancel Process
      | customerName | processName |
      | uiTest001    | 贷款作废流程      |
    #Finance Refund Confirm
    Then Enter advice in Loan Cancel Finance Refund Confirm Page
      | advice              |
      | 贷款作废流程-资金部退款确认-测试同意 |
    And Submit in Loan Cancel Finance Refund Confirm Page
      | submitter |
      | 朱云峰       |
