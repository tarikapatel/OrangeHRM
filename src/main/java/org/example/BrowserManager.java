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

    public static final String AUTOMATE_USERNAME = "tarikapatel_ln1hQ8";
    public static final String AUTOMATE_ACCESS_KEY = "pCszBqJNz1SepLKihJBH";
    public static final String BrowserStackURL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    LoadProp loadProp = new LoadProp();
    DesiredCapabilities caps = new DesiredCapabilities();

    String browserName = "Chrome";
    boolean cloud = false;
    // String browserName = System.getProperty("browser");
    // boolean cloud = Boolean.parseBoolean(System.getProperty("cloud"));

    public void openBrowser() {
        //making decision cloud true or false
        //this will be run if cloud true (In cloud)
        if (cloud) {
            //applying conditional loop for different browser options
            if (browserName.equalsIgnoreCase("Chrome")) {

                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "7");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.14.0");
            } else if (browserName.equalsIgnoreCase("edge")) {
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "11");
                caps.setCapability("browser", "Edge");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.5.2");
            } else if (browserName.equalsIgnoreCase("firefox")) {
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Firefox");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.10.0");
            } else {
                System.out.println("Your browser name is wrong.");
            }

            try {
                driver = new RemoteWebDriver(new URL(BrowserStackURL), caps);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


        } else {
            //this will be run if cloud false(locally)

            if (browserName.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", "src/test/java/Drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/test/java/Drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            } else {
                System.out.println("Your browser name is wrong.");
            }

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get(loadProp.getProperty("url"));
    }
    public void closeBrowser()
    {
        driver.close();
    }
}
