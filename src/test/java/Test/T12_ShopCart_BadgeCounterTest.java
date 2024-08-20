package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class T12_ShopCart_BadgeCounterTest extends BaseTest {
    public HelpMethods helpMethods;

    @Test
    public void shoppingCart() {
        helpMethods = new HelpMethods(driver);

        String expectedResult = "Editura Litera. Librarie Online. Cele mai bune titluri de carte";
        helpMethods.pageValidation(expectedResult);

        WebElement searchField = driver.findElement(By.id("search"));
        searchField.sendKeys("Alfie");

        WebElement clickSearchButton = driver.findElement(By.xpath("//button[@class='action search']"));
        clickSearchButton.click();

        String expectedPageResult = "Căutați rezultate pentru: 'Alfie'";
        helpMethods.pageValidation(expectedPageResult);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement sortByDropDownArrow = driver.findElement(By.id("sorter"));
        Select select = new Select(sortByDropDownArrow);
        select.selectByValue("price_asc");

//        List<WebElement> sortByOptionList = driver.findElements(By.xpath("//select[@id='sorter']/option"));
//        sortByOptionList.get(1).click();

        WebElement inStockOptions = driver.findElement(By.xpath("//ol[@class='items am-filter-items-stock                -am-singleselect']/li[1]"));
        inStockOptions.click();

        WebElement addToCartFirstItem = driver.findElement(By.xpath("//div[@class='actions-primary']/form[@data-product-sku='CPB494']/button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addToCartFirstItem);

        WebElement closePopUpWithContinueButton = driver.findElement(By.xpath("//aside[@class='modal-popup add-to-cart-popup _show']//div[@class='modal-inner-wrap']/footer/button[2]"));
        closePopUpWithContinueButton.click();

        WebElement addToCartSecondItem = driver.findElement(By.xpath("//div[@class='actions-primary']/form[@data-product-sku='CPB498']/button"));
        js.executeScript("arguments[0].click();", addToCartSecondItem);

        WebElement closePopUpWithContinueBtn2 = driver.findElement(By.xpath("//aside[@class='modal-popup add-to-cart-popup _show']//div[@class='modal-inner-wrap']/footer/button[2]"));
        closePopUpWithContinueBtn2.click();

        //Assert shopping cart badge counter
        WebElement counterBadge = driver.findElement(By.xpath("//div[@class='minicart-wrapper']/a/span[2]/span[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(counterBadge,"2"));

        helpMethods.assertCounter(2, counterBadge);



    }
}
