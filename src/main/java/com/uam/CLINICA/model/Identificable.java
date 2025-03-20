package com.uam.CLINICA.model;

import java.time.*;

import javax.persistence.*;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.util.*;

import lombok.*;

@MappedSuperclass //destinada a ser heredada por otras clases
@Getter
@Setter
public class Identificable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    @Hidden
    private String id;
    
 // Esto va en todas las entidades.
 	@ReadOnly
 	@Hidden
 	 public LocalDate fechaIng;
 	@ReadOnly
 	@Hidden
 	 public String usuarioIng;
 	@Hidden
 	@ReadOnly
 	 public String usuarioUpd;

	@Hidden
 	@ReadOnly
 	 public String usuarioDel;
 	@ReadOnly
 	@Hidden
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
 		System.out.println("CREADO: " + usuarioIng);
 		System.out.println("MODIFICADOR: " + usuarioUpd);
 		System.out.println("IGUALES O NO: " + !usuarioUpd.equals(usuarioIng));
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
