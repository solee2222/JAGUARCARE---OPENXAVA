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
 	 public LocalDate fechaIng;
 	@ReadOnly
 	 public String usuarioIng;
 	@ReadOnly
 	 public String usuarioUpd;
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
 	}
    
   
}
