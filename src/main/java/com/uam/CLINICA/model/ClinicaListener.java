package com.uam.CLINICA.model;

import java.lang.reflect.*;

import javax.persistence.*;

public class ClinicaListener {
	
	@PrePersist
	public <T> void prePersiste(T entity) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String entidad = entity.toString();
		Field usuarioField = entity.getClass().getDeclaredField("usuarioIng");
		usuarioField.setAccessible(true);
		usuarioField.set(entidad,"Prueba");
	}
	
	@PreUpdate
	public <T> void preUpdate(T entity) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String entidad = entity.toString();
		Field usuarioField = entity.getClass().getDeclaredField("usuarioIng");
		usuarioField.setAccessible(true);
		usuarioField.set(entidad,"Prueba");
	}

}
