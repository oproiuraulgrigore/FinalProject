package Tests;

import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class AddAProductToBasketTest extends ShareData {

    public WebDriver driver;

    @Test
    public void MetodaTest() {

        driver = null;

        WebElement ProductPage = getDriver().findElement(By.xpath("//a[@title='Show details for Build your own computer']"));
        ProductPage.click();

        List<WebElement> SelectRam = getDriver().findElements(By.xpath("//select[@name='product_attribute_2']"));
        String ExpectRam = "2 GB";
        for (int index = 0; index < SelectRam.size(); index++){
            if (SelectRam.get(index).getText().equals(ExpectRam)){
                SelectRam.get(index).click();
            }
        }

        WebElement HDD = getDriver().findElement(By.xpath("//label[@for='product_attribute_3_6']"));
        HDD.click();

        WebElement AddToCart = getDriver().findElement(By.xpath("//button[@class='button-1 add-to-cart-button']"));
        AddToCart.click();

        WebElement CloseAdd = getDriver().findElement(By.xpath("//span[@class='close']"));
        CloseAdd.click();

    }
}
