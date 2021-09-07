package com.udemy.spring.springselenium.window;

import com.udemy.spring.springselenium.SpringBaseTestNGTest;
import com.udemy.spring.springselenium.operations.service.WindowSwitchService;
import com.udemy.spring.springselenium.page.window.MainPage;
import com.udemy.spring.springselenium.page.window.PageA;
import com.udemy.spring.springselenium.page.window.PageB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@TestPropertySource(properties = "browser=chrome")
public class WindowSwitchTest extends SpringBaseTestNGTest {

    @Autowired
    private MainPage mainPage;

    @Autowired
    private PageA pageA;

    @Autowired
    private PageB pageB;

    @Autowired
    private WindowSwitchService switchService;

    @BeforeClass
    public void setup(){
        this.mainPage.goTo();
        this.mainPage.isAt();
        this.mainPage.launchAllWindows();
    }

    @Test
    public void switchTest(){
        this.switchService.switchByTitle("Page A");
        this.pageA.addToArea("Hi page A!");
        this.switchService.switchByIndex(2);
        this.pageB.addToArea("Hello page B!");
    }

}
