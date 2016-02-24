package com.converter;

import com.domain.User;
import com.ui.domain.UIUser;

public interface UserConverter {

	public User createUser(UIUser ui);
	public UIUser createUIUser(User user);
}
