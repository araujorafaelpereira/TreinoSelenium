package primeiroDesafioPaginaLocal;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import primeiraParte.DSL;

public class TesteBaseadoEmParametrosPage {
	private DSL dsl;
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
	public By retornoNome = By.id("descNome");
	public By retornoSobrenome = By.id("descSobrenome");
	public By retornoSexo = By.id("descSobrenome");
	public By retornoComidaCarne = By.xpath("//span[contains(text(), 'Carne')]");
	public By retornoEscolaridade = By.id("descEscolaridade");
	public By retornoEsportes = By.xpath("//span[contains(text(),  'Natacao  Corrida ')]");
	public By retornoSugestões = By.id("descSugestoes");
	
	
	
	
	
	public  TesteBaseadoEmParametrosPage(WebDriver driver) {
	 dsl = new DSL(driver);
	}
	

	public void setNome(String nome) {
		dsl.escreve(primeiroNome, nome);
		
	}
	
	public void setSobreNome( String sobrenome) {
		dsl.escreve(segundoNome, sobrenome);
		
		
	}
	public void setSexo (String valor) {
		
		if(valor == "Masculino") {
		dsl.clicaRadio(sexoMasculino);
		Assert.assertTrue(dsl.validaRadioClicado(sexoMasculino));
		}else {
			dsl.clicaRadio(sexoFeminino);
			Assert.assertTrue(dsl.validaRadioClicado(sexoFeminino));
		}
		
		
	}
	
public void setComidaFavorita (String valor) {
		
		if(valor == "Carne") {
		dsl.clicaRadio(comidaCarne);
		Assert.assertTrue(dsl.validaRadioClicado(comidaCarne));
		}else if(valor == "Frango") {
			dsl.clicaRadio(comidaFrango);
			Assert.assertTrue(dsl.validaRadioClicado(comidaFrango));
		}else if(valor == "Pizza") {
			dsl.clicaRadio(comidaPizza);
			Assert.assertTrue(dsl.validaRadioClicado(comidaPizza));
		}else if(valor == "Vegetariano") {
			dsl.clicaRadio(comidaVegetariano);
			Assert.assertTrue(dsl.validaRadioClicado(comidaVegetariano));
		}
		
		
	}
		public void setEscolaridade(String valor) {
			dsl.selecionarCombo(comboEscolaridade, valor);

			
}			
		public void setPraticaEsporte(String valor) {
			dsl.selecionarCombo(comboEscolaridade, valor);

			
}	
		public void setEsporte(String valor, String valorTwo) {
			
			dsl.quantidadeDeSelecaoCombo(comboPraticaEsporte , valor, valorTwo);
			
			
			
		}
		public void setSugestoes(String valor) {
			dsl.escreve(campoSugestoes, valor);
			
			//Assert.assertEquals(valor, dsl.pegaTexto(campoSugestoes));
			
			
		}
		
		public void clicarCadastrar() {
			dsl.clicarBotao(botaoCadastrar);
		}
		 public void validaRespostaDoValoresPreenchidos() {
			 
			 Assert.assertEquals(dsl.pegaTexto(primeiroNome),dsl.pegaTexto(retornoNome));
			 
			 // Seguir refatorando o código e tentar montar suite de testes 
			 
			 
			 
		 }
		 /*public void validarRetornoDosDados() {
			 
			 Assert.assertTrue(dsl.pegaTexto(retornoNome).contains("Rafael"));
			 Assert.assertTrue(dsl.pegaTexto(retornoSobrenome).contains("Araujo"));
			 Assert.assertTrue(dsl.pegaTexto(retornoSexo).contains("Masculino"));
			 Assert.assertEquals("Carne",dsl.pegaTexto(retornoComidaCarne));
			 Assert.assertTrue(dsl.pegaTexto(retornoEscolaridade).contains("doutorado"));
			 Assert.assertEquals("Natacao Corrida",dsl.pegaTexto(retornoEsportes));
			 Assert.assertTrue(dsl.pegaTexto(retornoSugestões).contains("Sugiro esforço total"));
			 
			 
		 }*/
		 
		 public String pegaValorAlert() {
			String txt = dsl.retornaValorAlert();
			 return txt;
		 }
		 
		
}
