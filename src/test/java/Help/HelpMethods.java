package Help;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HelpMethods {

    private WebDriver driver;

    public HelpMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void pageValidation(String expectedTitle) {
        String actualResult = driver.getTitle();
        Assert.assertTrue(actualResult.equals(expectedTitle), "The page is not correct");
    }

    public void assertContactInfo(WebElement element, String nume) {
        Assert.assertTrue(element.getText().contains(nume), "There is no element found");
    }

    public void scrollIntoViewGeneral(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void checkMessage(WebElement element, String message) {
        Assert.assertTrue(element.getText().equals(message), "Mesajul nu este afisat corect");
    }


    public void assertCounter(int expectedItemCount, WebElement element) {
        String counterText = element.getText();
        int actualItemCount = Integer.parseInt(counterText);
        Assert.assertEquals(actualItemCount, expectedItemCount, "Shopping cart counter mismatch");
    }

    public List<WebElement> getProductElements() {
        return driver.findElements(By.xpath("//tr[@class='item-info']/td/a"));
    }

    public void closeCookies() {
        WebElement cookies = driver.findElement(By.id("ez-cookie-notification__accept"));
        if (cookies.isDisplayed()) {
            cookies.click();
        }
        else {
        }

    }

}
