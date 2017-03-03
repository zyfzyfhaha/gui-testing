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
Feature: CarDealer Order
  I want to use this template for my feature file

  Background: Login to system
    Given Login to system for testing CarDealer Order

  Scenario: AC1: Normal process with one relavant - spinsterhood
    #Accept Order
    Given Navigate to CarDealerOrderList page
    And Switch Driver To CarDealerOrder Page
    Then Find my order
      | customerName |
      | 车商订单测试		 |
    And Click the Accept Order button
    #Back Order
    When Click Accepted Order tab
    Then Find my order
      | customerName |
      | 车商订单测试		 |
    And Click the Back Order button
    And Check if back success
      | customerName |
      | 车商订单测试		 |

