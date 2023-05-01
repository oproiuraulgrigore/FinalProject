package Tests;

import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends ShareData {

    public WebDriver driver;

    @Test
    public void MetodaTest() {

        driver = null;

        WebElement LoginPage = getDriver().findElement(By.xpath("//a[@class='ico-login']"));
        LoginPage.click();

        WebElement Email = getDriver().findElement(By.xpath("//input[@data-val-required='Please enter your email']"));
        String EmailValue = "oproiu_raul@yahoo.com";
        Email.sendKeys(EmailValue);

        WebElement Password = getDriver().findElement(By.xpath("//input[@name='Password']"));
        String PasswordValue = "Test123";
        Password.sendKeys(PasswordValue);

        WebElement RememberPassword = getDriver().findElement(By.xpath("//label[@for='RememberMe']"));
        RememberPassword.click();

        WebElement LoginButton = getDriver().findElement(By.xpath("//button[@class='button-1 login-button']"));
        LoginButton.click();

    }
}
