package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import common.functions.DriverFactory;
import common.functions.WebSupport;

public class TC001 {

	@Test
	public void testGoogle() throws Exception {
		WebDriver driver = DriverFactory.createDriver();
		WebSupport webSupport = new WebSupport(driver);
		driver.get("https://118.189.75.56/Portal");
		driver.findElement(By.xpath("//div[@id='search']/div/input")).sendKeys("acid");
		driver.findElement(By.xpath("//div[@id='search']/div/input")).sendKeys(Keys.ENTER);
		webSupport.waitForLoading();
		driver.findElement(By.xpath("//td/a[@id='lnk_8324']")).click();
		Thread.sleep(10000);
	}

}
