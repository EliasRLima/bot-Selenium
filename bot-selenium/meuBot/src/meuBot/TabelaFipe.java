package meuBot;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;

public class TabelaFipe {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
	    System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    ArrayList<String> texto = new ArrayList<String>();
	    for(int carros = 1; carros <= 212;carros++) {
	    	driver.get("http://fipeapi.appspot.com/api/1/carros/veiculos/"+carros+".json");
	    	texto.add(driver.findElement(By.xpath("//body")).getText());
	    	new Thread();
			Thread.sleep(1000);
	    }
	    driver.close();
	    
	    for(int i = 0;i<texto.size();i++) {
	    	System.out.println(texto.get(i));
	    }
	}
}
