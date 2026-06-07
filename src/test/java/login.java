import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class login {
    WebDriver driver;
    @FindBy(id="user-name")
    WebElement user;
    @FindBy (id="password")
    WebElement pwd;
    @FindBy (id="login-button")
    WebElement loginBtn;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

   @Test
    public void userLogin()
    {
        user.sendKeys("standard_user");
        pwd.sendKeys("secret_sauce");
        loginBtn.click();
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
    }

    @AfterMethod
    public void tearDown()
    {   if(driver!=null) {
        driver.quit();
    }
    }

}
