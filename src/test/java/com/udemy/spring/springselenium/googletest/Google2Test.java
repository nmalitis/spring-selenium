package com.udemy.spring.springselenium.googletest;

import com.udemy.spring.springselenium.SpringBaseTestNGTest;
import com.udemy.spring.springselenium.operations.annotation.LazyAutowired;
import com.udemy.spring.springselenium.page.google.CookieAcceptor;
import com.udemy.spring.springselenium.page.google.GooglePage;
import com.udemy.spring.springselenium.operations.service.ScreenshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Google2Test extends SpringBaseTestNGTest {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenshotService;

    @LazyAutowired
    private CookieAcceptor cookieAcceptor;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        if (this.cookieAcceptor.isAt()) this.cookieAcceptor.accept();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("selenium");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.screenshotService.takeScreenShot();
        this.googlePage.close();
    }

}
