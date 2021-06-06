package nl.knab.trello.ui.objects;

import static org.testng.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import nl.knab.trello.ui.steps.Hooks;

public class CreateBoardPageObjects {

	private static Logger Log = Logger.getLogger(CreateBoardPageObjects.class.getName());

	public CreateBoardPageObjects() {
		PageFactory.initElements(Hooks.getDriver(), this);

	}

	/**
	 * Identifying the WebElement in the Trello Home Page
	 * 
	 */

	@FindBy(how = How.LINK_TEXT, using = "Log in")
	private WebElement login;

	@FindBy(how = How.ID, using = "user")
	private WebElement email;

	@FindBy(how = How.ID, using = "login")
	private WebElement loginwithatlassin;

	@FindBy(how = How.ID, using = "password")
	private WebElement password;

	@FindBy(how = How.ID, using = "login-submit")
	private WebElement logintrello;

	@FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[2]/button[1]/span/span")
	private WebElement headercreatebutton;

	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div/section/div/nav/ul/li[1]/button/span[2]")
	private WebElement createboard;

	@FindBy(how = How.CLASS_NAME, using = "ldU5w4hl0WLLul")
	private WebElement addnametoboard;

	@FindBy(how = How.XPATH, using = "//*[@id=\"layer-manager-overlay\"]/div/div/div/div[2]/div/button")
	private WebElement createboardbutton;

	/**
	 * Calling the Selenium Webdriver and hit the Trello URL
	 */

	public void trelloPage(String url) {
		Hooks.getDriver().get(url);
		Hooks.getDriver().manage().window().maximize();
		Hooks.getDriver().findElement(By.className("gdpr-cookie-consent-button")).click();
		Log.info("Browser Opened Successfully");

	}

	public void clickLogin() {
		login.click();
	}

	public void loginMail(String mail) {

		assertNotNull(mail, "email should not be null");
		email.sendKeys(mail);
	}

	public void loginButtonAtlassin() {
		loginwithatlassin.click();
	}

	public void password(String pswd) {

		assertNotNull(pswd, "password should not be null");

		password.sendKeys(pswd);
	}

	public void loginToTrello() {
		logintrello.click();
	}

	public void trelloHomePageVerification() {

		String TRELLO_HOMEPAGE = "https://trello.com/jayashreeeswaran/boards";
		String trelloHomeURL = Hooks.driver.getCurrentUrl();
		Assert.assertEquals(trelloHomeURL, TRELLO_HOMEPAGE);
		Log.info("Successfully login to Trello");
	}

	public void addHeaderCreateButton() {
		headercreatebutton.click();
	}

	public void createBoard() {
		createboard.click();
	}

	public void addNameBoard(String boardname) {

		assertNotNull(boardname, "boardname should not be null");

		addnametoboard.sendKeys(boardname);

	}

	public void createBoardButton() {
		createboardbutton.click();
		
		Log.info("New Board created successfully via UI");
	}

}
