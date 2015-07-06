Feature: Add book to the library

  Background: 
    Given server is running

  Scenario Outline: Log in and add the book
     When client log in with user "ss15.sqm@gmail.com" and password "12345qwertasdfg"
     And client enters book creation section
     And client fills in <name> and <size> and <status> and adds a book
     Then the book <name> should be present in the library
     And user logout
     
     Examples: 
     
       | name                 | size | status |
       | FirstBookUniqueName  | 47   | New    |
       | SecondBookUniqueName | 107  | Used   |
       | ThirdBookUniqueName  | 432  | Used   |
         
      