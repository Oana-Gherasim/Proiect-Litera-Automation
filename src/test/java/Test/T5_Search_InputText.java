package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T5_Search_InputText extends BaseTest {
    public HelpMethods helpMethods;
    @Test
    public void inputText (){
        helpMethods = new HelpMethods(driver);

        String expectedResult = "Editura Litera. Librarie Online. Cele mai bune titluri de carte";
        helpMethods.pageValidation(expectedResult);


        WebElement searchField = driver.findElement(By.id("search"));

        searchField.click();
        searchField.clear();


        String textToEnter = "Alfie";
        searchField.sendKeys(textToEnter);
        String value = searchField.getAttribute("value");
        Assert.assertEquals(textToEnter, value);
    }
}
