Feature: Retrieve User by Id API functionality

  @sanity22
  Scenario: Retrieve existing user provide valid Id
    Given correct user id provided
    When GET request is executed via Retrieve User by Id endpoint
    Then the response code should be 200
    And response match JSON schema



