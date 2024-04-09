# language: es
Característica:Inicio de sesión de usuario

  Escenario: Inicio de sesión exitoso
    Dado que "Laura" con email "usuario2@example.com" y contrasena "123"
    Cuando se realiza una solicitud POST a "/sesion" con el email y contrasena validos
    Entonces la respuesta debe tener un codigo de estado 200
    Y la respuesta debe incluir el mensaje "Inicio de sesion exitoso"
    Y la respuesta debe incluir el token

