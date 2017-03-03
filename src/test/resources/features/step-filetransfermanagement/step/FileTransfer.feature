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
Feature: File Transfer
  I want to use this template for my feature file

  Background: Login to system
    Given Login to system for File Transfer
      | idNumber			|
      | 330100198502080003	|

  #Scenario Outline: file transfer
  Scenario: AC1:File Transfer
    #Normal Process
    Given Click My Task panel
    And Click My Task button
    And Find my client
      | customerName | processName	|
      | uiTest011    | 文档传递流程	|
    And Click the operation button
    And Click the submit button in infoReview page when document delivery
    #Copy Contract
    Given Click My Task panel
    And Click My Task button
    And Find my client
      | customerName | processName	|
      | uiTest011    | 文档传递流程	|
    And Click the operation button
    When Navigate to car info tab
    Then Enter car info in carInfo tab
      | carFrameNo 			| carEngineNo	| maxCapacity	| billNo	|
      | ABCDEFG1234567890   | Engine001		| 4				| BillNo001	|
    And Click the save button in carInfo tab
    When Navigate to customer info tab
    Then Click the save button in customerInfo tab
    When Navigate to counter tab
    Then Click the save button in counter tab
    When Navigate to basic info tab
    And Click the submit button in copyContract page when document delivery
    #Review Info Again
    Given Click My Task panel
    And Click My Task button
    And Find my client
      | customerName | processName	|
      | uiTest011    | 文档传递流程	|  
    And Click the operation button
    And Click the submit button in infoReview page when document delivery
    #Receive Info
    Given Click My Task panel
    And Click My Task button
    And Find my client
      | customerName | processName	|
      | uiTest011    | 文档传递流程	|  
    And Click the operation button
    And Click the submit button in infoReview page when document delivery
    Then Check if file transfer successfully
      | customerName | currentNode	|
      | uiTest011    | 资料接收		|  