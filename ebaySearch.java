package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/* 28/03/2023 An exercise on Selenium by Ina.
 * 
 * The launchBrowser method instantiates the browser driver and launches the browser. 
 * The searchProduct method does some operations on the eBay website:
 * 		- Inserts 'Sony Headphones' in the search field
 * 		- Clicks on the 'Search' button
 * 		- Clicks on the 'Daily Deals' link.
 * The navigate method navigates to Yle.fi and back to eBay.
 * The closeBrowser method quits the browser session.
 * The main method calls all the methods and then prints 'Finished'.
 * 
 */

public class ebaySearch {
	WebDriver driver;

	public void launchBrowser() {
		//Instantiate the browser by locating the browser driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ina.raisanen\\Selenium-chrome-driver\\chromedriver.exe");
		
		//Some options are configured for the driver to work properly
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox"); //Bypass OS security model
		options.addArguments("--disable-dev-shm-usage"); //Overcome limited resource problems
		options.addArguments("--start-maximized"); //Open the browser window as maximized
		options.addArguments("--disable-extensions"); //Disable browser extensions
		driver = new ChromeDriver(options);
		
		//Open the browser
		driver.get("https://ebay.com/");
		
		//Print the title of the page
		System.out.println(driver.getTitle());
	}
	
	public void searchProduct() throws InterruptedException {
		 //Give the page 2 seconds to load
		Thread.sleep(2000);
		
		//Locate page element id's by selecting 'Inspect' on the web page
		//Insert the search keywords in the search bar element
		driver.findElement(By.id("gh-ac")).sendKeys("Sony Headphones");
		
		//Click on the search button and wait for 2 seconds
		driver.findElement(By.id("gh-btn")).click();
		Thread.sleep(2000);
		
		//Click on the Daily Deals link
		driver.findElement(By.linkText("Daily Deals")).click();
	}
	
	public void navigate() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().to("https://www.yle.fi/");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		ebaySearch obj = new ebaySearch();
		obj.launchBrowser();
		obj.searchProduct();
		obj.navigate();
		obj.closeBrowser();
		System.out.println("Finished");
	}
}
