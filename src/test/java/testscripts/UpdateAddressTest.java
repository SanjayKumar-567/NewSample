package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import baseclass.BaseClass;

public class UpdateAddressTest extends BaseClass {
	@Test
	public void updateAdress() {
	WebElement updatebutton =	driver.findElement(By.id("editaddress_fl"));
	
	updatebutton.click();
	WebElement radiobutton=	driver.findElement(By.id("Office"));
	radiobutton.click();
	
	
	driver.findElement(By.name("Home")).click();
	driver.findElement(By.name("Name")).sendKeys("samjay");
	driver.findElement(By.name("House/Office Info")).sendKeys("mooversampet");
	driver.findElement(By.id("Street Info")).sendKeys("10th street");
	driver.findElement(By.id("Landmark")).sendKeys("near airtel showroom back side");
	WebElement country=	driver.findElement(By.id("Country"));
	Select slt = new Select(country);
	slt.selectByVisibleText("india");
	WebElement state=driver.findElement(By.name("State"));
	Select slt1 = new Select(state);
	slt.selectByVisibleText("tamilnadu");
	WebElement city=driver.findElement(By.name("City"));
	Select slt2 = new Select(city);
	slt.selectByVisibleText("chennai");
	driver.findElement(By.name("Pincode")).sendKeys("600061");
	driver.findElement(By.name("Phone Number")).sendKeys("098765432");
	driver.findElement(By.id("Update Address")).click();
	}


}
