package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchUrl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "C:\\EclipseWorkingDirectory\\seleniumProject\\src\\test\\resources\\drivers\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://www.browserstack.com");
System.out.println("URL launch");
driver.close();
System.out.println("URL closed");
	}

}
