package abc;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class WebdriverMethods {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		
		System.setProperty("webdriver.gecko.driver", 
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.google.com");
		WebElement googleSrchBx = driver.findElement(By.name("q"));
		/*File file = googleSrchBx.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File("/home/manish/eclipse-workspace"
				+ "/Selenium_Revision/SS/" +System.currentTimeMillis()+".jpg"));
		*/
		
		System.out.println("search box available: "+googleSrchBx.isDisplayed());
		googleSrchBx.sendKeys("robot framework selenium");
		//System.out.println("Entered text is: "+ googleSrchBx.getText());
		
		System.out.println("Dimension: "+googleSrchBx.getRect().getDimension());
		System.out.println("height: "+googleSrchBx.getRect().getHeight());
		System.out.println("width: "+googleSrchBx.getRect().getWidth());
		System.out.println("points"+googleSrchBx.getRect().getPoint());
		System.out.println("Location: "+googleSrchBx.getLocation());
		
		System.out.println("color: "+googleSrchBx.getCssValue("color"));
		WebElement textPart = driver.findElement(By.xpath("//*[@id='SIvCob']"));
		System.out.println("color mix: "+textPart.getCssValue("color"));
		System.out.println("font-size: "+textPart.getCssValue("font-size"));
		System.out.println("font-family: "+textPart.getCssValue("font-family"));
		System.out.println("text allign: "+textPart.getCssValue("text-align"));
		File file = googleSrchBx.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File("/home/manish/eclipse-workspace"
				+ "/Selenium_Revision/SS/" +System.currentTimeMillis()+".jpg"));
		
		
		if(driver.getPageSource().contains("robot")) {
			System.out.println("robot word is available");
		}
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		
		driver.manage().window().setPosition(new Point(-2000, 0));
		//Robot robot = new Robot();
		/*robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyPress(KeyEvent.VK_N);
		
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_N);
		
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		robot.mouseWheel(500);
		
		robot.keyPress(KeyEvent.VK_WINDOWS);
//		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_D);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
//		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_D);*/
		Thread.sleep(500);
		driver.quit();

	}

}
