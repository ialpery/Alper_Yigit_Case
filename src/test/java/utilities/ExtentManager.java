package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.nio.file.*;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getExtent() {
        if (extent == null) {
            try {
                Path outDir = Paths.get("test-output");
                Files.createDirectories(outDir);

                String reportPath = outDir.resolve("ExtentReport.html").toString();
                ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

                extent = new ExtentReports();
                extent.attachReporter(spark);
            } catch (Exception e) {
                throw new RuntimeException("Extent init failed", e);
            }
        }
        return extent;
    }
}
