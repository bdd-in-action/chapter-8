package com.bddinaction.chapter8.jbehave.steps;

import com.bddinaction.chapter8.jbehave.flowsteps.TravellerFlowSteps;
import com.bddinaction.chapter8.jbehave.pages.BookingPage;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class BookingAFlightSteps {

    @Steps
    TravellerFlowSteps traveller;

    @Given("I want to book a flight")
    public void givenIWantToBookAFlight() {
        traveller.navigateToFlightBookings();
    }

    @When("I search for $flightType flights from $from to $to in $travelClass")
    public void whenISearchForFlights(String flightType, String from, String to, String travelClass) {
        traveller.searchForFlights(flightType, from, to, travelClass);
    }

    @Then("I should see the list of all available flights")
    public void thenIShouldSeeTheListOfAllAvailableFlights() {
    }

    BookingPage bookingPage;

    @When("I enter '$prefix' into the 'from' city field")
    public void enterFromPrefix(String prefix) {
        bookingPage.setFrom(prefix);
    }

    @Then("I should see the following cities: $expectedCities")
    public void shouldSeeCities(List<String> expectedCities) {
        assertThat(bookingPage.getFromTypeaheads()).containsAll(expectedCities)
                                                   .hasSize(expectedCities.size());

    }

}
