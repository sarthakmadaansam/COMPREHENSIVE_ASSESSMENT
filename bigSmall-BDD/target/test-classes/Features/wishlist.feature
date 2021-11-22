Feature: Wishlist Icon

Scenario:  As a user I want to check the My Wishlist page 

Given User launches browser and opens URL "https://www.bigsmall.in/" for wishlist
When  User clicks on the search box and types "Harry Potter" and clicks Enter and selects Harry Potter playing cards and adds it to wishlist
Then  Page is navigated to My Wishlist with added item

