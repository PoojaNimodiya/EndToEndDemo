package TestWebsite;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserLaunch {
	
	public WebDriver driver;
	
	/*@BeforeTest
	public void LaunchBrowser() {
		//String exePath = "C:\\Jars\\chromedriver_win32\\chromedriver.exe"; 

		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new chromeDriver();
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		System.out.println("Website Url::::"+driver.getCurrentUrl());
		System.out.println("Website title:::::"+driver.getTitle());
	}*/
	
	
	/*@BeforeTest
	public void LaunchBrowser() {
		String exePath = "C:\\Jars\\geckodriver-v0.21.0-win64\\geckodriver.exe"; 

		System.setProperty("webdriver.gecko.driver", exePath);
		driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		System.out.println("Website Url::::"+driver.getCurrentUrl());
		System.out.println("Website title::::"+driver.getTitle());
	}*/
	
	/*@BeforeTest
	public void LaunchBrowser() {
		
		String exePath = "C:\\Jars\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe"; 

		System.setProperty("webdriver.ie.driver", exePath);
		driver = new InternetExplorerDriver();
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		System.out.println("Website Url::::"+driver.getCurrentUrl());
		System.out.println("Website title::::"+driver.getTitle());
	}*/
	
	@Parameters("Browers")
	@BeforeTest
	public void LaunchBrowser(String Browser){
		if(Browser.equalsIgnoreCase("chrome")){
			
			String exePath = "C:\\Jars\\chromedriver_win32\\chromedriver.exe"; 
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
			driver.get("http://gmail.com");
		}else if(Browser.equalsIgnoreCase("firefox")){
		String exePath = "C:\\Jars\\geckodriver-v0.21.0-win64\\geckodriver.exe"; 

		System.setProperty("webdriver.gecko.driver", exePath);
		driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		}
	
}
	
	@DataProvider(name="Authentication")
	public static Object [][] credentials(){
		return new Object [][] {{"poojanimodiya16@gmail.com", "Poonam@25"},{"poojanimodiya16@gmail.com", "Poonam@25"}};
		
	}
	
	@Test(dataProvider = "Authentication")
	public void getSiteInfo(String username, String password) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
		driver.findElement(By.id("identifierNext")).click();
		driver.findElement(By.xpath("//input[@aria-label='Enter your password']")).sendKeys(password);
		driver.findElement(By.id("passwordNext")).click();
	}
	
	/*@Test
	@Parameters({"username","password"})
	public void getSiteInfo(String username, String password) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
		driver.findElement(By.id("identifierNext")).click();
		driver.findElement(By.xpath("//input[@aria-label='Enter your password']")).sendKeys(password);
		driver.findElement(By.id("passwordNext")).click();
	}*/
	
	
	/*@AfterTest
	public void TearDown(){
		driver.close();
	}*/
	
}
