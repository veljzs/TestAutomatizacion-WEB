package com.nttdata.steps;

import com.nttdata.page.StoreCarritoPage;
import com.nttdata.page.StoreItemPage;
import com.nttdata.page.StoreLoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class StoreSteps {
    WebDriver driver;
    StoreLoginPage StoreLoginPage;
    StoreItemPage StoreItemPage;
    StoreCarritoPage StoreCarritoPage;

    public StoreSteps(WebDriver driver){
        this.driver = driver;
        StoreLoginPage = new StoreLoginPage(driver);
        StoreItemPage = new StoreItemPage(driver);
        StoreCarritoPage = new StoreCarritoPage(driver);
    }

    public void navegarA(String url){
        driver.get(url);
    }

    public void hacerLogin (String correo, String clave){
        StoreLoginPage.entrarEnFormIniciarSesion();
        StoreLoginPage.FormIniciarSesion(correo, clave);
        StoreLoginPage.clickEnIniciarSesion();
    }

    public void irASubCategoria (){
        StoreItemPage.seleccionarMen();
    }

    public void AgregarUnidades(int articulos) {
        StoreItemPage.clickEnArticulo();
        StoreItemPage.elegirNumeroDeUnidades(articulos);
        StoreItemPage.clickAgregarAlCarrito();
        StoreItemPage.getConfirmacionProductoAgregado();
    }

    public void validacionProductoAgregado () {
        Assertions.assertEquals("Producto añadido correctamente a su carrito de compra",StoreItemPage.getConfirmacionProductoAgregado());
    }
    public void validacionCalculoDePreciosModal(){
        double precioIndividual = Double.parseDouble(StoreItemPage.getMontoIndividual());
        double precioFinal = Double.parseDouble(StoreItemPage.getMontoFinal());
        int unidades = Integer.parseInt(StoreItemPage.getUnidades());
        Assertions.assertEquals(precioIndividual*unidades, precioFinal);
    }

    public void FinalizarCompraModal () {
        StoreItemPage.clickFinalizarCompraModal();
    }

    public void validacionTituloCarrito(String titulo){
        Assertions.assertEquals(titulo,StoreCarritoPage.getTituloCarrito());

    }
    public void validacionCalculoDePreciosCarrito(){
        double precioIndividual = Double.parseDouble(StoreCarritoPage.getMontoIndividual());
        double precioFinal = Double.parseDouble(StoreCarritoPage.getMontoFinal());
        int unidades = Integer.parseInt(StoreCarritoPage.getUnidades());
        Assertions.assertEquals(precioIndividual*unidades, precioFinal);
    }
}
