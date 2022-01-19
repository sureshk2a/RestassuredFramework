Feature: Validating Employee API's

  Scenario Outline: Verify user is successfully created
    Given Add CreateUser payload with name "Hank"
    When User calls "CreateEmployee" api with "post" request
    Then the api call is with status code "200"
    And "status" in response is "success"
    And verify id created maps to "<id>" using "GetEmployee"

    Examples:
    |id|
    |  |