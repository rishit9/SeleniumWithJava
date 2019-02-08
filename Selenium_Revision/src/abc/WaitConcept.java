package abc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitConcept {
	
	public static void implictlyWaitConcept(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	public static void explicitWaitConcept(WebDriver driver, WebElement locator, int timeOut) {
		//WaebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.VisibilityOfElementLocated(By.id("")))
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
	
	public static void fluentWaitConcept(WebDriver driver, WebElement locator, int timeOut) {
		//wait.ignoring(throwable.class).until(ExpectedConditions.elementToBeClickable(WebElelment));
		new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(locator));
		locator.getRect().toString();
		locator.click();
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", 
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().window().setPosition(new Point(-2000,0));
		Thread.sleep(1000);
		driver.manage().window().maximize();
		driver.quit();

	}

}
