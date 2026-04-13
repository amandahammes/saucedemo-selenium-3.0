package tests.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ExtentReportManager;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    protected static final Logger logger =
            LogManager.getLogger(BaseTest.class);

    @BeforeEach
    void setUp(TestInfo testInfo) {
        driver = DriverFactory.getDriver();

        extent = ExtentReportManager.getInstance();
        test = extent.createTest(testInfo.getDisplayName());

        logger.info("Iniciando teste: {}", testInfo.getDisplayName());

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(ConfigReader.getImplicitWait()));
        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(ConfigReader.getPageLoadTimeout()));

        driver.manage().window().maximize();

        driver.get(ConfigReader.getBaseUrl());
    }

    @AfterEach
    void tearDown() {
        logger.info("Finalizando teste");
        DriverFactory.quitDriver();
        extent.flush();
    }
}