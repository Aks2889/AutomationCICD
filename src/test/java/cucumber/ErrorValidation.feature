Feature: Error validations

@ErrorValidation
Scenario Outline: Negative Test of Login Page

Given I landed on Ecommerce Page

When Logged in with username <name> and password <password>

Then "Incorrect email or password." message is displayed

Examples:
  | name                 | password |
  | testakshata@test.com | A@123456 |