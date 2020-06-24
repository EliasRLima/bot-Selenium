package meuBot;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
 
public class ComboBox {
 
    /**
     * @param args
     */
	static ArrayList<String> texto = new ArrayList<String>();
    public static void main(String[] args) throws InterruptedException{        
    	WebDriver driver = entrarNosite();
        WebElement div = driver.findElement(By.xpath("//div[@class=\"tab vertical tab-veiculos\"]"));
        WebElement ul = div.findElement(By.tagName("ul"));
        List<WebElement> links = ul.findElements(By.tagName("li"));
        WebElement li;
        List<WebElement> lisb;
        List<WebElement> lisc; 
        List<WebElement> lisa;
        WebElement botao, barra_li3, barra_li2, barra_li, div21, cb2, barra2, barra_ul2,div31, cb3;
        WebElement barra3,barra_ul3,interna,article,form,div1,div2,div3,cb,barra,barra_ul;
        for (int i = 0; i < links.size(); i++)
        {
        	li = links.get(i);
            if(li.getText().equals("Consulta de Carros e Utilitários Pequenos")) {
            	li.click();
            	interna = li.findElement(By.xpath("//div[@class=\"tab horizontal inside\"]"));
            	article = interna.findElement(By.xpath("//article[@class=\"open inside-search\"]"));
            	form = article.findElement(By.xpath("//div[@class=\"form\"]"));
            	clickEmA(form,1);
            	//clickEmB(form,1);
            	System.out.println(tamanhoDeB(form));
            	for(int b=1;b<=tamanhoDeB(form);b++) {
            		clickEmB(form,b,1);
            	}
            		
            	}         
        }
        for(int cont = 0; cont < ComboBox.texto.size();cont++) {
        	System.out.println(ComboBox.texto.get(cont));
        }

    }
    
    public static WebDriver entrarNosite() {
    	WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://veiculos.fipe.org.br");
        WebElement html = driver.findElement(By.tagName("html"));
        for(int d = 0; d < 40; d++) {
        	html.sendKeys(Keys.DOWN);
        }
        return driver;
    }
    
    public static int tamanhoDeB(WebElement form) {
    	WebElement div21 = form.findElement(By.xpath("//div[@id=\"selectAnoModelocarro_chosen\"]"));
    	WebElement cb2 = div21.findElement(By.xpath("//a[@class=\"chosen-single chosen-default\"]"));
    	cb2.click();
    	WebElement barra2 = div21.findElement(By.xpath("//div[@class=\"chosen-drop\"]"));
    	WebElement barra_ul2 = barra2.findElement(By.xpath("//ul[@class=\"chosen-results\"]"));
    	List<WebElement> array = barra_ul2.findElements(By.xpath("//li[@data-option-array-index]"));
    	return array.size();
    }
    public static int tamanhoDeC(WebElement form) {
    	WebElement div31 = form.findElement(By.xpath("//div[@id=\"selectAnocarro_chosen\"]"));
		WebElement cb3 = div31.findElement(By.xpath("//a[@class=\"chosen-single chosen-default\"]"));
        cb3.click();
        WebElement barra3 = div31.findElement(By.xpath("//div[@class=\"chosen-drop\"]"));
    	WebElement barra_ul3 = barra3.findElement(By.xpath("//ul[@class=\"chosen-results\"]"));
		List<WebElement> array = barra_ul3.findElements(By.xpath("//li[@data-option-array-index]"));
		return array.size();
    }
    
    public static void clickEmA(WebElement form, int loop) {
    	WebElement div1 = form.findElement(By.xpath("//div[@class=\"step-1\"]"));
    	WebElement div2 = div1.findElement(By.xpath("//div[@class=\"input\"]"));
    	WebElement div3 = div2.findElement(By.xpath("//div[@class=\"chosen-container chosen-container-single\"]"));
    	WebElement cb = div3.findElement(By.xpath("//a[@class=\"chosen-single chosen-default\"]"));
    	cb.click();
    	WebElement barra = div3.findElement(By.xpath("//div[@class=\"chosen-drop\"]"));
    	WebElement barra_ul = barra.findElement(By.xpath("//ul[@class=\"chosen-results\"]"));
    	WebElement barra_li = barra_ul.findElement(By.xpath("//li[@data-option-array-index=\""+(loop)+"\"]"));
    	barra_li.click();
    }
    
