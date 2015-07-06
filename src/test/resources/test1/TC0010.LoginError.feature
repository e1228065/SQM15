Feature: Logging with wrong credentials fails

  Background: 
    Given server is running

  Scenario: Log in and add the book
     When client log in with user "ss15.sqm@gmail.com" and password "12345"
     Then Error is displayed
     And user is not logged in
