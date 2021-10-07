package maven.Epiphanie_Tutoring;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Login {

ChromeDriver driver;
	
	@BeforeTest
	public void openurl() {
		String chromepath= System.getProperty("user.dir") + "\\Resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		driver.navigate().to("https://epiphanietutoring.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Epiphanie AI Tutoring - Coming Soon");
	}
	
	@Test(priority = 0, enabled = true)
	public void login() {
		WebElement username = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[1]/div[1]/input"));
		username.sendKeys("mai.ahmed21");
		
		WebElement password = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[1]/div[2]/input"));
		password.sendKeys("abcABC123!");
		
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[2]/div[2]/button"));
		loginBtn.click();
		
	}
	
	@Test( priority = 0, dependsOnMethods = {"login"} )
	public void open_edit_profile_page(){
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Epiphanie AI Tutoring"));
		assertTrue(driver.getTitle().startsWith("Epiphanie AI Tutoring"));
		System.out.println("title: " + driver.getTitle());
		WebElement Editprofile_Btn = driver.findElement(By.xpath("/html/body/section/div/div[1]/div/a[4]"));
		Editprofile_Btn.click();
	}
	
	@AfterTest
	public void close_driver() {
        
		driver.close();
	
	}
	
}
