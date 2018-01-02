#Author: Pritam.Maibam@meijer.com

Feature: Digital Shopping - Reading Data from Excel to Perform Repetative Actions

  Background:
    Then clear all array list

  @tryRun1
  Scenario: Sample scenario to Validate Store With Zip Code
    Given user navigate to MeijerDotCom
    When user provide '49525' on GeoLocation Setting screen
    Then click Find Stores Button on GeoLOcation Setting