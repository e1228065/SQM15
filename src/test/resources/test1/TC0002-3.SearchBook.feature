Feature: TC0002-TC0003 Search the book in library

  Background: 
    Given server is running

  Scenario: Log in and search existing book based on title
     When client log in with user "ss15.sqm@gmail.com" and password "12345qwertasdfg"
     And client serches book "austriantestingboard" 
     Then the result "Austrian Testing Board: Willkommen" is present on the page
     And user logout
     
  Scenario: Log in and search existing book based on Author
     When client log in with user "ss15.sqm@gmail.com" and password "12345qwertasdfg"
     And client serches book "istqb austria" 
     Then the result "Austrian Testing Board: Willkommen" is present on the page
     And user logout