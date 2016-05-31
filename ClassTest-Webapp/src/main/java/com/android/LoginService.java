package com.android;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.android.domain.TokenResponse;
import com.android.domain.UserLogin;
import com.domain.TokenUser;
import com.domain.User;
import com.service.providers.TokenUserService;
import com.service.providers.TokenUserServiceImplementation;
import com.service.providers.UserService;
import com.service.providers.UserServiceImplementation;

@Path("/test/login")
public class LoginService {

	UserService userService = new UserServiceImplementation();
	TokenUserService tokenService = new TokenUserServiceImplementation();

	public TokenResponse verifyIfTokenIsAvailable(String token) {
		TokenUser toke = tokenService.getTokenByToken(token);
		Date actualDate = new Date();
		Date date = toke.getTokenDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minutes = calendar.get(Calendar.MINUTE);
		int year = calendar.get(Calendar.YEAR);
		int day = calendar.get(Calendar.DATE);
		int month = calendar.get(Calendar.MONTH);
		Calendar newCalendar = Calendar.getInstance();
		newCalendar.set(year, month, day, hour + 2, minutes, 0);
		TokenResponse response = new TokenResponse();
		if (actualDate.after(newCalendar.getTime()))
			response.setAvailability(false);
		else
			response.setAvailability(true);
		return response;
	}

	@GET
	@Path("/get/{username}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserLogin getUserWithUsernameAndPassword(@PathParam("username") String username,
			@PathParam("password") String password) {
		if (userService.verifyLogin(username, password)) {
			UUID uuid = UUID.randomUUID();
			String randomUUIDString = uuid.toString();
			TokenUser token = tokenService.findTokenByUserId(userService.getUserByUsername(username).getUserId());
			if (token != null) {
				token.setToken(randomUUIDString);
				Date date = new Date();
				token.setTokenDate(date);
				tokenService.addToken(token);
			} else {
				token = new TokenUser();
				token.setToken(randomUUIDString);
				Date date = new Date();
				token.setTokenDate(date);
				token.setUserId(userService.getUserByUsername(username).getUserId());
				tokenService.addToken(token);
			}
			User user = userService.getUserByUsername(username);
			UserLogin userLogin = new UserLogin();
			userLogin.setRole(user.getRole());
			userLogin.setToken(token.getToken());
			userLogin.setUserId(user.getUserId());
			userLogin.setUsername(username);
			return userLogin;
		} else
			return null;
	}

	@GET
	@Path("/checkIfAvailable/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public TokenResponse checkIfAvailable(@PathParam("token") String token) {
		return verifyIfTokenIsAvailable(token);
	}

	@POST
	@Path("/logout")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public TokenResponse logout(UserLogin userLogin) {
		TokenUser toke = tokenService.getTokenByToken(userLogin.getToken());
		TokenResponse response = new TokenResponse();
		response.setAvailability(true);
		tokenService.remove(toke);
		return response;

	}
}
