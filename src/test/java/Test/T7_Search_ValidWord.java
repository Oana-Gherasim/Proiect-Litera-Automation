package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class T7_Search_ValidWord extends BaseTest {
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

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement clickSearchButton = driver.findElement(By.xpath("//button[@class='action search']"));
        clickSearchButton.click();

        //Assert that the user is redirected to the correct page after entering a valid word into the search field
        String expectedPageResult = "Căutați rezultate pentru: 'Alfie'";
        helpMethods.pageValidation(expectedPageResult);



    }
}
