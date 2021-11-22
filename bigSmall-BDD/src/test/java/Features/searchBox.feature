Feature: Search a Product

Scenario:  As a user I want to be able to search for a product by typing in the search box

Given User launches chrome browser and opens URL "https://www.bigsmall.in/"
When  User clicks on search box and enters "Home Decor"
Then  User gets redirected to another page displaying Home Decor products 

