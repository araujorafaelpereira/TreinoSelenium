package primeiroDesafioPaginaLocal;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsaJavascript {

	
@Test 
public void usaScroll() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	WebElement frame = driver.findElement(By.id("frame2"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeAsyncScript("window.scrollBy(0,arguments[0] )", frame.getLocation().y);// Aqui ele zera o argumento y assim referenciando ele como a localização do webelement frame
	 //mas se não quiser fazer assim é só passar o valor de cada dentro da DSL tem como fazer o page desse cara 
	 driver.findElement(By.id("frameButton")).click();
	 //driver.quit();
	
	
}



}
