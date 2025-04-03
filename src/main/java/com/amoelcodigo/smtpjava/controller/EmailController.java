package com.amoelcodigo.smtpjava.controller;

import com.amoelcodigo.smtpjava.services.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    @PostMapping("/sendWithAttachment")
    public String sendEmailWithAttachment(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body,
            @RequestParam String filePath) {
        try {
            emailService.sendEmailWithAttachment(to, subject, body, filePath);
            return "Correo con adjunto enviado a " + to;
        } catch (MessagingException e) {
            return "Error al enviar el correo: " + e.getMessage();
        }
    }

    @PostMapping("/sendWithMultipleAttachment")
    public String sendEmailWithMultipleAttachment(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body,
            @RequestParam List<MultipartFile> files) {
        try {
            emailService.sendEmailWithMultipleAttachment(to, subject, body, files);
            return "Correo con adjunto enviado a " + to;
        } catch (MessagingException e) {
            return "Error al enviar el correo: " + e.getMessage();
        }
    }
}
