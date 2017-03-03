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
#AC1: Normal process for loan review
@test
Feature: Loan Review
  I want to use this template for my feature file

  Background: Login to system
    Given Login to system for testing Loan Review
      | idNumber           |
      | 330106198001010013 |

  Scenario: AC1: Normal process for loan review
    #Start Loan
    Given Navigate to Loan Review page
    And Navigate to Start Loan page
      | customerName |
      | uiTest001    |
    And Enter customer details in StartLoan page
      | businessType | product | carType | separation | isDiscount | detailBrand | carSeries | carModel          | isImport | carDealer | carFee  | billingPrice | loanPrice | handingFee | province | city | area | address   |
      | 信用卡贷款(普通模式)  | 自动化测试专用 | 新车      | 否          | 否          | 奥迪          | 奥迪A1      | 2014款 30 TFSI 技术型 | 否        | 自动化测试车行   | 自动化测试费用 |       300000 |    250000 |         15 | 浙江省      | 杭州市  | 西湖区  | 浙商财富中心3号楼 |
    Then Click the submit button in StartLoan Page
    Then Click the confirm YES button in StartLoan Page
    And Select a submitter in StartLoan Page
      | submmiter |
      | 朱云峰       |
    And Click the Final Confirm button in StartLoan Page
    #Normal Process
    Given Click My Task panel in loan review process when the node submit successfully
    And Click My Task button in loan review process when the node submit successfully
    And Find my client in loan review process when the node submit successfully
      | customerName | processName |
      | uiTest001    | 贷款申请流程      |
    And Click the Operation button in loan review process when the node submit successfully
    #Order Allocation
    Then Enter details in Order Allocation page
      | mainSigner | viceSigner | mainSignerWeight | viceSignerWeight | agreeOption | advice    |
      | 朱云峰        |      70003 |               50 |               50 | 同意          | 签单分配-测试同意 |
    Then Click the submit button in Order Allocation page
    And Click sureOption button in Order Allocation page
    #Normal Process
    Given Click My Task panel in loan review process when the node submit successfully
    And Click My Task button in loan review process when the node submit successfully
    And Find my client in loan review process when the node submit successfully
      | customerName | processName |
      | uiTest001    | 贷款申请流程      |
    And Click the Operation button in loan review process when the node submit successfully
    #Order Investigation
    Then Enter details in Order Investigation page
      | agreeOption | advice     |
      | 同意          | 签单调查主-测试同意 |
    Then Click the submit button in Order Investigation page
    Then Click the confirm YES button in Order Investigation Page
    #Normal Process
    Given Login to system with specific account
      | userName    | password    |
      | 15868470003 | 15868470003 |
    Given Click My Task panel in loan review process when the node submit successfully
    And Click My Task button in loan review process when the node submit successfully
    And Find my client in loan review process when the node submit successfully
      | customerName | processName |
      | uiTest001    | 贷款申请流程      |
    And Click the Operation button in loan review process when the node submit successfully
    #Order invesitgation vice
    Then Enter details in Order Investigation vice page
      | agreeOption | advice     |
      | 同意          | 签单调查副-测试同意 |
    Then Click the submit button in Order Investigation Vice page
    Then Click the confirm YES button in Order Investigation Vice Page
    Then Select a submitter in Order Investigation Vice Page
      | submitter |
      | 朱云峰       |
    Then Click the final confirm button in Order Investigation Vice Page
    #Start File Transfer
    Given Login to system with specific account
      | userName    | password    |
      | 15868473551 | 15868473551 |
    And Navigate to File Transfer Page in loan review process when the node submit successfully
    And Navigate to Start File Transfer Page in loan review process when the node submit successfully
      | customerName |
      | uiTest001    |
    Then Add a file record in loan review process when the node submit successfully
    And Submit the file record
    #Normal Process
    Given Click My Task panel in loan review process when the node submit successfully
    And Click My Task button in loan review process when the node submit successfully
    And Find my client in loan review process when the node submit successfully
      | customerName | processName |
      | uiTest001    | 贷款申请流程      |
    And Click the Operation button in loan review process when the node submit successfully
    #Business Entering
    When Enter basic details in Business Entering page
      | cardNoValidTime | licenceIssuingAuthority | nativePlace | homePhone   | housingStatus | education | professionCode | post  | industry | workNatureCode | monthlyIncome | yearlyIncome | reservedFundsYear | reservedFunds | socialYear | companyName | companyPhone | employTime | companyProvince | companyCity | companyArea | companyAddressDetail | homeProvince | homeCity | homeArea | curAddressTime | homeAddressDetail | isAgency | agreeOption | advice    |
      | 2019-12-31      | 测试派出所                   | 浙江杭州        | 15868470001 | 自有住房          | 本科        | 职员             | 科员及职员 | 医疗行业     | 民企             | 5000-9999     |       150000 | 3年以上              | 1-500         | 3年以上       | 车国          |  15868470001 | 2015-12-31 | 浙江省             | 杭州市         | 西湖区         | 浙商财富中心3号楼            | 浙江省          | 杭州市      | 西湖区      | 2015-12-31     | 浙商财富中心            | 否        | 同意          | 业务录入-测试同意 |
    And Add emergency contracts in Business Entering page
      | emergencyName | emergencyRelationship | emergencyPhone | emergencyIsCarUser |
      | uiTest002     | 父亲                    |    15868470002 | 否                  |
      | uiTest003     | 母亲                    |    15868470003 | 否                  |
    And Enter budget details in Business Entering page
      | isPublicLicense | paymentMethod | deliveryMethod | collectedAmount | xzzDiscountAmount |
      | 否               | 全额打款          | 现金             |            1000 |               100 |
    Then Click the submit button in Business Entering page
    And Click the final confirm button in Business Entering page
    #Normal Process
    Given Click My Task panel in loan review process when the node submit successfully
    And Click My Task button in loan review process when the node submit successfully
    And Find my client in loan review process when the node submit successfully
      | customerName | processName |
      | uiTest001    | 贷款申请流程      |
    And Click the Operation button in loan review process when the node submit successfully
    #Primary Review
    Then Enter advice in Primary Review Page
      | advice    |
      | 初级审核-测试同意 |
    And Check the image in Primary Review Page
    And Submit in Primary Review Page
    #Normal Process
    Given Click My Task panel in loan review process when the node submit successfully
    And Click My Task button in loan review process when the node submit successfully
    And Find my client in loan review process when the node submit successfully
      | customerName | processName |
      | uiTest001    | 贷款申请流程      |
    And Click the Operation button in loan review process when the node submit successfully
    #Middle Review
    Then Enter advice in Middle Review Page
      | advice    |
      | 中级审核-测试同意 |
    And Check the image in Middle Review Page
    And Submit in Middle Review Page
      | submitter |
      | 朱云峰       |
    #Normal Process
    Given Click My Task panel in loan review process when the node submit successfully
    And Click My Task button in loan review process when the node submit successfully
    And Find my client in loan review process when the node submit successfully
      | customerName | processName |
      | uiTest001    | 贷款申请流程      |
    And Click the Operation button in loan review process when the node submit successfully
    #Headquaters Review Center
    Then Select process advice in Headquaters Review Center Page
      | isVisitHome | isAgency | isCompanyGps | isBankGps |
      | 否           | 否        | 否            | 否         |
    Then Enter advice in Headquaters Review Center Page
      | advice        |
      | 总部审批中心审核-测试同意 |
    And Check the image in Headquaters Review Center Page
    And Check Property distribute in Headquaters Review Center Page
    And Submit in Headquaters Review Center Page
    #Normal Process
    Given Click My Task panel in loan review process when the node submit successfully
    And Click My Task button in loan review process when the node submit successfully
    And Find my client in loan review process when the node submit successfully
      | customerName | processName |
      | uiTest001    | 贷款申请流程      |
    And Click the Operation button in loan review process when the node submit successfully
    #Pay Request
    Then Select agency account in Pay Request Page
      | payName |
      | 朱云峰     |
    And Enter Advice in Pay Request Page
      | advice    |
      | 付款申请-测试同意 |
    And Submit in Pay Request Page
      | submitter |
      | 朱云峰       |
    #Normal Process
    Given Click My Task panel in loan review process when the node submit successfully
    And Click My Task button in loan review process when the node submit successfully
    And Find my client in loan review process when the node submit successfully
      | customerName | processName |
      | uiTest001    | 贷款申请流程      |
    And Click the Operation button in loan review process when the node submit successfully
    # Pay Review
    Then Select finance account and Enter advice in Pay Review Page
      | advice    |
      | 付款审批-测试同意 |
    And Submit in Pay Review Page
      | submitter |
      | 朱云峰       |
    #Normal Process
    Given Click My Task panel in loan review process when the node submit successfully
    And Click My Task button in loan review process when the node submit successfully
    And Find my client in loan review process when the node submit successfully
      | customerName | processName |
      | uiTest001    | 贷款申请流程      |
    And Click the Operation button in loan review process when the node submit successfully
    #Capital Allocation
    Then Enter advice in Capital Allocation Page
      | advice    |
      | 资金划拨-测试同意 |
    And Submit in Capital Allocation Page
      | submitter |
      | 朱云峰       |
    #Normal Process
    Given Click My Task panel in loan review process when the node submit successfully
    And Click My Task button in loan review process when the node submit successfully
    And Find my client in loan review process when the node submit successfully
      | customerName | processName |
      | uiTest001    | 贷款申请流程      |
    And Click the Operation button in loan review process when the node submit successfully
    # Branch Company Pay
    Then Enter description in Branch Company Pay Page
      | remark     |
      | 分公司付款-测试说明 |
    And Enter advice in Branch Company Pay Page
      | advice    |
      | 资金划拨-测试同意 |
    And Submit in Branch Company Pay Page
      | submitter |
      | 朱云峰       |
