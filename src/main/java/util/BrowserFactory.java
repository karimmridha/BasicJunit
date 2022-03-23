
package util;


import java.util.concurrent.TimeUnit;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserFactory {

	 WebDriver driver;

	 String url = "http://techfios.com/test/101/";
@Test
	public  void startBrowser() {

		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver99.exe");
		driver = new ChromeDriver();
        //open the test page
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//create list items
		
		driver.findElement(By.xpath("/html/body/div[4]/input[1]")).sendKeys("bak");
		driver.findElement(By.xpath("/html/body/div[4]/input[2]")).click();
		driver.findElement(By.xpath("/html/body/div[4]/input[1]")).sendKeys("jak");
		driver.findElement(By.xpath("/html/body/div[4]/input[2]")).click();
		driver.findElement(By.xpath("/html/body/div[4]/input[1]")).sendKeys("rak");
		driver.findElement(By.xpath("/html/body/div[4]/input[2]")).click();
		
		//select ToggleAll button
		driver.findElement(By.xpath("/html/body/div[3]/input[3]")).click();
		
		//webElements after list item created
		WebElement item1=driver.findElement(By.xpath("//*[@id=\"todos-content\"]/form/ul/li[1]/input"));
		//item1.click();
		WebElement item2=driver.findElement(By.xpath("//*[@id=\"todos-content\"]/form/ul/li[2]/input"));
		WebElement item3=driver.findElement(By.xpath("//*[@id=\"todos-content\"]/form/ul/li[3]/input"));
		
		//ToggleAll webelement to validate whether checked or not
		WebElement toggleAll=driver.findElement(By.xpath("/html/body/div[3]/input[3]"));
		
		//validation if ToggleAll selected then all list item selects
		boolean c=true;
		if(c=toggleAll.isSelected()) {
			c=item1.isSelected()&& item2.isSelected() && item3.isSelected();
		}else {
			System.out.println("not checked");
		}
		
		//remove button
		driver.findElement(By.xpath("/html/body/div[3]/input[1]")).click();
		
		

	}

}