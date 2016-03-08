/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;


//For send a message
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@ManagedBean(name = "signUpBean")
@RequestScoped
public class signUpBean{
    
    private String name;
    private String password;
    private String repeatPassword;
    private String inputCode;
    private String email;
    private String secretCode;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    private String createSecretCode(){
        Random r = new Random();
        String code =Integer.toString(r.nextInt());
        return code;
    }
    
    public void sendEmailMess(){
        final String username = "dmtr.goltsev@gmail.com";
        final String password = "jhfg511726503543";
        secretCode = createSecretCode();
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                }
          });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("dmtr.goltsev@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("Team Forum");
            message.setText("Hello Dear friend, it's a code for verification : " + secretCode);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
                throw new RuntimeException(e);
        }
    }
    
    public String verification(){
        if(inputCode.equals(secretCode)) return "index.xhtml?faces-redirect=true";
        else return "signUp.xhtml";
    }
    
    public void create(){
        
    }
    
    public signUpBean() {
    }
    
}