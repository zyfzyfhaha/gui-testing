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
#AC1: Normal process for loan modify
@test
Feature: Loan Modify
  I want to use this template for my feature file

  Background: Login to system
    Given Login to system for testing Loan Modify
      | idNumber           |
      | 330106198001010013 |

  Scenario: AC1: Normal process for loan modify
    #Start Loan
    Given Navigate to Start Loan Modify Page
      | customerName |
      | uiTest001    |
    And Modify the loan details in Start Loan Modify Page
      | address      | loanPrice |
      | 浙商财富中心3号楼607 |    270000 |
    And Submit in Start Loan Modify Page
      | submitter |
      | 朱云峰       |
    #Normal Process
    Given Select next node from My Task in Loan Modify Process
      | customerName | processName |
      | uiTest001    | 贷款修改流程      |
    # Business Input
    Then Modify the loan details in Loan Modify Business Input Page
      | yearlyIncome | advice           |
      |       200000 | 贷款修改流程-业务录入-测试同意 |
    And Submit in Loan Modify Business Input Page
    #Normal Process
    Given Select next node from My Task in Loan Modify Process
      | customerName | processName |
      | uiTest001    | 贷款修改流程      |
    #Primary Review
    Then Modify advice in Loan Modify Primary Review Page
      | advice           |
      | 贷款修改流程-初级审核-测试同意 |
    And Submit in Loan Modify Primary Review Page
    #Normal Process
    Given Select next node from My Task in Loan Modify Process
      | customerName | processName |
      | uiTest001    | 贷款修改流程      |
    #Middle Review
    Then Modify advice in Loan Modify Middle Review Page
      | advice           |
      | 贷款修改流程-中级审核-测试同意 |
    And Submit in Loan Modify Middle Review Page
      | submitter |
      | 朱云峰       |
    #Normal Process
    Given Select next node from My Task in Loan Modify Process
      | customerName | processName |
      | uiTest001    | 贷款修改流程      |
    #Branch Company Manager
    Then Modify advice in Loan Modify Branch Company Manager Page
      | advice            |
      | 贷款修改流程-分公司经理-测试同意 |
    And Submit in Loan Modify Branch Company Manager Page
    #Normal Process
    Given Select next node from My Task in Loan Modify Process
      | customerName | processName |
      | uiTest001    | 贷款修改流程      |
    #Headquaters Review Center
    Then Modify advice in Loan Modify Headquaters Review Center Page
      | advice             |
      | 贷款修改流程-总部审批中心-测试同意 |
    And Submit in Loan Modify Headquaters Review Center Page
    #Normal Process
    Given Select next node from My Task in Loan Modify Process
      | customerName | processName |
      | uiTest001    | 贷款修改流程      |
    #Branch Company Finance Manager
    Then Modify in Loan Modify Branch Company Finance Manager Page
      | payMethod | advice              |
      | 全额回款      | 贷款修改流程-分公司财务主管-测试同意 |
    And Submit in Loan Modify Branch Company Finance Manager Page
      | submitter |
      | 朱云峰       |
    #Normal Process
    Given Select next node from My Task in Loan Modify Process
      | customerName | processName |
      | uiTest001    | 贷款修改流程      |
    #Branch Company Refund Confirm
    Then Modify advice in Loan Modify Branch Company Refund Confirm Page
      | advice              |
      | 贷款修改流程-分公司退款确认-测试同意 |
    And Submit in Loan Modify Branch Company Refund Confirm Page
      | submitter |
      | 朱云峰       |
    #Normal Process
    Given Select next node from My Task in Loan Modify Process
      | customerName | processName |
      | uiTest001    | 贷款修改流程      |
    #Finance Refund Confirm
    Then Modify advice in Loan Modify Finance Refund Confirm Page
      | advice              |
      | 贷款修改流程-资金部退款确认-测试同意 |
    And Submit in Loan Modify Finance Refund Confirm Page
    #Normal Process
    Given Select next node from My Task in Loan Modify Process
      | customerName | processName |
      | uiTest001    | 贷款修改流程      |
    #Pay Request
    Then Modify advice in Loan Modify Pay Request Page
      | advice           |
      | 贷款修改流程-付款申请-测试同意 |
    And Submit in Loan Modify Pay Request Page
      | submitter |
      | 朱云峰       |
    #Normal Process
    Given Select next node from My Task in Loan Modify Process
      | customerName | processName |
      | uiTest001    | 贷款修改流程      |
    # Pay Review
    Then Modify advice in Loan Modify Pay Review Page
      | advice           |
      | 贷款修改流程-付款审批-测试同意 |
    And Submit in Loan Modify Pay Review Page
      | submitter |
      | 朱云峰       |
    #Normal Process
    Given Select next node from My Task in Loan Modify Process
      | customerName | processName |
      | uiTest001    | 贷款修改流程      |
    #Capital Allocation
    Then Modify advice in Loan Modify Capital Allocation Page
      | advice           |
      | 贷款修改流程-资金划拨-测试同意 |
    And Submit in Loan Modify Capital Allocation Page
      | submitter |
      | 朱云峰       |
    #Normal Process
    Given Select next node from My Task in Loan Modify Process
      | customerName | processName |
      | uiTest001    | 贷款修改流程      |
    # Branch Company Pay
    Then Modify advice in Loan Modify Branch Company Pay Page
      | advice            | explanation         |
      | 贷款修改流程-分公司付款-测试同意 | 贷款修改流程-分公司付款说明-测试说明 |
    And Submit in Loan Modify Branch Company Pay Page
      | submitter |
      | 朱云峰       |
