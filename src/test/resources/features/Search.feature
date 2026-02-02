Feature: Search functionality

Scenario: User searches for a valid product
Given User opens the application
When User enters "HP" into the search box field
And User clicks on Search button
Then User should get valid product dispplayed in search results


Scenario: User searches for an invalid product
Given User opens the application
When User enters invalid product "Honda" into the search box field
And User clicks on Search button
Then User should get a message about no product matching

Scenario: User searches without any product
Given User opens the application
When User dont enter any product name into the searchbox field
And User clicks on Search button
Then User should get a message about no product matching
