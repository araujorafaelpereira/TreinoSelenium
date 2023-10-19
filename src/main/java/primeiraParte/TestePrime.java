package primeiraParte;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.By.*;

public class TestePrime {
    private WebDriver driver;
    private DSL dsl;

    public By radioXbox = By.xpath("//input[@id= 'j_dt86:console:0']/../..//span");
    public By radioPS4 = By.xpath("//label[.='PS4']/..//span");
    @Before
    public void inicializa (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xthml");
        dsl = new DSL(driver);
    }

    @After
    public void finaliza(){
    driver.quit();

    }

    @Test
    public void deveInteragirComRadioPrime(){
    dsl.clicaRadio(radioXbox);
    dsl.clicaRadio(radioPS4);



    }




}
