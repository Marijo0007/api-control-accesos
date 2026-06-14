package com.accesscontrol.dto;

public class AccesoRequestDTO {

    private Long usuarioId;
    private String tipo;
    private String puntoAcceso;
    private String estado;

    // getters y setters
    public Long getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getPuntoAcceso() {
        return puntoAcceso;
    }
    public void setPuntoAcceso(String puntoAcceso) {
        this.puntoAcceso = puntoAcceso;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

}