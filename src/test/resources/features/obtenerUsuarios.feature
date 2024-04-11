# language: es
Característica:Obtener todos los usuarios

  Escenario: Obtener todos los usuarios exitosamente
    Dado que "Laura", "Angie" y "Melissa"
    Cuando se realiza una solicitud GET a "/usuarios"
    Entonces la respuesta debe incluir un codigo de estado 200
    Y la respuesta debe incluir la informacion de los usuarios
