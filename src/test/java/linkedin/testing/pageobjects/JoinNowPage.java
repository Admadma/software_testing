package linkedin.testing.pageobjects;

import linkedin.testing.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JoinNowPage extends CommonPageObject{

    @FindBy(id = "join-form-submit")
    private WebElement agreeAndJoinButton;

    @FindBy(id = "email-address")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    private final Map<String, WebElement> inputFieldsMap = Map.of(
            "Email", emailInput,
            "", passwordInput
    );

    public JoinNowPage(WebDriverFactory factory) {
        super(factory);
    }

    public void clickOnAgreeAndJoinButton(){
        waitForElementToBeClickable(agreeAndJoinButton);
        agreeAndJoinButton.click();
        waitForPageReadiness();
    }

    public WebElement getInputFieldByName(final String name) {
        return inputFieldsMap.get(name);
    }
}
