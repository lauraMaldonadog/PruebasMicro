package co.com.uniquindio.edu.pruebas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class UsuarioObtener {

    private String nombre;
    private String contrasena;
    private String email;

    public UsuarioObtener(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static List<UsuarioObtener> obtenerUsuarios() {

        UsuarioObtener usuario1 = new UsuarioObtener( "Laura");
        UsuarioObtener usuario2 = new UsuarioObtener( "Angie");
        UsuarioObtener usuario3 = new UsuarioObtener( "Melissa");

        List<UsuarioObtener> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        return usuarios;

    }


    }
