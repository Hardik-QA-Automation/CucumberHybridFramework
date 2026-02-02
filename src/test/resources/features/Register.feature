Feature: Registration functionality

Scenario: Create an account with mandatory fileds:
Given User navigates to the Register Account page
When User enters the details into below fields
|firstname|Hardik           |
|lastname |Pancha           |
|telephone|1234567890       |
|password |12644            |
And User selects Privacy Policy
And User clicks on Continue button
Then User account should be created successfully


Scenario: Create an account with all fileds:
Given User navigates to the Register Account page
When User enters the details into below fields
|firstname|Hardik           |
|lastname |Pancha           |
|telephone|1234567890       |
|password |12644            |
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button
Then User account should be created successfully

Scenario: Create a duplicate account
Given User navigates to the Register Account page
When User enters the details into below fields with duplicate email
|firstname|Hardik           |
|lastname |Pancha           |
|email    |hardikpancha@gmail.com|
|telephone|1234567890       |
|password |12644            |
And User selects Privacy Policy
And User clicks on Continue button
Then User should get a proper warning about duplicate email

Scenario: Create an account without filling any details
Given User navigates to the Register Account page
When User dont enter the details into below fields
And User clicks on Continue button
Then User should get a proper warning messages for every mandatory fields