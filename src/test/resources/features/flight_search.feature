Feature: Search Flights on MakeMyTrip

  Scenario: Search for flights from HYD to MAA
    Given I open the MakeMyTrip website
    When I click on the "Flights" section
    And I select "Round Trip"
    And I enter "HYD" as the From Location
    And I enter "MAA" as the To Location
    And I select a Departure Date
    And I select a Return Date
    And I click the Search button
    Then I should be redirected to the search results page
