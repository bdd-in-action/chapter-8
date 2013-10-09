package com.bddinaction.chapter8.jbehave.flowsteps;

import com.bddinaction.chapter8.jbehave.model.FrequentFlyerMember;
import com.bddinaction.chapter8.jbehave.pages.HomePage;
import com.bddinaction.chapter8.jbehave.pages.LoginPage;
import net.thucydides.core.annotations.Step;

import static org.fest.assertions.api.Assertions.assertThat;

public class AuthenticationFlowSteps {

LoginPage loginPage;
HomePage homePage;

@Step
public void enterEmailAndPasswordFor(FrequentFlyerMember user) {
    loginPage.open();
    loginPage.enterEmailAndPassword(user.getEmail(), user.getPassword());
}

@Step
public void signsIn() {
    loginPage.signIn();
}

@Step
public void verifyWelcomeMessageFor(FrequentFlyerMember user) {
    String welcomeMessage = homePage.getWelcomeMessage();
    assertThat(welcomeMessage).isEqualTo("Welcome " + user.getFirstName());
}
}
