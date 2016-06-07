package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.converter.UserConverter;
import com.converter.UserConverterImplementation;
import com.domain.Role;
import com.domain.User;
import com.service.providers.RoleService;
import com.service.providers.RoleServiceImplementation;
import com.service.providers.UserService;
import com.service.providers.UserServiceImplementation;
import com.ui.domain.UIUser;

@Controller
@RequestMapping(value = "/user")
public class UserController{

	UserService service = new UserServiceImplementation();
	UserConverter converter = new UserConverterImplementation();
	RoleService roleService=new RoleServiceImplementation();

	private List<UIUser> transofrmList() {
		List<User> pList = service.getAllUsers();
		System.out.println(pList.size());
		List<UIUser> puiList = new ArrayList<UIUser>();
		for (User a : pList) {
			puiList.add(converter.createUIUser(a));
		}
		return puiList;

	}

	@RequestMapping(method = RequestMethod.GET)
	public String listClasses(Model model) {
		UIUser ui = new UIUser();
		model.addAttribute("user", ui);
		List<UIUser> elist = transofrmList();
		model.addAttribute("listUsers", elist);
		return "user";
	}
	
	@RequestMapping("/remove/{id}")
	public String removeUser(@PathVariable("id") int id) {
		if (service.getUserById(id) != null){
			User u=service.getUserById(id);
			System.out.println("this is the class:"+u.getName());
			service.removeUser(u);;
		}
		return "redirect:/user";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("user") UIUser ui) {
		User u=converter.createUser(ui);
		Role r=roleService.getRoleById(1);
		u.setRole(r);
		service.addUser(u);
		return "redirect:/user";

	}
}
