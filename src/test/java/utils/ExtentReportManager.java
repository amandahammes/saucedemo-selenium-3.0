package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {
            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("reports/extent-report.html");

            reporter.config().setReportName("Automação Selenium");
            reporter.config().setDocumentTitle("Relatório de Testes");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Projeto", "SauceDemo");
            extent.setSystemInfo("Browser", ConfigReader.getBrowser());
            extent.setSystemInfo("Ambiente", "QA");
        }

        return extent;
    }
}