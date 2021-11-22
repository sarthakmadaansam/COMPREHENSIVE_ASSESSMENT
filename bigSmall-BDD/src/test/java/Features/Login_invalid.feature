Feature: Invalid Login

Scenario:  As a user, I want to see whether login fails on providing invalid data as input

Given User launches browser and opens URL "https://www.bigsmall.in/" for invalid data
When  User clicks on Log In and enters invalid data
Then  The user data is not accepted and error message is displayed
