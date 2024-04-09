# language: es
Característica:Eliminar un usuario exitosamente
  Dado que existe un usuario con ID "1"
  Cuando se realiza una solicitud DELETE a "/usuarios/1"
  Entonces la respuesta debe tener un código de estado 200
  Y la respuesta debe incluir un mensaje de éxito "Usuario eliminado con éxito"
