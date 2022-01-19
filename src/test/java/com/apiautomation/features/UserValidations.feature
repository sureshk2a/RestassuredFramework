Feature: Validating Employee API's

  Scenario: Verify user is successfully created
    Given Add CreateUser payload with name "Flecher"
    When User calls "CreateEmployee" api with "post" request
    Then the api call is with status code "200"
    And "status" in response is "success"
