package com.bddinaction.chapter8.jbehave.pages.components;

import com.bddinaction.chapter8.jbehave.pages.BookingPage;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class MainMenu extends PageObject {

    public void selectMenuOption(String menuOption) {
        find(By.linkText(menuOption)).click();
    }

    public BookingPage selectBookFlight() {
        selectMenuOption("Book");
        return switchToPage(BookingPage.class);
    }

}
