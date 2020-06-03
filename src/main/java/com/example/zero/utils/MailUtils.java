package com.example.zero.utils;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class MailUtils {
    //直接当成工具类处理
    public static  void sendMail(String mail,String emailmsg) throws Exception {

        Properties pros = new Properties();
        //给对象设置属性
        pros.setProperty("mail.transport.protocol","SMTP");//服务器的类型
        pros.setProperty("mail.debug","true");//开启debug
        pros.setProperty("mail.host","smtp.qq.com");
        pros.setProperty("mail.smtp.auth","true");//开启验证

        //邮件SSlsocket通信工厂
        MailSSLSocketFactory msf;

        try {
            msf= new  MailSSLSocketFactory();
            msf.setTrustAllHosts(true);
            pros.put("mail.smtp.ssl.enable","true");
            pros.put("mail.smtp.ssl.socketFactory",msf);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        //进行创建验证器

        Authenticator auth=new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1930352617@qq.com","jkeyqmstwrbsccgb");
            }
        };
        //进行内容的发送
        Session session = Session.getInstance(pros, auth);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("1930352617@qq.com"));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(mail));//接收方的地址
        message.setSubject("用户提醒");
        // message.setContent(emailmsg,"text/html;charset=utf-8");
        message.setContent("<div style=\"color:#0000FF\">\n" +
                        "  <h3>"+emailmsg+"</h3>\n" +
                        " \n" +
                        "</div>\n" +
                        " <img border=\"0\" src=\"http://www.runoob.com/images/pulpit.jpg\" alt=\"Pulpit rock\" width=\"304\" height=\"228\">",
                "text/html;charset=utf-8" );
        Transport.send(message);


    }
}
