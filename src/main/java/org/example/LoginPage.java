package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends Utils {
    LoadProp loadProp = new LoadProp();
    By _userName = By.cssSelector("input#txtUsername");
    By _password = By.cssSelector("input#txtPassword");
    By _loginButton = By.cssSelector("input#btnLogin");
    public void verifyUserIsOnLoginPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains(loadProp.getProperty("url")));//verifying the website is opening.
    }
    public void userEnterTheAdminDetails(){
        typeText(_userName,loadProp.getProperty("Username"));//enter the username
        typeText(_password, loadProp.getProperty("Password"));//enter the password
    }
    public void clickOnLoginButton(){
        clickOnElement(_loginButton);
    }
    public void userEntersRegisteredUserDetails(){
        typeText(_userName,loadProp.getProperty("employeeUserName"));//enters the username
        typeText(_password,loadProp.getProperty("employeePassword"));//enters the password

    }
}
