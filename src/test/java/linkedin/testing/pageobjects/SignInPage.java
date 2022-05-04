package linkedin.testing.pageobjects;

import linkedin.testing.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SignInPage extends CommonPageObject{
    private static final String SIGN_IN_PAGE_URL = "https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin";


    @FindBy(className = "btn__primary--large")
    private WebElement signInButton;

    @FindBy(id = "username")
    private WebElement emailOrPhone;

    @FindBy(id = "password")
    private WebElement passwordInput;

    private final Map<String, WebElement> inputFieldsMap = Map.of(
            "Email or Phone", emailOrPhone,
            "Password", passwordInput
    );

    public SignInPage(WebDriverFactory factory) {
        super(factory);
    }

    public void navigateToSignInPage(){
        navigateToUrl(SIGN_IN_PAGE_URL);
    }

    public void clickOnSignInButton(){
        waitForElementToBeClickable(signInButton);
        signInButton.click();
        waitForPageReadiness();
    }

    public WebElement getInputFieldByName(final String name) {
        return inputFieldsMap.get(name);
    }
}
