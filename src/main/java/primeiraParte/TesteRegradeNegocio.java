package primeiraParte;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteRegradeNegocio {
	private TesteRegraDeNegocioPage page;
	
	
	WebDriver driver = new ChromeDriver();
	@Before
	public void iniciaBrowser() {
		WebDriverManager.chromedriver().setup();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

	}

	@After
	public void fechaBrowser() {
		WebDriverManager.chromedriver().setup();
		driver.quit();
	}
	@Test
	public void validaRegrasCampoNome () {
		page.clicaCadastrarSemNome();
	}
	@Test
	public void validaRegrasCampoSobrenome () {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Rafael");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		String erroSobrenomeObrigatorio = alert.getText();
		Assert.assertEquals("Sobrenome eh obrigatorio", erroSobrenomeObrigatorio);
		alert.accept();
	}
	@Test
	public void validaRegrasCampoSexo () {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Rafael");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Araujo");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		String erroSobrenomeObrigatorio = alert.getText();
		Assert.assertEquals("Sexo eh obrigatorio", erroSobrenomeObrigatorio);
		alert.accept();
	}
	@Test
	public void validaRegraVegetarianoNaoComeCarne() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Rafael");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Araujo");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		String erroVegeta = alert.getText();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", erroVegeta);
		alert.accept();
	}
	@Test
	public void validaRegraEsporte() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Rafael");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Araujo");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		// Da para ser escrito assim : Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("O que eh esporte?");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		String erroEsporte = alert.getText();
		Assert.assertEquals("Voce faz esporte ou nao?", erroEsporte);
		alert.accept();
	}
	
}
