package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.homePage;
import pages.loginPage;

public class LoginTest{
	  private WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
	    	WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
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

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}