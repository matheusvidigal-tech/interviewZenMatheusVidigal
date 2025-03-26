package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.BasePage;
import pages.HomePage;
import pages.SearchResultsPage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Configs {

    private WebDriver driver;
    protected HomePage homePage;
    protected BasePage basePage;
    protected SearchResultsPage searchResultsPage;
    ChromeOptions options = new ChromeOptions();

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        //options.addArguments("--headless");
        options.setBinary("INSIRA_O_CAMINHO_AQUI");
    }

    @BeforeMethod
    public void loadApplication() {
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://blog.agibank.com.br");
        homePage = new HomePage();
        basePage = new BasePage();
        searchResultsPage = new SearchResultsPage();
        basePage.setDriver(driver);
    }

    @AfterMethod
    public void takeScreenshotForFailures(ITestResult testResult) {
        driver.quit();
        if(ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            LocalDateTime currentDate = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("_dd-MM-yyyy_HH-mm-ss");
            File destination = new File(System.getProperty("user.dir") + "/src/output/" + testResult.getName() +  currentDate.format(formatter) + ".png");
            try {
                FileHandler.copy(source, destination);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
