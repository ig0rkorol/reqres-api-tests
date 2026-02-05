Feature: Create User API functionality

  @sanity
  Scenario: Add user valid data
    Given correct user data provided
    When POST request is executed via Users endpoint
    Then the response code should be 201
    And response match JSON schema



