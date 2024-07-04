package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StoreLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Elementos localizados
    private By iniciarSesionElemento = By.xpath("//a[@title=\"Acceda a su cuenta de cliente\"]");
    private By correoElectronicoInput = By.xpath("//input[@id=\"field-email\"]");
    private By claveInput = By.xpath("//input[@id=\"field-password\"]");
    private By botonIniciarSesionElement = By.xpath("//button[@id=\"submit-login\"]");


    public StoreLoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void entrarEnFormIniciarSesion (){
        wait.until(ExpectedConditions.elementToBeClickable(iniciarSesionElemento));
        WebElement iniciarSesion= driver.findElement(iniciarSesionElemento);
        iniciarSesion.click();
    }

    public void FormIniciarSesion (String correo, String clave) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(correoElectronicoInput));
        WebElement correoElectronico = driver.findElement(correoElectronicoInput);
        correoElectronico.sendKeys(correo);
        WebElement password = driver.findElement(claveInput);
        password.sendKeys(clave);
    }

    public void clickEnIniciarSesion (){
        wait.until(ExpectedConditions.elementToBeClickable(botonIniciarSesionElement));
        WebElement botonIniciarSesion= driver.findElement(botonIniciarSesionElement);
        botonIniciarSesion.click();
    }
}
