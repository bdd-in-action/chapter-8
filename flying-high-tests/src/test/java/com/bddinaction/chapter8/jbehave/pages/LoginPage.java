package com.bddinaction.chapter8.jbehave.pages;

import com.bddinaction.chapter8.jbehave.pages.components.MainMenu;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://localhost:8080/#/welcome")
public class LoginPage extends PageObject {

    private WebElement email;
    private WebElement password;

    @FindBy(css = ".btn[value='Sign in']")
    private WebElement signin;

    public MainMenu mainMenu;

    public void signinAs(String userEmail, String userPassword) {
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        signin.click();
    }

    public MainMenu inMainMenu() {
        return mainMenu;
    }
}

