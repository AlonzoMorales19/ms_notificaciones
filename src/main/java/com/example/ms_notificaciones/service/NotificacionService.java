package com.example.ms_notificaciones.service;

import com.example.ms_notificaciones.entity.RegistroNotificacion;
import com.example.ms_notificaciones.repository.RegistroNotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificacionService {

    @Autowired
    private RegistroNotificacionRepository repository;

    public RegistroNotificacion crearNotificacion(Long idPedido) {

        // Si el pedido termina en 99 o es el 99, fallamos para probar la SAGA
        if (idPedido != null && idPedido == 99L) {
            throw new RuntimeException("Fallo simulado en notificaciones para activar compensacion");
        }

        String mensaje = "Pedido " + idPedido + " COMPLETADO";

        RegistroNotificacion registro = new RegistroNotificacion();
        registro.setIdPedido(idPedido);
        registro.setMensaje(mensaje);
        registro.setFecha(LocalDateTime.now());

        return repository.save(registro);
    }
}