package com.udemy.spring.springselenium.operations.config;

import com.udemy.spring.springselenium.operations.annotation.LazyConfiguration;
import com.udemy.spring.springselenium.operations.annotation.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

@LazyConfiguration
@Profile("!remote")
public class WebDriverConfig {

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver chromeDriver(){
        WebDriverManager.chromedriver().version("92.0.4515.107").setup();
        return new ChromeDriver();
    }

}
