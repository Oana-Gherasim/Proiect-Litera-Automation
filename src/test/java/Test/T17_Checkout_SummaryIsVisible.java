package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class T17_Checkout_SummaryIsVisible extends BaseTest {
    public HelpMethods helpMethods;
    @Test
    public void assertSummaryIsVisible() {
        helpMethods = new HelpMethods(driver);

        String expectedResult = "Editura Litera. Librarie Online. Cele mai bune titluri de carte";
        helpMethods.pageValidation(expectedResult);

        //Search for products
        WebElement searchField = driver.findElement(By.id("search"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys("Alfie");

        WebElement clickSearchButton = driver.findElement(By.xpath("//button[@class='action search']"));
        clickSearchButton.click();

        //Validate product page
        String expectedPageResult = "Căutați rezultate pentru: 'Alfie'";
        helpMethods.pageValidation(expectedPageResult);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Click in stock button
        WebElement inStockOptions = driver.findElement(By.xpath("//ol[@class='items am-filter-items-stock                -am-singleselect']/li[1]"));
        inStockOptions.click();

        //Add first item
        WebElement addToCartFirstItem = driver.findElement(By.xpath("//div[@class='actions-primary']/form[@data-product-sku='CPB494']/button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addToCartFirstItem);

        WebElement closePopUpWithContinueButton = driver.findElement(By.xpath("//aside[@class='modal-popup add-to-cart-popup _show']//div[@class='modal-inner-wrap']/footer/button[2]"));
        closePopUpWithContinueButton.click();

        //Add second item
        WebElement addToCartSecondItem = driver.findElement(By.xpath("//div[@class='actions-primary']/form[@data-product-sku='CPB498']/button"));
        js.executeScript("arguments[0].click();", addToCartSecondItem);

        WebElement closePopUpWithContinueBtn2 = driver.findElement(By.xpath("//aside[@class='modal-popup add-to-cart-popup _show']//div[@class='modal-inner-wrap']/footer/button[2]"));
        closePopUpWithContinueBtn2.click();

        //View cart summary
        WebElement clickShoppingCartIcon = driver.findElement(By.xpath("//div[@class='minicart-wrapper']/a"));
        clickShoppingCartIcon.click();

        //Navigate to shopping cart page
        WebElement clickVeziCosBtnFromDrop = driver.findElement(By.xpath("//div[@class='actions']/div[@class='secondary']/a"));
        clickVeziCosBtnFromDrop.click();

        String expectedResultCartPage = "Coșul tău";
        helpMethods.pageValidation(expectedResultCartPage);

        //Click "Continua" button
        WebElement continuaButton = driver.findElement(By.xpath("//li[@class='item']/button"));
        continuaButton.click();

        String expectedResultCheckoutPage = "Checkout";
        helpMethods.pageValidation(expectedResultCheckoutPage);

        //Assert summary is visible
        WebElement summary = driver.findElement(By.xpath("//div[@class='content minicart-items']"));
        Assert.assertTrue(summary.isDisplayed(),"Summary is noy visible");

    }
}
