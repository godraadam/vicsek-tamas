package dev.borgod.vicsektamas.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


//Just an example
public class WelcomeEmailSendingVisitor implements CommunicationServiceVisitor {

    @Override
    public void visit(MailSenderService mss) {
        JavaMailSender jms = mss.getJms();
        SimpleMailMessage sms = new SimpleMailMessage();
        //other config
        //jms.send(sms);
        
    }

    @Override
    public void visit(MessageSenderService mss) {
        // TODO Auto-generated method stub
        
    }

    
}
