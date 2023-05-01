package Tests;

import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class RegisterTest extends ShareData {

    public WebDriver driver;

    @Test
    public void MetodaTest() {

        driver = null;

        WebElement RegisterPage = getDriver().findElement(By.xpath("//a[@class='ico-register']"));
        RegisterPage.click();

        WebElement Gender = getDriver().findElement(By.xpath("//input[@value='M']"));
        Gender.click();

        WebElement FirstName = getDriver().findElement(By.xpath("//input[@data-val-required='First name is required.']"));
        String FirstNameValue ="Raul";
        FirstName.sendKeys(FirstNameValue);

        WebElement LastName = getDriver().findElement(By.xpath("//input[@data-val-required='Last name is required.']"));
        String LastNameValue ="Grigore";
        LastName.sendKeys(LastNameValue);

        List<WebElement> SelectDayInput = getDriver().findElements(By.xpath("//select[@name='DateOfBirthDay']"));
        Integer ExpectDay = 18;
        for (int index = 0; index < SelectDayInput.size(); index++){
            if (SelectDayInput.get(index).getText().equals(ExpectDay)){
                SelectDayInput.get(index).click();
            }
        }

        List<WebElement> SelectMonthInput = getDriver().findElements(By.xpath("//select[@name='DateOfBirthMonth']"));
        String ExpectMonth = "August";
        for (int index = 0; index < SelectMonthInput.size(); index++){
            if (SelectMonthInput.get(index).getText().equals(ExpectMonth)){
                SelectMonthInput.get(index).click();
            }
        }

        List<WebElement> SelectYearInput = getDriver().findElements(By.xpath("//select[@name='DateOfBirthYear']"));
        Integer ExpectYear = 1996;
        for (int index = 0; index < SelectYearInput.size(); index++){
            if (SelectYearInput.get(index).getText().equals(ExpectYear)){
                SelectYearInput.get(index).click();
            }
        }

        WebElement EmailAddress = getDriver().findElement(By.xpath("//input[@data-val-required='Email is required.']"));
        String EmailAddressValue = "oproiu_raul@yahoo.com";
        EmailAddress.sendKeys(EmailAddressValue);

        WebElement CompanyName = getDriver().findElement(By.xpath("//input[@name='Company']"));
        String CompanyNameValue = "Rokinon";
        CompanyName.sendKeys(CompanyNameValue);

        WebElement Password = getDriver().findElement(By.xpath("//input[@data-val-regex-pattern='^.{6,}$']"));
        String PassowordValue = "Test123";
        Password.sendKeys(PassowordValue);

        WebElement PasswordConfirm = getDriver().findElement(By.xpath("//input[@data-val-equalto='The password and confirmation password do not match.']"));
        String PassowordConfirmValue = "Test123";
        PasswordConfirm.sendKeys(PassowordConfirmValue);

        WebElement RegisterConfirm = getDriver().findElement(By.xpath("//button[@name='register-button']"));
        RegisterConfirm.click();

    }
}
