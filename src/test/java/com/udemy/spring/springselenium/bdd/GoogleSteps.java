package com.udemy.spring.springselenium.bdd;

import com.udemy.spring.springselenium.operations.annotation.LazyAutowired;
import com.udemy.spring.springselenium.page.google.CookieAcceptor;
import com.udemy.spring.springselenium.page.google.GooglePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.testng.Assert;

@SpringBootTest
@TestPropertySource(properties = "a=b")
public class GoogleSteps {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private CookieAcceptor cookieAcceptor;

    @Given("I am on the google site")
    public void launchSite() {
        this.googlePage.goTo();
        if (this.cookieAcceptor.isAt()) this.cookieAcceptor.accept();
    }

    @When("I enter {string} as a keyword")
    public void enterKeyword(String keyword) {
        this.googlePage.getSearchComponent().search(keyword);
    }

    @Then("I should see search results page")
    public void clickSearch() {
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
    }

    @Then("I should see at least {int} results")
    public void verifyResult(int count) {
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() >= count);
    }
}
