Feature: Login Functionality

Scenario: Login with valid credentials
Given User has navigated to login page
When User has entered valid email address <username> into email field 
And User has entred valid password <password> into password field
And User clicks on Login button
Then User should get successfully logged in
Examples:
|username 				|password|
|panchahardik@gmail.com |qwerty  |
|hardikpancha@gmail.com |123abc  |

Scenario: Login with invalid credentials
Given User has navigated to login page
When User has entered invalid email address into email field
And User has entred invalid password "1234dsfs5" into password field
And User clicks on Login button
Then User gets a proper warning message about credential mismatch

Scenario: Login with valid email and invalid password
Given User has navigated to login page
When User has entered valid email address "hardikpancha@gmail.com" into email field
And User has entred invalid password "12345asas" into password field
And User clicks on Login button
Then User gets a proper warning message about credential mismatch

Scenario: Login with invalid email and valid password
Given User has navigated to login page
When User has entered invalid email address into email field
And User has entred valid password "123abc" into password field
And User clicks on Login button
Then User gets a proper warning message about credential mismatch