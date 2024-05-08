package baseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import fileutility.ReadProperty;

public class BaseClass {
	 public WebDriver driver;
	ChromeOptions co;

	@BeforeClass

	public void openbrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\eclipse-jee-oxygen-3a-win32-x86_64\\chromedriver_win32\\chromedriver.exe");
	    co= new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");    
		driver = new ChromeDriver(co);
		//driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		ReadProperty properties = new ReadProperty();
		String url = properties.fetchproperty("url");

		driver.get(url);
		Reporter.log("browser opend sucessfuly and navigated to home page", true);
	}

	@BeforeMethod
	public void login() {

		ReadProperty properties = new ReadProperty();
		String username = properties.fetchproperty("username");

		driver.findElement(By.id("Email")).sendKeys(username);
		String password = properties.fetchproperty("password");
		// driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Reporter.log("logged in sucessfully", true);
	}

	@AfterMethod
	public void logout() {

driver.findElement(By.xpath("//div[text()='s']")).click();
		WebElement  logout= driver.findElement(By.xpath("//*[name()='svg'and @data-testid='LogoutIcon']"));

            logout.click();//li[normalize-space()='Logout']
		Reporter.log("logged out sucessfully", true);
	}

	@AfterClass
	public void closebrowser() {
		//driver.close();
		Reporter.log("browser closed sucessfullu", true);
	}

}
