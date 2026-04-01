Feature: Comprar dos productos

  Background:
    Given que el usuario esta en la página de inicio de sesión de Swag Labs

  Scenario Outline: Agregar dos productos al carrito y completar la compra
    When Inicio sesión en el sistema con credenciales válidas
    And Agrego los productos <product1> y <product2> al carrito
    And Visualizo los productos en el carrito para proceder con el pago
    And Completo el formulario con los datos de envío
    Then Valido que los productos <product1> y <product2> estén presentes en el resumen
    And Verifico que el subtotal sea la suma de ambos productos
    And Finalizo la compra exitosamente visualizando el mensaje de confirmación

    Examples:
      | product1                 | product2                  |
      | "Sauce Labs Backpack"     | "Sauce Labs Bike Light"    |
      | "Sauce Labs Bolt T-Shirt" | "Sauce Labs Fleece Jacket" |
