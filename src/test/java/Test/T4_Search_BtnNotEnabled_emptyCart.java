package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_Search_BtnNotEnabled_emptyCart extends BaseTest {
    public HelpMethods helpMethods;
    @Test
    public void buttonNotEnabled(){
        helpMethods = new HelpMethods(driver);

        String expectedResult = "Editura Litera. Librarie Online. Cele mai bune titluri de carte";
        helpMethods.pageValidation(expectedResult);


        WebElement searchField = driver.findElement(By.id("search"));

        searchField.click();
        searchField.clear();

        //Assert that the magnifying glass button is disabled when search field is empty
        WebElement clickSearchButton = driver.findElement(By.xpath("//button[@class='action search']"));
        Assert.assertFalse(clickSearchButton.isEnabled(),"Button is not disabled");

    }
}
