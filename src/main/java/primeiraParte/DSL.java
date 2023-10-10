package primeiraParte;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	private WebDriver driver; 
	
	
	
	public DSL(WebDriver driver) {
		super();
		this.driver = driver;
	}


	public void escreve(By element, String texto) {
		driver.findElement(element).clear();
		driver.findElement(element).sendKeys(texto);
	}
	public String obterValorCampo(By element, String texto) {
		return driver.findElement(element).getAttribute(texto);
	} // Todo recolhimento de atributo tem ser um metódo string e retornar algo
	
	public void clicaRadio (By element) {
		driver.findElement(element).click();
		
		
	}
	public boolean validaRadioClicado(By element) {
		return driver.findElement(element).isSelected();
	}
	public void selecionarCombo(By element, String texto) {
		WebElement selecionar = driver.findElement(element);
		Select combo = new Select(selecionar);
		combo.selectByVisibleText(texto);	
	}
	
	public String retornaValorCombo(By element) {
		WebElement selecionar = driver.findElement(element);
		Select combo = new Select(selecionar);
		return combo.getFirstSelectedOption().getText();
	}
	
	public void clicarBotao(By element) {
		driver.findElement(element).click();
	}
	public String pegaTexto(By element){
		return driver.findElement(element).getText();
	}
	public void abreAlertEPegaValor(By element, By element1) {
		
		driver.findElement(element).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		alert.accept();

		driver.findElement(element1).sendKeys(texto);
		
	}
	public String interageConfirmPegaTexto() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public void alertAceita() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		
	}
	public void alertNega() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		
		
		
	}
	public void alertEscreve(String texto) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(texto);
		
		
		
	}
	public boolean quantidadeDeSelecaoCombo(By elementT, String Txt1, String Txt2) {
		WebElement element = driver.findElement(elementT);
		Select comboMultiplo = new Select(element);
		comboMultiplo.selectByVisibleText(Txt1);
		comboMultiplo.selectByVisibleText(Txt2);
		// Da para o select ser feito assim :
		
		// new Select (driver.findElement(By.id("elementosForm:esportes"));)selectByVisibleText("Corrida");
		
		List<WebElement> allSelectOptions2 = comboMultiplo.getAllSelectedOptions();
		
		if(allSelectOptions2.size() == 2) {
			return true;
		}
		else {
			return false;
		}
		 
	}
	
	public String retornaValorAlert() {
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		alert.accept();
		return texto;
	}
	
public void  entraFrame(String nomeFrame, By element) {
	
	driver.switchTo().frame(nomeFrame); // Aqui ele entrou no contexto no frame
	driver.findElement(element).click(); // Para depois conseguir clicar em tal 
	
	
	
		
    }
	
	
	/**********JS ************/
	public Object executarJS(String cmd, Object...param) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeAsyncScript(cmd,param);
	}
	
/************** Tabela *********************/
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
		//procurar coluna do registro
		WebElement tabela = driver.findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		//procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		//clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		celula.findElement(By.xpath(".//input")).click();
		
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}
	
	// Estudar esse metodo depois é muito util
	
}
