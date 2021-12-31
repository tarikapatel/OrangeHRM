package org.example;
import org.openqa.selenium.By;
import org.testng.Assert;

public class EmployeeList extends Utils {
    By _enterEmployeeName = By.cssSelector("input#empsearch_employee_name_empName");
    By _clickOnSearchButton = By.cssSelector("input#searchBtn");
    By _clickOnCheckBox = By.cssSelector("input#ohrmList_chkSelectAll");
    By _clickOnDeleteButton = By.cssSelector("input#btnDelete");
    By _alertBoxAppear = By.cssSelector("div#deleteConfModal");
    By _clickOnOkButtonAlertBox = By.cssSelector("input#dialogDeleteBtn");
    By _deletionText = By.xpath("//table[@id='resultTable']/tbody/tr/td");
        public void userEntersTheEmployeeName() {
            typeText(_enterEmployeeName, loadProp.getProperty("employeeName"));//enters the employee name
        }
        public void userClickOnSearchButton() {
            clickOnElement(_clickOnSearchButton);//click on the search button to search the employee
        }
        public void userClickOnCheckBox(){
            driver.findElement(_clickOnCheckBox).click();//click on the checkbox
        }
        public void userClickOnDeleteButton(){
            clickOnElement(_clickOnDeleteButton);//click on the delete button
        }
        public void alertBox(){
            driver.findElement(_alertBoxAppear);
            waitForVisible(_alertBoxAppear,20);
        }
        public void clickOnOkButton(){
            driver.findElement(_clickOnOkButtonAlertBox).click();
        }
        public void verifyEmployeeRecordsDeletedSuccessfully(){
            //verifying that the employee records is deleted successfully.
            String actualDeleteSuccessMessage = getTextFromElement(_deletionText);
            String expectedDeleteSuccessMessage = loadProp.getProperty("deleteSuccessMessage");
            Assert.assertEquals(actualDeleteSuccessMessage,expectedDeleteSuccessMessage);
        }
}