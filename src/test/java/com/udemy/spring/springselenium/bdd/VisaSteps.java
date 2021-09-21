package com.udemy.spring.springselenium.bdd;

import com.udemy.spring.springselenium.operations.annotation.LazyAutowired;
import com.udemy.spring.springselenium.page.visa.VisaRegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.util.StringUtils;
import org.testng.Assert;

import java.time.LocalDate;

public class VisaSteps {

    @LazyAutowired
    private VisaRegistrationPage visaRegistrationPage;

    @Given("I am on VISA registration form")
    public void launchSite() {
        this.visaRegistrationPage.goTo();
        Assert.assertTrue(this.visaRegistrationPage.isAt());
    }

    @When("I select my from country {string} and to country {string}")
    public void selectCountry(String from, String to) {
        this.visaRegistrationPage.setCountryFromAndTo(from, to);
    }

    @And("I enter my dob as {string}")
    public void enterDob(String dob) {
        this.visaRegistrationPage.setBirthDate(LocalDate.parse(dob));
    }

    @And("I enter my name as {string} and {string}")
    public void enterNames(String fn, String ln) {
        this.visaRegistrationPage.setNames(fn, ln);
    }

    @And("I enter my contact details as {string} and {string}")
    public void enterEmailPhone(String email, String phone) {
        this.visaRegistrationPage.setContactDetails(email, phone);
    }

    @And("I enter the comment {string}")
    public void enterComment(String comment) {
        this.visaRegistrationPage.setComments(comment);
    }

    @And("I submit the form")
    public void submit() {
        this.visaRegistrationPage.submit();
    }

    @Then("I should see get the confirmation number")
    public void verifyConfirmationNumber() {
        Assert.assertFalse(StringUtils.isEmpty(this.visaRegistrationPage.getConfirmationNumber()));
    }
}
