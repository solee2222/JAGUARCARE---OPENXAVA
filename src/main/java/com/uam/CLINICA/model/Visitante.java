package com.uam.CLINICA.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
@View(name="Simple",members = "cifID,primerNombre, primerApellido")

public class Visitante extends Identificable{
	
	@Column(length=15)
	private String cifID;
	
	@Column(length=25)
	private String primerNombre;
	
	@Column(length=25)
	private String primerApellido;
	
	@Enumerated(EnumType.STRING)
    private Carrera carrera; 
    
    @Enumerated(EnumType.STRING)
    private TipoVisitante tipo;

    private String telefono;
	
	/*@OneToMany(mappedBy="visitante")
	@ListProperties("numero,date,receta.diagnostico,receta.sintomatologia.nombre,receta.medicamento.nombre,receta.cantidad")
	Collection<Visita> visitas;*/
	
}
