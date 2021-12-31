package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserManager extends BasePage {
    public static final String AUTOMATE_USERNAME = "shitalmehta_crwBkR";
    public static final String AUTOMATE_ACCESS_KEY = "SK1CquRVqa4xfbum1KbA";
    public static final String browserStackURL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
   String browserName = "Chrome";
   // String browserName = System.getProperty("browser");
    LoadProp loadProp = new LoadProp();
    DesiredCapabilities caps = new DesiredCapabilities();
    boolean cloud = false;
   // boolean cloud = Boolean.parseBoolean(System.getProperty("cloud"));
    public void openBrowser(){
        //making decision cloud true or false
        if(cloud)
        {
            //this will run if cloud true (in cloud)
            if(browserName.equalsIgnoreCase("Chrome")) {

                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "latest-beta");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.14.0");
            }
            else if (browserName.equalsIgnoreCase("edge"))
            {
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Edge");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.5.2");

            }
            else if (browserName.equalsIgnoreCase("firefox"))
            {
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Firefox");
                caps.setCapability("browser_version", "latest-beta");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.5.2");
            }
            else
            {
                System.out.println("Your Browser name is Wrong");
            }

            try{
                driver = new RemoteWebDriver(new URL(browserStackURL), caps);
            }catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }


        else //this will run if it is false
        {
            if (browserName.equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("edge"))
        {
            System.setProperty("webdriver.edge.driver" , "src/test/java/Drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver" , "src/test/java/Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else
        {
            System.out.println("Your Browser name is Wrong");
       }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get (loadProp.getProperty("url"));
    }

    public void closeBrowser()

    {
        driver.close();
    }
}
