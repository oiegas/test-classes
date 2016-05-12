package com.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	public static final EntityManager entityM = getEntityManager();
	public static final EntityManagerFactory entityF = getEntityManagerFactory();
	

	  private static EntityManagerFactory entityManagerFactory;
	  
	  public static EntityManager getEntityManager() {
		   EntityManagerFactory emFactory = getEntityManagerFactory();
		    return emFactory.createEntityManager();
	  }
	  
	  public static EntityManagerFactory getEntityManagerFactory() {
		  return getEntityManagerFactoryApp("testclasses");
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
