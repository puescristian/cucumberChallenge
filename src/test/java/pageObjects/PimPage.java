package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Employee;

import java.time.Duration;

import static utils.Messages.NO_RECORDS_FOUND;

public class PimPage {
    public WebDriver driver;

    public PimPage(WebDriver driver) {
        this.driver = driver;
    }

    private By tabPim = By.cssSelector("#menu_pim_viewPimModule > b");
    private By tabAddEmployee = By.id("menu_pim_addEmployee");
    private By tabListEmployee = By.id("menu_pim_viewEmployeeList");
    private By first_name = By.id("firstName");
    private By middle_name = By.id("middleName");
    private By last_name = By.id("lastName");
    private By first_name_edit = By.id("personal_txtEmpFirstName");
    private By middle_name_edit = By.id("personal_txtEmpMiddleName");
    private By last_name_edit = By.id("personal_txtEmpLastName");
    private By chek_login_details = By.id("chkLogin");
    private By user_name = By.id("user_name");
    private By user_password = By.id("user_password");
    private By re_password = By.id("re_password");
    private By btnSave = By.id("btnSave");
    private By btnSearch = By.id("searchBtn");
    private By searchInputName = By.xpath("//input[@id='empsearch_employee_name_empName']");
    private By btnDelete = By.id("btnDelete");
    private By dialogDeleteBtn = By.id("dialogDeleteBtn");
    private By validationField = By.xpath("//span[@class='validation-error'][not(@style='display: none;')]");
    private By resultTable = By.xpath("//table[@id='resultTable']//td");
    private String checkboxName = "//a[text()='%s %s']/../..//input[@type='checkbox']";



    public void goToPim() {
        driver.findElement(tabPim).click();
    }

    public void checkPimPageIsDisplayed() {
        assert (driver.findElement(By.id("menu_pim_addEmployee")).isDisplayed());
    }

    public void checkEmployeeDataIsDisplayed(Employee employee) {
        assert (driver.findElement(first_name_edit).getAttribute("value").equals(employee.getName()));
        assert (driver.findElement(middle_name_edit).getAttribute("value").equals(employee.getMiddleName()));
        assert (driver.findElement(last_name_edit).getAttribute("value").equals(employee.getLastName()));
    }

    public void enterFirstName(String name) {
        driver.findElement(first_name).sendKeys(name);
    }

    public void enterMiddleName(String middleName) {
        driver.findElement(middle_name).sendKeys(middleName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(last_name).sendKeys(lastName);
    }

    public void editFirstName(String name) {
        driver.findElement(first_name_edit).clear();
        driver.findElement(first_name_edit).sendKeys(name);
    }

    public void editMiddleName(String middleName) {
        driver.findElement(middle_name_edit).clear();
        driver.findElement(middle_name_edit).sendKeys(middleName);
    }


    public void editLastName(String lastName) {
        driver.findElement(last_name_edit).clear();
        driver.findElement(last_name_edit).sendKeys(lastName);
    }

    public void enterBasicData(Employee employee) {
        enterFirstName(employee.getName());
        enterMiddleName(employee.getMiddleName());
        enterLastName(employee.getLastName());
    }

    public void editBasicData(Employee employee) {
        editFirstName(employee.getName());
        editMiddleName(employee.getMiddleName());
        editLastName(employee.getLastName());
    }

    public void enterLoginDetailsData(Employee employee) {
        driver.findElement(chek_login_details).click();
        driver.findElement(user_name).sendKeys(employee.getUser());
        driver.findElement(user_password).sendKeys(employee.getPass());
        driver.findElement(re_password).sendKeys(employee.getPass());
    }

    public void clickOnTabAddEmployee() {
        driver.findElement(tabAddEmployee).click();
    }

    public void clickOnTabListEmployee() {
        driver.findElement(tabListEmployee).click();
    }

    public void clickSave() {
        driver.findElement(btnSave).click();
    }

    public void clickSearch() {
        driver.findElement(btnSearch).click();

    }

    public void searchEmployee(Employee employee) throws InterruptedException {
        Thread.sleep(1000);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.attributeContains(searchInputName, "class", "ac_input"));
        driver.findElement(searchInputName).click();
        driver.findElement(searchInputName).sendKeys(String.format("%s %s", employee.getName(), employee.getMiddleName()));
        clickSearch();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.attributeContains(searchInputName, "class", "ac_input"));
    }

    public void deleteEmployee(Employee employee) {
        driver.findElement(By.xpath(String.format(checkboxName, employee.getName(), employee.getMiddleName()))).click();
        driver.findElement(btnDelete).click();
        driver.findElement(dialogDeleteBtn).click();
    }

    public void validateNotFoundEmployee() {
        assert (driver.findElement(resultTable).getText().equals(NO_RECORDS_FOUND.getText()));

    }

    public void validateEmptyFields() {
        assert (driver.findElements(validationField).size() > 0);
    }
}
