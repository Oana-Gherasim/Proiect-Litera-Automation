package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class T6_Search_Suggestions extends BaseTest {
    public HelpMethods helpMethods;

    @Test
    public void searchBar() {
        helpMethods = new HelpMethods(driver);

        String expectedResult = "Editura Litera. Librarie Online. Cele mai bune titluri de carte";
        helpMethods.pageValidation(expectedResult);


        WebElement searchField = driver.findElement(By.id("search"));

        searchField.click();
        searchField.clear();
        searchField.sendKeys("Alfie");
        WebElement searchSuggestions = driver.findElement(By.id("searchsuite-autocomplete"));
        Assert.assertTrue(searchSuggestions.isEnabled(),"There are no search suggestions");




    }
}
