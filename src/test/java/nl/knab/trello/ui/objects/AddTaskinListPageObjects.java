package nl.knab.trello.ui.objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import nl.knab.trello.ui.steps.Hooks;

public class AddTaskinListPageObjects {	
	
	private static Logger Log = Logger.getLogger(AddTaskinListPageObjects.class.getName());

	public AddTaskinListPageObjects() {
		PageFactory.initElements(Hooks.getDriver(), this);
	}
	
	/**
	 * Identifying the WebElement in the New Board page for creating task in the list
	 * 
	 */
		
	@FindBy(how = How.XPATH, using = "//*[@id=\"board\"]/div[1]/div/div[1]/textarea")
	private WebElement chooselist;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"board\"]/div[2]/div/div[1]/textarea")
	private WebElement choosenextlist;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"board\"]/div[1]/div/div[3]/a/span[2]")
	private WebElement addcard;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"board\"]/div[2]/div/div[3]/a/span[2]")
	private WebElement nextaddcard;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"board\"]/div[1]/div/div[2]/div/div[1]/div/textarea")
	private WebElement addcardname;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"board\"]/div[2]/div/div[2]/div/div[1]/div/textarea")
	private WebElement nextaddcardname; 
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"board\"]/div[1]/div/div[2]/div/div[2]/div[1]/input")
	private WebElement addcardbutton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"board\"]/div[2]/div/div[2]/div/div[2]/div[1]/input")
	private WebElement addnextcardbutton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"board\"]/div[1]/div/div[2]/div/div[2]/div[1]/a")
	private WebElement cancelcardbutton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"board\"]/div[2]/div/div[2]/div/div[2]/div[1]/a")
	private WebElement cancelnextcardbutton;
	
	
	
	public void listNameBoard(String listname) throws Exception {
		
		chooselist.clear();
		chooselist.sendKeys(listname);
			Thread.sleep(3000);			
		}
	
	public void addCard() {
		addcard.click();
	}
	public void addCardNameList(String cardname) {
		
			addcardname.sendKeys(cardname);
		}
	
	public void addCardButton() {
		
		addcardbutton.click();
		}
	
	public void cancelCardButton() {
		cancelcardbutton.click();
	}

	public void nextlistNameBoard(String nextlistname) throws Exception {
		
		choosenextlist.clear();
		choosenextlist.sendKeys(nextlistname);
			Thread.sleep(3000);			
		}
	
	public void addNextCard() {
		nextaddcard.click();
	}
	
	public void addNextCardNameList(String nextcardname) {
		
		nextaddcardname.sendKeys(nextcardname);
		}
	
	public void addNextCardButton() {
		
		addnextcardbutton.click();
		
		Log.info("Task added successfully in the list");
		}
	
	public void cancelNextCardButton() {
		cancelnextcardbutton.click();
		
		
		
	}
}


