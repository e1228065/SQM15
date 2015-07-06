Feature: Login into google account

  Background: 
    Given server is running

  Scenario: Log in into google
    When client log in with user "ss15.sqm@gmail.com" and password "12345qwertasdfg"
    Then the start page for user "SQMuser" should be shown
    And user logout
