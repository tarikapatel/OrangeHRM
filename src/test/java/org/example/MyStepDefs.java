package org.example;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs {
    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    AddEmployee addEmployee = new AddEmployee();
    EmployeeList employeeList = new EmployeeList();
    LoadProp loadProp = new LoadProp();

    //Scenarion 1
    @Given("User is on login page")
    public void user_is_on_login_page() {
        loginPage.verifyUserIsOnLoginPage();
    }

    @When("User enter the admin details")
    public void user_enter_the_admin_details() {
        loginPage.userEnterTheAdminDetails();
    }

    @When("Click on login button")
    public void click_on_login_button() {
        loginPage.clickOnLoginButton();
    }

    @When("User is on dashboard page")
    public void user_is_on_dashboard_page() {
        dashBoardPage.verifyUserIsOnDashBoardPage();
    }

    @When("User hovers in PIM menu in order to add new employee")
    public void userHoversInPIMMenuInOrderToAddNewEmployee() {
        dashBoardPage.userHoverInPIMMenuAndClickAddEmployee();
    }

    @When("Enters the mandatory details")
    public void enters_the_mandatory_details() {
        addEmployee.userEntersEmployeeDetails();
    }

    @When("Click on Save Button")
    public void click_on_save_button() {
        addEmployee.clickOnSaveButton();
    }

    @When("Click on Logout button")
    public void click_on_logout_button() throws InterruptedException {
        addEmployee.userLogout();
    }

    @When("User enters the new user details on login page")
    public void user_enters_the_new_user_details_on_login_page() {
        loginPage.verifyUserIsOnLoginPage();
        loginPage.userEntersRegisteredUserDetails();
    }

    @When("Click on login")
    public void click_on_login() {
        loginPage.clickOnLoginButton();
    }

    @Then("User should be able to login successfully")
    public void user_should_be_able_to_login_successfully() {
        dashBoardPage.verifyUserIsOnDashBoardPage();
        dashBoardPage.verifyUserIsSuccessfullyLoggedIn(loadProp.getProperty("loginUrl"));
    }



    //Scenario 2
    @When("user click on the PIM menu")
    public void user_click_on_the_pim_menu()
    {
        dashBoardPage.userClickOnPIMMenu();
    }
    @When("enters the employee name")
    public void enters_the_employee_name() {
        employeeList.userEntersTheEmployeeName();
    }
    @When("click on search button")
    public void click_on_search_button() {
        employeeList.userClickOnSearchButton();
    }
    @When("click on checkbox")
    public void click_on_checkbox() {
        employeeList.userClickOnCheckBox();
    }
    @When("click on delete button")
    public void click_on_delete_button() {
        employeeList.userClickOnDeleteButton();
    }
    @Then("the alert box will appear")
    public void the_alert_box_will_appear() {
        employeeList.alertBox();
    }
    @Then("clicks on OK")
    public void clicks_on_ok() {
        employeeList.clickOnOkButton();
    }
    @Then("registered user employee record should be deleted successfully")
    public void registered_user_employee_record_should_be_deleted_successfully() {
        employeeList.verifyEmployeeRecordsDeletedSuccessfully();
    }

}
