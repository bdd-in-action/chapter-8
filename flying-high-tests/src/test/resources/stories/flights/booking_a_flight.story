Booking a flight

Narrative:
In order to travel to my destination
As a traveller
I want to be able to book a flight online

Scenario: Viewing available flights
Given I want to book a flight
When I search for return flights from Sydney to London in Business
Then I should see the list of all available flights

Scenario: Filtering cities
Given I want to book a flight
When I enter 'Se' into the 'from' city field
Then I should see the following cities: Seattle, Seoul
