package com.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	public static final EntityManager entityM = getEntityManager();
	

	  private static EntityManagerFactory entityManagerFactory;
	  
	  public static EntityManager getEntityManager() {
		   EntityManagerFactory emFactory = getEntityManagerFactoryApp("testclasses");
		    return emFactory.createEntityManager();
	  }
	
	  private static EntityManagerFactory getEntityManagerFactoryApp(String name) {
	    if (entityManagerFactory == null) {
	      entityManagerFactory = Persistence.createEntityManagerFactory(name);	      
	      return entityManagerFactory;
	    } else {
	      return entityManagerFactory;
	    }
	  }
}
