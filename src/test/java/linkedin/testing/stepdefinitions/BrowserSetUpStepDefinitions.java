package linkedin.testing.stepdefinitions;

import linkedin.testing.unideb.TestRunner;
import io.cucumber.java.*;

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


}
