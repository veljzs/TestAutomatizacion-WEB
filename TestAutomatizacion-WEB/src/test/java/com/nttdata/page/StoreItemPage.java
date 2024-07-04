package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class StoreItemPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    private By clothesElement = By.xpath("//li[@id=\"category-3\"]");
    private By menElement = By.xpath("//li[@id=\"category-4\"]");
    private By primerArticuloElement = By.xpath("//article[@data-id-product=\"1\"]");
    private By cantidadDeArticulosInput = By.xpath("//input[@id=\"quantity_wanted\"]");
    private By agregarAlCarritoButton = By.xpath("//button[@data-button-action=\"add-to-cart\"]");
    private By mensajeDeModalElement = By.xpath("//h4[@id=\"myModalLabel\"]");
    private By precioActualUnidad = By.xpath("//span[@class=\"current-price-value\"]");
    private By precioFinalCompra = By.xpath("//p[@class=\"product-total\"]/span[@class=\"value\"]");
    private By botonFinalizarCompra = By.xpath("//div[@class=\"cart-content-btn\"]/a");
    private By unidadesCompradas = By.xpath("//span[@class=\"product-quantity\"]");

    public StoreItemPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void seleccionarMen (){
        wait.until(ExpectedConditions.elementToBeClickable(clothesElement));
        WebElement clothesMenu = driver.findElement(clothesElement);
        actions.moveToElement(clothesMenu).perform();

        wait.until(ExpectedConditions.elementToBeClickable(menElement));
        WebElement menOption = driver.findElement(menElement);
        menOption.click();
    }

    public void clickEnArticulo () {
        wait.until(ExpectedConditions.elementToBeClickable(primerArticuloElement));
        WebElement primerArticulo= driver.findElement(primerArticuloElement);
        primerArticulo.click();
    }

    public void elegirNumeroDeUnidades (int articulos) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cantidadDeArticulosInput));
        WebElement cantidadDeArticulos = driver.findElement(cantidadDeArticulosInput);

        cantidadDeArticulos.click();
        cantidadDeArticulos.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE); //Seleccionar y borrar la concatenacion
        cantidadDeArticulos.clear();//Limpia el input

        cantidadDeArticulos.sendKeys(String.valueOf(articulos));
    }

    public void clickAgregarAlCarrito (){
        wait.until(ExpectedConditions.elementToBeClickable(agregarAlCarritoButton));
        WebElement agregarAlCarrito= driver.findElement(agregarAlCarritoButton);
        agregarAlCarrito.click();
    }

    public String getConfirmacionProductoAgregado (){
        //Manejo de modal
        wait.until(ExpectedConditions.visibilityOfElementLocated(mensajeDeModalElement));
        WebElement mensajeDeModal= driver.findElement(mensajeDeModalElement);
        String mensajeDeModalFinal= mensajeDeModal.getText().replace("\uE876","");
        return mensajeDeModalFinal.trim();
    }

    public String getMontoIndividual (){
        WebElement montoIndividual= driver.findElement(precioActualUnidad);
        String montoIndividualFinal= montoIndividual.getText().replace("S/","");
        return montoIndividualFinal.trim();

    }
    public String getMontoFinal (){
        //Manejo de modal
        WebElement montoFinal= driver.findElement(precioFinalCompra);
        String montoFinalFinal= montoFinal.getText().replace("S/","");
        return montoFinalFinal.trim();

    }
    public void clickFinalizarCompraModal (){
        wait.until(ExpectedConditions.elementToBeClickable(botonFinalizarCompra));
        WebElement finalizarCompra= driver.findElement(botonFinalizarCompra);
        finalizarCompra.click();
    }

    public String getUnidades (){
        WebElement unidades= driver.findElement(unidadesCompradas);
        String unidadesFinal= unidades.getText().replace("Cantidad: ","");
        return unidadesFinal.trim();
    }


}
