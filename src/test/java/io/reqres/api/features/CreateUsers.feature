Feature: Create User API functionality

  @sanity
  Scenario: Add user valid data
    Given correct user data provided
    When POST request is executed via Users endpoint
    Then the response code should be 201
    And response match JSON schema

  @sanity
  Scenario: Add user use invalid data
    When POST request is executed with incorrect json user data provided
    Then the response code should be 400
    And response error is "invalid_json"
    And response message is "The request body contains invalid JSON."



