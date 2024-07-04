Feature: Funcionalidad del Carrito de Compras
  @TestStore

  Scenario: Validación del Precio de un Producto
    Given estoy en la página de la tienda
    And me logueo con mi correo electronico "veronicajiemenezsu@gmail.com" y clave "Store.123Test"

    When navego a la categoria Clothes y subcategoria Men
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente

    When finalizo la compra
    Then valido el titulo de la pagina del "CARRITO"
    And vuelvo a validar el calculo de precios en el carrito