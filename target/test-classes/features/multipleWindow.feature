@multiplewindows
Feature: Clicking on window tabs

  Background:
  Given User is on ToolsQa page
  Scenario: click and switch to those tabs
    When User clicks on New Tab button
    Then User should see "This is a sample page" message on the new tab

    Scenario: click on the new window button
      When User clicks on New Window button
      Then User should see "This is a sample page"message on the new window

  Scenario: Clicking on New Window Message
    Given User clicks on New Window Message
    Then User should see New Window with a message "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization."