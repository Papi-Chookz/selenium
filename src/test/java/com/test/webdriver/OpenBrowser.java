package com.test.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		String base_url = "https://bcx--uat.sandbox.my.salesforce.com/";
		String account_url = "lightning/o/Account/home/";
		String new_account_xpath  = "//a[@title='New']";
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		
		driver.get(base_url);
		
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("remano.morgan@bcx.co.za.uat");
		driver.findElement(By.id("password")).sendKeys("yy!$IKn&5rG7");
		driver.findElement(By.id("Login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("App Launcher"));
			
		driver.navigate().to(base_url + account_url);
		
		System.out.println("Account URL: " + base_url + account_url);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(new_account_xpath)));
	
		driver.findElement(By.xpath(new_account_xpath)).click();	
		Thread.sleep(5000);		
		driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/records-modal-lwc-detail-panel-wrapper[1]/records-record-layout-event-broker[1]/slot[1]/records-lwc-detail-panel[1]/records-base-record-form[1]/div[1]/div[2]/div[1]/div[1]/records-lwc-record-layout[1]/forcegenerated-detailpanel_account___0124i000000vlbpqac___full___create___recordlayout2[1]/records-record-layout-block[1]/slot[1]/records-record-layout-section[1]/div[1]/div[1]/div[1]/slot[1]/records-record-layout-row[1]/slot[1]/records-record-layout-item[1]/div[1]/span[1]/slot[1]/records-record-layout-base-input[1]/lightning-input[1]/div[1]/div[1]/input[1]")).sendKeys("TFT");		
		Thread.sleep(5000);		
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();	
		System.out.println(System.getProperty("account.name"));    

	}
	
	
}
