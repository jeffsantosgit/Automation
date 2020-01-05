package br.com.jefferson.selenium.aprendizado;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static void tirar(WebDriver navegador, String arquivo) {
		
		
		File screenshot = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(arquivo));
		} catch (IOException e) {
			
			System.out.println("Houveram problemas ao copiar o arquivo para a pasta" + e.getMessage());
			
			
		}
		

		
		
		
	}
	
	

}
