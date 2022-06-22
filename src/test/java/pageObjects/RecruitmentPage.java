package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Employee;

import static utils.Messages.NO_RECORDS_FOUND;

public class RecruitmentPage {
    public WebDriver driver;

    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
    }

    private By tabRecruitment = By.cssSelector("#menu_recruitment_viewRecruitmentModule > b");
    private By tabAddRecruitmentCandidates = By.id("menu_recruitment_viewCandidates");
    private By addButton = By.id("btnAdd");
    private By first_name = By.id("addCandidate_firstName");
    private By middle_name = By.id("addCandidate_middleName");
    private By last_name = By.id("addCandidate_lastName");
    private By email = By.id("addCandidate_email");
    private By contactNumber = By.id("addCandidate_contactNo");
    private By jobVacancy = By.id("addCandidate_vacancy");
    private By jobTitle = By.id("addJobVacancy_jobTitle");
    private By vacancyName = By.id("addJobVacancy_name");
    private By hiringManager = By.id("addJobVacancy_hiringManager");
    private By numberOfPositions = By.id("addJobVacancy_noOfPositions");
    private By description = By.id("addJobVacancy_description");
    private By btnSave = By.id("btnSave");

    private By first_name_edit = By.id("personal_txtEmpFirstName");
    private By middle_name_edit = By.id("personal_txtEmpMiddleName");
    private By last_name_edit = By.id("personal_txtEmpLastName");
    private By chek_login_details = By.id("chkLogin");
    private By user_name = By.id("user_name");
    private By user_password = By.id("user_password");
    private By re_password = By.id("re_password");

    private By btnSearch = By.id("searchBtn");
    private By searchInputName = By.xpath("//input[@id='empsearch_employee_name_empName']");
    private By btnDelete = By.id("btnDelete");
    private By dialogDeleteBtn = By.id("dialogDeleteBtn");
    private By validationField = By.xpath("//span[@class='validation-error'][not(@style='display: none;')]");
    private By resultTable = By.xpath("//table[@id='resultTable']//td");
    private String checkboxName = "//a[text()='%s %s']/../..//input[@type='checkbox']";


    public void goToRecruitment() {
        driver.findElement(tabRecruitment).click();
    }

    public void checkRecruitmentPageIsDisplayed() {
        assert (driver.findElement(tabAddRecruitmentCandidates).isDisplayed());
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

}
