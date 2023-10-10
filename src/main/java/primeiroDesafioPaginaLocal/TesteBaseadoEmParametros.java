package primeiroDesafioPaginaLocal;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import primeiraParte.DSL;

@RunWith(Parameterized.class)
public class TesteBaseadoEmParametros {

	
	private DSL dsl;
	private TesteBaseadoEmParametrosPage page;


	@Before
	public void Inicializa() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new TesteBaseadoEmParametrosPage(driver);
	
}

	@After
	public void finaliza() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.quit();
	
}
	@Parameter
	public String nome;
	@Parameter(value = 1)
	public String sobrenome;
	@Parameter(value = 2)
	public String sexo;
	@Parameter(value = 3)
	public String comida;
	/*@Parameter(value = 4)
	public String escolaridade;
	@Parameter(value = 5)
	public String esporte;
	@Parameter(value = 6)
	public String esporte2;
	@Parameter(value = 7)
	public String sugestao;*/
	@Parameter(value = 4)
	public String msg;
	
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {
			{"", "","", "", "Nome eh obrigatorio"},
			
			
			
		});
	}
	
	
	
	@Test

	public void preencheSucesso() {

		page.setNome(nome);
		page.setSobreNome(sobrenome);
		page.setSexo(sexo);
		page.setComidaFavorita(comida);
		//page.setEscolaridade(escolaridade);
		//page.setEsporte(esporte,esporte2);
		//page.setSugestoes(sugestao);
		page.clicarCadastrar();
		
		Assert.assertEquals(msg, page.pegaValorAlert());
		System.out.println(msg);
	
		
		
	}
	
	

}
