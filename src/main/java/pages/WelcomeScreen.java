package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomeScreen extends Base{
    public WelcomeScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.view.View[@text=\"Welcome\"]")
    private WebElement welcomeText;

    public Boolean welcomeScreenDisplayed(){
        waitForElementToBeVisible(welcomeText);
        return welcomeText.isDisplayed();
    }
}
