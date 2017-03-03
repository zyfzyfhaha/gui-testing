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
Feature: Start Transfer
  I want to use this template for my feature file

  Background: Login to system
    Given Login to system for testing Start Transfer

  Scenario: AC1: Normal process with one relavant - spinsterhood
    #Normal Process
    Given Navigate to TransferIndex page
    And Navigate to Start Transfer Page
      | cardNo             |
      | 330100198502080003 |
    Then Enter Detail In Transfer Page
      | commit             |
      | 发起过户-自动化测试 |
    And Click Submit button In Transfer Page
    And Select Next Operator
        | operator 	|
    	| 朱云峰 	|
    #Normal Process
    Given Click My Task panel
    And Click My Task button
    And Find my client
      | customerName | processName		|
      | uiTest011    | 二手车过户流程	|
    And Click the operation button
    When Click the submit button in assessment report page
    Then Check if secondhand car transfer successfully
      | customerName | cardNo             | result 	|
      | uiTest011    | 330100198502080003 | 过户完成	|