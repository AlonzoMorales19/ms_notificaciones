package com.example.ms_notificaciones.controller;

import com.example.ms_notificaciones.entity.RegistroNotificacion;
import com.example.ms_notificaciones.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/notifications")
public class NotificacionController {

    @Autowired
    private NotificacionService service;

    @Autowired
    private com.example.ms_notificaciones.repository.RegistroNotificacionRepository repository;

    @GetMapping
    public java.util.List<com.example.ms_notificaciones.entity.RegistroNotificacion> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> crearNotificacion(@RequestBody Map<String, Object> body) {
        try {
            // Cambio crítico: Usar Long en lugar de Integer
            Long idPedido = Long.valueOf(body.get("idPedido").toString());
            RegistroNotificacion registro = service.crearNotificacion(idPedido);
            return ResponseEntity.ok(registro);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/health")
    public String health() {
        return "MS Notifications is ALIVE and kicking!";
    }
}