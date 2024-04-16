package co.com.uniquindio.edu.pruebas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioReestaContra {
    @JsonProperty("email")
    private String email;
    @JsonProperty("new_password")
    private String contrasena;
    @JsonProperty("reset_token")
    private String token;

    // Constructor

    public UsuarioReestaContra(String email, String contrasena) {
        this.email = email;
        this.contrasena = contrasena;
    }

    public UsuarioReestaContra(String email) {
        this.email = email;
    }

    // Constructor con token


    public UsuarioReestaContra(String email, String contrasena, String token) {
        this.email = email;
        this.contrasena = contrasena;
        this.token = token;
    }

    // Getters y setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
