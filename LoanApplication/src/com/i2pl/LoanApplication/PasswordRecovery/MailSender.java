package com.i2pl.LoanApplication.PasswordRecovery;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * A class to send email to the user using smtp.
 */

public class MailSender
{ 
	
	/**
	 * Sends email to the user using smtp.
	 *
	 * @param to the email id in which the OTP is to be sent.
	 *
	 * @param sub the subject of the corresponding email.
	 * 
	 * @param msg the mail body to be sent.
	 * 
	 * @param user the email id of password recovery gmail account.
	 * 
	 * @param pass the password id of password recovery gmail account.
	 *
	 * @return Nothing.
	 * 
	 * @exception Exception  any exception that may occur.

	 *
	 */
	
    public static void send(String to, String sub, 
                         String msg, final String user,final String pass)
    { 
        Properties props = new Properties();
     
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.port", "587");		
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getInstance(props,new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
  	 	         return new PasswordAuthentication(user,pass); 
            }
        });

        try {
     
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
           
            Transport.send(message);
        }
        catch(Exception e) {
    	     e.printStackTrace();
        }
    }  
}

