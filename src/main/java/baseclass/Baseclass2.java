package baseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import fileutility.ReadProperty;

public class Baseclass2 {


	 public WebDriver driver ;
		 @Parameters("browser")
		@BeforeClass(alwaysRun = true)

		public void openbrowser(String browser) {

			 if(browser.equals("chrome")) {

				 driver = new ChromeDriver();
			 }

			 else if(browser.equals("edge")) {

				 driver = new EdgeDriver();
			 }

			 else {

				 driver = new ChromeDriver();
			 }
			 //driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
			 ReadProperty properties = new ReadProperty();
		String url=	 properties.fetchproperty("url");
			 driver.get(url);
			Reporter.log("browser opend sucessfuly and navigated to home page",true);
		}

		@BeforeMethod(alwaysRun = true)

		public void login() {

			 ReadProperty properties = new ReadProperty();

				String username= properties.fetchproperty("username");
				driver.findElement(By.id("Email")).sendKeys(username);
				String password= properties.fetchproperty("password");
				//driver.findElement(By.id("Email")).sendKeys(username);
				driver.findElement(By.id("Password")).sendKeys(password);
				driver.findElement(By.xpath("//span[text()='Login']")).click();
			Reporter.log("logged in sucessfully",true);
		}

		@AfterMethod(alwaysRun = true)
		public void logout() {
			WebElement settings =driver.findElement(By.xpath("//div[@class='MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault css-bjoz8z']"));
			settings.click();
			WebElement  logout= driver.findElement(By.xpath("//*[@id=\"account-menu\"]/div[3]/ul/li[7]"));
	            logout.click();
	            Reporter.log("logged out sucessfully",true);

		}

		@AfterClass(alwaysRun = true)
		public void closebrowser() {
			driver.close();
			Reporter.log("browser closed sucessfullu",true);

		}
}
