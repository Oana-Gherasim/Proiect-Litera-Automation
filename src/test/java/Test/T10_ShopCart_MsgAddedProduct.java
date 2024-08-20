package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class T10_ShopCart_MsgAddedProduct extends BaseTest {
    public HelpMethods helpMethods;
    @Test
    public void assertAddedProductMsg() {
        helpMethods = new HelpMethods(driver);

        String expectedResult = "Editura Litera. Librarie Online. Cele mai bune titluri de carte";
        helpMethods.pageValidation(expectedResult);

        WebElement searchField = driver.findElement(By.id("search"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys("Alfie");

        WebElement clickSearchButton = driver.findElement(By.xpath("//button[@class='action search']"));
        clickSearchButton.click();

        String expectedPageResult = "Căutați rezultate pentru: 'Alfie'";
        helpMethods.pageValidation(expectedPageResult);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Sort items by price ascending
        WebElement sortByDropDownArrow = driver.findElement(By.id("sorter"));
        sortByDropDownArrow.click();

        List<WebElement> sortByOptionList = driver.findElements(By.xpath("//select[@id='sorter']/option"));
        sortByOptionList.get(1).click();

        //Choose option: in stock
        WebElement inStockOptions = driver.findElement(By.xpath("//ol[@class='items am-filter-items-stock                -am-singleselect']/li[1]"));
        inStockOptions.click();

        //Add first item to cart
        WebElement addToCartFirstItem = driver.findElement(By.xpath("//div[@class='actions-primary']/form[@data-product-sku='CPB494']/button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addToCartFirstItem);

        //Assert pop-up window with validation message for the added product
        WebElement validationMessage = driver.findElement(By.xpath("//header[@class='modal-header']/h1"));
        String expectedResultMessage =  "Produsul a fost adăugat în coș cu succes";
        helpMethods.checkMessage(validationMessage, expectedResultMessage);













    }
}
