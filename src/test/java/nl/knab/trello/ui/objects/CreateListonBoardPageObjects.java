package nl.knab.trello.ui.objects;


import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import nl.knab.trello.ui.steps.Hooks;


public class CreateListonBoardPageObjects {

	private static Logger Log = Logger.getLogger(CreateListonBoardPageObjects.class.getName());

	public CreateListonBoardPageObjects() {
		PageFactory.initElements(Hooks.getDriver(), this);
	}
	
	/**
	 * Identifying the WebElement in the New Board Page for creating list
	 * 
	 */
	

	@FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[1]/button/span[2]")
	private WebElement chooseboard;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"chrome-container\"]/div[1]/div[1]/div/div[2]/div/form/input")
	private WebElement boardname;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"board\"]/div/form/a/span")
	private WebElement addlist;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"board\"]/div/form/input")
	private WebElement addlistname;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"board\"]/div/form/div/input")
	private WebElement addlistbutton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"board\"]/div[4]/form/div/a")
	private WebElement cancellistbutton;
	
	public void chooseBoardinMenu() {
		chooseboard.click();		
	}
	
	public void searchBoardName(String findboard) throws Exception {
		boardname.sendKeys(findboard);	
		
		Thread.sleep(3000);
		boardname.sendKeys(Keys.ENTER);
		
		Log.info("Successfully identified the board");
	}
	
	
	public void addList() {
		addlist.click();
	}
	
	public void enterListName(String listname) {
		addlistname.sendKeys(listname);
	}
	
	public void addListtoBoard() {
		addlistbutton.click();
		
		Log.info("List successfully added in the new board");
	}
	
	public void cancelListButton() {
		cancellistbutton.click();
		
		
	}
	
}
