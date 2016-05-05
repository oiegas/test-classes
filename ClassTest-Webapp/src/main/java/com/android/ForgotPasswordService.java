package com.android;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.domain.User;
import com.service.providers.UserService;
import com.service.providers.UserServiceImplementation;

@Path("/test/forgotPassword")
public class ForgotPasswordService {
	final String username = "oiegasalex@gmail.com";
	final String password = "dinamomania";

	UserService userService = new UserServiceImplementation();

	@POST
	@Path("/sendEmail")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {
		User newUser = userService.getUserByEmail(user.getEmail());
		if (newUser == null) {
			return Response.status(400).entity(newUser).build();
		} else {
			UUID uuid = UUID.randomUUID();
			String randomUUIDString = uuid.toString();
			String newEmail = randomUUIDString.substring(0, 6);
			newUser.setPassword(newEmail);
			userService.updateUser(newUser);
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
				message.setSubject("Reset Password");
				message.setText("New password:" + newEmail);
				Transport.send(message);
				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}

			return Response.status(201).entity(user).build();
		}
	}

	@POST
	@Path("/changePassword")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response changePassword(String email, String code, String newPassword) {
		User user = userService.getUserByEmail(email);
		if(code.equals(user.getPassword())){
			user.setPassword(newPassword);
			userService.updateUser(user);
		}
		else{
			return Response.status(400).entity(user).build();
		}
		return Response.status(201).entity(user).build();
	}

}
