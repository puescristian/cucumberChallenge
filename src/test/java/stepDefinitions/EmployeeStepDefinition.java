package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pageObjects.LoginPage;
import pageObjects.PimPage;
import utils.Employee;
import utils.TestContextSetup;

import java.io.IOException;

import static utils.Messages.NO_RECORDS_FOUND;

public class EmployeeStepDefinition {

    private Employee employee;
    PimPage pimPage;
    LoginPage loginPage;

    TestContextSetup testContextSetup;

    public EmployeeStepDefinition(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup = testContextSetup;
        this.pimPage = new PimPage(this.testContextSetup.driver);
        this.loginPage = new LoginPage(this.testContextSetup.driver);
    }

    @And("User go to PIM tab")
    public void user_go_to_pim_tab() {
        pimPage.goToPim();

    }

    @Given("User is on PIM tab")
    public void user_is_on_pim_tab() {
        loginPage.loginWithCredentials("Admin", "admin123");
        pimPage.goToPim();

    }

    @When("User add a new employee")
    public void user_add_a_new_employee() {
        employee = new Employee();
        pimPage.checkPimPageIsDisplayed();
        pimPage.clickOnTabAddEmployee();
        pimPage.enterBasicData(employee);
        pimPage.enterLoginDetailsData(employee);
        pimPage.clickSave();
    }

    @When("User add a new employee without data")
    public void user_add_a_new_employee_without_data() {
        employee = new Employee("","","");
        pimPage.checkPimPageIsDisplayed();
        pimPage.clickOnTabAddEmployee();
        pimPage.enterBasicData(employee);
        pimPage.enterLoginDetailsData(employee);
        pimPage.clickSave();
    }

    @When("User edit a employee with name: {string}, middleName: {string} and lastName: {string}")
    public void user_edit_a_employee_with_name_middleName_and_lastName(String name, String middleName, String lastName) throws InterruptedException {
        user_add_a_new_employee();
        employee_data_is_displayed();
        employee.setName(name);
        employee.setMiddleName(middleName);
        employee.setLastName(lastName);
        Thread.sleep(2000);
        pimPage.clickSave();
        pimPage.editBasicData(employee);
        pimPage.clickSave();
        employee_data_is_displayed();
    }

    @Then("employee data is displayed")
    public void employee_data_is_displayed() {
        pimPage.checkEmployeeDataIsDisplayed(employee);
    }

    @Given("a employee created")
    public void a_employee_created() {
        user_is_on_pim_tab();
        user_add_a_new_employee();
        employee_data_is_displayed();
    }

    @When("User delete a employee")
    public void user_delete_a_employee() throws InterruptedException {
        user_go_to_pim_tab();
        pimPage.clickOnTabListEmployee();
        pimPage.searchEmployee(employee);
        pimPage.deleteEmployee(employee);
    }

    @Then("the employee data is not show")
    public void the_employee_data_is_not_show() throws InterruptedException {
        pimPage.searchEmployee(employee);
        pimPage.validateNotFoundEmployee();
    }

    @Then("empty field validation is show")
    public void empty_field_validation_is_show() {
        pimPage.validateEmptyFields();
    }
}
