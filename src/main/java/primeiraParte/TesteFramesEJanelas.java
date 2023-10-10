package primeiraParte;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteFramesEJanelas {
	private WebDriver driver;
	@Before
	public void incializa() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		// O user.dir pega a raiz do projeto e adicionei o restante do projeto
	}
	
	@After
	public void finaliza() {
		driver.quit();
		}
	
	
	
	
    @Test
	public void  deveInteragirComFrames () {
	
    	
		driver.switchTo().frame("frame1"); // Aqui ele entrou no contexto no frame
		driver.findElement(By.id("frameButton")).click(); // Para depois conseguir clicar em tal 
		Alert alert = driver.switchTo().alert(); // O frame liberava um alerta
		String msg = alert.getText(); // pegou a mensagem desse alerta
		Assert.assertEquals("Frame OK!", msg); // Validou se era a mensagem esperada
		alert.accept();// aceitou o frame 
		
		driver.switchTo().defaultContent(); // Voltou para o contexto do primeiro html
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg); // escreveu a mensagem do frame no nome 
    	
	}

    
    
    @Test
	public void  deveInteragirComPopUpComTitulo () {
	
    	
    
		
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");// Aqui o Popup tinha titulo ele entra na Popup
		System.out.println(driver.getWindowHandle()); // Aqui ele escreve o identificador das janelas abertas
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo ?");// Aqui ele escreve a Popup
		driver.close();// Aqui ele fecha apenas a Popup
		driver.switchTo().window(""); // se localiza para janela default
		driver.findElement(By.tagName("textarea")).sendKeys("E agora ?"); // Aqui escreve no text area da janela default
		
		
		
		
		
		
    }
    
   
    
    @Test
	public void  deveInteragirComPopUpSemTitulo () {
	
    	
    
		driver.findElement(By.id("buttonPopUpHard")).click(); // Aqui ele clicka nno botão para gerar o Popup
		System.out.println(driver.getWindowHandles()); // Aqui escreve no console o localizador da janela de uma só 
		System.out.println(driver.getWindowHandles());// Aqui escreve no console o localizador de todas janela de uma só 
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]); // Como o localizar se alter sempre em todos os testes
		// Ele colocou os localizadores em um array e selecionou o primeiro
		driver.findElement(By.tagName("textarea")).sendKeys("deu certo ?"); // Escreveu no popup
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]); // Aqui selecinou a janela dafault pelo array e escreveu
		driver.findElement(By.tagName("textarea")).sendKeys("E agora ?");
		driver.quit(); // Fecha todas as instancias do navegador 
    }
    
}
