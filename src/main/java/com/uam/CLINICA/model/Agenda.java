package com.uam.CLINICA.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

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
	
	

}
