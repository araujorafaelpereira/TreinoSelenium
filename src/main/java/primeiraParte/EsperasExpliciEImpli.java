package primeiraParte;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EsperasExpliciEImpli {
    private WebDriver driver;


    @Before
    public void inicializa (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

    }

    @After
    public void finaliza(){
        driver.quit();

    }

    @Test
    public void deveUtilizarEsperaFixa() throws InterruptedException {
         //By bttn = By.id("buttonDelay");
        // By newArea = By.id("novoCampo");
     driver.findElement(By.id("buttonDelay")).click(); // Aqui a espera fica setada de forma fixa ,pode se dizer mais grosseira
        Thread.sleep(5000); // Aqui ele seta o tempo que ele quer que espere
     driver.findElement(By.id("novoCampo")).sendKeys("deu bom");
      // Aqui ele espera fixamente 5 secodundos mesmo se o elemento já apareceu
     // dsl.escreve(newArea, "Deu bom");



    }

    @Test
    public void deveUtilizarExplicita() throws InterruptedException {
        By bttn = By.id("buttonDelay");
        By newArea = By.id("novoCampo");
        driver.findElement(By.id("buttonDelay")).click(); // Aqui ele clica
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000)); //inicia o wait parametrizando uma epsera
        // A espera de 3000 milliseconds ou seja ele vai esperar esse elemento aparecer até 3 seconds
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("novoCampo"))); // Aqui setando o elemento
        driver.findElement(By.id("novoCampo")).sendKeys("deu bom");// Aqui escrevendo

        // Para elementos modernos estudar classe ExpectedConditions


    }


}
