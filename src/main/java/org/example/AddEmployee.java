package org.example;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
public class AddEmployee extends Utils{
    By _firstName = By.cssSelector("input#firstName");
    By _lastName = By.cssSelector("input#lastName");
    By _checkBox = By.cssSelector("input#chkLogin");
    By _userName = By.cssSelector("input#user_name");
    By _password = By.cssSelector("input#user_password");
    By _confirmPassword = By.cssSelector("input#re_password");
    By _clickSaveButton = By.cssSelector("input#btnSave");
    By _welcomeButton= By.xpath("//*[@id='welcome']");
    By _logout=By.xpath("//*[@id='welcome-menu']/ul/li[3]/a");

    public void userEntersEmployeeDetails(){
        typeText(_firstName,currentTimeStamp()+loadProp.getProperty("FirstName"));// enter the first name
        typeText(_lastName,currentTimeStamp()+ loadProp.getProperty("LastName"));//enter last name
        clickOnElement(_checkBox); //click on checkbox
        typeText(_userName,loadProp.getProperty("employeeUserName"));//enters the username
        typeText(_password,loadProp.getProperty("employeePassword"));//enters the password
        typeText(_confirmPassword,loadProp.getProperty("employeeConfirmPassword"));//confirms the password
    }
    public void clickOnSaveButton(){
        clickOnElement(_clickSaveButton);//click on save button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
    public void userLogout() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement( _welcomeButton);//click on the dropdown
        Thread.sleep(1000);
        clickOnElement(_logout);//click on logout
    }
}