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
Feature: First Maintenance
  I want to use this template for my feature file

  Background: Login to system
    Given Login to system for testing First Maintenance
      | idNumber           |
      | 330106198001010013 |

  Scenario: AC1: Normal process for First Maintenance
    #Start First Maintenance
    Given Navigate to Enter Maintenance Page
      | customerName |
      | uiTest001    |
    Then Enter insurance detail in Enter Maintenance Page
      | insuranceCompany | insuranceType | insuranceName | Fee  | Money | InsuranceNo         | startDate  | endDate    |
      | Automation Insu  | 商业险           | 商业险           | 1000 | 50000 | insuranceNoTest0001 | 2016-09-28 | 2020-09-27 |
    And Save in Enter Maintenance Page
    Then Check if the insurance details correct in previous page in First Maintenance process
      | customerName | insuranceCompany | insuranceType | insuranceName | Fee  | Money | InsuranceNo         | startDate  | endDate    | insuranceStatus | registrant |
      | uiTest001    | Automation Insu  | 商业险           | 商业险           | 1000 | 50000 | insuranceNoTest0001 | 2016-09-28 | 2020-09-27 | 车行              | 朱云峰        |
