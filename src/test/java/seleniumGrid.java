import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.URL;

public class seleniumGrid {
    WebDriver driver;


    @BeforeMethod
    @Parameters("browser")
    public void setupBrowser(String browser) throws Exception{
        MutableCapabilities options;
        switch(browser.toLowerCase()){
            case "chrome" :
                    options = new ChromeOptions();
                    break;
            case "firefox":
                options = new FirefoxOptions();
                break;
            case "edge":
                options = new EdgeOptions();
                break;
            default:
                options =new ChromeOptions();
        }
         driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
    }
    @Test
    public void runTest() {

        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        System.out.println("Browser: " + ((RemoteWebDriver) driver).getCapabilities().getBrowserName());
        System.out.println("Title" + driver.getTitle());
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
