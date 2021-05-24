package dev.borgod.vicsektamas.service;

public interface CommunicationServiceVisitor {
    void visit(MailSenderService mss);
    void visit(MessageSenderService mss);
}
