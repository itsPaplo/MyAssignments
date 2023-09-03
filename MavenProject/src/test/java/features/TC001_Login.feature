Feature: Login Functionality

Scenario: Login with correct credential

Given Browser launched and is maximised and is in Login page
And Enter the correct username
And Enter the correct password
When user clicks on login button
Then verify login attempt is successfull

Scenario: Login with incorrect credential

Given Browser launched and is maximised and is in Login page
And Enter the incorrect username
And Enter the incorrect password
When user clicks on login button
But verify login attempt has failed