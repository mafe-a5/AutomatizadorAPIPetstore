Feature: Crear orden PetStore

  @crearOrden
  Scenario: Crear orden en PetStore
    When creo la orden con id 1001, petId 1234, cantidad 1 y estado "placed"
    Then el código de respuesta de la orden es 200
    And el estado de la orden es "placed"