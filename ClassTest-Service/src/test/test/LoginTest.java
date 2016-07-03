package test;

import org.junit.Test;

import com.service.providers.UserService;
import com.service.providers.UserServiceImplementation;

import junit.framework.TestCase;

public class LoginTest extends TestCase{
	
	@Test
	public void testLogin(){
		UserService userService=new UserServiceImplementation();
		boolean b=userService.verifyLogin("aaa", "aaa");
	assertEquals(true, b);
	}
	
}
