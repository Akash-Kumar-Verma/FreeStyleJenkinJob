package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.homePage;
import pages.loginPage;

public class LoginTest{
	  private WebDriver driver;
	  public String url= "https://www.amazon.in/";

	    @BeforeSuite
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akashverma02\\eclipse-workspace\\freeStyle.assignment\\drivers\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
			
			//WebDriver
			System.out.println("Setup Successful");
			driver.get(url);
			System.out.println("Successfully nevigated to url");
	    }

	    @DataProvider(name="usertestdata")
		public static  Object[][] userinputdata(){
			Object[][] data=new Object[][] {{"akashv5482@gmail.com","akashchakia"}};
			return data;
		}
	    
	    @Test(priority=1,dataProvider="usertestdata")
	    public void login(String username,String password) {

			driver.findElement(homePage.btn_signIn).click();
		
			driver.findElement(loginPage.text_username).sendKeys(username);
			
			driver.findElement(loginPage.btn_continue).click();
			
			driver.findElement(loginPage.text_password).click();
			
			driver.findElement(loginPage.text_password).sendKeys(password);
		
			driver.findElement(loginPage.btn_signInSubmit).click();
			
			Assert.assertEquals(driver.getTitle(), "Amazon");
			
			System.out.println("Test passed");
	       
	    }

	    @AfterSuite
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}