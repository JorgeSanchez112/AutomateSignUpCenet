package Components.utilities.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExtentReporterNG {
    static Properties prop;

    public static ExtentReports getReportObject(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String path = System.getProperty("user.dir") + prop.getProperty("reportPath");
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName(prop.getProperty("reportName"));
        reporter.config().setDocumentTitle(prop.getProperty("documentTitle"));

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo(prop.getProperty("rol"), prop.getProperty("nameManager"));
        return extent;
    }
}
