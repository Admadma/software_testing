package linkedin.testing.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import linkedin.testing.config.TestConfig;
import linkedin.testing.factory.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


@ContextConfiguration(classes = TestConfig.class)
public class HomePageStepDefinitions {

    @Autowired
    private WebDriverFactory factory;


    @And("the Cookie disclaimer is closed")
    public void theCookieDisclaimerIsClosed() {
        var driver = factory.getWebDriver();
        var acceptButton = driver.findElement(By.cssSelector("#artdeco-global-alert-container > div > section > div > div.artdeco-global-alert-action__wrapper > button:nth-child(2)"));
        acceptButton.click();
    }

    @Then("the page url is \"([^\"]*)\"$")
    public void thePageUrlIsEqualTo(final String targetUrl) {
        var driver = factory.getWebDriver();
        final var url = driver.getCurrentUrl();
        assertThat(url, equalTo(targetUrl));
    }

    @Then("the following elements are in the header")
    public void theFollowingElementsAreInTheHeader(final DataTable table) {
        var driver = factory.getWebDriver();
        final var data = table.asMaps(String.class, String.class);

        data.forEach(row -> {
            final var selector = row.get("selector");
            final var expectedReferencedPage = row.get("referenced page");

            final var selectedElement = driver.findElement(By.cssSelector(selector));
            assertThat(selectedElement, notNullValue());

            final var actualReferencedPageUrl = selectedElement.getAttribute("href");
            assertThat(actualReferencedPageUrl, equalTo(expectedReferencedPage));
        });
    }

}
