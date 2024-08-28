package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T9_ShopCart_AnuntaBtn extends BaseTest {
    public HelpMethods helpMethods;
    @Test
    public void assertAnuntaButton(){
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

        //Click out of stock product
        WebElement outOfStockProduct = driver.findElement(By.xpath("//div[@class='product details product-item-details']/strong/a[@title='Pachet 8 carti despre Alfie']"));
        outOfStockProduct.click();

        String expectedProductPageName = "Pachet 8 carti despre Alfie";
        helpMethods.pageValidation(expectedProductPageName);

        //Assert product is out of stock because there is a "Anunta-ma" button and not a "Add to cart button"
        WebElement anuntaMaButton = driver.findElement(By.xpath("//div[@class='actions-toolbar padding']/div/button/span"));
        String expectedText= "ANUNȚĂ-MĂ";
        helpMethods.checkMessage(anuntaMaButton, expectedText);



    }
}
