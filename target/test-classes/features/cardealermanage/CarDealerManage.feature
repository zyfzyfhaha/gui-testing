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
Feature: CarDealer Management
  I want to use this template for my feature file

  Background: Login to system
    Given login to system
    	| dealerName 	|
    	| 新增测试车行 	|

  Scenario: AC1: Normal process with one relavant - spinsterhood
    #Add car dealer
    Given Navigate to CarDealerList page
    And Navigate to AddCarDealer page
    And Enter carDealer information
    	| dealerName 	| carDealerType | contactName 	| contactPhone | isDiscount | province	| city | area 	| detailAddress 	| employeeNum 	| placeProportion 	| salesVolume 	|
    	| 新增测试车行 	| 经销商 		| 林秀秀			| 13588850002  | true		| 浙江省 	| 杭州市 | 西湖区 | 浙商财富中心		 |50		 		| 300			 	| 1200		 	|
    And Add carDealer bank information
    	| accountName 	| bankName 	| subBankName 	| bankCardNum 	| accountType 	| remark 	|
    	| 户名测试		 	| 工商银行 	| 工商银行西湖支行 	| 62100002222 	| 个人账户 		| 测试备注信息 	|
    And Change to feeManage tab
    And Add Fee Solution
    	| feeName 		| term 	| poundage 	| minEarnings | rebateType 	| rebate	| rebateTeam | GPSNum 	| premiumType 	| isRenewal 	| pbDeposit 	| predictedPurchasetax 	|
    	| 测试费用方案名称 	| 12期 	| 10		| 500		  | 固定比率		| 8 		| 5			 | 无	 	| 车行		 	| 是		 		| 123			| 公司				 	|
    Then Click submit button
    	| submitterName 	|
    	| 朱云峰 				|
    #confirm
    Given Confirm carDealer
    	| dealerName 	|
    	| 新增测试车行 	|
    #Normal Process
    Given Click My Task panel
    And Click My Task button
    And Find my client
      | customerName 	|processName	|
      | 新增测试车行    	|车商新增流程	|
    And Click the operation button
    #Review By Area Manager 区域经理审核
    When carDealer Click the submit button
    Then carDealer Select Next User
    	| submitterName 	|
    	| 朱云峰 			|
    #Review By Branch 分公司审核
    Given Click My Task panel
    And Click My Task button
    And Find my client
      | customerName 	|processName	|
      | 新增测试车行    	|车商新增流程	|
    And Click the operation button
    When carDealer Click the submit button
    #Review By Auto Financing Department 汽车金融部审核
    Given Click My Task panel
    And Click My Task button
    And Find my client
      | customerName 	|processName	|
      | 新增测试车行    	|车商新增流程	|
    And Click the operation button
    When carDealer Click the submit button
    #Review By Finance Of Branch 分公司财务审核
    Given Click My Task panel
    And Click My Task button
    And Find my client
      | customerName 	|processName	|
      | 新增测试车行    	|车商新增流程	|
    And Click the operation button
    When carDealer Click the submit button
    Then carDealer Select Next User Div
    	| submitterName 	|
    	| 朱云峰 				|
    #Review By Cashier Of Branch 分公司出纳审核
    Given Click My Task panel
    And Click My Task button
    And Find my client
      | customerName 	|processName	|
      | 新增测试车行    	|车商新增流程	|
    And Click the operation button
    When carDealer Click the submit button
    Then Check if carDealer add successfully
      | dealerName 	|
      | 新增测试车行	|
