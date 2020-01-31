package whiteBoxLogin.com.wbl.Login;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WhiteBoxDemo {


	
		public WebDriver driver;
		public String driverPath="C:\\Users\\Chand\\OneDrive\\Desktop\\chromedriver.exe";
		public String url="http://whiteboxqa.com";
		
		
	 @BeforeTest
	  public void setUp()
	  {
		 System.setProperty("webdriver.chrome.driver", driverPath);
		  driver=new ChromeDriver();
		  driver.get(url);
		  driver.manage().window().maximize();
	  }
	  @Test
	  public void titleTest() {
		  driver.findElement(By.id("loginButton")).click();
		  driver.findElement(By.id("username")).sendKeys("chandana.duvvuru@outlook.com");
		  driver.findElement(By.id("password")).sendKeys("chandana123");
		  driver.findElement(By.id("login")).click();
		  Actions actions = new Actions(driver);
		  WebElement menuOption = driver.findElement(By.xpath("//div[@id='navbar-collapse']/ul[@class='nav navbar-nav']/li[4]/a[@href='#']"));
		     //Mouse hover menuOption 'Resources'
		     actions.moveToElement(menuOption).perform();
		  
		 driver.findElement(By.xpath("//div[@id='navbar-collapse']/ul[@class='nav navbar-nav']/li[4]/ul[@class='dropdown-menu']//a[@href='presentations.php']")).click();
		 driver.findElement(By.xpath("/html/body[@class='home-page']/div[@class='wrapper']//section[@class='widget']/ul[@class='hidden-xs nav']//a[@id='books']")).click();
		 driver.findElement(By.xpath("/html/body[@class='home-page']/div[@class='wrapper']/div/div[@class='page-wrapper']/div[@class='page-content']//div[@id='books']//table//a[@href='https://goo.gl/4ghdtw']")).click();
		 System.out.println(driver.getTitle());
		 ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(availableWindows.get(1)); 
		 System.out.println(driver.getTitle()); 
		 driver.findElement(By.xpath("//div[3]/div[2]/div[2]/div[3]")).click();
		 
		 
		 
		
		}
	  
	  @AfterTest
	  public void tearDown()
	  {
		  driver.close();
	  }
	}


