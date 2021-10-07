package maven.Epiphanie_Tutoring;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Registration {

	ChromeDriver driver;
	
	@BeforeTest
	public void openurl() {
		String chromepath= System.getProperty("user.dir") + "\\Resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		driver.navigate().to("https://epiphanietutoring.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@Test
	public void Test_url() {
		System.out.println("Url is: "+ driver.getCurrentUrl());
		System.out.println("title is: "+ driver.getTitle());

	}
	@Test
	public void Register(){
		WebElement First_name = driver.findElement(By.xpath("//*[@id=\"id_first_name\"]"));
		First_name.sendKeys("mai");
		
//		//explicit wait     *******
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.titleContains("Epiphanie AI Tutoring - Coming Soon"));
//		assertTrue(driver.getTitle().startsWith("Epiphanie AI Tutoring - Coming Soon"));
//		System.out.println("title: " + driver.getTitle());
//		//                 ********
		
//		//Fluent wait      ********
//		try {
//			Wait<WebDriver> fluent_wait = new FluentWait<WebDriver>(driver)
//					.withTimeout(10, TimeUnit.SECONDS)
//					.pollingEvery(2, TimeUnit.SECONDS)
//					.ignoring(NoSuchElementException.class);
//			WebElement message= fluent_wait
//					.until(new Function<WebDriver, WebElement>() {
//						public WebElement apply(WebDriver d) {
//							return d.findElement(By.xpath("//*[@id=\\\"id_first_name\\\"]"));
//						}
//			
//		});
//			System.out.println("text: "+ message.getText());
////		assertTrue(message.getText().contains());
//	}
//	finally {
//		
//	}	
		 //          ********
	}     
            

		
	@AfterTest
	public void close_driver() {
		driver.close();
	}

}
