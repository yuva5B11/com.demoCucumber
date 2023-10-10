package stepdefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRMLibrary {

//	public WebDriver driver;
	public DesiredCapabilities cap;
	public RemoteWebDriver driver;
	String newEmpc;

	@Given("i open browser with url {string}")
	public void i_open_browser_with_url(String url) throws MalformedURLException {
		cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		URL huburl=new URL("http://10.3.175.6:444");
		driver=new RemoteWebDriver(huburl,cap);
//		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}
	@Then("i should see login page")
	public void i_should_see_login_page() {
		if(driver.findElement(By.id("btnLogin")).isDisplayed()) {
			System.out.println("Login Page Displayed");
		}
	}

	@When("i enter username as {string}")
	public void i_enter_username_as(String userId) {
		driver.findElement(By.id("txtUsername")).sendKeys(userId);
	}

	@When("i enter password as {string}")
	public void i_enter_password_as(String password) {
		driver.findElement(By.id("txtPassword")).sendKeys(password);
	}

	@When("i click login button")
	public void i_click_login_button() {
		driver.findElement(By.id("btnLogin")).click();
	}

	@Then("i should see Admin module")
	public void i_should_see_admin_module() {
		if(driver.findElement(By.linkText("Admin")).isDisplayed()) {
			System.out.println("Admin Module displayed");
		}
	}

	@When("i click logout")
	public void i_click_logout() {
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	@When("i close browser")
	public void i_close_browser() {
		driver.quit();
	}
	
	@Then("i should get login error")
	public void i_should_get_login_error() {
		String str= driver.findElement(By.id("spanMessage")).getText();
		if(str.contains("Invalid")) {
			System.out.println("Approprite message displayed");
		}
	}
	
	//Emp Code
	
	@When("i go to add employee page")
	public void i_go_to_add_employee_page() {
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
	}
	
	@When("i enter firstname as {string}")
	public void i_enter_firstname_as(String fname) {
		driver.findElement(By.id("firstName")).sendKeys(fname);
	}
	
	@When("i enter lastname as {string}")
	public void i_enter_lastname_as(String lname) {
		driver.findElement(By.id("lastName")).sendKeys(lname);
		newEmpc=driver.findElement(By.id("employeeId")).getAttribute("value");
	}
	
	@When("i click Save")
	public void i_click_save() {
		driver.findElement(By.id("btnSave")).click();
	}
	
	@Then("i should see newly created employee in EmployeeList")
	public void i_should_see_newly_created_employee_in_employee_list() {
		System.out.println("emp code is  "+newEmpc);
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Employee List")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(newEmpc);
		driver.findElement(By.id("searchBtn")).click();
		
		List<WebElement> row,cols;
		row=driver.findElement(By.id("resultTable")).findElements(By.tagName("tr"));
		for(int i=1;i<row.size();i++) {
			cols=row.get(i).findElements(By.tagName("td"));
			System.out.println("Col count is  :"+cols.size());
			if(cols.get(1).getText().equals(newEmpc)) {
				System.out.println("Newly created emp found");
				break;
			}
		}
	}
	

}
