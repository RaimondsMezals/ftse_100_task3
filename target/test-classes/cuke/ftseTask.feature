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
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Finding out the riser
    Given I can access "https://www.hl.co.uk/shares/stock-market-summary/ftse-100" 
    When I navigate to the risers
    Then I should see the largest riser within the list
    
    @tag2
  Scenario: Finding out the faller
    Given I can access "https://www.hl.co.uk/shares/stock-market-summary/ftse-100" 
    When I navigate to the fallers
    Then I should see the largest faller within the list


