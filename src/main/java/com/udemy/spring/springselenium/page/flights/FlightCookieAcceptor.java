package com.udemy.spring.springselenium.page.google;

import com.udemy.spring.springselenium.operations.annotation.PageFragment;
import com.udemy.spring.springselenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@PageFragment
public class FlightCookieAcceptor extends Base {

    @FindBy(css = "[jsname='higCR']")
    private WebElement acceptBtn;

    public void accept(){
        this.acceptBtn.click();
    }

    @Override
    public boolean isAt() {
        try {
            return this.wait.withTimeout(Duration.ofSeconds(4)).until((d) -> this.acceptBtn.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}