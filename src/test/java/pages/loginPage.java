package pages;

import org.openqa.selenium.By;

public class loginPage {
	public static By text_username = By.id("ap_email");
	public static By text_password = By.id("ap_password");
	public static By btn_signIn = By.xpath("//p[@class='submit']//span[1]");
	public static By btn_continue = By.id("continue");
	public static By btn_signInSubmit = By.id("signInSubmit");
}

