Feature: Consulta una mascota

  @consultaMascota
  Scenario Outline: Consulta una mascota por id
    Given estoy en la pagina de mascotas
    When hago la consulta de la mascota con el id <idMascota>
    Then el código de la respuesta de mascota es <statusCode>

    Examples:
      | idMascota | statusCode |
      | 3         | 200        |
      | 1234      | 200        |
      | 7000      | 404        |