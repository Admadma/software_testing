package linkedin.testing.stepdefinitions;

import io.cucumber.spring.CucumberContextConfiguration;
import linkedin.testing.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static linkedin.testing.config.TestConfig.PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS;

@CucumberContextConfiguration
@ContextConfiguration(classes = TestConfig.class)
public class LinkedinSignupStepDefs {

}
