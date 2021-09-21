package com.udemy.spring.springselenium;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.udemy.spring.springselenium.bdd",
        tags = { "@visa" },
        plugin = {
                "pretty",
                "html:C:\\Users\\nauris.malitis\\OneDrive - Accenture\\Documents\\udemy\\temp"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
