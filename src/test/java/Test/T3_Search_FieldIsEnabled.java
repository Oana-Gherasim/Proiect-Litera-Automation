package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_Search_FieldIsEnabled extends BaseTest {
    public HelpMethods helpMethods;
    @Test
    public void buttonIsClickable(){
        helpMethods = new HelpMethods(driver);

        String expectedResult = "Editura Litera. Librarie Online. Cele mai bune titluri de carte";
        helpMethods.pageValidation(expectedResult);

        WebElement searchField = driver.findElement(By.id("search"));
        Assert.assertTrue(searchField.isEnabled(),"Search bar is not enabled");

    }
}
