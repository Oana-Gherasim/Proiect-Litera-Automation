package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void openSite() {
        driver = new ChromeDriver();
        driver.get("https://www.litera.ro/?p=1");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement cookies = driver.findElement(By.id("ez-cookie-notification__accept"));
        cookies.click();
    }

    @AfterMethod
    public void closeSite() {
        driver.quit();
    }
}
