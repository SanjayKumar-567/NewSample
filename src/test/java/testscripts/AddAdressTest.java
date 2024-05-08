package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import baseclass.BaseClass;

public class AddAdressTest extends BaseClass{
	@Test
	public void addAdress() {
		WebElement settings =driver.findElement(By.xpath("//div[@class='MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault css-bjoz8z']"));

		settings.click();

		driver.findElement(By.xpath("//ul[@role='menu']/li[1]")).click();

		driver.findElement(By.xpath("//div[text()='My Addresses']"));

		driver.findElement(By.xpath("//button[text()='Add Address']")).click();

		driver.findElement(By.name("Home")).click();
		driver.findElement(By.name("Name")).sendKeys("samjau kimar");
		driver.findElement(By.name("House/Office Info")).sendKeys("mooversampet");
		driver.findElement(By.id("Street Info")).sendKeys("8th street");
		driver.findElement(By.id("Landmark")).sendKeys("near airtel showroom");
		WebElement country=	driver.findElement(By.id("Landmark"));
		Select slt = new Select(country);
		slt.selectByVisibleText("india");
		WebElement state=driver.findElement(By.name("State"));
		Select slt1 = new Select(state);
		slt.selectByVisibleText("tamilnadu");
		WebElement city=driver.findElement(By.name("City"));
		Select slt2 = new Select(city);
		slt.selectByVisibleText("chennai");
		driver.findElement(By.name("Pincode")).sendKeys("600091");
		driver.findElement(By.name("Phone Number")).sendKeys("098765432");
		driver.findElement(By.id("btnDisabled")).click();
		Reporter.log("address added succesfully",true);
		



		
		
	}


}
