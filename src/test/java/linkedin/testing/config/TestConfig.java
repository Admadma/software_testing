package linkedin.testing.config;

import linkedin.testing.factory.WebDriverFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("linkedin.testing")
public class TestConfig {
    public static final long PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS = 15;

    @Bean(destroyMethod = "closeWebDriver")
    public WebDriverFactory webDriverFactory() {
        return new WebDriverFactory();
    }
}
