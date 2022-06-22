package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LoginPage;
import utils.Employee;
import utils.TestContextSetup;

import java.io.IOException;

public class LoginStepDefinition {

    private Employee employee;
    public LoginPage loginPage;
    TestContextSetup testContextSetup;

    public LoginStepDefinition(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup = testContextSetup;
        this.loginPage = new LoginPage(this.testContextSetup.driver);
    }

    @Given("User is on OrangeHRM login page")
    public void user_is_on_orange_hrm_login_page() {
        Assert.assertTrue(loginPage.getTitle().contains("OrangeHRM"));
    }

    @When("User login into application with user: {string} and password: {string}")
    public void user_login_into_application_with_and_password(String user, String pass) {
        loginPage.loginWithCredentials(user,pass);

    }

    @Then("Home page is displayed")
    public void home_page_is_displayed() {
        loginPage.checkHomePageIsDisplayed();
    }

    @Then("invalid credentials message is show")
    public void invalid_credentials_message_is_show() {
        loginPage.validateInvalidCredentialMessage();
    }

    @Then("not credentials message is show")
    public void not_credentials_message_is_show() {
        loginPage.validateNotEmptyMessage();
    }


}
