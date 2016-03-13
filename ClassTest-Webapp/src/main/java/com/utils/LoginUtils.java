package com.utils;

import com.domain.User;

public class LoginUtils {

	public static User userLogedIn;

	public static User getUserLogedIn() {
		return userLogedIn;
	}

	public static void setUserLogedIn(User userLogedIn) {
		LoginUtils.userLogedIn = userLogedIn;
	}
}
