Feature: Validating Tourist API's

  Scenario Outline: Verify tourist is successfully created
    Given Add CreateTourist payload with name "<name>" and mail "<mail>"
    When User calls "CreateTourist" api with "post" request
    Then the api call is with status code "201"
    And "tourist_name" in response is "<name>"
    And map "id" to "GetTourist"
    Examples:
      |name  | mail |
      |Tokyo|fdfankji@gmail.com|

#  Scenario Outline: Verify tourist is successfully deleted
#    Given Get "id" of the employee "<name>"
#    When User calls "DeleteTourist" api with "delete" request
#    Then the api call is with status code "200"
#    And "tourist_name" in response is "<name>"
#    And map "id" to "GetTourist"
#    Then the api call is with status code "404"
#
#    Examples:
#      | name |
#      |Franklin|