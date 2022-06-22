Feature: Admin employees

  @Employee
  Scenario: User Add a new employee
    Given User is on PIM tab
    When User add a new employee
    Then employee data is displayed

  @Employee1
  Scenario: User delete a employee
    Given a employee created
    When User delete a employee
    Then the employee data is not show

  @Employee
  Scenario: User can't created a employee without data
    Given User is on PIM tab
    When User add a new employee without data
    Then empty field validation is show

  @Employee
  Scenario Outline: User edit a new employee with data
    Given User is on PIM tab
    When User edit a employee with name: "<name>", middleName: "<middleName>" and lastName: "<lastName>"
    Then employee data is displayed

    Examples:
      | name     | middleName | lastName |
      | fulanito | 01         | de tal   |
      | zutano   | 01         | de tal   |

