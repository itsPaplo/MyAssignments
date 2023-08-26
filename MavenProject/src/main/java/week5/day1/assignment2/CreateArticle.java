package week5.day1.assignment2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateArticle extends SnowBaseClass {
	
	@Test
	public void createArticle() throws InterruptedException {
		WebElement filter = wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//input[@id='filter']")));
		filter.sendKeys("Knowledge");
		wait.until(ExpectedConditions.elementToBeClickable(shadow.findElementByXPath("//mark[text()='Knowledge']/parent::span"))).click();		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(shadow.findElementByXPath("//iframe[@title='Main Content']")));
		wait.until(ExpectedConditions.elementToBeClickable(shadow.findElementByXPath("//span[text()='Create an Article']/parent::button"))).click();		
		wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//input[@id='sys_display.kb_knowledge.kb_knowledge_base']"))).sendKeys(kBase);
		wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//input[@id='sys_display.kb_knowledge.kb_category']"))).sendKeys(ctgry);		
		wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//input[@id='kb_knowledge.short_description']"))).sendKeys(shrtDesc);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(shadow.findElementByXPath("//iframe[@id='kb_knowledge.text_ifr']")));	
		wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//p"))).sendKeys(artclTxt);		
		driver.switchTo().parentFrame();
		wait.until(ExpectedConditions.elementToBeClickable(shadow.findElementByXPath("//button[contains(@class,'form_action_button')]"))).click();
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.elementToBeClickable(shadow.findElementByXPath("//div[text()='All']"))).click();
		filter = wait.until(ExpectedConditions.visibilityOf(shadow.findElementByXPath("//input[@id='filter']")));
		filter.clear();
		filter.sendKeys("My Knowledge");
		wait.until(ExpectedConditions.elementToBeClickable(shadow.findElementByXPath("//mark[text()='My Knowledge']/parent::span"))).click();		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(shadow.findElementByXPath("//iframe[@title='Main Content']")));
		WebElement table = shadow.findElementByXPath("//table[@id='kb_knowledge_table']/tbody");
		String descTxt;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int count=0;
		for(int i=1;i<=rows.size();i++) {
			descTxt = table.findElement(By.xpath("//table[@id='kb_knowledge_table']/tbody/tr["+i+"]/td[4]")).getText();
			if(descTxt.contains(shrtDesc)) {
				System.out.println("Create new Article: PASS");
				count++;
				break;
			}
		}
		if(count==0) {
			System.out.println("Create new Article: FAIL");
		}
	}

}
