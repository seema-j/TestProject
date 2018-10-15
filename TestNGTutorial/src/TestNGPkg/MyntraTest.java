package TestNGPkg;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import Utilities.*;

public class MyntraTest {
	
	WebDriver driver;
	String handle;
	String xpath;
	Set<String> handles;
	String newhandle;
	WebDriverWait wait;
	WebElement Wallet1;
	String price;
	
	@BeforeClass
  public void beforeClass() {

	System.setProperty("webdriver.chrome.driver", "F:\\Seema\\JavaTutorial\\SoftwareInst\\chromedriver_win32\\chromedriver.exe");
	driver = new  ChromeDriver();
	
	driver.get("https://www.myntra.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	
  }
	
  @Test(priority=1,enabled=false)
  public void f() throws IOException, InterruptedException {
	  

		ScreenCapture.getScreenShot(driver);
		
		
		WebElement search = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		search.sendKeys("Wallet");		
		search.sendKeys(Keys.ENTER);
		
		 wait = new WebDriverWait(driver,2000);
		 xpath = "//img[contains(@src,'6848786')]";
		 Wallet1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

		ScreenCapture.getScreenShot(driver);
		
		Wallet1.click();
		
		
		Thread.sleep(1000);
		
		 handle = driver.getWindowHandle();
		 handles = driver.getWindowHandles();
		handles.remove(handle);
		 newhandle = handles.iterator().next();
		driver.switchTo().window(newhandle);
		
		 price = driver.findElement(By.xpath("//p[@class='pdp-discount-container']/strong[@class='pdp-price']")).getText();
		
		System.out.println(price);
		
		ScreenCapture.getScreenShot(driver);
		
		driver.close();
		
  }
  @Test(priority=0)
  public void p() throws IOException {
	  
	 // ScreenCapture.getScreenShot(driver);
		
		driver.switchTo().window(handle);
		
		 wait = new WebDriverWait(driver,2000);
		 xpath = "//img[contains(@src,'6791542')]";
		 Wallet1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

		 ScreenCapture.getScreenShot(driver);
		Wallet1.click();
		
		 handle = driver.getWindowHandle();
		 handles = driver.getWindowHandles();
		handles.remove(handle);
		 newhandle = handles.iterator().next();
		driver.switchTo().window(newhandle);
		
		wait = new WebDriverWait(driver,2000);
		 xpath = "//p[@class='pdp-discount-container']/strong[@class='pdp-price']";
		 WebElement priceObj= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

		 price =  priceObj.getText();
		 
		 ScreenCapture.getScreenShot(driver);
		 System.out.println(price);
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

 

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
