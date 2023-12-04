package service;

import javax.persistence.*;

import org.openxava.jpa.*;

public class EntityManagerAdmin {
	
	    private static EntityManager instance;
	    private static final String UNIDAD = "default";
	    public static EntityManager getInstance() {
	            EntityManager em = XPersistence.getManager();
	            if (em == null) {
	                em = XPersistence.createManager();
	            }

	            return em;
	    }
	    private EntityManagerAdmin(){}

}
