package windowhandle;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {
	WebDriver driver;
	
	@Test
	public void windowHangle() throws InterruptedException {
		
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("xpath");
		String handle1 =driver.getWindowHandle();	//getting the string code of a window
		System.out.println(handle1);
//		Set<String> handlea = driver.getWindowHandles();	//get the string window code of current page:
//		System.out.println(handlea);
		
		driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
		String handle2 =driver.getWindowHandle();
		System.out.println(handle2);
//		Set<String> handleb = driver.getWindowHandles();	
//		System.out.println(handleb);
		
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
//		driver.findElement(By.linkText("www.w3schools.com")).click();
		
		driver.findElement(By.xpath("//a[contains(text(), 'XPath Tutorial - W3Schools')]")).click();
		Set<String> handle3 =driver.getWindowHandles();
		System.out.println(handle3);
		
//		Set<String> handlec = driver.getWindowHandles();	
//		System.out.println(handlec);
		
//		driver.findElement(By.xpath("//a[contains(text(), 'XPath Tutorial - W3Schools')]/child::span")).click();
		
		//print window codes separately
		System.out.println(driver.getTitle());
		for(String i: handle3) {
			System.out.println(i);
			driver.switchTo().window(i);
		}
		
	}
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		driver = new ChromeDriver();	//remove WebDriver
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.yahoo.com/");
		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
