package com.amoelcodigo.smtpjava.controller;

import com.amoelcodigo.smtpjava.services.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(final EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")  // Define una ruta POST para enviar correos
    public String enviarCorreo(@RequestParam String to,
                               @RequestParam String subject,
                               @RequestParam String body) {
        emailService.sendEmail(to, subject, body);
        return "Correo enviado correctamente a " + to;
    }
}
