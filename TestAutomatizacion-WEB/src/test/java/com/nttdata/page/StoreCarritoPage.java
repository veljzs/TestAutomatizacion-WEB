package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StoreCarritoPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By tituloCarritoElemento = By.xpath("//div[@class=\"card-block\"]/h1");
    private By precioActualUnidad = By.xpath("//span[@class=\"price\"]");
    private By precioFinalDeCompra = By.xpath("//div[@class=\"cart-summary-line cart-total\"]/span[@class=\"value\"]");
    private By unidadesCompradas = By.xpath("//span[@class=\"label js-subtotal\"]");


    public StoreCarritoPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getTituloCarrito (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tituloCarritoElemento));
        WebElement tituloCarrito= driver.findElement(tituloCarritoElemento);
        return tituloCarrito.getText();
    }

    public String getMontoIndividual (){
        WebElement montoIndividual= driver.findElement(precioActualUnidad);
        String montoIndividualFinal= montoIndividual.getText().replace("S/","");
        System.out.println(montoIndividualFinal.trim());
        return montoIndividualFinal.trim();

    }
    public String getMontoFinal (){
        WebElement montoFinal= driver.findElement(precioFinalDeCompra);
        String montoFinalFinal= montoFinal.getText().replace("S/","");
        System.out.println(montoFinalFinal.trim());
        return montoFinalFinal.trim();

    }
    public String getUnidades (){
        WebElement unidades= driver.findElement(unidadesCompradas);
        String unidadesFinal= unidades.getText().replace("artículos","");
        System.out.println(unidadesFinal.trim());
        return unidadesFinal.trim();
    }
}
