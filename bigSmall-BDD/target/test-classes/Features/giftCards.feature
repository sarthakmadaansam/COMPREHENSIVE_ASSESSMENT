Feature: Gift Cards icon

Scenario: As a user I want to add Gift Cards

Given User launches browser and opens URL "https://www.bigsmall.in/" for giftcards
When  User clicks on the option Gift cards from top-right corner of the page and selects a gift card of Rs 1000 and adds it to cart
Then  Page is navigated to My Cart with added item

