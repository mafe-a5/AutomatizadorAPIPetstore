Feature: Consultar orden Petstore

  @consultarOrden
  Scenario: Consultar la orden de la pagina Petstore
    When consulto la orden con id 1001
    Then el código de respuesta de la consulta es 200
    And muestro el estado de la orden