package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import common.functions.DriverFactory;
import common.functions.ReadExcel;
import common.functions.WebSupport;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Steps_Definition {
	WebDriver driver;
	WebSupport webSupport;
	@Given("^I open browser and navigate to the website\\.$")
	public void i_open_browser_and_navigate_to_the_website() throws Throwable {
		driver = DriverFactory.createDriver();
		this.webSupport =  new WebSupport(driver);
		driver.get("https://id.atlassian.com/login");
	}

	@Given("^I provide a valid credential of testcase \"([^\"]*)\"\\.$")
	public void i_provide_a_valid_credential_of_testcase(String arg1) throws Throwable {
		ReadExcel ex = new ReadExcel(arg1);
		System.setProperty("CurrentFeature", arg1);
		String usr = ex.getUsername(ex.getVar("credentialID"));
		String pwd = ex.getPassword(ex.getVar("credentialID"));
		webSupport.sendKeysToElement("//input[@id='username']", usr);
		webSupport.clickOnElement("//span[text()='Continue']");
		webSupport.sendKeysToElement("//input[@id='password']", pwd);
		
	}

	@Given("^I click on Submit button\\.$")
	public void i_click_on_Submit_button() throws Throwable {
		webSupport.clickOnElement("//span[text()='Log in']");
	}

	@Then("^I should login successfully\\.$")
	public void i_should_login_successfully() throws Throwable {
		Thread.sleep(15000);
		Assert.assertTrue(webSupport.verifyElement("//h1[text()='Manage your account']"));
		
	}
	@After
	public void cleanUp(){
		driver.quit();
	}

}
