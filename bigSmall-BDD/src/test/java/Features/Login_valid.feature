Feature: Valid Login

Scenario:  As a user, I want to be able to log in to my account using correct data

Given User launches chrome browser and opens URL "https://www.bigsmall.in/"
When  User clicks on Log In and enters valid data
Then  The user data is accepted and user is redirected to My Account page
