/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.awt.HeadlessException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author MIGUEL ANGEL
 */
public class CorreoDAO {

    public void transfer_to_email(String nombres, String tarea) {
        String correoEnvia = "icaapp.frstpp@gmail.com";//correo de origen
        String contrasena = "fykwcivhzkkirwrs";//contraseña de la aplicación
        String asunto = "Tarea Finalizada!";//asunto del correo
        String mensaje = "Se ha finalizado la tarea!\n"//contenido que contendrá el mensaje
                + "\n"
                + "Tarea: [ " + tarea + " ]\n"
                + "\n"
                + "Por: [ " + nombres + " ]\n"
                + "\n"
                + "Revise el apartado Tareas Finalizadas de la aplicación web para ver más detalles :)";

        Properties pr = new Properties();
        //parametros que se requieren para enviar correos
        pr.put("mail.smtp.host", "smtp.gmail.com");
        pr.put("mail.smtp.ssl.trust", "smtp.gmail.com");//ésta linea le dice al sistema que el proceso ejecutado es seguro
        pr.setProperty("mail.smtp.starttls.enable", "true");
        pr.put("mail.smtp.port", "587");//587 para que se pueda ¿n implementar archivos
        pr.setProperty("mail.smtp.port", "587");
        pr.put("mail.smtp.user", correoEnvia);
        pr.setProperty("mail.smtp.auth", "true");

        Session ss = Session.getDefaultInstance(pr);
        MimeMessage mail = new MimeMessage(ss);

        try {
            mail.setFrom(new InternetAddress(correoEnvia));// De:
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress("mamendez86@misena.edu.co"));// Para:
            mail.setSubject(asunto);// Asunto:
            mail.setText(mensaje);// Mensaje:

            try (Transport tr = ss.getTransport("smtp")) {
                tr.connect(correoEnvia, contrasena);
                tr.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            }
            System.out.println("El correo se envió exitosamente");
        } catch (HeadlessException | MessagingException e) {
            System.out.println("Error enviando el correo...\n" + e);
        }
    }
}
