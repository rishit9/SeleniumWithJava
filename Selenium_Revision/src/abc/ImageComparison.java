package abc;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ImageComparison {

	public WebDriver driver;
	private String baseUrl;

	@BeforeSuite
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", 
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		//baseUrl = "https://www.facebook.com";
		baseUrl = "https://www.google.co.in/";
		driver.navigate().to(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testImageComparison() throws IOException, InterruptedException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Thread.sleep(3000);
		FileHandler.copy(screenshot, new File("/home/manish/eclipse-workspace/Selenium_Revision/SS/GoogleOutput.jpg"));

		File fileInput = new File("/home/manish/eclipse-workspace/Selenium_Revision/SS/GoogleInput.jpg");
		File fileOutPut = new File("/home/manish/eclipse-workspace/Selenium_Revision/SS/GoogleOutput.jpg");

		BufferedImage bufferfileInput = ImageIO.read(fileInput);
		DataBuffer datafileInput = bufferfileInput.getData().getDataBuffer();
		int sizefileInput = datafileInput.getSize();
		
		BufferedImage bufferfileOutPut = ImageIO.read(fileOutPut);
		DataBuffer datafileOutPut = bufferfileOutPut.getData().getDataBuffer();
		int sizefileOutPut = datafileOutPut.getSize();
		
		Boolean matchFlag = true;
		if (sizefileInput == sizefileOutPut) {
			for (int i = 0; i < sizefileInput; i++) {
				if (datafileInput.getElem(i) != datafileOutPut.getElem(i)) {
					matchFlag = false;
					break;
				}
			}
		} else {
			matchFlag = false;
			Assert.assertTrue(matchFlag, "Images are not same");
		}

	}
}
