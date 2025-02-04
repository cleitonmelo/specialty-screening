package br.com.hackaton.specialtyscreening.util;

import jakarta.mail.internet.MimeMessage;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {

    private JavaMailSender mailSender = null;

    @Autowired
    public SendEmail(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @SneakyThrows
    public void sendEmail(String to, String subject, String body) {
       MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);

        mailSender.send(mimeMessage);
    }
}
