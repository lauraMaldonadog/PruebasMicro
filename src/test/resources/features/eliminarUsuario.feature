# language: es
Característica:Eliminar un usuario exitosamente

  Escenario: Eliminar un usuario exitosamente
    Dado que existe un usuario con ID 1
    Cuando se elimina el usuario con ID 1
    Entonces la respuesta obtenida debe tener un codigo de estado 200
    Y la respuesta debe incluir el mensaje "Usuario eliminado con exito"


