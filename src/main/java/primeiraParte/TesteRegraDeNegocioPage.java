package primeiraParte;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TesteRegraDeNegocioPage {
	private DSL dsl;
	
	public  TesteRegraDeNegocioPage(WebDriver driver) {
		 dsl = new DSL(driver);
		}
	//Elementos da tela
	public By primeiroNome = By.id("elementosForm:nome");
	public By segundoNome = By.id("elementosForm:sobrenome");
	public By sexoMasculino = By.id("elementosForm:sexo:0");
	public By sexoFeminino = By.id("elementosForm:sexo:1");
	public By comidaCarne = By.id("elementosForm:comidaFavorita:0");
	public By comidaFrango = By.id("elementosForm:comidaFavorita:0");
	public By comidaPizza = By.id("elementosForm:comidaFavorita:0");
	public By comidaVegetariano = By.id("elementosForm:comidaFavorita:0");
	public By comboEscolaridade = By.id("elementosForm:escolaridade");
	public By comboPraticaEsporte = By.id("elementosForm:esportes");
	public By campoSugestoes = By.id("elementosForm:sugestoes");
	public By botaoCadastrar = By.id("elementosForm:cadastrar");
	
	
	
	public void clicaCadastrarSemNome() {
		dsl.clicarBotao(botaoCadastrar);
		Assert.assertEquals("Nome eh obrigatorio", dsl.retornaValorAlert());
		
		
	}
}
