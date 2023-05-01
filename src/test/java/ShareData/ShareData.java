package ShareData;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class ShareData {

        private WebDriver driver;

        public WebDriver getDriver() {
            return driver;
        }
        @BeforeMethod
        public void setupChrome(){

            String cicd = System.getProperty("ci_cd");
            ChromeOptions chromeOptions = new ChromeOptions();

            if(Boolean.parseBoolean(cicd)){
                chromeOptions.addArguments("--headless");
            }else{
                System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
            }
            chromeOptions.addArguments("--window-size=1920,1080");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

            driver = new ChromeDriver(chromeOptions);

            driver.get("https://demo.nopcommerce.com/");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        }
        @AfterMethod
        public void clearBrowser(){

            driver.quit();

        }
    }

