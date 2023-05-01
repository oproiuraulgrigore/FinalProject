package ShareData;

import ExtentUtility.ExtentReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Log;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShareData {

        private WebDriver driver;

        public WebDriver getDriver() {
            return driver;
        }

        public HashMap<String, String> TestData;
        private String TestName;

        public static ExtentReport ExtentReportUtility = new ExtentReport();
        public static List<Log> LogContext = new ArrayList<>();
        public ExtentReport TestReport;


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

            TestName = this.getClass().getSimpleName();
            TestReport = new ExtentReport(TestName);


        }
        @AfterMethod
        public void ClearEnviroment(ITestResult Result){

            if(Result.getStatus()==ITestResult.FAILURE){

            }
            synchronized (ExtentReportUtility){
                ExtentTest CurentTest = ExtentReportUtility.getExtent().createTest(""+TestName+"- report");
                LogContext.addAll(TestReport.getTestReport().getModel().getLogs());
                for(Log log:LogContext){
                    CurentTest.getModel().getLogs().add(log);
                }
                ExtentReportUtility.getExtent().flush();
                LogContext.clear();
            }
            driver.quit();
        }

    }

