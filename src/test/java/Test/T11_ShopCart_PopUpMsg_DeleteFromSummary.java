package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class T11_ShopCart_PopUpMsg_DeleteFromSummary extends BaseTest {
    public HelpMethods helpMethods;
    @Test
    public void shoppongCartAssertMessage (){
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

        WebElement closePopUpWithContinueBtn = driver.findElement(By.xpath("//aside[@class='modal-popup add-to-cart-popup _show']/div[@class='modal-inner-wrap']/footer/button[2]"));
        closePopUpWithContinueBtn.click();

        //View cart summary
        WebElement cartSummary = driver.findElement(By.xpath("//div[@class='minicart-wrapper']/a"));
        cartSummary.click();

        //Delete product from summary
        WebElement deleteButton = driver.findElement(By.xpath("//div[@class='product actions']/div/a"));
        helpMethods.scrollIntoViewGeneral(deleteButton);
        deleteButton.click();

        //Assert pop-up message after deleting a product from summary
        WebElement validationMsg = driver.findElement(By.xpath("//aside[@class='modal-popup confirm _show']/div[@class='modal-inner-wrap']/div/div"));
        String expectedMsg = "Ești sigur că vrei să ștergi acest produs din coșul de cumpărături?";
        helpMethods.checkMessage(validationMsg, expectedMsg);

        //Click "Ok" button
        WebElement okButton = driver.findElement(By.xpath("//aside[@class='modal-popup confirm _show']/div[@class='modal-inner-wrap']/footer/button[2]"));
        okButton.click();

        //Assert message that appears when clicking the empty shopping cart
        WebElement emptyCartMsg = driver.findElement(By.xpath("//strong[contains(text(),'Nu ai niciun produs în coșul tău de cumpărături')]"));
        String expectedText = "Nu ai niciun produs în coșul tău de cumpărături";
        helpMethods.checkMessage(emptyCartMsg,expectedText);



    }
}
