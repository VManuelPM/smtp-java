package com.amoelcodigo.smtpjava.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    EmailService(final JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        message.setFrom("amoelcodigotest@gmail.com");
        mailSender.send(message);
    }

    public void sendEmailWithAttachment(String to, String subject, String text, String filePath) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);
        helper.setFrom("amoelcodigotest@gmail.com");

        FileSystemResource file = new FileSystemResource(new File(filePath));
        helper.addAttachment(file.getFilename(), file);

        mailSender.send(mimeMessage);
    }

    public void sendEmailWithMultipleAttachment(String to, String subject, String text, List<MultipartFile> files) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);
        helper.setFrom("amoelcodigotest@gmail.com");

        for (MultipartFile file: files){
            helper.addAttachment(file.getOriginalFilename(), file);
        }

        mailSender.send(mimeMessage);
    }
}
