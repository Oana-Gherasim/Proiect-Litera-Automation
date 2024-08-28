package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class T21_EndToEndTest extends BaseTest {
    public HelpMethods helpMethods;
    @Test
    public void endToEnd() {
        helpMethods = new HelpMethods(driver);
        String expectedResult = "Editura Litera. Librarie Online. Cele mai bune titluri de carte";
        helpMethods.pageValidation(expectedResult);

        WebElement logInIcon = driver.findElement(By.xpath("//div[@class='actions dropdown options switcher-options no-chevron account-dropdown']"));
        logInIcon.click();

        WebElement contulMeu = driver.findElement(By.xpath("//ul[@class='header links']/li[1]"));
        contulMeu.click();


        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("oanatestmail0@gmail.com");

        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("Parola_litera123");

        WebElement submitButton = driver.findElement(By.id("send2"));
        submitButton.click();

        WebElement searchField = driver.findElement(By.id("search"));
        searchField.sendKeys("Alfie");

        WebElement searcBtn = driver.findElement(By.xpath("//button[@class='action search']"));
        searcBtn.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> sortByOptionList = driver.findElements(By.xpath("//select[@id='sorter']/option"));
        sortByOptionList.get(1).click();

        WebElement inStockOptions = driver.findElement(By.xpath("//ol[@class='items am-filter-items-stock                -am-singleselect']/li[1]"));
        inStockOptions.click();

        WebElement addToCartFirstItem = driver.findElement(By.xpath("//div[@class='actions-primary']/form[@data-product-sku='CPB494']/button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addToCartFirstItem);

        WebElement clickMergiLaCosBtn = driver.findElement(By.xpath("//div[@class='modal-inner-wrap']/footer/button[1]"));
        clickMergiLaCosBtn.click();

        //Assert page is correct
        String expectedPageShoppingCart = "Coșul tău";
        String actualPage = driver.getTitle();
        System.out.println(actualPage);
        helpMethods.pageValidation(expectedPageShoppingCart);


    }
}