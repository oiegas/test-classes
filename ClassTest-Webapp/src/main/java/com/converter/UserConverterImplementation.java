package com.converter;

import com.domain.User;
import com.service.providers.UserService;
import com.service.providers.UserServiceImplementation;
import com.ui.domain.UIUser;

public class UserConverterImplementation implements UserConverter{
	
	UserService service=new UserServiceImplementation();

	public User createUser(UIUser ui) {
		User user;
		if(service.getUserById(ui.getUserId())!=null)
			user=service.getUserById(ui.getUserId());
		else
			user=new User();
		if((!ui.getName().equals(""))||ui.getName()!=null)
			user.setName(ui.getName());
		if((!ui.getUsername().equals(""))||ui.getUsername()!=null)
			user.setUsername(ui.getUsername());
		if((!ui.getPassword().equals(""))||ui.getPassword()!=null)
			user.setPassword(ui.getPassword());
		if((!ui.getEmail().equals(""))||ui.getEmail()!=null)
			user.setEmail(ui.getEmail());
		return user;
		
	}

	public UIUser createUIUser(User user) {
		UIUser ui=new UIUser();
		if(user.getUserId()!=0)
			ui.setUserId(user.getUserId());
		if((!user.getName().equals(""))||user.getName()!=null)
		ui.setName(user.getName());
		if((!user.getUsername().equals(""))||user.getUsername()!=null)
			ui.setUsername(user.getUsername());
		if((!user.getPassword().equals(""))||user.getPassword()!=null)
			ui.setPassword(user.getPassword());
		if((!user.getEmail().equals(""))||user.getEmail()!=null)
			ui.setEmail(user.getEmail());
		return ui;
	}

}
