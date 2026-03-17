package com.example.ms_notificaciones.repository;

import com.example.ms_notificaciones.entity.RegistroNotificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroNotificacionRepository 
        extends JpaRepository<RegistroNotificacion, Long> {
}