package com.udemy.spring.springselenium.page.window;

import com.udemy.spring.springselenium.operations.annotation.Page;
import com.udemy.spring.springselenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class PageC extends Base {

    @FindBy(id = "area")
    private WebElement textArea;

    public void addToArea(final String msg){
        this.textArea.sendKeys(msg);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.textArea.isDisplayed());
    }
}
