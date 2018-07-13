package pages;

import data.ReadExcel;
import java.util.NoSuchElementException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddLeadsPage {
	private static WebDriver driver;
	private WebDriverWait wait;
	private String dataFolderPath = System.getProperty("user.dir") + "\\src\\data\\";

	private By addLeadsTitle = By.xpath("//div[@class='ocl-page-title']/h1");

	private By firstName = By.id("firstName");
	private By lastName = By.id("lastName");
	private By phNo = By.id("phNo");
	private By email = By.id("email");

	public By imageChooseBtn = By.xpath("//input[@type='file'][contains(@name,'imageFiles')]");

	public By documentAddBtn = By.cssSelector("div.selectRequested span.add-row");
	private By documentSelectBtn = By.id("documents1.documentType");
	private By documentChooseBtn = By.xpath("//input[contains(@name,'documentFiles')]");
	
	public By saveBtn = By.id("btn-addLeadsForm");
	private By saveMsg = By.cssSelector("#globalMessages ul.success-msg");

	public AddLeadsPage(WebDriver driver) {
		AddLeadsPage.driver = driver;
		wait = new WebDriverWait(driver, 2000);
	}

	public String getTitle() {
		return driver.findElement(addLeadsTitle).getText();
	}

	private String[][] getLeadExcelData() {
		ReadExcel objReadExcel = new ReadExcel();

		String[][] strArray = objReadExcel.getExcelData(dataFolderPath, "LeadData.xls", "LeadData");
		return strArray;
	}

	public void setLeadValues() {
		String[][] strArray = this.getLeadExcelData();

		driver.findElement(firstName).clear();
		driver.findElement(lastName).clear();
		driver.findElement(email).clear();
		driver.findElement(phNo).clear();

		driver.findElement(firstName).sendKeys((strArray[0][0]));
		driver.findElement(lastName).sendKeys((strArray[0][1]));
		driver.findElement(email).sendKeys((strArray[0][2]));
		driver.findElement(phNo).sendKeys((strArray[0][3]));
	}

	public void clickOnBtn(By byValue) {
		driver.findElement(byValue).click();
	}

	public Boolean clickOnSaveBtn() {
		driver.findElement(saveBtn).click();
		Boolean isSaved = true;
		this.handleDuplicates();

		return isSaved;
	}

	public Boolean clickOnSaveBtnForDocuments() {
		driver.findElement(saveBtn).click();
		Boolean isSaved = true;

		if (isErrorLabelPresent())
			isSaved = false;
		else
			this.handleDuplicates();

		return isSaved;
	}

	private void handleDuplicates() {
		System.out.println("inside duplicates");
		By buttonCss = By.cssSelector("div.button-wpr button.create-duplicate-lead");
		try {
			driver.findElement(buttonCss).click();
		} catch (Exception e) {
			System.out.println("Exception:: " + e.getMessage());
		}
	}

	private boolean isErrorLabelPresent() {
		Boolean isErrorLabelPresent = true;
		By errorLabel = By.xpath("//label[contains(@for,'documentFiles')]");
		try {
			driver.findElement(errorLabel);
		} catch (NoSuchElementException e) {
			isErrorLabelPresent = false;
		} catch (Exception e) {
			isErrorLabelPresent = false;
			System.out.println("Exception:: " + e.getMessage());
		}
		return isErrorLabelPresent;
	}

	public void addImage() {
		try {
			this.clickOnBtn(imageChooseBtn);

			String execFilePath = dataFolderPath + "FileUpload.exe";
			String filePath = dataFolderPath + "Divya_Image.jpg";

			Runtime.getRuntime().exec(execFilePath + " " + filePath);
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void addDocument() {
		this.clickOnBtn(documentAddBtn);

		wait.until(ExpectedConditions.presenceOfElementLocated(documentSelectBtn));
		Select dropdown = new Select(driver.findElement(documentSelectBtn));
		dropdown.selectByValue("OTHER");

		try {
			Thread.sleep(5000);
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(documentChooseBtn));
			this.clickOnBtn(documentChooseBtn);

			String execFilePath = dataFolderPath + "FileUpload.exe";
			String filePath = dataFolderPath + "Divya_Resume.pdf";

			Runtime.getRuntime().exec(execFilePath + " " + filePath);
			Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getSavedMessage(Boolean isSaved) {
		String actualMsgDisplayed = "";

		if (isSaved) {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(saveMsg));
			actualMsgDisplayed = driver.findElement(saveMsg).getText();
		}

		return actualMsgDisplayed;
	}

}
