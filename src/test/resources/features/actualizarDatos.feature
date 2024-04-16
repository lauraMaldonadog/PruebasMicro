# language: es
Característica:Agregar un nuevo usuario

  Escenario: Actualizar datos de un usuario exitosamente
    Dado que existe un usuario con ID 1 que desea actualizar
    Cuando se realiza una solicitud PUT a "/usuarios/1" con los datos actualizados: nombre aleatorio y email aleatorio
    Entonces la respuesta debe tener un codigo de estado 200 de salida al actualizar
    Y la respuesta debe incluir un mensaje de exito "Datos de usuario actualizados con éxito"