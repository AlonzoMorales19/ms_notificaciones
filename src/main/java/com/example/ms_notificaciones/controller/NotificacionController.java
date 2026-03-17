package com.example.ms_notificaciones.controller;

import com.example.ms_notificaciones.entity.RegistroNotificacion;
import com.example.ms_notificaciones.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService service;

    @PostMapping
    public ResponseEntity<?> crearNotificacion(@RequestBody Map<String, Object> body) {

        try {
            Integer idPedido = Integer.valueOf(body.get("idPedido").toString());

            RegistroNotificacion registro = service.crearNotificacion(idPedido);

            return ResponseEntity.ok(registro);

        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}