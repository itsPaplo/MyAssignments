package week2.day2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LeafGroundSelect {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));

		// Which is your favorite UI Automation tool?
		WebElement toolmnu = driver.findElement(By.xpath("//select[contains(@class,'selectonemenu')]"));
		Select tooldd = new Select(toolmnu);
		List<WebElement> tooloptnlist = tooldd.getOptions();
		for (int i = 1; i < tooloptnlist.size(); i++) {
			String opt = tooloptnlist.get(i).getText();
			System.out.println("listed: " + opt);
			if ((opt.contains("Selen")) || (opt.contains("Cyp"))) {
				System.out.println("selected: " + opt);
				tooloptnlist.get(i).click();

			}
		}

		// Choose your preferred country.
		WebElement countrydd = driver.findElement(By.xpath("//label[contains(text(),'Country')]"));
		countrydd.click();
		driver.findElement(By.xpath("//li[contains(text(),'India')]")).click();
		countrydd.click();

		// TC01: Confirm Cities belongs to Country is loaded
		int flag = 0;
		List<WebElement> countrylist = driver.findElements(By.xpath("(//ul[contains(@class,'selectonemenu')])[1]/li"));
		System.out.println('\n' + "TC01: Confirm Cities belongs to Country is loaded" + '\n'
				+ "------------------------------------------------------------------------------------------");
		for (int i = 1; i < countrylist.size(); i++) {
			int count = 0;
			countrydd.click();
			countrylist.get(i).click();
			String cntrnms = countrylist.get(i).getText();
			Thread.sleep(100);
			driver.findElement(By.xpath("//label[contains(text(),'City')]")).click();
			List<WebElement> citylist = driver
					.findElements(By.xpath("(//div[@class='ui-selectonemenu-items-wrapper'])[4]//li"));
			for (int j = 0; j < citylist.size(); j++) {
				Thread.sleep(100);
				String citynm = citylist.get(j).getText();
				if (cntrnms.contains("Brazil")) {
					if ((citynm.contains("Rio")) || (citynm.contains("Salv")) || (citynm.contains("Sao"))) {
						count++;
					}
				}
				if (cntrnms.contains("Germ")) {
					if ((citynm.contains("Ber")) || (citynm.contains("Fran")) || (citynm.contains("Mun"))) {
						count++;
					}
				}
				if (cntrnms.contains("India")) {
					if ((citynm.contains("Beng")) || (citynm.contains("Chen")) || (citynm.contains("Del"))) {
						count++;
					}
				}
				if (cntrnms.contains("USA")) {
					if ((citynm.contains("Den")) || (citynm.contains("New")) || (citynm.contains("San"))) {
						count++;
					}
				}
			}
			if (count == citylist.size() - 1) {
				System.out.println("All Cities loaded for county: " + cntrnms);
				flag++;
			} else {
				System.out.println("All Cities not loaded for county: " + cntrnms);
			}
			citylist.clear();
		}
		if (flag == countrylist.size() - 1) {
			System.out.println("For each Country selection all their respective cities loaded: PASS" + '\n');
		} else {
			System.out.println("For few Country selection few of their cities failed to load: FAIL" + '\n');
		}

		// Choose the Course: Method 01 Selecting using list find
		driver.findElement(By.xpath("//button[contains(@class,'autocomplete')]")).click();
		List<WebElement> autocmplist = driver.findElements(By.xpath("//ul[contains(@class,'autocomplete-list')]/li"));
		for (int i = 0; i < autocmplist.size(); i++) {
			String autocmpitem = autocmplist.get(i).getText();
			if (autocmpitem.contains("Selen")) {
				autocmplist.get(i).click();
			}
		}

		// Choose the Course : Method 02 normal type and click the matching autocomplete
		// suggestion
		driver.findElement(By.xpath("//li[contains(@class,'autocomplete-input')]/input")).sendKeys("Play");
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[contains(@class,'autocomplete-query')]/parent::li")).click();

		//TC02: Choose language randomly and verify Two is selected irrespective of language selection
		WebElement langlbl = driver.findElement(By.xpath("//label[contains(@id,'lang') and contains(@class,'selectonemenu')]"));
		langlbl.click();
		List<WebElement> langlist = driver.findElements(By.xpath("//ul[contains(@id,'lang') and contains(@class,'selectonemenu')]/li"));
		int count=0;
		System.out.println('\n' + "TC02: Choose language randomly and verify Two is selected irrespective of language selection" + '\n'
				+ "------------------------------------------------------------------------------------------");
		for(int i=1;i<langlist.size();i++) {
			langlbl.click();
			Thread.sleep(100);
			String langnm = langlist.get(i).getAttribute("data-label");
			langlist.get(i).click();			
			Thread.sleep(300);
			WebElement slctlist = driver.findElement(By.xpath("//select[contains(@id,'value')]"));			
			Select slctnumdd = new Select(slctlist); 
			List<WebElement> slctddoptns = slctnumdd.getOptions();	
			driver.findElement(By.xpath("//label[contains(@id,'value') and contains(@class,'selectonemenu')]")).click();
			List<WebElement> optnnumlist = driver.findElements(By.xpath("//ul[contains(@id,'value') and contains(@class,'selectonemenu')]/li"));		

			for(int j=1;j<slctddoptns.size();j++) {
				Thread.sleep(300);
				String optntxt = slctddoptns.get(j).getAttribute("value");
				if(optntxt.contentEquals("Two")) {
					optnnumlist.get(j).click();	
					count++;
				}
			}			

			System.out.println("Value 'Two' is selected for the Language selection: " + langnm);	

		}
		if(count==langlist.size()-1) {
			System.out.println("Options with value 'Two' is selected for all language selection: PASS");
		}
		else {
			System.out.println("Options with value 'Two' is not selected for all language selection: FAIL");
		}
	}
}
