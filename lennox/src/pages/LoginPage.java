package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private static WebDriver driver;

	By signinLink = By.xpath("//div[@class='utility']/div[@class='container']//a[@href='/signin']");
	By username = By.cssSelector("#j_username");
	By password = By.cssSelector("#j_password");
	By loginBtn = By.cssSelector("#loginSubmit");

	public LoginPage(WebDriver driver) {
		LoginPage.driver = driver;
	}

	public void clickSignin() {
		driver.findElement(signinLink).click();
	}

	public void setUserName(String strUserName) {
		driver.findElement(username).sendKeys(strUserName);
	}

	public void setPassword(String strPassword) {
		driver.findElement(password).sendKeys(strPassword);
	}

	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

}
