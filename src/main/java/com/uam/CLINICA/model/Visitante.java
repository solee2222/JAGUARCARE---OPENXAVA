package com.uam.CLINICA.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
@View(name="Simple",members = "primer_Nombre, primer_Apellido")

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
	
}
