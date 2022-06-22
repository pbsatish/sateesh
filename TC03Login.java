package ABC_Demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC03_Login_Static_Paarameters {
	
	
	static WebDriver driver;
	
	//Global Variables
	static String TestURL="https://opensource-demo.orangeHRMlive.com/";
	static String UserName="Admin", Password="admin123";
	static String Nationality="Mexican9";
	
	
	//step1
		 @DataProvider(name = "Orange1")
		  public static Object[][] Test123() throws Exception {
		        return new Object[][] { 
		        	{ "Admin", "admin123","Indians127", },
		        	{ "Admin", "admin123","Indians128" },
		        	{ "Admin", "admin123","Indians129" }
		        	};
		  }

	@Test (dataProvider="Orange1") //step2
	public void Login_Test(String UserName,String Password,String Nationality) throws Exception //step3
	{
		
		TC03_Login_Static_Paarameters.OpenChromeBrowser();
		TC03_Login_Static_Paarameters.OpenorangeHRM(TestURL);
		TC03_Login_Static_Paarameters.Login(UserName,Password);
		TC03_Login_Static_Paarameters.AddNationalities(Nationality);
		driver.quit();
	}
	
	

	public static void OpenorangeHRM(String testURL2) {
		
		driver.get(TestURL);
	}

	//local variables
	public static void Login(String UserName1,String Password1) throws Exception
	{
		findElement(By.name("txtUsername")).sendKeys(UserName1);
		findElement(By.name("txtPassword")).sendKeys(Password1);
		findElement(By.id("btnLogin")).click();
	}
	
	public static   void AddNationalities(String Nationality1) throws Exception
	{
		

		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys(Nationality1);
		findElement(By.id("btnSave")).click();
		
		
	}
	
	
	
	
	public static void OpenChromeBrowser() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
	
	}
	
	
	
	
	public static  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement element= driver.findElement(by);    	    
		
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", element);
	 
		}
		
		return element;
	}
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
