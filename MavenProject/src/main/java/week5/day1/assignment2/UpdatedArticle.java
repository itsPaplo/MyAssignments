package week5.day1.assignment2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class UpdatedArticle extends SnowBaseClass {
	
	@Test
	public void updateArticle() throws InterruptedException {
		WebElement filter = wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//input[@id='filter']")));
		filter.sendKeys("My Knowledge");
		wait.until(ExpectedConditions.elementToBeClickable(shadow.findElementByXPath("//mark[text()='My Knowledge']/parent::span"))).click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(shadow.findElementByXPath("//iframe[@title='Main Content']")));
		WebElement table = wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//table[@id='kb_knowledge_table']/tbody")));
		String descTxt;
		String nwCtgry = "Java";
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		String crntCtgry="";
		for(int i=1;i<=rows.size();i++) {
			descTxt = table.findElement(By.xpath("//table[@id='kb_knowledge_table']/tbody/tr["+i+"]/td[4]")).getText();
			if(descTxt.contains(shrtDesc)) {
				crntCtgry = table.findElement(By.xpath("//table[@id='kb_knowledge_table']/tbody/tr["+i+"]/td[6]/a")).getText();
				table.findElement(By.xpath("//table[@id='kb_knowledge_table']/tbody/tr["+i+"]/td[3]/a")).click();
				break;
			}
		}
		
		WebElement ctgr = wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//input[@id='sys_display.kb_knowledge.kb_category']")));
		ctgr.clear();
		ctgr.sendKeys(nwCtgry);		
		String updtCtgry="";
		wait.until(ExpectedConditions.elementToBeClickable(shadow.findElementByXPath("//button[@id='sysverb_update']"))).click();
		table = wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//table[@id='kb_knowledge_table']/tbody")));
		rows.clear();
		rows = table.findElements(By.tagName("tr"));
		for(int i=1;i<=rows.size();i++) {
			descTxt = table.findElement(By.xpath("//table[@id='kb_knowledge_table']/tbody/tr["+i+"]/td[4]")).getText();
			if(descTxt.contains(shrtDesc)) {
				updtCtgry = table.findElement(By.xpath("//table[@id='kb_knowledge_table']/tbody/tr["+i+"]/td[6]/a")).getText();	
				break;
			}
		}

		if((updtCtgry.contains(nwCtgry)) && !(updtCtgry.contains(crntCtgry))){
			System.out.println("Category of the Article updated: PASS");			
		}
		else {
			System.out.println("Category of the Article updated: FAIL");
		}
	}

}
