package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {


    public static String takeScreenshot(WebDriver driver, String name) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String path = "test-output/screenshots/" + name + ".png";
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(path);
        FileUtils.copyFile(src, dest);
        return path;
    }
}
