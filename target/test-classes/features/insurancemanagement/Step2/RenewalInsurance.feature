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
#AC1: Normal process for First Maintenance
@test
Feature: Renewal Insurance
  I want to use this template for my feature file

  Background: Login to system
    Given Login to system for testing Renewal Insurance
      | idNumber           |
      | 330106198001010013 |

  Scenario: AC1: Normal process for Renewal Insurance
    #Start First Maintenance
    Given Navigate to Enter Maintenance Page in Renewal Insurance process
      | customerName |
      | uiTest001    |
    Then Enter insurance detail in Enter Maintenance Page in Renewal Insurance process
      | insuranceCompany | insuranceType | insuranceName | Fee  | Money | InsuranceNo         | startDate  | endDate    | insuranceStatus |
      | Automation Insu  | 交强险           | 交强险           | 2000 | 60000 | insuranceNoTest0002 | 2020-09-28 | 2030-09-27 | 公司              |
    And Save the insurance detail in Renewal Insurance process
    Then Check if the insurance details correct in previous page in Renewal Insurance process
      | customerName | insuranceCompany | insuranceType | insuranceName | Fee  | Money | InsuranceNo         | startDate  | endDate    | insuranceStatus | registrant | verificationStatus | isFirstMaintenance |
      | uiTest001    | Automation Insu  | 交强险           | 交强险           | 2000 | 60000 | insuranceNoTest0002 | 2020-09-28 | 2030-09-27 | 公司              | 朱云峰        | 未核销                | 否                  |
