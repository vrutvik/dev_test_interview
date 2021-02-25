package Test_FakeGoldBar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test_FakeGoldBar {
	public static int size = 9;
	public static int chunk = size/3;
	public static int i = 0;
	public static String result = "Yay! You find it!";
	public static int x = chunk;
	public static ChromeDriver driver;
	static void input_values() {
		int k;
		int j;
		for(k=i;k<x;k++) {
			String S = k+"";
		driver.findElementByXPath("//div[@class='board-row']//input[@id='left_"+S+"']").clear();
		driver.findElementByXPath("//div[@class='board-row']//input[@id='left_"+S+"']").sendKeys("value",""+k);
		}
		for(j = i ; j<x;j++) {
			String S2 = j+3+"";
			driver.findElementByXPath("//div[@class='board-row']//input[@id='right_"+j+"']").clear();
			driver.findElementByXPath("//div[@class='board-row']//input[@id='right_"+j+"']").sendKeys("value",""+S2+"");
		}
		driver.findElementByXPath("//*[@id='weigh']").click();
		String op = driver.findElementByXPath("//div[@class='result']//button[@id='reset']").getText();
		if(op.equals('=')) {
			driver.findElementByXPath("//button[.='Reset']").click();
			System.out.println("Reset");
			x=+3;
			i=+3;
			if(x>size) {
				System.exit(-1);
			}
			input_values();
		}
		else {
			check_values();
		
		}
		
	}
	static void check_values() {
		int q = i;
		for(q=i;q<chunk;q++) {
			driver.findElementByXPath("//*[@id='coin_"+q+"']").click();
			System.out.println("click on coin"+q);
			Alert al = driver.switchTo().alert();
			String Al_m = driver.switchTo().alert().getText();
			if(Al_m==result) {
				System.out.println("We got the results."+Al_m);
				System.exit(1);
			}
			al.accept();
			System.out.println("click on accept & checking values");
			check_values();
				//System.out.println("No Luck!");
		}
		input_values();	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 driver= new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver.get("http://ec2-54-208-152-154.compute-1.amazonaws.com/");
		driver.manage().window().maximize();
		driver.getTitle();
		input_values();
		//driver.findElementByXPath("//div[@class='board-row']//input[@id='right_"+S2+"']").sendKeys("value",""+k);
		}
}
		
		
