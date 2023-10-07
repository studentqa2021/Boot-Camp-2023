@Function @Smoke @Regression
Feature: check google search function
  description: iphone 13 must visible

  @Positive @TC_BCNP-26
  Scenario: As a google search user i can search iphone13
    Given open a browser
    And go to google
    When search for iphone13
    Then search option should visible only iphone13
