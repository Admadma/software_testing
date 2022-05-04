package com.ni.ta.unideb.stepdef;

import com.ni.ta.unideb.TestRunner;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserSetUpStepDefinitions extends TestRunner {

    @Before
    public void before(Scenario scenario) {
        System.out.println("------------------------------");
        System.out.println("Starting - " + scenario.getName());
        System.out.println("------------------------------");
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println("------------------------------");
        System.out.println("before step");
        System.out.println("------------------------------");
    }

    @AfterStep
    public void afterStep() {
        System.out.println("------------------------------");
        System.out.println("after step");
        System.out.println("------------------------------");
    }

    @After
    public void after(Scenario scenario) {
        System.out.println("------------------------------");
        System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
        System.out.println("------------------------------");
        if (driver != null) {
            driver.close();
        }
    }

    @Given("^I have opened the browser$")
    public void openBrowser() {
        System.setProperty("webdriver.gecko.driver", "/home/gabor_ivanyi-nagy/Downloads/geckodriver"); // path to bin file. NOTE: platform dependent
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-profile");
        options.addArguments("/home/gabor_ivanyi-nagy/snap/firefox/common/.cache/mozilla/firefox/iivb642g.default");

        // Firefox browser url ird be hogy -> about:profiles
        // Local Directory kimásolva és használva "-profile"-ként
        // Bármilyen IDEA-beli modositás után Build project!!!!! aztán futtasd

        driver = new FirefoxDriver(options);
    }
}
