package linkedin.testing.pageobjects;

import linkedin.testing.factory.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class ProfilPage extends CommonPageObject{

    @FindBy(id="globalfooter-select_language")
    private WebElement languageSelect;

    @FindBy(css=".pv-top-card-add-goals.mr2 > button")
    private WebElement OpenToButton;
    @FindBy(css="section > div > div  > button.artdeco-button--secondary > span")
    private WebElement AddProfileButton;
    @FindBy(css="section > div > div  > div > div > button.artdeco-dropdown__trigger> span")
    private WebElement MoreButton;

    public ProfilPage(WebDriverFactory factory) {
        super(factory);
    }

    public String getOpenToButtonText(){
        waitForElementToBeClickable(OpenToButton);
        return OpenToButton.getText();
    }
    public String getAddProfileButton(){
        waitForElementToBeClickable(AddProfileButton);
        return AddProfileButton.getText();
    }
    public String getMoreButton(){
        waitForElementToBeClickable(MoreButton);
        return MoreButton.getText();
    }



    public void scrollToTheBottomOfThePage() {
        ((JavascriptExecutor) getWebDriverFromFactory()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
