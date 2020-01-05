package br.com.jefferson.selenium.aprendizado;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Teste {
private WebDriver navegador;
	
	
	
	
	@Before
	public void testParaValidarAcesso() {
	


			// Abrindo o navegador
			System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");

			/*
			 * WebDriver driver = new ChromeDriver();
			 * driver.get("http://www.google.com/xhtml"); WebElement searchBox =
			 * driver.findElement(By.name("q")); searchBox.sendKeys("ChromeDriver");
			 * searchBox.submit();
			 */
			navegador = new ChromeDriver();
			navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			navegador.get("http://www.juliodelima.com.br/taskit");		
			
			navegador.findElement(By.linkText("Sign in")).click();


			 //Identificando o formulário de login
			  WebElement formularioSignin = navegador.findElement(By.id("signinbox"));
			  
			//Digitar no campo com name "login" que está dentro do formulário de id "sign inbox" o texto "julio0001"		  
			 formularioSignin.findElement(By.name("login")).sendKeys("julio0001");
			  
			// Digitar no campo com name "password" que está dentro do formulário de "sign inbox" o texto "123456"
			formularioSignin.findElement(By.name("password")).sendKeys("123456");
			  
			//Clicar no link com o texto "SIGN IN"
			formularioSignin.findElement(By.linkText("SIGN IN")).click();
			
			//Validar que dentro do elemento com class "me" está o texto "Hi, Julio"
			
			/*WebElement me = navegador.findElement(By.className("me"));
			String textoNoElemento = me.getText();
			Assert.assertEquals("Hi, Julio",  textoNoElemento);*/
			
			//Clicar em um link que possua a class "me"
			navegador.findElement(By.className("me")).click();
			
			
			
			
			// Clicar em um link que possua o texto "more data about you"
			navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
			
		}

	
	@Test
	public void incluirDadosUsuario(){
	
	
		// Clicar no link que possui o texto "Sign in"
		  
		  
		
		
		//Clicar no botão  "*add more data" através do seu xpath //button[@data-target="addmoredata"]
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
		
		
		//identificar popup onde está o formulário de id "addmoredata"
		WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

	
		
		//na combo de name type escolher a opção "Phone"
		WebElement campoType = popupAddMoreData = navegador.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText("Phone");
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		// Colocar no campo de name contact digitar o +5599999999999
		popupAddMoreData.findElement(By.xpath("//input[@name=\"contact\"]")).sendKeys("teste");
		
		//clicar no link de text save que está na popup
		popupAddMoreData.findElement(By.xpath("//*[@id=\"addmoredata\"]/div[2]/a")).click();
		
	   //na mensagem de id toast container, validar que o texto "your contact has been added"
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		Assert.assertEquals("Your contact has been added!", mensagem);
		
		
		}
	
	
	/*@Test
	public void removerContatoUsuario() {
	//clicar no elemento pelo xpath "//span[text()="teste"]/following-sibling::a"
		navegador.findElement(By.xpath("//span[text()=\"teste\"]/following-sibling::a")).click();
		
	//confirmar a janela javascript
	navegador.switchTo().alert().accept();
	
		
	// confirmar que a mensagem foi "Rest in peace, dear phone!"
	WebElement popupmensagem = navegador.findElement(By.id("toast-container"));
	String mensagem = popupmensagem.getText();
	Assert.assertEquals("Rest in peace, dear phone!", mensagem);
	
	//String screenshotArquivo = "C:/Users/CASA/Documentos" + Gerador.dataScreenshot() + test.getMethodName() + ".png";
	//Screenshot.tirar(navegador, screenshotArquivo);
		
	// Aguardar até 10 segundo para que a janela desapareça
	WebDriverWait esperar = new WebDriverWait(navegador, 10);
	esperar.until(ExpectedConditions.stalenessOf(popupmensagem));
	
	
		
	//fazer logout
	navegador.findElement(By.linkText("Logout")).click();	
		
		
	}*/
	

	
	
	
	@After
	public void tearDown() {
	
		//Fechar o navegador
		//navegador.quit();
	}
}


