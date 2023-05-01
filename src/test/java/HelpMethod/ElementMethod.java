package HelpMethod;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementMethod {

    private static WebDriver driver;

    public ElementMethod(WebDriver driver) {

        this.driver = driver;
    }

    public static void WaitElementVisible(WebElement Element){
        WebDriverWait WaitExplicit = new WebDriverWait(driver, Duration.ofSeconds(3));
        WaitExplicit.until(ExpectedConditions.visibilityOf(Element));

    }


    public void MoveToElement(WebElement Element){
        WaitElementVisible(Element);
        Actions actions = new Actions(driver);
        actions.moveToElement(Element).perform();
    }

}
