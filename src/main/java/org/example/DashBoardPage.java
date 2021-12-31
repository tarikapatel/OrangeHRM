package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class DashBoardPage extends Utils {
    By _viewPimModule = By.id("menu_pim_viewPimModule");
    By _pimAddEmployee = By.id("menu_pim_addEmployee");
    By _clickOnPIMMenu = By.cssSelector("a#menu_pim_viewPimModule");

    public void verifyUserIsOnDashBoardPage() {
        //verifying user is on dashboardpage
        Assert.assertTrue(driver.getCurrentUrl().contains(loadProp.getProperty("DashboardURL")));
    }

    public void userHoverInPIMMenuAndClickAddEmployee() {
        //Go to website and find element
        WebElement pim = driver.findElement(_viewPimModule);
        WebElement addEmployee = driver.findElement(_pimAddEmployee);
        Actions builder = new Actions(driver);
        Action seriesOfActions = builder.moveToElement(pim).moveToElement(addEmployee).click().build();
        seriesOfActions.perform();
    }
    public void verifyUserIsSuccessfullyLoggedIn(String PageURL){
        Assert.assertTrue(driver.getCurrentUrl().equals(PageURL));
    }
    public void userClickOnPIMMenu() {
        clickOnElement(_clickOnPIMMenu);
    }
}