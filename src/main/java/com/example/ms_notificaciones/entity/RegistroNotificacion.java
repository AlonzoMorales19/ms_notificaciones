package com.example.ms_notificaciones.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "registro_notificaciones")
public class RegistroNotificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_pedido", nullable = false)
    private Integer idPedido;

    @Column(name = "mensaje", nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    public RegistroNotificacion() {
    }

    public RegistroNotificacion(Long id, Integer idPedido, String mensaje, LocalDateTime fecha) {
        this.id = id;
        this.idPedido = idPedido;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}