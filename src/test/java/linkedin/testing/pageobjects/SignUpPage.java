package linkedin.testing.pageobjects;

import linkedin.testing.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SignUpPage extends CommonPageObject{

    @FindBy(id ="join-form-submit")
    private WebElement registrationButton;

    @FindBy(id = "email-address")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    private final Map<String, WebElement> inputFieldsMap = Map.of(
            "Email", emailInput,
            "", passwordInput
    );


    public SignUpPage(WebDriverFactory factory) {
        super(factory);
    }

    public void clickOnRegistrationButton() {
        waitForElementToBeClickable(registrationButton);
        registrationButton.click();
        waitForPageReadiness();
    }

}
