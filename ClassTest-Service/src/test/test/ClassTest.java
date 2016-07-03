package test;

import org.junit.Test;

import com.domain.Clas;
import com.service.providers.ClassService;
import com.service.providers.ClassServiceImplementation;

import junit.framework.TestCase;

public class ClassTest extends TestCase{
	
	@Test
	public void testAddClass(){
		ClassService classService=new ClassServiceImplementation();
		int initial=classService.getAllClasses().size();
		Clas clas=new Clas();
		clas.setName("Seria B");
		classService.addClass(clas);
		assertEquals(initial+1, classService.getAllClasses().size());
	}

}
