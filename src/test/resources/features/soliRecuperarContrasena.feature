# language: es
Característica:Solicitar recuperacion de contrasena

  Escenario: Solicitar recuperacion de contrasena exitosamente de una
    Dado que existe un usuario con email "melissa1@example.com" registrado en la base de datos
    Cuando se realiza una solicitud POST a "/recuperacion_contra" con el email del usuario
    Y realiza el cambio de contrasena con un POST a "/restablecimiento_contra"
    Entonces la respuesta debe incluir el mensaje "Contraseña actualizada exitosamente"