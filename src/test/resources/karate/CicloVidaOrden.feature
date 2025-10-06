Feature: Ciclo de vida completo de la orden en PetStore

  Background:
    * url 'https://petstore.swagger.io/v2/store'
    * def nuevaOrden =
    """
    {
      "id": 999,
      "petId": 10,
      "quantity": 1,
      "shipDate": "2025-10-05T22:30:00.000Z",
      "status": "placed",
      "complete": true
    }
    """

  Scenario: Crear, consultar, eliminar y validar eliminación de una orden
    # Crear orden
    Given path 'order'
    And request nuevaOrden
    When method POST
    Then status 200
    And match response.id == 999
    * def idOrden = response.id
    * print 'Orden creada con ID: ', idOrden

    # Consultar orden creada
    Given path 'order', idOrden
    When method GET
    Then status 200
    And match response.id == idOrden
    * print 'Consulta exitosa. Estado: ', response.status

    # Eliminar la orden
    Given path 'order', idOrden
    When method DELETE
    Then status 200
    * print 'Orden eliminada con ID: ', idOrden

    # Validar que fue eliminada
    Given path 'order', idOrden
    When method GET
    Then status 404
    * print 'Validación completada: la orden ', idOrden, ' fue eliminada correctamente.'