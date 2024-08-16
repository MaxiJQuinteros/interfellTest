package stepDef;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Registration;
import pages.WelcomeScreen;

import java.net.MalformedURLException;
import java.net.URL;

public class RegistrationStepdefs {

    private AndroidDriver driver;
    private Registration registration;
    private WelcomeScreen welcomeScreen;


    @Given("I open the app")
    public void iOpenTheAppliction() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("376bc5cb")
                .setPlatformVersion("13")
                .setApp("Raziel/interfellTest/src/main/resources/app-test-QA.APK")
                .setAutomationName("UiAutomator2");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        registration = new Registration(driver);
        welcomeScreen = new WelcomeScreen(driver);
    }

    @When("I use {string} as username")
    public void iUseAsUsername(String userName) {
        registration.inputUsername(userName);
    }

    @And("I use {string} as password")
    public void iUseAsPassword(String password) {
        registration.inputPassword(password);
    }

    @And("I use {string} as re-password")
    public void iUseAsRePassword(String repassword) {
        registration.inputRePassword(repassword);
    }

    @And("I use {string} as email")
    public void iUseAsEmail(String email) {
        registration.inputEmail(email);
    }

    @And("press the Login button")
    public void pressTheLoginButton() {
        registration.clickSubmit();
    }

    @Then("the Welcome screen is displayed")
    public void theWelcomeScreenIsDisplayed() {
        Assert.assertTrue(welcomeScreen.welcomeScreenDisplayed());
    }

    @Then("the error message {string} is displayed under the {string} field")
    public void theErrorMessageIsDisplayedUnderTheField(String message, String field) {
    }

    @When("I clear the {string} field")
    public void iClearTheField(String field) {
        registration.clearField(field);
    }

    @And("I press the confirm button")
    public void iPressTheConfirmButton() {
        registration.clickConfirm();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
