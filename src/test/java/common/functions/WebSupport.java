package common.functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebSupport {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	
	public WebSupport(WebDriver driver123) {
		this.driver = driver123;
		this.wait = new WebDriverWait(this.driver, 30);
		this.act = new Actions(driver123);
	}
	
	public void waitForLoading() {
		String spin = "//img[@src='/Portal/Content/images/loading.gif']";
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spin)));
	}
	
	public void clickOnElement(String xpath) {
		WebElement elm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		act.moveToElement(elm).build().perform();
		elm.click();
	}
	
	public void sendKeysToElement(String xpath, String keys) {
		WebElement elm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		act.moveToElement(elm).build().perform();
		elm.sendKeys(keys);
	}
	
	public Boolean verifyElement(String xpath) {
		Boolean result = false;
		try {
			WebElement elm = driver.findElement(By.xpath(xpath));
			act.moveToElement(elm).build().perform();
			Thread.sleep(1000);
			result = true;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}


}
