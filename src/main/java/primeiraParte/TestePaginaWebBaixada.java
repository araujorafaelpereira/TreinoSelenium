package primeiraParte;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestePaginaWebBaixada {
	
	private WebDriver driver;
	private DSL dsl;
	@Before
	public void incializa() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		// O user.dir pega a raiz do projeto e adicionei o restante do projeto
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		//driver.quit();
		}
	
	// elementos 
	
		By campoNome = By.id("elementosForm:nome");
		By sugestoes = By.id("elementosForm:sugestoes");
		By radioSexo = By.id("elementosForm:sexo");
		By checkBoxAlimento = By.id("elementosForm:comidaFavorita:0");
		By comboEscolaridade = By.id("elementosForm:escolaridade");
		By comboEsportes = By.id("elementosForm:esportes");
		By botaoObrigado = By.id("buttonSimple");
		By linkClick = By.linkText("Voltar");
		By alert = By.id("alert");
		By alertConfirm = By.id("confirm");
		By alertPrompt = By.id("prompt");
		
		
	
	
	
	
	@Test
	public void testeTextField() {
		
		dsl.escreve(campoNome, "Rafael");
		// Em cima ele escreveu rafael
		// Abaixo ele queria rafael e verificou se o que foi escrito foi rafal pegando o
		// valeu do textfield
		Assert.assertEquals("Aqui valida", "Rafael", dsl.obterValorCampo(campoNome, "value"));
		
	}

	@Test

	public void testeTextArea() {

		dsl.escreve(sugestoes, "Lá vai a sugestão");
		Assert.assertEquals("Lá vai a sugestão", dsl.obterValorCampo(sugestoes, "value"));
		

	}

	@Test
	public void testeRadioButtom() {

		dsl.clicaRadio(radioSexo);
		Assert.assertTrue(dsl.validaRadioClicado(radioSexo));// Verifica se está
																							// selecionado
		
	}

	@Test
	public void testeCheckBox() {

	
		dsl.clicaRadio(checkBoxAlimento);
		Assert.assertTrue(dsl.validaRadioClicado(checkBoxAlimento));// Verifica se está
																									// selecionado
		
	}

	@Test
	public void testeInteragirComCombo() {

		
		dsl.selecionarCombo(comboEscolaridade,"2o grau incompleto");// Aqui ele aponta o elemento da
		Assert.assertEquals("2o grau incompleto",dsl.retornaValorCombo(comboEscolaridade));
		
		// pagina como um web elemento
		 // Aqui ele mostra que é um combo/select e coloca o web elemento dentro dele
//		combo.selectByIndex(2); com esse web elemento dentro do combo conseguir manusear a seleção com funções pré criadas
//		combo.selectByValue("superior"); Aqui pelo value que está dentro do HTML 
		// Aqui pega o texto vísivel
		

	}

	@Test
	public void testeVerificarValoresCombo() {

		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));// Aqui ele aponta o elemento da
																						// pagina como um web elemento
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());

		boolean encontrou = false;
		for (WebElement option : options) {
			if (option.getText().equals("doutorado")) {
				encontrou = true;
				break;

			}

		}
		Assert.assertTrue(encontrou);
		
	}

	@Test
	public void deveVerificarValorComboMultiplo() {
		
		
		dsl.selecionarCombo(comboEsportes, "Natacao");
		dsl.selecionarCombo(comboEsportes, "Corrida");
		
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		

		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals("Quantos tem selecionado no combo", 3, allSelectedOptions.size());

		combo.deselectByVisibleText("corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals("Quantos tem selecionado no combo", 2, allSelectedOptions.size());
		

	}

	@Test
	public void deveInteragirComBotoes() {
		
		dsl.clicarBotao(botaoObrigado);
		Assert.assertEquals("Ver se botão alterou valor", "Obrigado!", dsl.obterValorCampo(botaoObrigado, "value"));
		

	}

	@Test
	// @ignore ignora o CT que está com a tag
	public void deveInteragirComLinks() {
		
		dsl.clicarBotao(linkClick);

		Assert.assertEquals("Voltou!", dsl.pegaTexto(linkClick));

	}

	@Test
	public void deveBuscarTextosNaPagina() {
		

		// Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo
		// de treinamento ");
		// Acima ele busca todo os todos do body do html e transforma em uma string e
		// depois busca na string

		Assert.assertEquals("Campo de treinamento", driver.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
				driver.findElement(By.className("facilAchar")).getText());

	}

	@Test

	public void testeAlert() {
		

		dsl.abreAlertEPegaValor(alert, campoNome);

		
	}

	@Test

	public void interagindoConfirm() {
		
		dsl.clicarBotao(alertConfirm);
		String primeiroValorAlert = dsl.interageConfirmPegaTexto(); // Aqui ele pega a instancia alert dentro do selenium que contem varios parametros de HTML
		Assert.assertEquals("Confirm Simples", primeiroValorAlert);
		System.out.println(primeiroValorAlert);// Aqui pega o texto do alerta
		dsl.alertAceita();
		String segundoValorAlert = dsl.interageConfirmPegaTexto();
		Assert.assertEquals("Confirmado", segundoValorAlert);
		dsl.alertAceita();
		
		dsl.clicarBotao(alertConfirm);
		String terceiroValorAlert = dsl.interageConfirmPegaTexto();
		Assert.assertEquals("Confirm Simples", terceiroValorAlert);
		dsl.alertNega();
		String quartoValorAlert = dsl.interageConfirmPegaTexto();
		Assert.assertEquals("Negado", quartoValorAlert);
		dsl.alertNega();
		
		

	}
	
	@Test
	
	public void interageComAlertPrompt () {
		
		
		dsl.clicarBotao(alertPrompt);
		String primeiroValorAlert = dsl.interageConfirmPegaTexto();
		Assert.assertEquals("Digite um numero", primeiroValorAlert);
		dsl.alertEscreve("12");
		dsl.alertAceita();
		String segundoValorAlert = dsl.interageConfirmPegaTexto();
		Assert.assertEquals("Era 12?", segundoValorAlert);
		dsl.alertAceita();
		String terceiroValorAlert = dsl.interageConfirmPegaTexto();
		Assert.assertEquals(":D", terceiroValorAlert);
		dsl.alertAceita();		// driver.quit();
		
		
	}

	@Test
	public void testeLimpaInput() {
		dsl.escreve(campoNome, "rafael");
		Assert.assertEquals("rafael", dsl.obterValorCampo(campoNome, "value"));
		dsl.escreve(campoNome, "jão");
		Assert.assertEquals("rafael", dsl.obterValorCampo(campoNome, "value"));
		
		
		
	}
	@Test
	public void deveClicarBotaoTabela() {
		
		dsl.clicarBotaoTabela("Escolaridade", "Mestrado", "Radio", "elementosForm:tableUsuarios");
		
		
		
	}
}
