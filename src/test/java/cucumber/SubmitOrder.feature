@tag
Feature: Purchase the Order from Ecommerce website
Background:
 Given  I landed on Ecommerce Page

  @Regression
   Scenario Outline: Positive Test of Submitting the Order

```
Given Logged in with username <name> and password <password>
When I add product <productName> to Cart
And Checkout <productName> and submit the order
Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

Examples:
  | name                  | password      | productName |
  | testakshata@test.com  | Test.123456   | ZARA COAT 3 |
  
  
  