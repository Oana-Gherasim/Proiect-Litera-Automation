package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T1_LogInTest extends BaseTest {
    public HelpMethods helpMethods;

    @Test
    public void logIn() {
        helpMethods = new HelpMethods(driver);

        String expectedResult = "Editura Litera. Librarie Online. Cele mai bune titluri de carte";
        helpMethods.pageValidation(expectedResult);

        WebElement logInIcon = driver.findElement(By.xpath("//div[@class='actions dropdown options switcher-options no-chevron account-dropdown']"));
        logInIcon.click();

        WebElement contulMeu = driver.findElement(By.xpath("//ul[@class='header links']/li[1]"));
        contulMeu.click();

        String expectedName = "Contul meu";
        helpMethods.pageValidation(expectedName);

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("oanatestmail0@gmail.com");

        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("Parola_litera123");

        WebElement submitButton = driver.findElement(By.id("send2"));
        submitButton.click();

        String expectedPageName = "Contul meu";
        helpMethods.pageValidation(expectedPageName);

        WebElement messageArea = driver.findElement(By.xpath("//div[@class='box box-information']/div[1]/p"));
        String expectedResultName = "Oana Gherasim";
        String expectedResultEmail = "oanatestmail0@gmail.com";
        helpMethods.assertContactInfo(messageArea, expectedResultName);
        helpMethods.assertContactInfo(messageArea, expectedResultEmail);


    }


}
