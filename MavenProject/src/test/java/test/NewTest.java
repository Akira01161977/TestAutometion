package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest {
	
	public WebDriver driver;
	
  @Test(priority=0)
  public void openUrl() {
	driver.get("http://13.93.116.170:8080/login");
	String title = driver.getTitle();
	String page=driver.getPageSource();
	System.out.println(page);
	Assert.assertTrue(title.contains("Sign in [Jenkins]"));
  }
  
  @Test(priority=1)
  public void Login() {
	  driver.findElement(By.name("j_username")).sendKeys("admin");
  	  driver.findElement(By.name("j_password")).sendKeys("7UuCMjJYGZ");
  	  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  driver.findElement(By.name("Submit")).click();
	  
	  Assert.assertEquals("Cruscotto [Jenkins]",driver.getTitle());
  }
  
  @Test(priority=2)
  public void NewElement() {
	  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  driver.findElement(By.linkText("Nuovo Elemento")).click();
	  Assert.assertEquals("Nuovo Elemento [Jenkins]",driver.getTitle());
	  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  String jobName="TestAutomation";
	  driver.findElement(By.name("name")).sendKeys("TestAutomation");
  	  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	  driver.findElement(By.className("org_jenkinsci_plugins_workflow_job_WorkflowJob")).click();
	  driver.findElement(By.id("ok-button")).click();
	  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	  
	  Assert.assertEquals(jobName+" Config [Jenkins]",driver.getTitle());
	  
  }
  
  @Test(priority=3)
  public void DeleteElement() {
	  String jobName="TestAutomation";
	  driver.findElement(By.linkText(jobName)).click();
	  Assert.assertEquals(jobName+" [Jenkins]",driver.getTitle());
	  driver.findElement(By.linkText("Elimina Pipeline")).click();
	  
	  	  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  	driver.switchTo().alert().accept();
	  	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  	  
			  
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
	  driver = new ChromeDriver();
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}