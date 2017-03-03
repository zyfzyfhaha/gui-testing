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
#AC1:File Transfer
@test
Feature: Send Manage Company
  I want to use this template for my feature file

  Background: Login to system
    Given Login to system for Send Manage Company
      | idNumber			|
      | 330100198502080003	|

  Scenario: AC1:Send Manage Company
    #Normal Process
    Given Navigate to send manage company index
    And Find my client in index
    	| customerName |
    	| uiTest011    |
    And Click the add parcel button
    When Click the add express button
    Then Enter express info in expressEntering page
      | expressCompany 	| billNo		|
      | 顺丰		   		| express001	|
    And Click submit button in expressEntering page
    Then Check if send express successfully
      | customerName | expressCompany 	| billNo		| status	|
      | uiTest011    | 顺丰		   		| express001	| 未收件		|
    #Receipt Manage Bank
    Given Navigate to receipt manage bank index
    When Find my client in receiptBank index
    	| customerName |
    	| uiTest011    |
    And Click the receipt button in receiptBank Index
    Then Check if bank receipt successfully
      | customerName | expressCompany 	| billNo		| status	|
      | uiTest011    | 顺丰		   		| express001	| 已收件		|
    #Send Manage Bank
    Given Navigate to send manage bank index
    When Find my client in sendBank index
    	| customerName |
    	| uiTest011    |
    And Click the add express button in send bank index
    Then Enter express info for send bank in expressEntering page
      | expressCompany 	| billNo		|
      | 顺丰		   		| express002	|
    And Click submit button in expressEntering page
    Then Check if send bank express successfully
      | expressCompany 	| billNo		| status	|
      | 顺丰		   		| express002	| 未收件		|
    #Receipt Manage Company
    Given Navigate to receipt manage company index
    When Find my client in receiptCompany index
    	| customerName |
    	| uiTest011    |
    And Click the receipt button in receiptCompany Index
    Then Check if company receipt successfully
      | expressCompany 	| billNo		| status	|
      | 顺丰		   		| express002	| 已收件		|