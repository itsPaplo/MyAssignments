Feature: Login Functionality

Scenario: Login with correct credential

#Given Browser launched and is maximised and is in Login page
And Enter the username as 'DemoSalesManager'
And Enter the password as 'crmsfa'
When user clicks on login button
Then verify login attempt

Scenario: Login with incorrect credential

#Given Browser launched and is maximised and is in Login page
And Enter the username as 'Demo'
And Enter the password as 'crmsfa'
When user clicks on login button
But verify login attempt