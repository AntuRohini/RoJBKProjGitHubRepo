package com.jbkqa.testCases;


import java.io.File;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.jbkqa.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	

	public String baseURL = readconfig.getAppURL();
	public String userMobile = readconfig.getUserLogin();
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
	
	public WebDriver driver;
	public static Logger logger;
	
	
	@BeforeClass
	public void setUp()
	{
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"Drivers/chromedriver");
		//"/Users/rohini/Documents/JavaCodes/jbkqaMavenProjV1/Drivers/chromedriver"
		
//		logger = LogManager.getLogger(BaseClass.class);
//		logger.info("This baseclass log");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		extent.attachReporter(spark);

			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			//driver = new ChromeDriver();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
		
		
		
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		extent.flush();
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver,String screenshotName)
	{
		
		try 
		{
			TakesScreenshot ts = ((TakesScreenshot)driver);
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("./Screenshots/"+screenshotName+System.currentTimeMillis()+".jpg"));
			System.out.println("Screenshot captured.");
		} catch (Exception e) 
		{
			System.out.println("Exception while taking screenshot "+e.getMessage());
			
		} 
		
	}
	
}