    public static void clickEmB(WebElement form, int loop,int loopa) {
    	try {
    		WebDriver driver = entrarNosite();
	        WebElement div = driver.findElement(By.xpath("//div[@class=\"tab vertical tab-veiculos\"]"));
	        WebElement ul = div.findElement(By.tagName("ul"));
	        List<WebElement> links = ul.findElements(By.tagName("li"));
	        WebElement li;

	        for (int i = 0; i < links.size(); i++)
	        {
	        	li = links.get(i);
	            if(li.getText().equals("Consulta de Carros e Utilitários Pequenos")) {
	            	li.click();
	            	WebElement interna = li.findElement(By.xpath("//div[@class=\"tab horizontal inside\"]"));
	            	WebElement article = interna.findElement(By.xpath("//article[@class=\"open inside-search\"]"));
	            	form = article.findElement(By.xpath("//div[@class=\"form\"]"));
	            	clickEmA(form,loopa);
	            	WebElement div21 = form.findElement(By.xpath("//div[@id=\"selectAnoModelocarro_chosen\"]"));
	            	WebElement cb2 = div21.findElement(By.xpath("//a[@class=\"chosen-single chosen-default\"]"));
	            	cb2.click();
	            	WebElement barra2 = div21.findElement(By.xpath("//div[@class=\"chosen-drop\"]"));
	            	WebElement barra_ul2 = barra2.findElement(By.xpath("//ul[@class=\"chosen-results\"]"));
	            	WebElement barra_li2 = barra_ul2.findElement(By.xpath("//li[@data-option-array-index=\""+(loop)+"\"]"));            	
	            	barra_li2.click();
	            	System.out.println(tamanhoDeC(form));
	            		for(int c=1;c<=tamanhoDeC(form);c++) {	
	            			clickEmC(form,c,loopa,loop);                    	
	            		}
	            		driver.close();
	            	}         
	        }
    	}catch(Exception e) {
    		
    	}
    }
    
    public static void clickEmC(WebElement form, int loop,int loopa, int loopb) {
    	try {
    		    WebDriver driver = entrarNosite();
    	        WebElement div = driver.findElement(By.xpath("//div[@class=\"tab vertical tab-veiculos\"]"));
    	        WebElement ul = div.findElement(By.tagName("ul"));
    	        List<WebElement> links = ul.findElements(By.tagName("li"));
    	        WebElement li;

    	        for (int i = 0; i < links.size(); i++)
    	        {
    	        	li = links.get(i);
    	            if(li.getText().equals("Consulta de Carros e Utilitários Pequenos")) {
    	            	li.click();
    	            	WebElement interna = li.findElement(By.xpath("//div[@class=\"tab horizontal inside\"]"));
    	            	WebElement article = interna.findElement(By.xpath("//article[@class=\"open inside-search\"]"));
    	            	form = article.findElement(By.xpath("//div[@class=\"form\"]"));
    	            	clickEmA(form,loopa);
    	            	clickEmB(form,loopb, loopa);
    	            	System.out.println(tamanhoDeC(form));
    	            		for(int c=1;c<=tamanhoDeC(form);c++) {
    	            			WebElement div31 = form.findElement(By.xpath("//div[@id=\"selectAnocarro_chosen\"]"));
    	                		WebElement cb3 = div31.findElement(By.xpath("//a[@class=\"chosen-single chosen-default\"]"));
    	                        cb3.click();
    	                        WebElement barra3 = div31.findElement(By.xpath("//div[@class=\"chosen-drop\"]"));
    	                    	WebElement barra_ul3 = barra3.findElement(By.xpath("//ul[@class=\"chosen-results\"]"));
    	                		WebElement barra_li3 = barra_ul3.findElement(By.xpath("//li[@data-option-array-index=\""+(loop)+"\"]"));
    	                    	barra_li3.click();
    	                    	
    	                    	WebElement botao = form.findElement(By.xpath("//a[@id=\"buttonPesquisarcarro\"]"));
    	                    	botao.click();
    	                    	
    	                    	WebElement tabela = form.findElement(By.xpath("//table"));
    	                    	ComboBox.texto.add(tabela.getText()+"\n-----------------------------------------------------------------\n");
    	                    	
    	                    	driver.close();
    	            		}
    	            	}         
    	        }
    		
        	
		}catch(Exception e) {
			System.out.println("");
		}
    }
}
