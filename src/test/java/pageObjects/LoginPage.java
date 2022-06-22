package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.Messages.INVALID_CREDENTIALS;
import static utils.Messages.USERNAME_EMPTY;

public class LoginPage {
    public static WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By txt_username = By.id("txtUsername");
    private By txt_password = By.id("txtPassword");
    private By btn_login = By.id("btnLogin");
    private By welcome = By.id("welcome");
    private By validationMessage = By.xpath("//span[@id='spanMessage']");


    public void checkHomePageIsDisplayed() {
        assert (driver.findElement(welcome).isDisplayed());
    }

    public void loginWithCredentials(String username, String password) {
        driver.findElement(txt_password).sendKeys(password);
        driver.findElement(txt_username).sendKeys(username);
        driver.findElement(btn_login).click();
    }

    public void validateInvalidCredentialMessage() {
        assert (driver.findElement(validationMessage).getText().equals(INVALID_CREDENTIALS.getText()));
    }

    public void validateNotEmptyMessage() {
        assert (driver.findElement(validationMessage).getText().equals(USERNAME_EMPTY.getText()));
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
