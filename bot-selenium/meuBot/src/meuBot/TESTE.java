package meuBot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
 
public class TESTE {
 
    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException{
         
    	WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe"); //navegador e endereço do driver do navegador
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qacad.ifma.edu.br/qacademico/index.asp?t=1001"); //link do site para login
        WebElement userLogin = driver.findElement(By.name("LOGIN")); //nome do campo de texto para login
        userLogin.sendKeys("seu-login"); //o login
        WebElement userSenha = driver.findElement(By.name("SENHA")); //nome do campo de texto para senha
        userSenha.sendKeys("sua-senha"); //a senha
        userSenha.sendKeys(Keys.ENTER);
        driver.get("https://qacad.ifma.edu.br/qacademico/index.asp?t=2032"); //alguma pagina interna do sistema (opcional)
 
    }
 
}
