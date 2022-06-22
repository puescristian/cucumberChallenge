Feature: Login into the application using the username and password

  Background:
    Given User is on OrangeHRM login page

  @Login
  Scenario: login with valid credentials
    When User login into application with user: "Admin" and password: "admin123"
    Then Home page is displayed

  @Login
  Scenario: Login without credentials
    When User login into application with user: "" and password: ""
    Then not credentials message is show


  @Login
  Scenario Outline: login with no valid credentials
    When User login into application with user: "<user>" and password: "<pass>"
    Then invalid credentials message is show
    Examples:
      | user      | pass   |
      | perengano | 999999 |
      | asdfdsa   | 987456 |
