package abc;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenSHotConcept {
	static WebDriver driver;
	
	public static void TakeScreenshotOf(String imageName) throws IOException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File("/home/manish/eclipse-workspace/abc/src/abc/"+imageName+ ".jpg"));	
		
	}

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.gecko.driver", "/home/manish/Downloads/Selenium/Lib"
				+ "/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		TakeScreenshotOf("Google_HomePage");

	}

}
