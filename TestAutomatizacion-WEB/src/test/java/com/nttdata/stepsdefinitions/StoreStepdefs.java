package com.nttdata.stepsdefinitions;

import com.nttdata.steps.StoreSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StoreStepdefs {
    StoreSteps store;
    WebDriver driver;
    Scenario scenario;

    @Before(order = 0)
    public void setUp(){
        //Se ejecutará Automáticamente
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        store = new StoreSteps(driver);
        store.navegarA("https://qalab.bensg.com/store/pe/");
        screenShot();
    }

    @And("me logueo con mi correo electronico {string} y clave {string}")
    public void meLogueoConMiCorreoElectronicoYClave(String correo, String clave) {
        store.hacerLogin(correo, clave);
        screenShot();
    }

    @When("navego a la categoria Clothes y subcategoria Men")
    public void navegoALaCategoriaClothesYSubcategoriaMen() {
        store.irASubCategoria();
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int arg0) {
        store.AgregarUnidades(arg0);
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        store.validacionProductoAgregado();
    }


    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        store.validacionCalculoDePreciosModal();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        store.FinalizarCompraModal();
        screenShot();
    }

    @Then("valido el titulo de la pagina del {string}")
    public void validoElTituloDeLaPaginaDel(String arg0) {
        store.validacionTituloCarrito(arg0);
    }


    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        store.validacionCalculoDePreciosCarrito();
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }


}
