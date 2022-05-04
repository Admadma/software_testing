package linkedin.testing.stepdefinitions;

import io.cucumber.spring.CucumberContextConfiguration;
import linkedin.testing.config.TestConfig;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = TestConfig.class)
public class LinkedinCucumberContext {
}
