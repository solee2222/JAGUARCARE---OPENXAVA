package com.uam.CLINICA.model;

import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Agenda {
	
	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid") //Universally unique identifier
	@Column
    @Hidden
    private String id_Agenda;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@ReferenceView("Simple")
    private Visitante visitante;
	
	@DateTime
	@Column(length=10)
	private Date fecha;
	
	@Column(length=10)
	private String hora;
	
	@Column(length=20)
	private String especialidad;
	// Este campo podría ser un enum, pero no conozco las especialidades
}
