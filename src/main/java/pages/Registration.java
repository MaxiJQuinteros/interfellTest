package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration extends Base {

    public Registration(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.EditText[@text=\"Username\"]")
    private WebElement userName;
    @FindBy(xpath = "//android.widget.EditText[@text=\"Password\"]")
    private WebElement password;
    @FindBy(xpath = "//android.widget.EditText[@text=\"Repeat password\"]")
    private WebElement rePassword;
    @FindBy(xpath = "//android.widget.EditText[@text=\"Email (Optional)\"]")
    private WebElement email;
    @FindBy(xpath = "//android.widget.TextView[@text=\"SUBMIT\"]")
    private WebElement submitButton;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Your email is empty, we recommended since is needed for account recovery, do you want continue?\"]")
    private WebElement emptyEmailMessage;
    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")
    private WebElement cancelButton;
    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")
    private WebElement confirmButton;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Username should not contain @\"]")
    private WebElement errorUsernameAt;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Username exist\"]")
    private WebElement errorUsernameAlreadyOnUse;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Username is required\"]")
    private WebElement errorEmptyUsername;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Password is required\"]")
    private WebElement errorEmptyPassword;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Password does not have the format\"]")
    private WebElement errorPasswordFormat;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Repeat password is required\"]")
    private WebElement errorEmptyRepeatPassword;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Please enter a valid email\"]")
    private WebElement errorEmailFormat;

    public void inputUsername(String username) {
        sendKeys(userName, username);
    }

    public void inputPassword(String passwrd) {
        sendKeys(password, passwrd);
    }

    public void inputRePassword(String repassword) {
        sendKeys(rePassword, repassword);
    }

    public void inputEmail(String eMail) {
        sendKeys(email, eMail);
    }

    public void clickSubmit() {
        click(submitButton);
    }

    public Boolean errorMessageVerifiction(String message, String field) {
        boolean result = false;
        switch (field) {
            case "username":
                if (errorUsernameAt.getText().equals(message) || errorEmptyUsername.getText().equals(message) || errorUsernameAlreadyOnUse.getText().equals(message)) {
                    return result = true;
                }
                break;
            case "password":
                if (errorEmptyPassword.getText().equals(message) || errorPasswordFormat.getText().equals(message)) {
                    return result = true;
                }
                break;
            case "repeat password":
                if (errorEmptyRepeatPassword.getText().equals(message) || errorPasswordFormat.getText().equals(message)) {
                    return result = true;
                }
                break;
            case "email":
                if (errorEmailFormat.getText().equals(message)) {
                    return result = true;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + field);
        }
        return result;
    }

    public void clearField(String field) {
        switch (field) {
            case "username":
                clear(userName);
                break;
            case "password":
                clear(password);
                break;
            case "repeat password":
                clear(rePassword);
                break;
            case "email":
                clear(email);
                break;
        }
    }

    public void clickConfirm() {
        click(confirmButton);
    }
}
