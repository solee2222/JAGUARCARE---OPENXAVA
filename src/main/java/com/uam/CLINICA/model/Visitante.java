package com.uam.CLINICA.model;

import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

import lombok.*;

@Entity
@Getter @Setter

@View(name="Simple",members = "primerNombre, primerApellido; carrera, tipo")
@View(name="VisitanteAuditoria",members = "Auditoria [usuarioIng,fechaIng;usuarioUpd,fechaUpd];primerNombre, primerApellido; carrera, tipo")

public class Visitante {
	@Id
	
	private String id;
	
	
	@Column(name = "primer_nombre")
	private String primerNombre;
	
	 @Column(name = "primer_apellido")
	private String primerApellido; 
	
	@Enumerated(EnumType.STRING)
    private Carrera carrera;
    
    @Enumerated(EnumType.STRING)
    private TipoVisitante tipo;

    private String telefono;
    
 // Esto va en todas las entidades.
  	@ReadOnly
  	 public LocalDate fechaIng;
  	@ReadOnly
  	 public String usuarioIng;
  	@ReadOnly
  	 public String usuarioUpd;
  	@ReadOnly
  	@Hidden
 	 public String usuarioDel;
  	@ReadOnly
  	 public LocalDate fechaUpd;
  	
  	@PrePersist
  	public void prepersist()
  	{
  		fechaIng = LocalDate.now();
  		usuarioIng = Users.getCurrent();
  	}
  	
  	@PreUpdate
  	public void preupdate()
  	{
  		fechaUpd = LocalDate.now();
  		usuarioUpd = Users.getCurrent();
 		if (!usuarioUpd.equals(usuarioIng))
 		{
 			throw new javax.validation.ValidationException(
                    "No puede modificar este elemento porque lo creó otra persona."
            );
 		}
  	}
  	
  	@PreRemove
 	public void preremove()
 	{
 		usuarioDel = Users.getCurrent();
 		System.out.println("INTENTO DE BORRAR: " + usuarioDel);
 		if (!usuarioDel.equals(usuarioIng))
 		{
 			throw new javax.validation.ValidationException(
                    "No puede eliminar este elemento porque lo creó otra persona."
            );
 		}

 	}
	
}
