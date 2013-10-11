package com.bddinaction.chapter8.jbehave.pages;

import com.bddinaction.chapter8.jbehave.model.DestinationDeal;
import com.beust.jcommander.internal.Lists;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static ch.lambdaj.Lambda.extract;
import java.util.List;

import static ch.lambdaj.Lambda.on;
import static org.fest.assertions.api.Assertions.assertThat;

public class HomePage extends PageObject {

    @FindBy(id = "welcome-message")
    private WebElement welcomeMessage;

    @FindBy(css = ".featured .featured-destination")
    private List<WebElement> featuredDestinations;

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }

    public List<DestinationDeal> getFeaturedDestinations() {
        List<DestinationDeal> deals = Lists.newArrayList();
        for (WebElement destinationEntry : featuredDestinations) {
            deals.add(destinationDealFrom(destinationEntry));
        }
        return deals;
    }

    private DestinationDeal destinationDealFrom(WebElement destinationEntry) {
        String destinationCity = $(destinationEntry).findBy(".destination-title").getText();
        String priceValue = $(destinationEntry).findBy(".destination-price").getText();

        int price = Integer.parseInt(priceValue.substring(1));
        return new DestinationDeal(destinationCity, price);
    }
}
