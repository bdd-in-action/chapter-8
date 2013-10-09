package com.bddinaction.chapter8.jbehave.flowsteps;

import com.bddinaction.chapter8.jbehave.pages.BookingPage;
import com.bddinaction.chapter8.jbehave.pages.LoginPage;
import net.thucydides.core.annotations.Step;

public class TravellerFlowSteps {

    LoginPage loginPage;
    BookingPage bookingPage;

    @Step
    public void navigateToFlightBookings() {
        loginPage.open();
        loginPage.inMainMenu().selectMenuOption("Book");
    }

    @Step("Search for {0} flights from {1} to {2} in {3} class")
    public void searchForFlights(String flightType, String from, String to, String travelClass) {
        bookingPage.setFlightType(flightType);
        bookingPage.setFrom(from);
        bookingPage.setTo(to);
        bookingPage.setTravelClass(travelClass);

        bookingPage.searchButton().shouldNotBeEnabled();

    }
}
