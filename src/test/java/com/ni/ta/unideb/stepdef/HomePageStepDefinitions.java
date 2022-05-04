package com.ni.ta.unideb.stepdef;

import com.ni.ta.unideb.TestRunner;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePageStepDefinitions extends TestRunner {

    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        driver.get("https://www.linkedin.com/");
    }

    @And("the Cookie disclaimer is closed")
    public void theCookieDisclaimerIsClosed() {
        //System.out.println(driver.findElement(By.xpath("//button[text()='']")));
    }

    @Then("the page url is \"([^\"]*)\"$")
    public void thePageUrlIsEqualTo(final String targetUrl) {
        final var url = driver.getCurrentUrl();
        assertThat(url, equalTo(targetUrl));
    }

    @Then("the following elements are in the header")
    public void theFollowingElementsAreInTheHeader(final DataTable table) {
        final var data = table.asMaps(String.class, String.class);

        data.forEach(row -> {
            final var selector = row.get("selector");
            final var expectedReferencedPage = row.get("referenced page");

            final var selectedElement = driver.findElement(By.cssSelector(selector));
            assertThat(selectedElement, notNullValue());

            final var actualReferencedPageUrl = getParent(selectedElement).getAttribute("href");
            assertThat(actualReferencedPageUrl, equalTo(expectedReferencedPage));
        });
    }

    private WebElement getParent(final WebElement element) {
        return element.findElement(By.xpath("./.."));
    }
}
