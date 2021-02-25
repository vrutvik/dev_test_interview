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
	public static ChromeDriver driver;
	static void input_values() {
		for(int k=i;k<chunk;k++) {
			String S = k+"";
		driver.findElementByXPath("//div[@class='board-row']//input[@id='left_"+S+"']").clear();
		driver.findElementByXPath("//div[@class='board-row']//input[@id='left_"+S+"']").sendKeys("value",""+k);
		}
		for(int j = i ; j<chunk;j++) {
			String S2 = j+3+"";
			driver.findElementByXPath("//div[@class='board-row']//input[@id='right_"+j+"']").clear();
			driver.findElementByXPath("//div[@class='board-row']//input[@id='right_"+j+"']").sendKeys("value",""+S2+"");
		}
	}
	static void check_values() {
		int q = i;
		while(q<=chunk) {
			driver.findElementByXPath("//*[@id='coin_"+q+"']").click();
			Alert al = driver.switchTo().alert();
			//driver.switchTo().alert().sendKeys("Text");
			String Al_m = driver.switchTo().alert().getText();
			al.accept();
			if(Al_m==result) {
				System.out.println("We got the results."+Al_m);
				break;
			}
			else{
				//al.accept();
				check_values();
				//System.out.println("No Luck!");
			}
			break;	
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 driver= new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver.get("http://ec2-54-208-152-154.compute-1.amazonaws.com/");
		driver.getTitle();
		
//		for(int k=i;k<chunk;k++) {
//			String S = k+"";
//		driver.findElementByXPath("//div[@class='board-row']//input[@id='left_"+S+"']").clear();
//		driver.findElementByXPath("//div[@class='board-row']//input[@id='left_"+S+"']").sendKeys("value",""+k);
//		}
//		for(int j = i ; j<chunk;j++) {
//			String S2 = j+3+"";
//			driver.findElementByXPath("//div[@class='board-row']//input[@id='right_"+j+"']").clear();
//			driver.findElementByXPath("//div[@class='board-row']//input[@id='right_"+j+"']").sendKeys("value",""+S2+"");
//		}
		input_values();
		driver.findElementByXPath("//*[@id='weigh']").click();
		String op = driver.findElementByXPath("//div[@class='result']//button[@id='reset']").getText();
		if(op.equals('=')) {
			i++;
			input_values();
		}
		else {
			i++;
			check_values();
		
	}
	
		//driver.findElementByXPath("//div[@class='board-row']//input[@id='right_"+S2+"']").sendKeys("value",""+k);
		}
}
		
		
