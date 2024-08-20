package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class T8_ShopCart_LipsaStoc extends BaseTest {
    public HelpMethods helpMethods;
    @Test
    public void assertLipsaStoc(){
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

        helpMethods.closeCookies();

        //Validate product page
        String expectedPageResult = "Căutați rezultate pentru: 'Alfie'";
        helpMethods.pageValidation(expectedPageResult);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Assert product is out of stock
        WebElement labelStocEpuizat = driver.findElement(By.xpath("//div[@id='product-item-info_38119']/a//span/div/picture[@class='mfwebp']/img[@title='lipsă stoc']"));
        Assert.assertTrue(labelStocEpuizat.isDisplayed());





    }

}
