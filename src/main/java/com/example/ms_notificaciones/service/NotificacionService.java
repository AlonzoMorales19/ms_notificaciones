package com.example.ms_notificaciones.service;

import com.example.ms_notificaciones.entity.RegistroNotificacion;
import com.example.ms_notificaciones.repository.RegistroNotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificacionService {

    @Autowired
    private RegistroNotificacionRepository repository;

    @Autowired
    private JavaMailSender mailSender;

    public RegistroNotificacion crearNotificacion(Integer idPedido) {

        if (idPedido == 99) {
            throw new RuntimeException("Fallo simulado en notificaciones");
        }

        String mensaje = "Pedido " + idPedido + " COMPLETADO";

        RegistroNotificacion registro = new RegistroNotificacion();
        registro.setIdPedido(idPedido);
        registro.setMensaje(mensaje);
        registro.setFecha(LocalDateTime.now());

        RegistroNotificacion guardado = repository.save(registro);

        enviarCorreo(mensaje);

        return guardado;
    }

    private void enviarCorreo(String mensaje) {
        try {
            System.out.println("Intentando enviar correo...");

            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo("amoralesg45@miumg.edu.gt"); 
            mail.setSubject("Confirmación de Pedido");
            mail.setText(mensaje);

            mail.setFrom("test@mailtrap.io"); 

            mailSender.send(mail);

            System.out.println("Correo enviado correctamente");

        } catch (Exception e) {
            System.out.println("ERROR AL ENVIAR CORREO:");
            e.printStackTrace();
        }
    }
}
