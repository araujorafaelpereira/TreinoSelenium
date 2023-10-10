package primeiroDesafioPaginaLocal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import primeiraParte.DSL;

public class PreenchimentoComSucesso {
	private PreenchimentoComSucessoPage page;


	@Before
	public void Inicializa() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		new DSL(driver);
		page = new PreenchimentoComSucessoPage(driver);
	
}

	@After
	public void finaliza() {
		/*WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.quit();*/
	
}

	@Test

	public void preencheSucesso() {

		// Preenche nome
		page.setNome("Rafael");
		// Preenche sobrenome
		page.setSobreNome("Araujo");
		// Escolhe sexo
		page.setSexo("Masculino");
		// Escolhe comida preferida

		page.setComidaFavorita("Carne");
		// Escole escolaridade

		page.setEscolaridade("Doutorado");

		// Seleciona pratica de esportes

		page.setEsporte("Natacao", "Corrida");

		// Preenche sugestões
		page.setSugestoes("Sugiro esforço total");

		// Clicar em cadastrar

		page.clicarCadastrar();

		// verifica retorno cadastrado
		//page.validaRespostaDoValoresPreenchidos();
		/*Assert.assertTrue(driver.findElement(By.id("descNome")).getText().contains("Rafael"));
		Assert.assertTrue(driver.findElement(By.id("descSobrenome")).getText().contains("Araujo"));
		Assert.assertTrue(driver.findElement(By.id("descSexo")).getText().contains("Masculino"));
		Assert.assertEquals("Carne",driver.findElement(By.xpath("//span[contains(text(), 'Carne')]")).getText());
		Assert.assertTrue(driver.findElement(By.id("descEscolaridade")).getText().contains("doutorado"));
		Assert.assertEquals("Natacao Corrida",driver.findElement(By.xpath("//span[contains(text(),  'Natacao  Corrida ')]")).getText());
		Assert.assertTrue(driver.findElement(By.id("descSugestoes")).getText().contains("Sugiro esforço total"));*/
	
	// Algun locators foi necessario a utilizaçao de xpath quando ficar dificil buscar na tabela de locators
	
		// Reajustar codigo com acerções 
		
		
	}
	
	@Test
	public void testJavascript() {
		
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeAsyncScript("alert('Testando js via selenium')");
		js.executeAsyncScript("document.getElementById('elementosForm:nome').value = 'Escrito via JS'");*/
		

		
		
		
	}
	
	
	
	
}
