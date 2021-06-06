package nl.knab.trello.ui.objects;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import nl.knab.trello.ui.steps.Hooks;


public class SeachInvalidBoardPageObjects {
	
	private static Logger Log = Logger.getLogger(SeachInvalidBoardPageObjects.class.getName());

	public SeachInvalidBoardPageObjects() {
		PageFactory.initElements(Hooks.getDriver(), this);
	}
	
	/**
	 * Identifying the WebElement in the Trello Home Page for search the non-exists board
	 * 
	 */
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[1]/div[2]/span")
	private WebElement searchboard;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[2]/div[7]")
	private WebElement boardnotfound;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[1]/div[2]/span/a/span/span")
	private WebElement searchicon;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[1]/div/input")
	private WebElement searchboardname;
	
	
	public void searchBoardinPage() throws Exception {
		searchboard.click();
				
		Thread.sleep(2000);
		
		searchicon.click();
		
		Thread.sleep(1000);

	}
	
	public void searchBoardName(String boardname) throws Exception {
		searchboardname.sendKeys(boardname);
		
		Thread.sleep(2000);
	}
		
	public void boardMissing() {
		String boardmissingtext = "We couldn't find any cards or boards that matched your search.";
		String missingboardtext = boardnotfound.getText();
		
		Assert.assertEquals(missingboardtext, boardmissingtext);
		
		Log.info("Nonexisting Board doesn't display");
		
	}
		
	
}



