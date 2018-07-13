package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private static WebDriver driver;
	By homePageUserName = By.xpath("//li[@class='welcome-msg']");
	By proposalToolLink = By.cssSelector("nav#navigation a[title='Proposal Tool']");

	public HomePage(WebDriver driver) {
		HomePage.driver = driver;
	}

	public String getHomePageUserName() {
		return driver.findElement(homePageUserName).getText();
	}

	public void clickOnProposalLink() {
		driver.findElement(proposalToolLink).click();
	}

}
