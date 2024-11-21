package com.example.recyclerview;

public class Contacto {
    private String nombre;
    private String email;
    private String tlfn;
    private int imagen;

    public Contacto(String nombre, String email, String tlfn, int imagen) {
        this.nombre = nombre;
        this.email = email;
        this.tlfn = tlfn;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTlfn() {
        return tlfn;
    }

    public void setTlfn(String tlfn) {
        this.tlfn = tlfn;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", tlfn='" + tlfn + '\'' +
                ", imagen=" + imagen +
                '}';
    }
}
