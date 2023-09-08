Feature: Login

Scenario: Login Functionality

Given Browser is launched and is maximised
Then Enter username
And Enter password
When user clicks on Login button
Then verify successfull login
