package com.uam.CLINICA.model;

import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

import lombok.*;

@Entity
@Getter @Setter
//@EntityListeners(ClinicaListener.class )
public class Agenda extends Identificable{
	
	/*@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid") //Universally unique identifier
	@Column
    @Hidden
    private String id_Agenda;*/
	
	@ManyToOne(fetch = FetchType.LAZY)
	@ReferenceView("Simple")
    private Visitante visitante;
	
	@DateTime
	@Column(length=10)
	private Date fecha;
	
	@Column(length=20)
	private String especialidad;
	
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
