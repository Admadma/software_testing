package linkedin.testing.pageobjects;

import linkedin.testing.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class FeedPage extends CommonPageObject{

    @FindBy(css = ".feed-identity-module__actor-meta > a.ember-view")
    private WebElement profilButton;

    public FeedPage(WebDriverFactory factory) {
        super(factory);
    }

    public void clickOnProfilButton(){
        waitForElementToBeClickable(profilButton);
        profilButton.click();
        waitForPageReadiness();
    }
}
