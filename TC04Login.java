package ABC_Demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;

public class TC03_Login_Static_Paarameters2 {
	
	
	static WebDriver driver;
	
	//Global Variables
	//static String UserName="Admin", Password="admin123";
	//static String Nationality="Mexican9";
	
	@DataProvider(name = "Orange1")
	public static Object[][] Test123() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		
		Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC01_Nationality999.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	
	
	
	@Test (dataProvider="Orange1") //step2
	public void Login_Test(String UserName,String Password,String Nationality) throws Exception //step3
	{
		
		//TC03_Login_Static_Paarameters2.OpenChromeBrowser();
		TC03_Login_Static_Paarameters2.OpenOrangeHRM();
		TC03_Login_Static_Paarameters2.Login(UserName,Password);
		TC03_Login_Static_Paarameters2.AddNationalities(Nationality);
		driver.quit();
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
	
	
	public static  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
 
	
	
	
	
	
	public static void OpenOrangeHRM() throws Exception
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	
	public static void OpenChromeBrowser() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
